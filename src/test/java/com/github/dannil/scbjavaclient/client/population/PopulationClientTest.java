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

package com.github.dannil.scbjavaclient.client.population;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.population.demography.DemographyClient;
import com.github.dannil.scbjavaclient.client.population.name.NameClient;
import com.github.dannil.scbjavaclient.client.population.projections.ProjectionsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.StatisticsClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PopulationClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        PopulationClient client = new PopulationClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void isSubClientsSameLocale() {
        PopulationClient client = new PopulationClient();
        Locale locale = client.getLocale();

        // Not all sub-clients needs to be here. If one of the asserts fails it
        // automatically applies to all sub-clients since they share the same logic
        assertEquals(client.demography().getLocale(), locale);
        assertEquals(client.name().getLocale(), locale);
        assertEquals(client.projections().getLocale(), locale);
        assertEquals(client.statistics().getLocale(), locale);
    }

    @Test
    public void demographyClient() {
        PopulationClient client = new PopulationClient();

        assertEquals(client.demography().getClass(), DemographyClient.class);
    }

    @Test
    public void nameClient() {
        PopulationClient client = new PopulationClient();

        assertEquals(client.name().getClass(), NameClient.class);
    }

    @Test
    public void projectionsClient() {
        PopulationClient client = new PopulationClient();

        assertEquals(client.projections().getClass(), ProjectionsClient.class);
    }

    @Test
    public void statisticsClient() {
        PopulationClient client = new PopulationClient();

        assertEquals(client.statistics().getClass(), StatisticsClient.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        PopulationClient client = new PopulationClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("BE/"), client.getUrl());
    }

}
