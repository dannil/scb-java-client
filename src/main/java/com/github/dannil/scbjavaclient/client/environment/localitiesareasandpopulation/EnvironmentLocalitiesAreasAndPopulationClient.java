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

package com.github.dannil.scbjavaclient.client.environment.localitiesareasandpopulation;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.environment.localitiesareasandpopulation.population.EnvironmentLocalitiesAreasAndPopulationPopulationClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles environment localities areas and population data.</p>
 *
 * @since 0.7.0
 */
public class EnvironmentLocalitiesAreasAndPopulationClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public EnvironmentLocalitiesAreasAndPopulationClient() {
        super();

        addClient("population", new EnvironmentLocalitiesAreasAndPopulationPopulationClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLocalitiesAreasAndPopulationClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with environment localities areas and
     * population population data.</p>
     *
     * @return a client for environment localities areas and population population data
     */
    public EnvironmentLocalitiesAreasAndPopulationPopulationClient population() {
        return (EnvironmentLocalitiesAreasAndPopulationPopulationClient) getClient("population");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0810/");
    }

}
