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
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.ResponseModel;
import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.Files;
import com.github.dannil.scbjavaclient.test.utility.Filters;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class AbstractClientIT extends RemoteIntegrationTestSuite {

    @Test
    @Date("2017-01-01")
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
    @Date("2017-01-01")
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
    @Date("2017-01-01")
    public void urlForbidden() {
        SCBClient client = new SCBClient(new Locale("sv", "SE"));

        // This call will result in a HTTP 403 response (forbidden) since the
        // response from this table is larger than the API allows (given all the available
        // inputs)
        String response = client.getRawData("NV/NV0119/IVPKNLonAr");

        assertNull(response);
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
    @Date("now")
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
    @Date("now")
    public void checkForCorrectPackageAndClientNames() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        Filters.files(files, AbstractClient.class, AbstractContainerClient.class, SCBClient.class);

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
    @Date("now")
    public void checkForUniqueTableImplementations() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        Filters.files(files, AbstractClient.class, AbstractContainerClient.class);

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
                assertTrue(e.getMessage(), false);
            }
        }
        assertTrue("Classes implementing same table: " + offendingClasses.toString(), offendingClasses.isEmpty());
    }

    @Test
    @Date("now")
    public void checkForCorrectSuperclass() {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        Filters.files(files, AbstractClient.class, AbstractContainerClient.class);

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
                assertTrue(e.getMessage(), false);
            }
        }
        assertTrue("Classes not extending correct superclass: " + matchedClasses.toString(), matchedClasses.isEmpty());
    }

    // Method which is used to check for correctly overloaded methods (with methods
    // throwing HTTP 403 removed)
    @Test
    @Date("now")
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
                    // Removed offending methods which occur more than once (which means
                    // that there does exists an overload)
                    if (offendingMethods.get(full) > 1) {
                        offendingMethods.remove(full);
                    }
                }
            } catch (ClassNotFoundException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                assertTrue(e.getMessage(), false);
            }
        }
        // Filter out known methods throwing HTTP 403. Format is the same used for the
        // entries in the offending methods collection
        Set<String> knownMethods = new HashSet<>();
        knownMethods.add("PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient.getPriceIndexForDomesticSupply");
        knownMethods.add("FinancialMarketsStatisticsClaimsAndLiabilitiesClient.getClaimsAndLiabilitiesOutsideSweden");
        knownMethods.add(
                "FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient.getNonResidentTradeInSwedishShares");
        knownMethods.add("PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient.getProducerPriceIndexHomeSales");
        knownMethods.add("PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient.getCostsAndIncomes");
        knownMethods.add("PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient.getProducerPriceIndex");
        knownMethods.add("GoodsAndServicesForeignTradeCNClient.getImportsAndExportsOfGoods");
        knownMethods.add("PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient.getExportPriceIndex");
        knownMethods.add("PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient.getBalanceSheet");
        knownMethods.add("PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient.getImportPriceIndex");
        knownMethods.add("PublicFinancesAnnualAccountsStatementAccountsCountyClient.getIncomeAndCosts");
        knownMethods.add("PricesAndConsumptionPPISPIN2007MonthlyAndQuarterlyClient.getPriceIndexForDomesticSupply");
        knownMethods.add("PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient.getIncomeStatements");
        for (Iterator<Entry<String, Integer>> it = offendingMethods.entrySet().iterator(); it.hasNext();) {
            Entry<String, Integer> entry = it.next();
            if (knownMethods.contains(entry.getKey())) {
                it.remove();
            }
        }
        assertTrue("Methods not having correct overloads: " + offendingMethods.keySet().toString(),
                offendingMethods.isEmpty());
    }

}
