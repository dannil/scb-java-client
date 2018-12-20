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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.communication.http.HttpResponse;
import com.github.dannil.scbjavaclient.communication.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.exception.SCBClientResponseTooLargeException;
import com.github.dannil.scbjavaclient.format.json.JsonConverter;
import com.github.dannil.scbjavaclient.model.ResponseModel;
import com.github.dannil.scbjavaclient.test.TestConstants;
import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;
import com.github.dannil.scbjavaclient.test.utility.Files;
import com.github.dannil.scbjavaclient.test.utility.Filters;
import com.github.dannil.scbjavaclient.test.utility.SourceInspector;
import com.github.dannil.scbjavaclient.test.utility.TestProcessor;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

@Suite
@Remote
public class AbstractClientIT {

    @Test
    @Date("2017-01-01")
    public void toFallbackUrlDoGetRequest() {
        SCBClient client = new SCBClient(new Locale("en", "US"));

        String url = client.getRootUrl() + "HE/HE0103/HE0103B/BefolkningAlder";

        // This request is performed with the locale set to English. This means that if
        // we receive a response with Swedish text, we've used the fallback url.
        String response = client.doGetRequest(url);

        assertTrue(response.contains("ålder"));
        assertTrue(response.contains("kön"));
        assertTrue(response.contains("boendeform"));
        assertTrue(response.contains("tabellinnehåll"));
        assertTrue(response.contains("år"));
    }

    @Test
    @Date("2017-01-01")
    public void toFallbackUrlDoPostRequest() {
        SCBClient client = new SCBClient(new Locale("en", "US"));

        String url = client.getRootUrl() + "HE/HE0103/HE0103B/BefolkningAlder";

        Map<String, Collection<?>> map = new HashMap<String, Collection<?>>();
        map.put("Alder", Arrays.asList("tot"));
        map.put("Kon", Arrays.asList("4"));
        map.put("Boendeform", Arrays.asList("SMAG"));
        map.put("Tid", Arrays.asList("2012"));

        // This request is performed with the locale set to English. This means that if
        // we receive a response with Swedish text, we've used the fallback url.
        String response = client.doPostRequest(url, QueryBuilder.build(map));

        assertTrue(response.contains("ålder"));
        assertTrue(response.contains("kön"));
        assertTrue(response.contains("boendeform"));
        assertTrue(response.contains("år"));
    }

    @Test
    @Date("2017-01-01")
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
    @Date("2017-01-01")
    public void urlNotFound() {
        SCBClient client = new SCBClient(new Locale("sv", "SE"));

        String response = client.getRawData("ABC/ABC/ABC");

        assertNull(response);
    }

    @Test
    @Date("2018-06-28")
    public void urlForbidden() {
        SCBClient client = new SCBClient(new Locale("sv", "SE"));

        // This call will result in a HTTP 403 response (forbidden) since the
        // response from this table is larger than the API allows (given all the
        // available inputs)
        assertThrows(SCBClientResponseTooLargeException.class, () -> client.getRawData("NV/NV0119/IVPKNLonAr"));
    }

