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

package com.github.dannil.scbjavaclient.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.agriculture.AgricultureClient;
import com.github.dannil.scbjavaclient.client.businessactivities.BusinessActivitiesClient;
import com.github.dannil.scbjavaclient.client.educationandresearch.EducationAndResearchClient;
import com.github.dannil.scbjavaclient.client.energy.EnergyClient;
import com.github.dannil.scbjavaclient.client.environment.EnvironmentClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.FinancialMarketsClient;
import com.github.dannil.scbjavaclient.client.goodsandservices.GoodsAndServicesClient;
import com.github.dannil.scbjavaclient.client.labourmarket.LabourMarketClient;
import com.github.dannil.scbjavaclient.client.livingconditions.LivingConditionsClient;
import com.github.dannil.scbjavaclient.client.population.PopulationClient;
import com.github.dannil.scbjavaclient.client.pricesandconsumption.PricesAndConsumptionClient;
import com.github.dannil.scbjavaclient.client.publicfinances.PublicFinancesClient;
import com.github.dannil.scbjavaclient.client.transport.TransportClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class SCBClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void setLocalizationLanguage() {
        Locale locale = new Locale("sv", "SE");
        SCBClient client = new SCBClient(locale);

        Locale localizationLocale = new Locale("en", "US");
        client.setLocalizationLocale(localizationLocale);

        assertEquals(localizationLocale, client.getLocalizationLocale());
    }

    @Test
    public void agriculture() {
        SCBClient client = new SCBClient();

        assertEquals(AgricultureClient.class, client.agriculture().getClass());
    }

    @Test
    public void businessActivities() {
        SCBClient client = new SCBClient();

        assertEquals(BusinessActivitiesClient.class, client.businessActivities().getClass());
    }

    @Test
    public void educationAndResearch() {
        SCBClient client = new SCBClient();

        assertEquals(EducationAndResearchClient.class, client.educationAndResearch().getClass());
    }

    @Test
    public void energy() {
        SCBClient client = new SCBClient();

        assertEquals(EnergyClient.class, client.energy().getClass());
    }

    @Test
    public void environment() {
        SCBClient client = new SCBClient();

        assertEquals(EnvironmentClient.class, client.environment().getClass());
    }

    @Test
    public void financialMarkets() {
        SCBClient client = new SCBClient();

        assertEquals(FinancialMarketsClient.class, client.financialMarkets().getClass());
    }

    @Test
    public void goodsAndServices() {
        SCBClient client = new SCBClient();

        assertEquals(GoodsAndServicesClient.class, client.goodsAndServices().getClass());
    }

    @Test
    public void labourMarket() {
        SCBClient client = new SCBClient();

        assertEquals(LabourMarketClient.class, client.labourMarket().getClass());
    }

    @Test
    public void livingConditions() {
        SCBClient client = new SCBClient();

        assertEquals(LivingConditionsClient.class, client.livingConditions().getClass());
    }

    @Test
    public void population() {
        SCBClient client = new SCBClient();

        assertEquals(PopulationClient.class, client.population().getClass());
    }

    @Test
    public void pricesAndConsumption() {
        SCBClient client = new SCBClient();

        assertEquals(PricesAndConsumptionClient.class, client.pricesAndConsumption().getClass());
    }

    @Test
    public void publicFinances() {
        SCBClient client = new SCBClient();

        assertEquals(PublicFinancesClient.class, client.publicFinances().getClass());
    }

    @Test
    public void transport() {
        SCBClient client = new SCBClient();

        assertEquals(TransportClient.class, client.transport().getClass());
    }

    @Test
    public void getUrl() {
        Locale locale = new Locale("en", "US");
        SCBClient client = new SCBClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale), client.getUrl());
    }

}
