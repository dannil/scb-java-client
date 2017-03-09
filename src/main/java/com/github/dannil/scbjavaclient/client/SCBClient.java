/*
 * Copyright 2014 Daniel Nilsson
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

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import com.github.dannil.scbjavaclient.client.environment.EnvironmentClient;
import com.github.dannil.scbjavaclient.client.finance.FinanceClient;
import com.github.dannil.scbjavaclient.client.population.PopulationClient;
import com.github.dannil.scbjavaclient.exception.SCBClientNotFoundException;
import com.github.dannil.scbjavaclient.format.json.JsonAPIConfigTableFormat;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;
import com.github.dannil.scbjavaclient.utility.URLUtility;

/**
 * <p>Root client for the client hierarchy.</p>
 *
 * @since 0.0.2
 */
public class SCBClient extends AbstractContainerClient {

    private EnvironmentClient environmentClient;

    private FinanceClient financeClient;

    private PopulationClient populationClient;

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public SCBClient() {
        super();

        this.environmentClient = new EnvironmentClient();
        addClient(this.environmentClient);

        this.financeClient = new FinanceClient();
        addClient(financeClient);

        this.populationClient = new PopulationClient();
        addClient(this.populationClient);
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the locale for this client
     */
    public SCBClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with environment data.</p>
     *
     * @return a client for environment data
     */
    public EnvironmentClient environment() {
        return this.environmentClient;
    }

    /**
     * <p>Retrieve the client for interacting with finance data.</p>
     *
     * @return a client for finance data
     */
    public FinanceClient finance() {
        return this.financeClient;
    }

    /**
     * <p>Retrieve the client for interacting with population data.</p>
     *
     * @return a client for population data
     */
    public PopulationClient population() {
        return this.populationClient;
    }

    /**
     * <p>Fetches all the inputs for a given table from the API.</p>
     *
     * @param table
     *            the table to fetch the inputs from
     * @return a collection of all codes and their respective values
     *
     * @see com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat#getInputs()
     *      JsonAPITableFormat#getInputs()
     */
    public Map<String, Collection<String>> getInputs(String table) {
        String url = getUrl() + table;
        String json = doGetRequest(url);

        return new JsonAPITableFormat(json).getInputs();
    }

    /**
     * <p>Returns the list of the available regions for a given table.</p>
     *
     * @param table
     *            the table to retrieve the regions from
     * @return a list of the available regions for the given table
     */
    public List<String> getRegions(String table) {
        String url = getUrl() + table;
        String json = doGetRequest(url);
        String code = "Region";

        JsonAPITableFormat format = new JsonAPITableFormat(json);
        return format.getValues(code);
    }

    /**
     * <p>Returns the list of the available times for a given table.</p>
     *
     * @param table
     *            the table to retrieve the times from
     * @return a list of the available times for the given table
     */
    public List<String> getTimes(String table) {
        String url = getUrl() + table;
        String json = doGetRequest(url);
        String code = "Tid";

        JsonAPITableFormat format = new JsonAPITableFormat(json);
        return format.getValues(code);
    }

    /**
     * <p>Fetch the JSON response from the specified table. As opposed to
     * {@link #getRawData(String, Map)}, this method fetches all available data and
     * therefore doesn't support selecting specific values before calling the API.</p>
     *
     * <p>Do note: as this method matches all content codes available on the API, the
     * response is likely to be several times larger than the response when selecting
     * values.</p>
     *
     * @param table
     *            the table to fetch data from
     * @return a JSON string containing all available data in the specified table
     *
     * @see com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat#getValues(String)
     *      JsonAPITableFormat#getValues(String)
     */
    public String getRawData(String table) {
        String url = getUrl() + table;
        String json = doGetRequest(url);

        Map<String, Collection<?>> inputs = new HashMap<>();
        inputs.put("ContentsCode", new JsonAPITableFormat(json).getValues("ContentsCode"));

        return getRawData(table, inputs);
    }

    /**
     * <p>Fetch the JSON response from the specified table. Useful if you're only
     * interested in the raw JSON data.</p>
     *
     * @param table
     *            the table to fetch data from
     * @param query
     *            the selected values
     * @return a response from the API formatted as JSON
     */
    public String getRawData(String table, Map<String, Collection<?>> query) {
        return doPostRequest(getUrl() + table, QueryBuilder.build(query));
    }

    /**
     * <p>Fetches the config from the API. Useful if you for example need to know how
     * often you're allowed to make calls to the API, or the max size of the response.</p>
     *
     * @return the config
     */
    public Map<String, String> getConfig() {
        String url = getUrl() + "?config";
        String json = doGetRequest(url);

        JsonAPIConfigTableFormat format = new JsonAPIConfigTableFormat(json);

        Map<String, String> config = new HashMap<>();
        for (Entry<String, Collection<String>> entry : format.getInputs().entrySet()) {
            Iterator<String> it = entry.getValue().iterator();
            config.put(entry.getKey(), it.next());
        }
        return config;
    }

    /**
     * <p>Checks if the specified <code>Locale</code> is supported by the API. The method
     * performs a request to the API using the <code>Locale</code>'s language and checks
     * if a HTTP resource exists matching the language.</p>
     *
     * @param locale
     *            the <code>Locale</code> to check
     * @return true if the <code>Locale</code> is supported, otherwise false
     */
    public static boolean isSupportedLocale(Locale locale) {
        String url = URLUtility.getRootUrl(locale);

        AbstractRequester get = new GETRequester();
        try {
            get.getBody(url);
            return true;
        } catch (SCBClientNotFoundException e) {
            return false;
        }
    }

    @Override
    public String getUrl() {
        return getRootUrl();
    }

}
