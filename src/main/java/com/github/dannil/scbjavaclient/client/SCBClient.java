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
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.environment.EnvironmentClient;
import com.github.dannil.scbjavaclient.client.population.PopulationClient;
import com.github.dannil.scbjavaclient.exception.SCBClientUrlNotFoundException;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;
import com.github.dannil.scbjavaclient.utility.URLUtility;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.utility.requester.RequestMethod;
import com.github.dannil.scbjavaclient.utility.requester.RequesterFactory;

/**
 * <p>Root client for the client hierarchy.</p>
 * 
 * @since 0.0.2
 */
public class SCBClient extends AbstractContainerClient {

    private PopulationClient populationClient;

    private EnvironmentClient environmentClient;

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public SCBClient() {
        super();

        this.populationClient = new PopulationClient();
        this.clients.add(this.populationClient);

        this.environmentClient = new EnvironmentClient();
        this.clients.add(this.environmentClient);
    }

    /**
     * <p>Overloaded constructor.</p>
     * 
     * @param locale
     *            the locale for this client
     */
    public SCBClient(Locale locale) {
        this();

        this.setLocale(locale);
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
        String json = super.get(table);

        return new JsonAPITableFormat(json).getInputs();
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
        String json = super.get(table);

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
        return super.post(table, QueryBuilder.build(query));
    }

    /**
     * <p>Checks if the specified <code>Locale</code> is supported by the API. The method
     * performs a request to the API using the <code>Locale</code>'s language and checks
     * if a HTTP resource exists matching the language.</p>
     * 
     * @param locale
     *            the locale to check
     * @return true if the locale is supported, otherwise false
     */
    public static boolean isSupportedLocale(Locale locale) {
        String url = URLUtility.getRootUrl(locale);

        AbstractRequester get = RequesterFactory.getRequester(RequestMethod.GET);
        try {
            get.getBodyAsString(url);
            return true;
        } catch (SCBClientUrlNotFoundException e) {
            return false;
        }
    }

}
