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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

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
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class PopulationStatisticsClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        PopulationStatisticsClient client = new PopulationStatisticsClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void isSubClientsSameLocale() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();
        Locale locale = client.getLocale();

        // Not all sub-clients needs to be here. If one of the asserts fails it
        // automatically applies to all sub-clients since they share the same logic
        assertEquals(locale, client.amount().getLocale());
        assertEquals(locale, client.density().getLocale());
        assertEquals(locale, client.liveBirths().getLocale());
        assertEquals(locale, client.partnership().getLocale());
    }

    @Test
    public void adopteesClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsAdopteesClient.class, client.adoptees().getClass());
    }

    @Test
    public void amountClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsAmountClient.class, client.amount().getClass());
    }

    @Test
    public void asylumSeekersClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsAsylumSeekersClient.class, client.asylumSeekers().getClass());
    }

    @Test
    public void averageAgeClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsAverageAgeClient.class, client.averageAge().getClass());
    }

    @Test
    public void backgroundClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsBackgroundClient.class, client.background().getClass());
    }
    
    @Test
    public void citizenshipClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsCitizenshipClient.class, client.citizenship().getClass());
    }

    @Test
    public void deathsClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsDeathsClient.class, client.deaths().getClass());
    }

    @Test
    public void densityClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsDensityClient.class, client.density().getClass());
    }

    @Test
    public void foreignBornPersonsClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsForeignBornPersonsClient.class, client.foreignBornPersons().getClass());
    }

    @Test
    public void foreignCitizensClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsForeignCitizensClient.class, client.foreignCitizens().getClass());
    }

    @Test
    public void householdClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsHouseholdClient.class, client.household().getClass());
    }

    @Test
    public void liveBirthsClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsLiveBirthsClient.class, client.liveBirths().getClass());
    }
    
    @Test
    public void meanPopulationClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsMeanPopulationClient.class, client.meanPopulation().getClass());
    }

    @Test
    public void migrationClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsMigrationClient.class, client.migration().getClass());
    }

    @Test
    public void partnershipClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsPartnershipClient.class, client.partnership().getClass());
    }

    @Test
    public void vitalEventsClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(PopulationStatisticsVitalEventsClient.class, client.vitalEvents().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        PopulationStatisticsClient client = new PopulationStatisticsClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("BE/BE0101/"), client.getUrl());
    }

}
