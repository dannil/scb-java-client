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

package com.github.dannil.scbjavaclient.client.financialmarkets.statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.financialmarkets.statistics.claimsandliabilities.FinancialMarketsStatisticsClaimsAndLiabilitiesClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.statistics.depositandlending.FinancialMarketsStatisticsDepositAndLendingClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.statistics.economicindicators.FinancialMarketsStatisticsEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.statistics.keyfigures.FinancialMarketsStatisticsKeyFiguresClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.statistics.statistics.FinancialMarketsStatisticsStatisticsClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class FinancialMarketsStatisticsClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        FinancialMarketsStatisticsClient client = new FinancialMarketsStatisticsClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void claimsAndLiabilities() {
        FinancialMarketsStatisticsClient client = new FinancialMarketsStatisticsClient();

        assertEquals(FinancialMarketsStatisticsClaimsAndLiabilitiesClient.class,
                client.claimsAndLiabilities().getClass());
    }

    @Test
    public void depositAndLending() {
        FinancialMarketsStatisticsClient client = new FinancialMarketsStatisticsClient();

        assertEquals(FinancialMarketsStatisticsDepositAndLendingClient.class, client.depositAndLending().getClass());
    }

    @Test
    public void economicIndicators() {
        FinancialMarketsStatisticsClient client = new FinancialMarketsStatisticsClient();

        assertEquals(FinancialMarketsStatisticsEconomicIndicatorsClient.class, client.economicIndicators().getClass());
    }

    @Test
    public void keyFigures() {
        FinancialMarketsStatisticsClient client = new FinancialMarketsStatisticsClient();

        assertEquals(FinancialMarketsStatisticsKeyFiguresClient.class, client.keyFigures().getClass());
    }

    @Test
    public void statistics() {
        FinancialMarketsStatisticsClient client = new FinancialMarketsStatisticsClient();

        assertEquals(FinancialMarketsStatisticsStatisticsClient.class, client.statistics().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        FinancialMarketsStatisticsClient client = new FinancialMarketsStatisticsClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("FM/FM5001/"), client.getUrl());
    }

}
