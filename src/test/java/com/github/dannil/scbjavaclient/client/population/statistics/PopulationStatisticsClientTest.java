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

import com.github.dannil.scbjavaclient.client.population.statistics.adoptees.PopulationStatisticsAdopteesClient;
import com.github.dannil.scbjavaclient.client.population.statistics.amount.PopulationStatisticsAmountClient;
import com.github.dannil.scbjavaclient.client.population.statistics.asylumseekers.PopulationStatisticsAsylumSeekersClient;
import com.github.dannil.scbjavaclient.client.population.statistics.averageage.PopulationStatisticsAverageAgeClient;
import com.github.dannil.scbjavaclient.client.population.statistics.deaths.PopulationStatisticsDeathsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.density.PopulationStatisticsDensityClient;
import com.github.dannil.scbjavaclient.client.population.statistics.foreigncitizens.PopulationStatisticsForeignCitizensClient;
import com.github.dannil.scbjavaclient.client.population.statistics.livebirths.PopulationStatisticsLiveBirthsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.migration.PopulationStatisticsMigrationClient;
import com.github.dannil.scbjavaclient.client.population.statistics.partnership.PopulationStatisticsPartnershipClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
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
        assertEquals(client.amount().getLocale(), locale);
        assertEquals(client.density().getLocale(), locale);
        assertEquals(client.liveBirths().getLocale(), locale);
        assertEquals(client.partnership().getLocale(), locale);
    }

    @Test
    public void adopteesClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(client.adoptees().getClass(), PopulationStatisticsAdopteesClient.class);
    }

    @Test
    public void amountClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(client.amount().getClass(), PopulationStatisticsAmountClient.class);
    }

    @Test
    public void asylumSeekersClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(client.asylumSeekers().getClass(), PopulationStatisticsAsylumSeekersClient.class);
    }

    @Test
    public void averageAgeClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(client.averageAge().getClass(), PopulationStatisticsAverageAgeClient.class);
    }

    @Test
    public void deathsClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(client.deaths().getClass(), PopulationStatisticsDeathsClient.class);
    }

    @Test
    public void densityClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(client.density().getClass(), PopulationStatisticsDensityClient.class);
    }

    @Test
    public void foreignCitizensClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(client.foreignCitizens().getClass(), PopulationStatisticsForeignCitizensClient.class);
    }

    @Test
    public void liveBirthsClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(client.liveBirths().getClass(), PopulationStatisticsLiveBirthsClient.class);
    }

    @Test
    public void migrationClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(client.migration().getClass(), PopulationStatisticsMigrationClient.class);
    }

    @Test
    public void partnershipClient() {
        PopulationStatisticsClient client = new PopulationStatisticsClient();

        assertEquals(client.partnership().getClass(), PopulationStatisticsPartnershipClient.class);
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
