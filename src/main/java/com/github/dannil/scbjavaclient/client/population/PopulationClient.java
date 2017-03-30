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
import com.github.dannil.scbjavaclient.client.population.amount.PopulationAmountClient;
import com.github.dannil.scbjavaclient.client.population.averageage.PopulationAverageAgeClient;
import com.github.dannil.scbjavaclient.client.population.demography.PopulationDemographyClient;
import com.github.dannil.scbjavaclient.client.population.density.PopulationDensityClient;
import com.github.dannil.scbjavaclient.client.population.livebirths.PopulationLiveBirthsClient;
import com.github.dannil.scbjavaclient.client.population.name.PopulationNameStatisticsClient;
import com.github.dannil.scbjavaclient.client.population.partnership.PopulationPartnershipClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

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

        addClient("amount", new PopulationAmountClient());
        addClient("averageage", new PopulationAverageAgeClient());
        addClient("demography", new PopulationDemographyClient());
        addClient("density", new PopulationDensityClient());
        addClient("livebirths", new PopulationLiveBirthsClient());
        addClient("namestatistics", new PopulationNameStatisticsClient());
        addClient("partnership", new PopulationPartnershipClient());
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
     * <p>Retrieve the client for interacting with population amount data.</p>
     *
     * @return a client for population amount data
     */
    public PopulationAmountClient amount() {
        return (PopulationAmountClient) getClient("amount");
    }

    /**
     * <p>Retrieve the client for interacting with population average age data. </p>
     *
     * @return a client for population average age data
     */
    public PopulationAverageAgeClient averageAge() {
        return (PopulationAverageAgeClient) getClient("averageage");
    }

    /**
     * <p>Retrieve the client for interacting with population demography data. </p>
     *
     * @return a client for population demography data
     */
    public PopulationDemographyClient demography() {
        return (PopulationDemographyClient) getClient("demography");
    }

    /**
     * <p>Retrieve the client for interacting with population density data. </p>
     *
     * @return a client for population density data
     */
    public PopulationDensityClient density() {
        return (PopulationDensityClient) getClient("density");
    }

    /**
     * <p>Retrieve the client for interacting with population live births data. </p>
     *
     * @return a client for population live births data
     */
    public PopulationLiveBirthsClient liveBirths() {
        return (PopulationLiveBirthsClient) getClient("livebirths");
    }

    /**
     * <p>Retrieve the client for interacting with population name statistic data.</p>
     *
     * @return a client for population name statistic data
     */
    public PopulationNameStatisticsClient nameStatistics() {
        return (PopulationNameStatisticsClient) getClient("namestatistics");
    }

    /**
     * <p>Retrieve the client for interacting with population partnership data.</p>
     *
     * @return a client for population partnership data
     */
    public PopulationPartnershipClient partnership() {
        return (PopulationPartnershipClient) getClient("partnership");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/");
    }

}
