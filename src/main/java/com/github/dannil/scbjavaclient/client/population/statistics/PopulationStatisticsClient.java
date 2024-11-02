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

package com.github.dannil.scbjavaclient.client.population.statistics;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.population.statistics.adoptees.PopulationStatisticsAdopteesClient;
import com.github.dannil.scbjavaclient.client.population.statistics.amount.PopulationStatisticsAmountClient;
import com.github.dannil.scbjavaclient.client.population.statistics.asylumseekers.PopulationStatisticsAsylumSeekersClient;
import com.github.dannil.scbjavaclient.client.population.statistics.averageage.PopulationStatisticsAverageAgeClient;
import com.github.dannil.scbjavaclient.client.population.statistics.background.PopulationStatisticsBackgroundClient;
import com.github.dannil.scbjavaclient.client.population.statistics.citizenship.PopulationStatisticsCitizenshipClient;
import com.github.dannil.scbjavaclient.client.population.statistics.deaths.PopulationStatisticsDeathsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.density.PopulationStatisticsDensityClient;
import com.github.dannil.scbjavaclient.client.population.statistics.foreignbornpersons.PopulationStatisticsForeignBornPersonsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.foreigncitizens.PopulationStatisticsForeignCitizensClient;
import com.github.dannil.scbjavaclient.client.population.statistics.household.PopulationStatisticsHouseholdClient;
import com.github.dannil.scbjavaclient.client.population.statistics.livebirths.PopulationStatisticsLiveBirthsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.meanpopulation.PopulationStatisticsMeanPopulationClient;
import com.github.dannil.scbjavaclient.client.population.statistics.migration.PopulationStatisticsMigrationClient;
import com.github.dannil.scbjavaclient.client.population.statistics.partnership.PopulationStatisticsPartnershipClient;
import com.github.dannil.scbjavaclient.client.population.statistics.vitalevents.PopulationStatisticsVitalEventsClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * Client which handles population statistics data fetching.
 *
 * @since 0.0.2
 */
public class PopulationStatisticsClient extends AbstractContainerClient {

