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

package com.github.dannil.scbjavaclient.client.financialmarkets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.FinancialMarketsBalanceOfPaymentsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.enterprises.FinancialMarketsEnterprisesClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.institutions.FinancialMarketsInstitutionsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.investmentfunds.FinancialMarketsInvestmentFundsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.securities.FinancialMarketsSecuritiesClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.shareholders.FinancialMarketsShareholdersClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.statistics.FinancialMarketsStatisticsClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class FinancialMarketsClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        FinancialMarketsClient client = new FinancialMarketsClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void balanceOfPaymentsClient() {
        FinancialMarketsClient client = new FinancialMarketsClient();

        assertEquals(FinancialMarketsBalanceOfPaymentsClient.class, client.balanceOfPayments().getClass());
    }

    @Test
    public void enterprisesClient() {
        FinancialMarketsClient client = new FinancialMarketsClient();

        assertEquals(FinancialMarketsEnterprisesClient.class, client.enterprises().getClass());
    }

    @Test
    public void institutionsClient() {
        FinancialMarketsClient client = new FinancialMarketsClient();

        assertEquals(FinancialMarketsInstitutionsClient.class, client.institutions().getClass());
    }

    @Test
    public void investmentFundsClient() {
        FinancialMarketsClient client = new FinancialMarketsClient();

        assertEquals(FinancialMarketsInvestmentFundsClient.class, client.investmentFunds().getClass());
    }

    @Test
    public void securitiesClient() {
        FinancialMarketsClient client = new FinancialMarketsClient();

        assertEquals(FinancialMarketsSecuritiesClient.class, client.securities().getClass());
    }

    @Test
    public void shareholdersClient() {
        FinancialMarketsClient client = new FinancialMarketsClient();

        assertEquals(FinancialMarketsShareholdersClient.class, client.shareholders().getClass());
    }

    @Test
    public void statisticsClient() {
        FinancialMarketsClient client = new FinancialMarketsClient();

        assertEquals(FinancialMarketsStatisticsClient.class, client.statistics().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        FinancialMarketsClient client = new FinancialMarketsClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("FM/"), client.getUrl());
    }

}
