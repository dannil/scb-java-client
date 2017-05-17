/*
 * Copyright 2016 Daniel Nilsson
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

import static org.junit.Assert.assertEquals;

import java.util.Locale;

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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StatisticsClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        StatisticsClient client = new StatisticsClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void isSubClientsSameLocale() {
        StatisticsClient client = new StatisticsClient();
        Locale locale = client.getLocale();

        // Not all sub-clients needs to be here. If one of the asserts fails it
        // automatically applies to all sub-clients since they share the same logic
        assertEquals(client.amount().getLocale(), locale);
        assertEquals(client.density().getLocale(), locale);
        assertEquals(client.liveBirths().getLocale(), locale);
        assertEquals(client.partnership().getLocale(), locale);
    }

    @Test
    public void adopteesClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.adoptees().getClass(), AdopteesClient.class);
    }

    @Test
    public void amountClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.amount().getClass(), AmountClient.class);
    }

    @Test
    public void asylumSeekersClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.asylumSeekers().getClass(), AsylumSeekersClient.class);
    }

    @Test
    public void averageAgeClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.averageAge().getClass(), AverageAgeClient.class);
    }

    @Test
    public void backgroundClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.background().getClass(), BackgroundClient.class);
    }

    @Test
    public void deathsClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.deaths().getClass(), DeathsClient.class);
    }

    @Test
    public void densityClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.density().getClass(), DensityClient.class);
    }

    @Test
    public void foreignBornPersonsClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.foreignBornPersons().getClass(), ForeignBornPersonsClient.class);
    }

    @Test
    public void foreignCitizensClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.foreignCitizens().getClass(), ForeignCitizensClient.class);
    }

    @Test
    public void householdClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.household().getClass(), HouseholdClient.class);
    }

    @Test
    public void liveBirthsClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.liveBirths().getClass(), LiveBirthsClient.class);
    }

    @Test
    public void migrationClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.migration().getClass(), MigrationClient.class);
    }

    @Test
    public void partnershipClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.partnership().getClass(), PartnershipClient.class);
    }

    @Test
    public void vitalEventsClient() {
        StatisticsClient client = new StatisticsClient();

        assertEquals(client.vitalEvents().getClass(), VitalEventsClient.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        StatisticsClient client = new StatisticsClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("BE/BE0101/"), client.getUrl());
    }

}
