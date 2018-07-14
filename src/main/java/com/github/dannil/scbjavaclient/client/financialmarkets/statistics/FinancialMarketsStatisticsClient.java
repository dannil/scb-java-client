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

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.statistics.claimsandliabilities.FinancialMarketsStatisticsClaimsAndLiabilitiesClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.statistics.depositandlending.FinancialMarketsStatisticsDepositAndLendingClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.statistics.economicindicators.FinancialMarketsStatisticsEconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.statistics.keyfigures.FinancialMarketsStatisticsKeyFiguresClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.statistics.statistics.FinancialMarketsStatisticsStatisticsClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles financial markets statistics data fetching.</p>
 *
 * @since 0.4.0
 */
public class FinancialMarketsStatisticsClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public FinancialMarketsStatisticsClient() {
        super();

        addClient("claimsandliabilities", new FinancialMarketsStatisticsClaimsAndLiabilitiesClient());
        addClient("depositandlending", new FinancialMarketsStatisticsDepositAndLendingClient());
        addClient("economicindicators", new FinancialMarketsStatisticsEconomicIndicatorsClient());
        addClient("keyfigures", new FinancialMarketsStatisticsKeyFiguresClient());
        addClient("statistics", new FinancialMarketsStatisticsStatisticsClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsStatisticsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with financial markets statistics claims and
     * liabilities data.</p>
     *
     * @return a client for financial markets statistics claims and liabilities data
     */
    public FinancialMarketsStatisticsClaimsAndLiabilitiesClient claimsAndLiabilities() {
        return (FinancialMarketsStatisticsClaimsAndLiabilitiesClient) getClient("claimsandliabilities");
    }

    /**
     * <p>Retrieve the client for interacting with financial markets statistics deposit
     * and lending data.</p>
     *
     * @return a client for financial markets statistics deposit and lending data
     */
    public FinancialMarketsStatisticsDepositAndLendingClient depositAndLending() {
        return (FinancialMarketsStatisticsDepositAndLendingClient) getClient("depositandlending");
    }

    /**
     * <p>Retrieve the client for interacting with financial markets statistics economic
     * indicators data.</p>
     *
     * @return a client for financial markets statistics economic indicators data
     */
    public FinancialMarketsStatisticsEconomicIndicatorsClient economicIndicators() {
        return (FinancialMarketsStatisticsEconomicIndicatorsClient) getClient("economicindicators");
    }

    /**
     * <p>Retrieve the client for interacting with financial markets statistics key
     * figures data.</p>
     *
     * @return a client for financial markets statistics key figures data
     */
    public FinancialMarketsStatisticsKeyFiguresClient keyFigures() {
        return (FinancialMarketsStatisticsKeyFiguresClient) getClient("keyfigures");
    }

    /**
     * <p>Retrieve the client for interacting with financial markets statistics statistics
     * data.</p>
     *
     * @return a client for financial markets statistics statistics data
     */
    public FinancialMarketsStatisticsStatisticsClient statistics() {
        return (FinancialMarketsStatisticsStatisticsClient) getClient("statistics");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM5001/");
    }

}
