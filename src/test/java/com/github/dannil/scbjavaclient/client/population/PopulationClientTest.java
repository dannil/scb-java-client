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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.population.name.PopulationNameClient;
import com.github.dannil.scbjavaclient.client.population.projections.PopulationProjectionsClient;
import com.github.dannil.scbjavaclient.client.population.statistics.PopulationStatisticsClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
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
        assertEquals(locale, client.name().getLocale());
        assertEquals(locale, client.statistics().getLocale());
    }

    @Test
    public void nameClient() {
        PopulationClient client = new PopulationClient();

        assertEquals(PopulationNameClient.class, client.name().getClass());
    }

    @Test
    public void projectionsClient() {
        PopulationClient client = new PopulationClient();

        assertEquals(PopulationProjectionsClient.class, client.projections().getClass());
    }

    @Test
    public void statisticsClient() {
        PopulationClient client = new PopulationClient();

        assertEquals(PopulationStatisticsClient.class, client.statistics().getClass());
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
