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

/**
 * <p>Client which handles financial markets data fetching.</p>
 *
 * @since 0.2.0
 */
public class FinancialMarketsClient extends AbstractContainerClient {

    private FinancialMarketsInstitutionsClient financialMarketsInstitutionsClient;

    private FinancialMarketsInvestmentFundsClient financialMarketsInvestmentFundsClient;

    private FinancialMarketsSecuritiesClient financialMarketsSecuritiesClient;

    private FinancialMarketsShareholdersClient financialMarketsShareholdersClient;

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public FinancialMarketsClient() {
        super();

        this.financialMarketsInstitutionsClient = new FinancialMarketsInstitutionsClient();
        addClient(this.financialMarketsInstitutionsClient);

        this.financialMarketsInvestmentFundsClient = new FinancialMarketsInvestmentFundsClient();
        addClient(this.financialMarketsInvestmentFundsClient);

        this.financialMarketsSecuritiesClient = new FinancialMarketsSecuritiesClient();
        addClient(this.financialMarketsSecuritiesClient);

        this.financialMarketsShareholdersClient = new FinancialMarketsShareholdersClient();
        addClient(this.financialMarketsShareholdersClient);
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
        return this.financialMarketsInstitutionsClient;
    }

    /**
     * <p>Retrieve the client for interacting with financial markets investment funds
     * data.</p>
     *
     * @return a client for financial markets investment funds data
     */
    public FinancialMarketsInvestmentFundsClient investmentFunds() {
        return this.financialMarketsInvestmentFundsClient;
    }

    /**
     * <p>Retrieve the client for interacting with financial markets securities data.</p>
     *
     * @return a client for financial markets securities data
     */
    public FinancialMarketsSecuritiesClient securities() {
        return this.financialMarketsSecuritiesClient;
    }

    /**
     * <p>Retrieve the client for interacting with financial markets shareholders
     * data.</p>
     *
     * @return a client for financial markets shareholders data
     */
    public FinancialMarketsShareholdersClient shareholders() {
        return this.financialMarketsShareholdersClient;
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "FM/";
    }

}
