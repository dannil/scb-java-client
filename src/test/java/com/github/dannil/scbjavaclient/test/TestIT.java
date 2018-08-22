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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.SCBClientBuilderIT;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;
import com.github.dannil.scbjavaclient.test.utility.Files;
import com.github.dannil.scbjavaclient.test.utility.Filters;

@Suite
public class TestIT {

    @Test
    public void checkForExistingRemoteAnnotation() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/test/java/com/github/dannil/scbjavaclient", "*IT.java");

        // Filter out THIS and some other classes from the list
        Filters.files(files, this.getClass(), SCBClientBuilderIT.class);

        List<Class<?>> matchedClasses = new ArrayList<Class<?>>();
        for (File file : files) {
            // Convert path into binary name
            String binaryName = Files.fileToBinaryName(file);

            // Reflect the binary name into a concrete Java class
            Class<?> clazz = null;
            try {
                clazz = Class.forName(binaryName);
                Remote r = clazz.getDeclaredAnnotation(Remote.class);
                if (r == null) {
                    matchedClasses.add(clazz);
                }
            } catch (ClassNotFoundException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                assertTrue(false, e.getMessage());
            }
        }
        assertTrue(matchedClasses.isEmpty(), "Classes not annotated with Remote " + matchedClasses.toString());
    }

    @Test
    public void checkForCorrectPackageAndName() {
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

                // Check if package name is correct
                if (clazz.getSimpleName().toLowerCase().indexOf(lastPart) > 0) {
                    matchedClasses.add(clazz);
                }
                // Check if test class name is correct
                else if (!clazz.getSimpleName().toLowerCase().startsWith(lastPart)) {
                    matchedClasses.add(clazz);
                }
            } catch (ClassNotFoundException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                assertTrue(false, e.getMessage());
            }
        }
        assertTrue(matchedClasses.isEmpty(),
                "Classes not having correct package and/or name: " + matchedClasses.toString());
    }

    @Test
    public void checkForMatchingNameAndPackage() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> mainFiles = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient", "*.java");
        List<File> testFiles = Files.find(execPath + "/src/test/java/com/github/dannil/scbjavaclient", "*.java");

        // Filter out some classes from the list
        Filters.files(mainFiles, "com.github.dannil.scbjavaclient.format.json.IJsonTableFormat",
                "com.github.dannil.scbjavaclient.format.AbstractTableFormat");

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
                assertTrue(false, e.getMessage());
            }

            for (File fileTest : testFiles) {
                String binaryNameTest = Files.fileToBinaryName(fileTest);
                if (binaryNameTest.startsWith(binaryNameMain)) {
                    matchedClasses.remove(clazz);
                }
            }
        }
        assertTrue(matchedClasses.isEmpty(),
                "Classes not having matching test class name and/or package: " + matchedClasses.toString());
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

        Stream<Field> streamFields = Arrays.stream(apiFields).filter(x -> x.getName().endsWith("_CODE"));
        for (Field f : streamFields.collect(Collectors.toList())) {
            fields.add((String) f.get(null));
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
                assertTrue(false, e.getMessage());
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
                        offending.add(field);
                    }
                }
            }
            if (!offending.isEmpty()) {
                matchedClasses.put(clazz, offending);
            }
        }
        assertTrue(matchedClasses.isEmpty(), "Clients not utilizing API constants : " + matchedClasses.toString());
    }

}
