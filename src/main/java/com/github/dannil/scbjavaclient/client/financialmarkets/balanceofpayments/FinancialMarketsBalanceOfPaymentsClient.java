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

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.directinvestments.FinancialMarketsBalanceOfPaymentsDirectInvestmentsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.economicindicators.FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.internationalinvestmentposition.FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.payments.FinancialMarketsBalanceOfPaymentsPaymentsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.portfolioinvestment.FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles financial markets balance of payments data fetching.</p>
 *
 * @since 0.4.0
 */
public class FinancialMarketsBalanceOfPaymentsClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public FinancialMarketsBalanceOfPaymentsClient() {
        super();

        addClient("directinvestments", new FinancialMarketsBalanceOfPaymentsDirectInvestmentsClient());
        addClient("economicindicators", new FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClient());
        addClient("internationalinvestmentposition",
                new FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClient());
        addClient("payments", new FinancialMarketsBalanceOfPaymentsPaymentsClient());
        addClient("portfolioinvestment", new FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsBalanceOfPaymentsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with financial markets balance of payments
     * direct investments data.</p>
     *
     * @return a client for financial markets balance of payments direct investments data
     */
    public FinancialMarketsBalanceOfPaymentsDirectInvestmentsClient directInvestments() {
        return (FinancialMarketsBalanceOfPaymentsDirectInvestmentsClient) getClient("directinvestments");
    }

    /**
     * <p>Retrieve the client for interacting with financial markets balance of payments
     * economic indicators data.</p>
     *
     * @return a client for financial markets balance of payments economic indicators data
     */
    public FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClient economicIndicators() {
        return (FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClient) getClient("economicindicators");
    }

    /**
     * <p>Retrieve the client for interacting with financial markets balance of payments
     * international investment position data.</p>
     *
     * @return a client for financial markets balance of payments international investment
     *         position data
     */
    public FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClient internationalInvestmentPosition() {
        return (FinancialMarketsBalanceOfPaymentsInternationalInvestmentPositionClient) getClient(
                "internationalinvestmentposition");
    }

    /**
     * <p>Retrieve the client for interacting with financial markets balance of payments
     * payments data.</p>
     *
     * @return a client for financial markets balance of payments payments data
     */
    public FinancialMarketsBalanceOfPaymentsPaymentsClient payments() {
        return (FinancialMarketsBalanceOfPaymentsPaymentsClient) getClient("payments");
    }

    /**
     * <p>Retrieve the client for interacting with financial markets balance of payments
     * portfolio investment data.</p>
     *
     * @return a client for financial markets balance of payments portfolio investment
     *         data
     */
    public FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient portfolioInvestment() {
        return (FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient) getClient("portfolioinvestment");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM0001/");
    }

}
