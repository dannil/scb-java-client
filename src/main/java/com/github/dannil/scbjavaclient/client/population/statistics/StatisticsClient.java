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
import com.github.dannil.scbjavaclient.client.population.statistics.adoptees.AdopteesClient;
import com.github.dannil.scbjavaclient.client.population.statistics.amount.AmountClient;
import com.github.dannil.scbjavaclient.client.population.statistics.asylumseekers.AsylumSeekersClient;
import com.github.dannil.scbjavaclient.client.population.statistics.averageage.AverageAgeClient;
import com.github.dannil.scbjavaclient.client.population.statistics.background.BackgroundClient;
import com.github.dannil.scbjavaclient.client.population.statistics.deaths.DeathsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.density.DensityClient;
import com.github.dannil.scbjavaclient.client.population.statistics.foreignbornpersons.ForeignBornPersonsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.foreigncitizens.ForeignCitizensClient;
import com.github.dannil.scbjavaclient.client.population.statistics.household.HouseholdClient;
import com.github.dannil.scbjavaclient.client.population.statistics.livebirths.LiveBirthsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.migration.MigrationClient;
import com.github.dannil.scbjavaclient.client.population.statistics.partnership.PartnershipClient;
import com.github.dannil.scbjavaclient.client.population.statistics.vitalevents.VitalEventsClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles population statistics data fetching.</p>
 *
 * @since 0.0.2
 */
public class StatisticsClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public StatisticsClient() {
        super();

        addClient("adoptees", new AdopteesClient());
        addClient("amount", new AmountClient());
        addClient("asylumseekers", new AsylumSeekersClient());
        addClient("averageage", new AverageAgeClient());
        addClient("background", new BackgroundClient());
        addClient("deaths", new DeathsClient());
        addClient("density", new DensityClient());
        addClient("foreignbornpersons", new ForeignBornPersonsClient());
        addClient("foreigncitizens", new ForeignCitizensClient());
        addClient("household", new HouseholdClient());
        addClient("livebirths", new LiveBirthsClient());
        addClient("migration", new MigrationClient());
        addClient("partnership", new PartnershipClient());
        addClient("vitalevents", new VitalEventsClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public StatisticsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with population statistics adoptees
     * data.</p>
     *
     * @return a client for population statistics adoptees data
     */
    public AdopteesClient adoptees() {
        return (AdopteesClient) getClient("adoptees");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics amount data.</p>
     *
     * @return a client for population statistics amount data
     */
    public AmountClient amount() {
        return (AmountClient) getClient("amount");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics asylum seekers
     * data.</p>
     *
     * @return a client for population statistics asylum seekers data
     */
    public AsylumSeekersClient asylumSeekers() {
        return (AsylumSeekersClient) getClient("asylumseekers");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics average age data.
     * </p>
     *
     * @return a client for population statistics average age data
     */
    public AverageAgeClient averageAge() {
        return (AverageAgeClient) getClient("averageage");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics background data.
     * </p>
     *
     * @return a client for population statistics background data
     */
    public BackgroundClient background() {
        return (BackgroundClient) getClient("background");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics deaths data. </p>
     *
     * @return a client for population statistics deaths data
     */
    public DeathsClient deaths() {
        return (DeathsClient) getClient("deaths");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics density data.
     * </p>
     *
     * @return a client for population statistics density data
     */
    public DensityClient density() {
        return (DensityClient) getClient("density");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics foreign-born
     * persons data. </p>
     *
     * @return a client for population statistics foreign-born persons data
     */
    public ForeignBornPersonsClient foreignBornPersons() {
        return (ForeignBornPersonsClient) getClient("foreignbornpersons");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics foreign citizens
     * data. </p>
     *
     * @return a client for population statistics foreign citizens data
     */
    public ForeignCitizensClient foreignCitizens() {
        return (ForeignCitizensClient) getClient("foreigncitizens");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics household data.
     * </p>
     *
     * @return a client for population statistics household data
     */
    public HouseholdClient household() {
        return (HouseholdClient) getClient("household");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics live births data.
     * </p>
     *
     * @return a client for population statistics live births data
     */
    public LiveBirthsClient liveBirths() {
        return (LiveBirthsClient) getClient("livebirths");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics migration data.
     * </p>
     *
     * @return a client for population statistics migration data
     */
    public MigrationClient migration() {
        return (MigrationClient) getClient("migration");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics partnership
     * data.</p>
     *
     * @return a client for population statistics partnership data
     */
    public PartnershipClient partnership() {
        return (PartnershipClient) getClient("partnership");
    }

    /**
     * <p>Retrieve the client for interacting with population statistics vital events
     * data.</p>
     *
     * @return a client for population statistics vital events data
     */
    public VitalEventsClient vitalEvents() {
        return (VitalEventsClient) getClient("vitalevents");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/");
    }

}
