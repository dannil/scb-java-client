/*
 * Copyright 2017 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.businessactivities.accomodationstatistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.businessactivities.accomodationstatistics.month.BusinessActivitiesAccomodationStatisticsMonthClient;
import com.github.dannil.scbjavaclient.client.businessactivities.accomodationstatistics.year.BusinessActivitiesAccomodationStatisticsYearClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class BusinessActivitiesAccomodationStatisticsClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        BusinessActivitiesAccomodationStatisticsClient client = new BusinessActivitiesAccomodationStatisticsClient(
                locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void monthClient() {
        BusinessActivitiesAccomodationStatisticsClient client = new BusinessActivitiesAccomodationStatisticsClient();

        assertEquals(BusinessActivitiesAccomodationStatisticsMonthClient.class, client.month().getClass());
    }

    @Test
    public void yearClient() {
        BusinessActivitiesAccomodationStatisticsClient client = new BusinessActivitiesAccomodationStatisticsClient();

        assertEquals(BusinessActivitiesAccomodationStatisticsYearClient.class, client.year().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        BusinessActivitiesAccomodationStatisticsClient client = new BusinessActivitiesAccomodationStatisticsClient(
                locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("NV/NV1701/"), client.getUrl());
    }

}