    @Test
    @Date("2017-01-01")
    public void getResponseModels() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);

        List<ResponseModel> models = client.getResponseModels("HE/HE0103/HE0103B/BefolkningAlder");

        assertNotNull(models);
        assertFalse(models.isEmpty());
    }

    @Test
    @Date("2017-01-01")
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
                assertTrue(false, e.getMessage());
            } catch (NoSuchMethodException e) {
                // Nope! Locale constructor not found
                matchedClasses.add(clazz);
            }
        }
        assertTrue(matchedClasses.isEmpty(),
                "Classes not declaring a Locale constructor: " + matchedClasses.toString());
    }

    @Test
    public void checkForCorrectPackageAndName() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        Filters.files(files, AbstractClient.class, AbstractContainerClient.class, SCBClient.class,
                SCBClientBuilder.class);

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
                String lastPart = substr.replace(".", "").concat("client");

                // Check if package name is correct
                if (clazz.getSimpleName().toLowerCase().indexOf(lastPart) > 0) {
                    matchedClasses.add(clazz);
                }
                // Check if class name is correct
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
    public void checkForUniqueTableImplementations() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        Filters.files(files, AbstractClient.class, AbstractContainerClient.class, SCBClientBuilder.class);

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
                if (clazz.isAnnotationPresent(Deprecated.class)) {
                    // Class is deprecated; we don't care if there's another class
                    // implementing the same tables as clazz (which is its replacer class)
                    continue;
                }

                Method m = clazz.getDeclaredMethod("getUrl");
                Constructor<?> c = clazz.getConstructor();
                Object t = c.newInstance();
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
                assertTrue(false, e.getMessage());
            }
        }
        assertTrue(offendingClasses.isEmpty(), "Classes implementing same table: " + offendingClasses.toString());
    }

    @Test
    public void checkForCorrectSuperclass() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        Filters.files(files, AbstractClient.class, AbstractContainerClient.class, SCBClientBuilder.class);

        // Convert paths into binary names
        Set<String> binaryNames = new TreeSet<String>();
        for (File file : files) {
            String binaryName = Files.fileToBinaryName(file);
            if (binaryName.contains("package-info")) {
                continue;
            } else {
                binaryNames.add(binaryName);
            }
        }

        List<Class<?>> matchedClasses = new ArrayList<>();
        for (String binaryName : binaryNames) {
            // Reflect the binary name into a concrete Java class
            Class<?> clazz = null;
            try {
                clazz = Class.forName(binaryName);
                String packageName = clazz.getPackage().getName();

                // Add all binary names which starts with the current class's package
                Set<String> children = new TreeSet<String>();
                for (String s : binaryNames) {
                    if (s.startsWith(packageName)) {
                        children.add(s);
                    }
                }
                // Remove the parent from the list
                children.remove(binaryName);

                Class<?> actualSuperclass = clazz.getSuperclass();
                Class<?> supposedSuperclass = null;
                if (children.size() > 0) {
                    // Current class's package has sub-packages; is a container client
                    supposedSuperclass = AbstractContainerClient.class;
                } else {
                    // Current class's package has no sub-packages; is a regular client
                    supposedSuperclass = AbstractClient.class;
                }
                if (!actualSuperclass.equals(supposedSuperclass)) {
                    matchedClasses.add(clazz);
                }
            } catch (ClassNotFoundException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                assertTrue(false, e.getMessage());
            }
        }
        assertTrue(matchedClasses.isEmpty(), "Classes not extending correct superclass: " + matchedClasses.toString());
    }

    // Method which is used to check for correctly overloaded methods (with methods
    // throwing HTTP 403 removed)
    @Test
    public void checkForOverloadedMethods() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        Filters.files(files, AbstractClient.class, AbstractContainerClient.class, SCBClient.class);

        Map<String, Integer> offendingMethods = new HashMap<String, Integer>();
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
                Method[] methods = clazz.getDeclaredMethods();
                for (int i = 0; i < methods.length; i++) {
                    Method m = methods[i];
                    if (m.getName().equals("getUrl") || !m.getName().startsWith("get")) {
                        continue;
                    }
                    String full = clazz.getSimpleName() + "." + m.getName();
                    if (!offendingMethods.containsKey(full)) {
                        offendingMethods.put(full, 1);
                    } else {
                        offendingMethods.put(full, offendingMethods.get(full) + 1);
                    }
                }
            } catch (ClassNotFoundException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                assertTrue(false, e.getMessage());
            }
        }

        // Remove offending methods which occur more than once (which means
        // that there does exists an overload)
        offendingMethods.values().removeIf(v -> v > 1);

        assertTrue(offendingMethods.isEmpty(),
                "Methods not having correct overloads: " + offendingMethods.keySet().toString());
    }

    @Test
    //@Date("2018-11-10")
    public void checkForCorrectUsageOfAllCodes() throws Exception {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        Filters.files(files, AbstractClient.class, AbstractContainerClient.class, SCBClient.class);

        StringBuilder builder = new StringBuilder();
        Set<String> offendingMethods = new HashSet<>();
        for (File f : files) {
            // Convert path into binary name
            String binaryName = Files.fileToBinaryName(f);
            if (binaryName.endsWith("package-info")) {
                continue;
            }

            // Reflect the binary name into a concrete Java class
            Class<?> clazz = null;
            try {
                clazz = Class.forName(binaryName);
            } catch (ClassNotFoundException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                assertTrue(false, e.getMessage());
            }

            // Class is deprecated; we don't care about it at all
            if (clazz.isAnnotationPresent(Deprecated.class)) {
                continue;
            }

            // Figure out implemented tables by inspecting the source code
            Map<String, String> tables = SourceInspector.getImplementedTables(Paths.get(f.getPath()));
            if (tables.isEmpty()) {
                continue;
            }
            Map<String, List<String>> parameters = SourceInspector.getParameters(Paths.get(f.getPath()));

            Object instance = clazz.getConstructor().newInstance();
            URLEndpoint url = (URLEndpoint) clazz.getMethod("getUrl", new Class<?>[] {}).invoke(instance,
                    new Object[] {});

            Method[] declaredMethods = clazz.getDeclaredMethods();
            List<Method> filteredMethods = new ArrayList<>();
            for (int i = 0; i < declaredMethods.length; i++) {
                Method m = declaredMethods[i];
                if (m.getName().equals("getUrl") || !m.getName().startsWith("get") || m.getParameterCount() == 0) {
                    continue;
                }
                filteredMethods.add(m);
            }
            for (Entry<String, String> entry : tables.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                for (Method filteredMethod : filteredMethods) {
                    // Method is deprecated; we don't care if it doesn't have all the
                    // codes
                    if (filteredMethod.isAnnotationPresent(Deprecated.class)) {
                        continue;
                    }
                    if (Objects.equals(filteredMethod.getName(), key)) {
                        String methodFqdn = clazz.getSimpleName() + "." + filteredMethod.getName();
                        URLEndpoint fullUrl = url.append(value);

                        // We need to use the English locale as the parameter names in the
                        // methods match the API
                        GETRequester requester = new GETRequester(StandardCharsets.UTF_8);
                        HttpResponse res = requester.getResponse(fullUrl.toURL("en").toString());
                        TimeUnit.MILLISECONDS.sleep(TestConstants.API_SLEEP_MS);
                        String body = res.getBody();
                        if (body != null) {
                            // Table exist for the given language; process it
                            JsonNode n = new JsonConverter().toNode(body);
                            JsonNode m = n.get("variables");
                            List<String> codes = m.findValuesAsText("code");
                            List<String> texts = m.findValuesAsText("text");

                            Map<String, String> codesTexts = new LinkedHashMap<>();
                            for (int i = 0; i < codes.size(); i++) {
                                codesTexts.put(codes.get(i), texts.get(i));
                            }
                            // Remove ContentsCode code as this is implicitly added by
                            // every method
                            codesTexts.remove("ContentsCode");

                            List<String> methodParameters = parameters.get(key);
                            List<String> apiParameters = new ArrayList<>(codesTexts.values());

                            boolean missingParameters = TestProcessor.isMissingParameters(methodParameters,
                                    apiParameters);

                            boolean jumbledParameters = false;
                            if (!missingParameters) {
                                jumbledParameters = TestProcessor.isJumbled(methodParameters, apiParameters);
                            }

                            // Validate constraints
                            if (missingParameters || jumbledParameters) {
                                offendingMethods.add(methodFqdn);

                                builder.append(methodFqdn + " has missing or jumbled parameters.");
                                builder.append(System.lineSeparator() + "\t");
                                builder.append("API parameters: " + apiParameters);
                                builder.append(System.lineSeparator() + "\t");
                                builder.append("Method parameters: " + methodParameters);
                                builder.append(System.lineSeparator());
                            }
                        }
                    }
                }
            }
        }
        assertTrue(offendingMethods.isEmpty(),
                "There are offending methods. " + System.lineSeparator() + builder.toString());
    }

    @Test
    public void checkForNonDuplicatedCodeAndValueCombinations()
            throws IllegalArgumentException, IllegalAccessException {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        Map<String, List<String>> offendingCodes = new HashMap<>();
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
                Field[] fields = clazz.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    String name = field.getName();
                    if (name.endsWith("CODE")) {
                        field.setAccessible(true);
                        String value = (String) field.get(clazz);
                        field.setAccessible(false);
                        String full = name + "." + value;
                        List<String> classes = null;
                        if (!offendingCodes.containsKey(full)) {
                            classes = new ArrayList<>();
                        } else {
                            classes = offendingCodes.get(full);
                        }
                        classes.add(clazz.getSimpleName());
                        offendingCodes.put(full, classes);
                    }
                }
            } catch (ClassNotFoundException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                assertTrue(false, e.getMessage());
            }
        }

        // Remove code and value combinations which only occurs once (which means it isn't
        // a duplicate)
        offendingCodes.values().removeIf(v -> v.size() == 1);

        assertTrue(offendingCodes.isEmpty(), "Duplicated code and value combinations: " + offendingCodes.toString());
    }

    @Test
    public void checkForCorrectPackageLevel() throws Exception {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        Filters.files(files, AbstractClient.class, AbstractContainerClient.class, SCBClientBuilder.class);

        Map<Class<?>, Long> matchedClasses = new HashMap<>();
        for (File file : files) {
            // Convert path into binary name
            String binaryName = Files.fileToBinaryName(file);
            if (binaryName.contains("package-info")) {
                continue;
            }

            String rootName = SCBClient.class.getName();
            String rootPackageName = rootName.substring(0, rootName.lastIndexOf('.'));

            // Reflect the binary name into a concrete Java class
            Class<?> clazz = null;
            try {
                clazz = Class.forName(binaryName);
                String name = clazz.getName();
                String packageName = name.substring(0, name.lastIndexOf('.'));

                int childPackagesBeginningPos = packageName.indexOf(rootPackageName) + rootPackageName.length();
                String childPackages = packageName.substring(childPackagesBeginningPos);
                long levelsBelowRoot = childPackages.codePoints().filter(x -> x == '.').count();

                Method m = clazz.getDeclaredMethod("getUrl");
                Constructor<?> c = clazz.getConstructor();
                Object t = c.newInstance();
                Object o = m.invoke(t);

                URLEndpoint endPoint = (URLEndpoint) o;
                String table = endPoint.getTable();
                long numberOfTableSegments = table.codePoints().filter(x -> x == '/').count();

                if (levelsBelowRoot != numberOfTableSegments) {
                    matchedClasses.put(clazz, numberOfTableSegments);
                }
            } catch (ClassNotFoundException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                assertTrue(false, e.getMessage());
            }
        }
        if (!matchedClasses.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append("The following classes has wrong package level: ");
            for (Entry<Class<?>, Long> entry : matchedClasses.entrySet()) {
                Class<?> clazz = entry.getKey();
                builder.append(clazz.getSimpleName());
                builder.append(" should have level ");
                builder.append(entry.getValue());
                builder.append(", ");
            }
            assertTrue(false, builder.toString());
        }
    }

    @Test
    public void checkForCodesPresentAmongConstants() throws Exception {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        Filters.files(files, AbstractClient.class, AbstractContainerClient.class, SCBClientBuilder.class);

        List<Field> constantVariables = Arrays.asList(APIConstants.class.getDeclaredFields());
        // Filter out synthetic variables (such as transient variable $jacocoData)
        constantVariables = constantVariables.stream().filter(x -> !x.isSynthetic()).collect(Collectors.toList());

        List<String> constantVariablesValues = new ArrayList<>();
        for (Field constantVariable : constantVariables) {
            constantVariablesValues.add(constantVariable.get(null).toString());
        }

        List<Class<?>> matchedClasses = new ArrayList<>();
        for (File file : files) {
            // Convert path into binary name
            String binaryName = Files.fileToBinaryName(file);
            if (binaryName.contains("package-info")) {
                continue;
            }

            Class<?> clazz = null;
            try {
                clazz = Class.forName(binaryName);

                List<Field> classVariables = Arrays.asList(clazz.getDeclaredFields());
                // Filter out synthetic variables (such as transient variable $jacocoData)
                classVariables = classVariables.stream().filter(x -> !x.isSynthetic()).collect(Collectors.toList());
                for (Field f1 : classVariables) {
                    f1.setAccessible(true);
                }

                List<String> classVariablesValues = new ArrayList<>();
                for (Field classVariable : classVariables) {
                    classVariablesValues.add(classVariable.get(null).toString());
                }

                boolean hasMatch = classVariablesValues.stream().anyMatch(x -> constantVariablesValues.contains(x));
                if (hasMatch) {
                    matchedClasses.add(clazz);
                }
            } catch (ClassNotFoundException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                assertTrue(false, e.getMessage());
            }
        }
        assertTrue(matchedClasses.isEmpty(), "Classes repeating codes: " + matchedClasses.toString());
    }

}
