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
import java.util.ArrayList;
import java.util.List;

import com.github.dannil.scbjavaclient.client.AbstractClientIT;
import com.github.dannil.scbjavaclient.client.AbstractClientTest;
import com.github.dannil.scbjavaclient.client.AbstractContainerClientTest;
import com.github.dannil.scbjavaclient.client.SCBClientIT;
import com.github.dannil.scbjavaclient.client.SCBClientTest;
import com.github.dannil.scbjavaclient.format.json.IJsonTableFormat;
import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.Files;
import com.github.dannil.scbjavaclient.test.utility.Filters;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@SuppressWarnings("deprecation")
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
        Filters.files(files, RemoteIntegrationTestSuite.class, Files.class, Date.class, DateJUnitRunner.class,
                Filters.class);

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
        Filters.files(files, AbstractClientIT.class, AbstractClientTest.class, AbstractContainerClientTest.class,
                SCBClientIT.class, SCBClientTest.class);

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
        Filters.files(mainFiles, IJsonTableFormat.class);

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

}
