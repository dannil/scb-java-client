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

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.institutions.FinancialMarketsInstitutionsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.investmentfunds.FinancialMarketsInvestmentFundsClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.securities.FinancialMarketsSecuritiesClient;
import com.github.dannil.scbjavaclient.client.financialmarkets.shareholders.FinancialMarketsShareholdersClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles financial markets data fetching.</p>
 *
 * @since 0.2.0
 */
public class FinancialMarketsClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public FinancialMarketsClient() {
        super();

        addClient("institutions", new FinancialMarketsInstitutionsClient());
        addClient("investmentfunds", new FinancialMarketsInvestmentFundsClient());
        addClient("securities", new FinancialMarketsSecuritiesClient());
        addClient("shareholders", new FinancialMarketsShareholdersClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with financial markets institutions
     * data.</p>
     *
     * @return a client for financial markets institutions data
     */
    public FinancialMarketsInstitutionsClient institutions() {
        return (FinancialMarketsInstitutionsClient) getClient("institutions");
    }

    /**
     * <p>Retrieve the client for interacting with financial markets investment funds
     * data.</p>
     *
     * @return a client for financial markets investment funds data
     */
    public FinancialMarketsInvestmentFundsClient investmentFunds() {
        return (FinancialMarketsInvestmentFundsClient) getClient("investmentfunds");
    }

    /**
     * <p>Retrieve the client for interacting with financial markets securities data.</p>
     *
     * @return a client for financial markets securities data
     */
    public FinancialMarketsSecuritiesClient securities() {
        return (FinancialMarketsSecuritiesClient) getClient("securities");
    }

    /**
     * <p>Retrieve the client for interacting with financial markets shareholders
     * data.</p>
     *
     * @return a client for financial markets shareholders data
     */
    public FinancialMarketsShareholdersClient shareholders() {
        return (FinancialMarketsShareholdersClient) getClient("shareholders");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/");
    }

}
