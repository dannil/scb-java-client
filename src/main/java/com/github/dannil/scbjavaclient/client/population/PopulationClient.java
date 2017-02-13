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
import com.github.dannil.scbjavaclient.utility.URLUtility;

/**
 * <p>Client which handles population data fetching.</p>
 *
 * @since 0.0.2
 */
public class PopulationClient extends AbstractContainerClient {

    private PopulationAmountClient populationAmountClient;

    private PopulationAverageAgeClient populationAverageAgeClient;

    private PopulationDemographyClient populationDemographyClient;

    private PopulationDensityClient populationDensityClient;

    private PopulationLiveBirthsClient populationLiveBirthsClient;

    private PopulationNameStatisticsClient populationNameStatisticsClient;

    private PopulationPartnershipClient populationPartnershipClient;

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public PopulationClient() {
        super();

        this.populationAmountClient = new PopulationAmountClient();
        this.add(this.populationAmountClient);

        this.populationAverageAgeClient = new PopulationAverageAgeClient();
        this.add(this.populationAverageAgeClient);

        this.populationDemographyClient = new PopulationDemographyClient();
        this.add(this.populationDemographyClient);

        this.populationDensityClient = new PopulationDensityClient();
        this.add(this.populationDensityClient);

        this.populationLiveBirthsClient = new PopulationLiveBirthsClient();
        this.add(this.populationLiveBirthsClient);

        this.populationNameStatisticsClient = new PopulationNameStatisticsClient();
        this.add(this.populationNameStatisticsClient);

        this.populationPartnershipClient = new PopulationPartnershipClient();
        this.add(this.populationPartnershipClient);
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationClient(Locale locale) {
        this();

        this.setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with population amount data.</p>
     *
     * @return a client for population amount data
     */
    public PopulationAmountClient amount() {
        return this.populationAmountClient;
    }

    /**
     * <p>Retrieve the client for interacting with population average age data. </p>
     *
     * @return a client for population average age data
     */
    public PopulationAverageAgeClient averageAge() {
        return this.populationAverageAgeClient;
    }

    /**
     * <p>Retrieve the client for interacting with population demography data. </p>
     *
     * @return a client for population demography data
     */
    public PopulationDemographyClient demography() {
        return this.populationDemographyClient;
    }

    /**
     * <p>Retrieve the client for interacting with population density data. </p>
     *
     * @return a client for population density data
     */
    public PopulationDensityClient density() {
        return this.populationDensityClient;
    }

    /**
     * <p>Retrieve the client for interacting with population live births data. </p>
     *
     * @return a client for population live births data
     */
    public PopulationLiveBirthsClient liveBirths() {
        return this.populationLiveBirthsClient;
    }

    /**
     * <p>Retrieve the client for interacting with population name statistic data.</p>
     *
     * @return a client for population name statistic data
     */
    public PopulationNameStatisticsClient nameStatistics() {
        return this.populationNameStatisticsClient;
    }

    /**
     * <p>Retrieve the client for interacting with population partnership data.</p>
     *
     * @return a client for population partnership data
     */
    public PopulationPartnershipClient partnership() {
        return this.populationPartnershipClient;
    }

    @Override
    public String getUrl() {
        return URLUtility.getRootUrl(getLocale()) + "BE/";
    }

}
