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

package com.github.dannil.scbjavaclient.client.population;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.population.name.PopulationNameClient;
import com.github.dannil.scbjavaclient.client.population.projections.PopulationProjectionsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.PopulationStatisticsClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles population data fetching.</p>
 *
 * @since 0.0.2
 */
public class PopulationClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public PopulationClient() {
        super();

        addClient("name", new PopulationNameClient());
        addClient("projections", new PopulationProjectionsClient());
        addClient("statistics", new PopulationStatisticsClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with population statistics name data.</p>
     *
     * @return a client for population statistics name data
     */
    public PopulationNameClient name() {
        return (PopulationNameClient) getClient("name");
    }

    /**
     * <p>Retrieve the client for interacting with population projections data.</p>
     *
     * @return a client for population projections data
     */
    public PopulationProjectionsClient projections() {
        return (PopulationProjectionsClient) getClient("projections");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics data.</p>
     *
     * @return a client for population statistics data
     */
    public PopulationStatisticsClient statistics() {
        return (PopulationStatisticsClient) getClient("statistics");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/");
    }

}
