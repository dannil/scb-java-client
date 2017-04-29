/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.ResponseModel;
import com.github.dannil.scbjavaclient.test.utility.Files;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractClientIT extends RemoteIntegrationTestSuite {

    @Test
    public void toFallbackUrlDoGetRequest() {
        SCBClient client = new SCBClient(new Locale("en", "US"));

        String url = client.getRootUrl() + "HE/HE0103/HE0103B/BefolkningAlder";

        // This request is performed with the locale set to English. This means that if we
        // receive a response with Swedish text, we've used the fallback url.
        String response = client.doGetRequest(url);

        assertTrue(response.contains("ålder"));
        assertTrue(response.contains("kön"));
        assertTrue(response.contains("boendeform"));
        assertTrue(response.contains("tabellinnehåll"));
        assertTrue(response.contains("år"));
    }

    @Test
    public void toFallbackUrlDoPostRequest() {
        SCBClient client = new SCBClient(new Locale("en", "US"));

        String url = client.getRootUrl() + "HE/HE0103/HE0103B/BefolkningAlder";

        Map<String, Collection<?>> map = new HashMap<String, Collection<?>>();
        map.put("Alder", Arrays.asList("tot"));
        map.put("Kon", Arrays.asList("4"));
        map.put("Boendeform", Arrays.asList("SMAG"));
        map.put("Tid", Arrays.asList("2012"));

        // This request is performed with the locale set to English. This means that if we
        // receive a response with Swedish text, we've used the fallback url.
        String response = client.doPostRequest(url, QueryBuilder.build(map));

        assertTrue(response.contains("ålder"));
        assertTrue(response.contains("kön"));
        assertTrue(response.contains("boendeform"));
        assertTrue(response.contains("år"));
    }

    @Test
    public void doPostRequestWithEmptyList() {
        SCBClient client = new SCBClient(new Locale("sv", "SE"));

        String url = client.getRootUrl() + "HE/HE0103/HE0103B/BefolkningAlder";

        Map<String, Collection<?>> inputMap = new HashMap<String, Collection<?>>();
        inputMap.put("Alder", Collections.EMPTY_LIST);

        String response = client.doPostRequest(url, QueryBuilder.build(inputMap));

        assertTrue(response.contains("år"));
        assertFalse(response.contains("ålder"));
        assertFalse(response.contains("kön"));
        assertFalse(response.contains("boendeform"));
    }

    @Test
    public void urlNotFound() {
        SCBClient client = new SCBClient(new Locale("sv", "SE"));

        String response = client.getRawData("ABC/ABC/ABC");

        assertNull(response);
    }

    @Test
    public void urlForbidden() {
        SCBClient client = new SCBClient(new Locale("sv", "SE"));

        // This call will result in a HTTP 403 response (forbidden) since the
        // response from this table is larger than the API allows (given all the available
        // inputs)
        String response = client.getRawData("NV/NV0119/IVPKNLonAr");

        assertNull(response);
    }

    @Test
    public void getResponseModels() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);

        List<ResponseModel> models = client.getResponseModels("HE/HE0103/HE0103B/BefolkningAlder");

        assertNotNull(models);
        assertFalse(models.isEmpty());
    }

    @Test
    public void getResponseModelsWithParameters() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);

        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.AGE_CODE, Arrays.asList("6-12", "13-19"));
        mappings.put(APIConstants.SEX_CODE, Arrays.asList("1", "2"));
        mappings.put("Boendeform", Arrays.asList("SMAG", "HY"));
        mappings.put("Tid", Arrays.asList("2010", "2012"));

        List<ResponseModel> models = client.getResponseModels("HE/HE0103/HE0103B/BefolkningAlder", mappings);

        assertNotNull(models);
        assertFalse(models.isEmpty());
    }

    @Test
    public void checkForLocaleConstructor() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient", "*Client.java");

        List<Class<?>> matchedClasses = new ArrayList<>();
        for (File file : files) {
            // Convert path into binary name
            String binaryName = Files.fileToBinaryName(file);

            // Reflect the binary name into a concrete Java class
            Class<?> clazz = null;
            try {
                clazz = Class.forName(binaryName);
                clazz.getDeclaredConstructor(Locale.class);
            } catch (ClassNotFoundException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                assertTrue(e.getMessage(), false);
            } catch (NoSuchMethodException e) {
                // Nope! Locale constructor not found
                matchedClasses.add(clazz);
            }
        }
        assertTrue("Classes not declaring a Locale constructor: " + matchedClasses.toString(),
                matchedClasses.isEmpty());
    }

    @Test
    public void checkForCorrectPackageAndClientNames() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        List<Class<?>> filters = new ArrayList<>();
        filters.add(AbstractClient.class);
        filters.add(AbstractContainerClient.class);
        filters.add(SCBClient.class);

        Iterator<File> it = files.iterator();
        while (it.hasNext()) {
            File f = it.next();
            for (Class<?> clazz : filters) {
                if (Objects.equals(Files.fileToBinaryName(f), clazz.getName())) {
                    it.remove();
                }
            }
        }

        List<Class<?>> matchedClasses = new ArrayList<>();
        for (File file : files) {
            // Convert path into binary name
            String binaryName = Files.fileToBinaryName(file);
            if (binaryName.contains("package-info")) {
                continue;
            }

            // Reflect the binary name into a concrete Java class
            Class<?> clazz = null;
            try {
                clazz = Class.forName(binaryName);
                String packageName = clazz.getPackage().getName();

                String toBeginFrom = "client";
                int beginIndex = packageName.lastIndexOf(toBeginFrom) + toBeginFrom.length() + 1;
                String substr = packageName.substring(beginIndex);
                String lastPart = substr.substring(substr.lastIndexOf(".") + 1).concat("client");

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
    public void checkForUniqueTableImplementations() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        List<Class<?>> filters = new ArrayList<>();
        filters.add(AbstractClient.class);
        filters.add(AbstractContainerClient.class);

        Iterator<File> it = files.iterator();
        while (it.hasNext()) {
            File f = it.next();
            for (Class<?> clazz : filters) {
                if (Objects.equals(Files.fileToBinaryName(f), clazz.getName())) {
                    it.remove();
                }
            }
        }

        Map<String, Class<?>> register = new HashMap<>();
        Map<String, List<Class<?>>> offendingClasses = new HashMap<>();
        for (File file : files) {
            // Convert path into binary name
            String binaryName = Files.fileToBinaryName(file);
            if (binaryName.contains("package-info")) {
                continue;
            }

            // Reflect the binary name into a concrete Java class
            Class<?> clazz = null;
            try {
                clazz = Class.forName(binaryName);

                Method m = clazz.getDeclaredMethod("getUrl");
                Object t = clazz.newInstance();
                Object o = m.invoke(t);

                URLEndpoint endPoint = (URLEndpoint) o;
                String table = endPoint.getTable();
                if (register.containsKey(table)) {
                    List<Class<?>> fetchedClasses = offendingClasses.get(table);
                    if (fetchedClasses == null) {
                        fetchedClasses = new ArrayList<>();
                        fetchedClasses.add(register.get(table));
                    }
                    fetchedClasses.add(clazz);
                    offendingClasses.put(table, fetchedClasses);
                } else {
                    register.put(table, clazz);
                }
            } catch (ReflectiveOperationException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                assertTrue(e.getMessage(), false);
            }
        }
        assertTrue("Classes implementing same table: " + offendingClasses.toString(), offendingClasses.isEmpty());
    }

}
