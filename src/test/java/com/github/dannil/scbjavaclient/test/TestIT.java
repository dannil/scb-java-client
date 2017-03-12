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
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.github.dannil.scbjavaclient.test.utility.Files;
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
        Iterator<File> it = files.iterator();
        while (it.hasNext()) {
            if (Objects.equals(Files.fileToBinaryName(it.next()), this.getClass().getName())) {
                it.remove();
            }
        }

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
        assertTrue("Classes not extending RemoteIntegrationTestSuite: "
                + matchedClasses.toString(), matchedClasses.isEmpty());
    }

    @Test
    public void checkForRunWithAnnotation() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/test/java/com/github/dannil/scbjavaclient", "*.java");

        // Filter out some classes from the list which shouldn't be annotated
        List<Class<?>> filters = new ArrayList<>();
        filters.add(RemoteIntegrationTestSuite.class);
        filters.add(Files.class);

        Iterator<File> it = files.iterator();
        while (it.hasNext()) {
            for (Class<?> clazz : filters) {
                if (Objects.equals(Files.fileToBinaryName(it.next()), clazz.getName())) {
                    it.remove();
                }
            }
        }

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

}
