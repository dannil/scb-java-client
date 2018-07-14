/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover.oldtablessni2002.BusinessActivitiesOrdersAndTurnoverOldTablesSNI2002Client;
import com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover.oldtablessni2007.BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007Client;
import com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover.ordersandturnover.BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class BusinessActivitiesOrdersAndTurnoverClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        BusinessActivitiesOrdersAndTurnoverClient client = new BusinessActivitiesOrdersAndTurnoverClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void oldTablesSNI2002Client() {
        BusinessActivitiesOrdersAndTurnoverClient client = new BusinessActivitiesOrdersAndTurnoverClient();

        assertEquals(BusinessActivitiesOrdersAndTurnoverOldTablesSNI2002Client.class,
                client.oldTablesSNI2002().getClass());
    }

    @Test
    public void oldTablesSNI2007Client() {
        BusinessActivitiesOrdersAndTurnoverClient client = new BusinessActivitiesOrdersAndTurnoverClient();

        assertEquals(BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007Client.class,
                client.oldTablesSNI2007().getClass());
    }

    @Test
    public void ordersAndTurnoverClient() {
        BusinessActivitiesOrdersAndTurnoverClient client = new BusinessActivitiesOrdersAndTurnoverClient();

        assertEquals(BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClient.class,
                client.ordersAndTurnover().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        BusinessActivitiesOrdersAndTurnoverClient client = new BusinessActivitiesOrdersAndTurnoverClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("NV/NV0501/"), client.getUrl());
    }

}