    /**
     * Default constructor. Initializes values and creates sub-clients.
     */
    public PopulationStatisticsClient() {
        super();

        addClient("adoptees", new PopulationStatisticsAdopteesClient());
        addClient("amount", new PopulationStatisticsAmountClient());
        addClient("asylumseekers", new PopulationStatisticsAsylumSeekersClient());
        addClient("averageage", new PopulationStatisticsAverageAgeClient());
        addClient("background", new PopulationStatisticsBackgroundClient());
        addClient("citizenship", new PopulationStatisticsCitizenshipClient());
        addClient("deaths", new PopulationStatisticsDeathsClient());
        addClient("density", new PopulationStatisticsDensityClient());
        addClient("foreignbornpersons", new PopulationStatisticsForeignBornPersonsClient());
        addClient("foreigncitizens", new PopulationStatisticsForeignCitizensClient());
        addClient("household", new PopulationStatisticsHouseholdClient());
        addClient("livebirths", new PopulationStatisticsLiveBirthsClient());
        addClient("meanpopulation", new PopulationStatisticsMeanPopulationClient());
        addClient("migration", new PopulationStatisticsMigrationClient());
        addClient("partnership", new PopulationStatisticsPartnershipClient());
        addClient("vitalevents", new PopulationStatisticsVitalEventsClient());
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * Retrieve the client for interacting with population statistics adoptees
     * data.
     *
     * @return a client for population statistics adoptees data
     */
    public PopulationStatisticsAdopteesClient adoptees() {
        return (PopulationStatisticsAdopteesClient) getClient("adoptees");
    }

    /**
     * Retrieve the client for interacting with population statistics amount data.
     *
     * @return a client for population statistics amount data
     */
    public PopulationStatisticsAmountClient amount() {
        return (PopulationStatisticsAmountClient) getClient("amount");
    }

    /**
     * Retrieve the client for interacting with population statistics asylum seekers
     * data.
     *
     * @return a client for population statistics asylum seekers data
     */
    public PopulationStatisticsAsylumSeekersClient asylumSeekers() {
        return (PopulationStatisticsAsylumSeekersClient) getClient("asylumseekers");
    }

    /**
     * Retrieve the client for interacting with population statistics average age data.
     *
     *
     * @return a client for population statistics average age data
     */
    public PopulationStatisticsAverageAgeClient averageAge() {
        return (PopulationStatisticsAverageAgeClient) getClient("averageage");
    }

    /**
     * Retrieve the client for interacting with population statistics background data.
     *
     *
     * @return a client for population statistics background data
     */
    public PopulationStatisticsBackgroundClient background() {
        return (PopulationStatisticsBackgroundClient) getClient("background");
    }

    /**
     * Retrieve the client for interacting with population statistics citizenship data.
     *
     *
     * @return a client for population statistics citizenship data
     */
    public PopulationStatisticsCitizenshipClient citizenship() {
        return (PopulationStatisticsCitizenshipClient) getClient("citizenship");
    }

    /**
     * Retrieve the client for interacting with population statistics deaths data.
     *
     * @return a client for population statistics deaths data
     */
    public PopulationStatisticsDeathsClient deaths() {
        return (PopulationStatisticsDeathsClient) getClient("deaths");
    }

    /**
     * Retrieve the client for interacting with population statistics density data.
     *
     *
     * @return a client for population statistics density data
     */
    public PopulationStatisticsDensityClient density() {
        return (PopulationStatisticsDensityClient) getClient("density");
    }

    /**
     * Retrieve the client for interacting with population statistics foreign-born
     * persons data.
     *
     * @return a client for population statistics foreign-born persons data
     */
    public PopulationStatisticsForeignBornPersonsClient foreignBornPersons() {
        return (PopulationStatisticsForeignBornPersonsClient) getClient("foreignbornpersons");
    }

    /**
     * Retrieve the client for interacting with population statistics foreign citizens
     * data.
     *
     * @return a client for population statistics foreign citizens data
     */
    public PopulationStatisticsForeignCitizensClient foreignCitizens() {
        return (PopulationStatisticsForeignCitizensClient) getClient("foreigncitizens");
    }

    /**
     * Retrieve the client for interacting with population statistics household data.
     *
     *
     * @return a client for population statistics household data
     */
    public PopulationStatisticsHouseholdClient household() {
        return (PopulationStatisticsHouseholdClient) getClient("household");
    }

    /**
     * Retrieve the client for interacting with population statistics live births data.
     *
     *
     * @return a client for population statistics live births data
     */
    public PopulationStatisticsLiveBirthsClient liveBirths() {
        return (PopulationStatisticsLiveBirthsClient) getClient("livebirths");
    }

    /**
     * Retrieve the client for interacting with population statistics mean population
     * data.
     *
     * @return a client for population statistics mean population data
     */
    public PopulationStatisticsMeanPopulationClient meanPopulation() {
        return (PopulationStatisticsMeanPopulationClient) getClient("meanpopulation");
    }

    /**
     * Retrieve the client for interacting with population statistics migration data.
     *
     *
     * @return a client for population statistics migration data
     */
    public PopulationStatisticsMigrationClient migration() {
        return (PopulationStatisticsMigrationClient) getClient("migration");
    }

    /**
     * Retrieve the client for interacting with population statistics partnership
     * data.
     *
     * @return a client for population statistics partnership data
     */
    public PopulationStatisticsPartnershipClient partnership() {
        return (PopulationStatisticsPartnershipClient) getClient("partnership");
    }

    /**
     * Retrieve the client for interacting with population statistics vital events
     * data.
     *
     * @return a client for population statistics vital events data
     */
    public PopulationStatisticsVitalEventsClient vitalEvents() {
        return (PopulationStatisticsVitalEventsClient) getClient("vitalevents");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/");
    }

}
