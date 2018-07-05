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

package com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.oldtablessni2002.GoodsAndServicesTurnoverServiceSectorOldTablesSNI2002Client;
import com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.oldtablessni2007.GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007Client;
import com.github.dannil.scbjavaclient.client.goodsandservices.turnoverservicesector.turnover.GoodsAndServicesTurnoverServiceSectorTurnoverClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class GoodsAndServicesTurnoverServiceSectorClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        GoodsAndServicesTurnoverServiceSectorClient client = new GoodsAndServicesTurnoverServiceSectorClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void oldTablesSNI2002Client() {
        GoodsAndServicesTurnoverServiceSectorClient client = new GoodsAndServicesTurnoverServiceSectorClient();

        assertEquals(GoodsAndServicesTurnoverServiceSectorOldTablesSNI2002Client.class,
                client.oldTablesSNI2002().getClass());
    }

    @Test
    public void oldTablesSNI2007Client() {
        GoodsAndServicesTurnoverServiceSectorClient client = new GoodsAndServicesTurnoverServiceSectorClient();

        assertEquals(GoodsAndServicesTurnoverServiceSectorOldTablesSNI2007Client.class,
                client.oldTablesSNI2007().getClass());
    }

    @Test
    public void turnoverClient() {
        GoodsAndServicesTurnoverServiceSectorClient client = new GoodsAndServicesTurnoverServiceSectorClient();

        assertEquals(GoodsAndServicesTurnoverServiceSectorTurnoverClient.class, client.turnover().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        GoodsAndServicesTurnoverServiceSectorClient client = new GoodsAndServicesTurnoverServiceSectorClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("HA/HA0101/"), client.getUrl());
    }

}
