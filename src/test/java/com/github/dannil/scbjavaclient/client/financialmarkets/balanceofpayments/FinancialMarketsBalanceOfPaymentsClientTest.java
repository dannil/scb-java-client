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

package com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.directinvestments.FinancialMarketsBalanceOfPaymentsDirectInvestmentsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.economicindicators.FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.internationalinvestmentposition.FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.payments.FinancialMarketsBalanceOfPaymentsPaymentsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.portfolioinvestment.FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class FinancialMarketsBalanceOfPaymentsClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        FinancialMarketsBalanceOfPaymentsClient client = new FinancialMarketsBalanceOfPaymentsClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void directInvestments() {
        FinancialMarketsBalanceOfPaymentsClient client = new FinancialMarketsBalanceOfPaymentsClient();

        assertEquals(FinancialMarketsBalanceOfPaymentsDirectInvestmentsClient.class,
                client.directInvestments().getClass());
    }

    @Test
    public void economicIndicators() {
        FinancialMarketsBalanceOfPaymentsClient client = new FinancialMarketsBalanceOfPaymentsClient();

        assertEquals(FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClient.class,
                client.economicIndicators().getClass());
    }

    @Test
    public void internationalInvestmentPosition() {
        FinancialMarketsBalanceOfPaymentsClient client = new FinancialMarketsBalanceOfPaymentsClient();

        assertEquals(FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClient.class,
                client.internationalInvestmentPosition().getClass());
    }

    @Test
    public void payments() {
        FinancialMarketsBalanceOfPaymentsClient client = new FinancialMarketsBalanceOfPaymentsClient();

        assertEquals(FinancialMarketsBalanceOfPaymentsPaymentsClient.class, client.payments().getClass());
    }

    @Test
    public void portfolioInvestment() {
        FinancialMarketsBalanceOfPaymentsClient client = new FinancialMarketsBalanceOfPaymentsClient();

        assertEquals(FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient.class,
                client.portfolioInvestment().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        FinancialMarketsBalanceOfPaymentsClient client = new FinancialMarketsBalanceOfPaymentsClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("FM/FM0001/"), client.getUrl());
    }

}
