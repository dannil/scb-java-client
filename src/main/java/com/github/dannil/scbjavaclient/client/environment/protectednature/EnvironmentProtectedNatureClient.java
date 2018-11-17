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

package com.github.dannil.scbjavaclient.client.environment.protectednature;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.environment.protectednature.naturetypes.EnvironmentProtectedNatureNatureTypesClient;
import com.github.dannil.scbjavaclient.client.environment.protectednature.numberandarea.EnvironmentProtectedNatureNumberAndAreaClient;
import com.github.dannil.scbjavaclient.client.environment.protectednature.populationandaccessibility.EnvironmentProtectedNaturePopulationAndAccessibilityClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles environment protected nature data fetching.</p>
 *
 * @since 0.5.0
 */
public class EnvironmentProtectedNatureClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public EnvironmentProtectedNatureClient() {
        super();

        addClient("naturetypes", new EnvironmentProtectedNatureNatureTypesClient());
        addClient("numberandarea", new EnvironmentProtectedNatureNumberAndAreaClient());
        addClient("populationandaccessibility", new EnvironmentProtectedNaturePopulationAndAccessibilityClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentProtectedNatureClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with environment protected nature nature
     * types data.</p>
     *
     * @return a client for environment protected nature nature types data
     */
    public EnvironmentProtectedNatureNatureTypesClient natureTypes() {
        return (EnvironmentProtectedNatureNatureTypesClient) getClient("naturetypes");
    }

    /**
     * <p>Retrieve the client for interacting with environment protected nature number and
     * area data.</p>
     *
     * @return a client for environment protected nature number and area data
     */
    public EnvironmentProtectedNatureNumberAndAreaClient numberAndArea() {
        return (EnvironmentProtectedNatureNumberAndAreaClient) getClient("numberandarea");
    }

    /**
     * <p>Retrieve the client for interacting with environment protected nature population
     * and accessibility data.</p>
     *
     * @return a client for environment protected nature population and accessibility data
     */
    public EnvironmentProtectedNaturePopulationAndAccessibilityClient populationAndAccessibility() {
        return (EnvironmentProtectedNaturePopulationAndAccessibilityClient) getClient("populationandaccessibility");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0603/");
    }

}
