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
import com.github.dannil.scbjavaclient.client.population.amount.AmountClient;
import com.github.dannil.scbjavaclient.client.population.averageage.AverageAgeClient;
import com.github.dannil.scbjavaclient.client.population.demography.DemographyClient;
import com.github.dannil.scbjavaclient.client.population.density.DensityClient;
import com.github.dannil.scbjavaclient.client.population.livebirths.LiveBirthsClient;
import com.github.dannil.scbjavaclient.client.population.name.NameStatisticsClient;
import com.github.dannil.scbjavaclient.client.population.partnership.PartnershipClient;
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

        addClient("amount", new AmountClient());
        addClient("averageage", new AverageAgeClient());
        addClient("demography", new DemographyClient());
        addClient("density", new DensityClient());
        addClient("livebirths", new LiveBirthsClient());
        addClient("namestatistics", new NameStatisticsClient());
        addClient("partnership", new PartnershipClient());
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
    public AmountClient amount() {
        return (AmountClient) getClient("amount");
    }

    /**
     * <p>Retrieve the client for interacting with population average age data. </p>
     *
     * @return a client for population average age data
     */
    public AverageAgeClient averageAge() {
        return (AverageAgeClient) getClient("averageage");
    }

    /**
     * <p>Retrieve the client for interacting with population demography data. </p>
     *
     * @return a client for population demography data
     */
    public DemographyClient demography() {
        return (DemographyClient) getClient("demography");
    }

    /**
     * <p>Retrieve the client for interacting with population density data. </p>
     *
     * @return a client for population density data
     */
    public DensityClient density() {
        return (DensityClient) getClient("density");
    }

    /**
     * <p>Retrieve the client for interacting with population live births data. </p>
     *
     * @return a client for population live births data
     */
    public LiveBirthsClient liveBirths() {
        return (LiveBirthsClient) getClient("livebirths");
    }

    /**
     * <p>Retrieve the client for interacting with population name statistic data.</p>
     *
     * @return a client for population name statistic data
     */
    public NameStatisticsClient nameStatistics() {
        return (NameStatisticsClient) getClient("namestatistics");
    }

    /**
     * <p>Retrieve the client for interacting with population partnership data.</p>
     *
     * @return a client for population partnership data
     */
    public PartnershipClient partnership() {
        return (PartnershipClient) getClient("partnership");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/");
    }

}
