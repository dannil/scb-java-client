/*
 * Copyright 2017 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.test.utility.Files;
import com.github.dannil.scbjavaclient.test.utility.Filters;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestIT {

	@Test
	public void checkForRemoteIntegrationTestSuiteAsSuperclass() {
		String execPath = System.getProperty("user.dir");

		// Find files matching the wildcard pattern
		List<File> files = Files.find(execPath + "/src/test/java/com/github/dannil/scbjavaclient", "*IT.java");

		// Filter out THIS class from the list
		Filters.files(files, this.getClass());

		List<Class<?>> matchedClasses = new ArrayList<Class<?>>();
		for (File file : files) {
			// Convert path into binary name
			String binaryName = Files.fileToBinaryName(file);

			// Reflect the binary name into a concrete Java class
			Class<?> clazz = null;
			try {
				clazz = Class.forName(binaryName);
				if (!RemoteIntegrationTestSuite.class.isAssignableFrom(clazz)) {
					matchedClasses.add(clazz);
				}
			} catch (ClassNotFoundException e) {
				// Class could not be created; respond with an assertion that'll always
				// fail
				e.printStackTrace();
				assertTrue(e.getMessage(), false);
			}
		}
		assertTrue("Classes not extending RemoteIntegrationTestSuite: " + matchedClasses.toString(),
				matchedClasses.isEmpty());
	}

	@Test
	public void checkForRunWithAnnotation() {
		String execPath = System.getProperty("user.dir");

		// Find files matching the wildcard pattern
		List<File> files = Files.find(execPath + "/src/test/java/com/github/dannil/scbjavaclient", "*.java");

		// Filter out some classes from the list which shouldn't be annotated
		Filters.files(files, "com.github.dannil.scbjavaclient.test");

		List<Class<?>> matchedClasses = new ArrayList<>();
		for (File file : files) {
			// Convert path into binary name
			String binaryName = Files.fileToBinaryName(file);

			// Reflect the binary name into a concrete Java class
			Class<?> clazz = null;
			try {
				clazz = Class.forName(binaryName);
				if (clazz.getAnnotation(RunWith.class) == null) {
					matchedClasses.add(clazz);
				}
			} catch (ClassNotFoundException e) {
				// Class could not be created; respond with an assertion that'll always
				// fail
				e.printStackTrace();
				assertTrue(e.getMessage(), false);
			}
		}
		assertTrue("Classes not annotated with RunWith: " + matchedClasses.toString(), matchedClasses.isEmpty());
	}

	@Test
	public void checkForCorrectPackageAndClientNames() {
		String execPath = System.getProperty("user.dir");

		// Find files matching the wildcard pattern
		List<File> files = Files.find(execPath + "/src/test/java/com/github/dannil/scbjavaclient/client", "*.java");

		// Filter out some classes from the list
		Filters.files(files, false, "com.github.dannil.scbjavaclient.client");

		List<Class<?>> matchedClasses = new ArrayList<>();
		for (File file : files) {
			// Convert path into binary name
			String binaryName = Files.fileToBinaryName(file);

			// Reflect the binary name into a concrete Java class
			Class<?> clazz = null;
			try {
				clazz = Class.forName(binaryName);
				String packageName = clazz.getPackage().getName();

				String toBeginFrom = "client";
				int beginIndex = packageName.lastIndexOf(toBeginFrom) + toBeginFrom.length() + 1;
				String sub = packageName.substring(beginIndex);
				String lastPart = sub.replace(".", "").concat("client");

				if (clazz.getSimpleName().toLowerCase().indexOf(lastPart) > 0) {
					matchedClasses.add(clazz);
				}
			} catch (ClassNotFoundException e) {
				// Class could not be created; respond with an assertion that'll always
				// fail
				e.printStackTrace();
				assertTrue(e.getMessage(), false);
			}
		}
		assertTrue("Classes not having matching package and client name: " + matchedClasses.toString(),
				matchedClasses.isEmpty());
	}

	@Test
	public void checkForMatchingNameAndPackage() {
		String execPath = System.getProperty("user.dir");

		// Find files matching the wildcard pattern
		List<File> mainFiles = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient", "*.java");
		List<File> testFiles = Files.find(execPath + "/src/test/java/com/github/dannil/scbjavaclient", "*.java");

		// Filter out some classes from the list
		Filters.files(mainFiles, "com.github.dannil.scbjavaclient.format.json.IJsonTableFormat");

		List<Class<?>> matchedClasses = new ArrayList<>();
		for (File fileMain : mainFiles) {
			// Convert path into binary name
			String binaryNameMain = Files.fileToBinaryName(fileMain);
			if (binaryNameMain.contains("package-info")) {
				continue;
			}

			// Reflect the binary name into a concrete Java class
			Class<?> clazz = null;
			try {
				clazz = Class.forName(binaryNameMain);
				matchedClasses.add(clazz);
			} catch (ClassNotFoundException e) {
				// Class could not be created; respond with an assertion that'll always
				// fail
				e.printStackTrace();
				assertTrue(e.getMessage(), false);
			}

			for (File fileTest : testFiles) {
				String binaryNameTest = Files.fileToBinaryName(fileTest);
				if (binaryNameTest.startsWith(binaryNameMain)) {
					matchedClasses.remove(clazz);
				}
			}
		}
		assertTrue("Test classes not having matching name and/or package : " + matchedClasses.toString(),
				matchedClasses.isEmpty());
	}

	@Test
	public void checkForUsageOfAPIVariables() throws Exception {
		String execPath = System.getProperty("user.dir");

		// Find files matching the wildcard pattern
		List<File> mainFiles = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient", "*.java");

		// Filter out some classes from the list
		Filters.files(mainFiles, APIConstants.class);

		Field[] apiFields = APIConstants.class.getDeclaredFields();

		// Remove non-codes and save the values of the code fields in a list
		List<String> fields = new ArrayList<>();
		for (int i = 0; i < apiFields.length; i++) {
			Field field = apiFields[i];
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}
			Object obj = null;
			obj = field.get(obj);
			if (field.getName().endsWith("_CODE")) {
				fields.add((String) obj);
			}
		}

		Map<Class<?>, List<String>> matchedClasses = new LinkedHashMap<>();
		for (File f : mainFiles) {
			// Convert path into binary name
			String binaryNameMain = Files.fileToBinaryName(f);
			if (binaryNameMain.endsWith("package-info")) {
				continue;
			}

			// Reflect the binary name into a concrete Java class
			Class<?> clazz = null;
			try {
				clazz = Class.forName(binaryNameMain);
			} catch (ClassNotFoundException e) {
				// Class could not be created; respond with an assertion that'll always
				// fail
				e.printStackTrace();
				assertTrue(e.getMessage(), false);
			}

			List<String> lines = java.nio.file.Files.readAllLines(Paths.get(f.getPath()), StandardCharsets.UTF_8);
			List<String> offending = new ArrayList<>();
			for (String line : lines) {
				// Skip line if it is a comment, Javadoc or alike
				String trimmedLine = line.trim();
				String[] comments = { "//", "/**", "/*", "*", "*/" };
				boolean offendingLine = false;
				for (int i = 0; i < comments.length; i++) {
					if (trimmedLine.startsWith(comments[i])) {
						offendingLine = true;
					}
				}
				if (offendingLine) {
					continue;
				}

				for (String field : fields) {
					String fieldAsJavaString = "\"" + field + "\"";
					if (line.contains(fieldAsJavaString)) {
						System.out.println(field + " : " + line);
						offending.add(field);
					}
				}
			}
			if (!offending.isEmpty()) {
				matchedClasses.put(clazz, offending);
			}
		}
		assertTrue("Clients not utilizing API constants : " + matchedClasses.toString(), matchedClasses.isEmpty());
	}

}
