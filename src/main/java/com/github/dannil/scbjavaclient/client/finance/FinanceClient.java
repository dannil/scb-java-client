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

package com.github.dannil.scbjavaclient.client.finance;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.finance.investmentfunds.FinanceInvestmentFundsClient;
import com.github.dannil.scbjavaclient.client.finance.shareholders.FinanceShareholdersClient;

/**
 * <p>Client which handles finance data fetching.</p>
 *
 * @since 0.2.0
 */
public class FinanceClient extends AbstractContainerClient {

    private FinanceInvestmentFundsClient financeInvestmentFundsClient;

    private FinanceShareholdersClient financeShareholdersClient;

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public FinanceClient() {
        super();

        this.financeInvestmentFundsClient = new FinanceInvestmentFundsClient();
        addClient(this.financeInvestmentFundsClient);

        this.financeShareholdersClient = new FinanceShareholdersClient();
        addClient(this.financeShareholdersClient);
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinanceClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with finance investment funds data.</p>
     *
     * @return a client for finance investment funds data
     */
    public FinanceInvestmentFundsClient investmentFunds() {
        return this.financeInvestmentFundsClient;
    }

    /**
     * <p>Retrieve the client for interacting with finance shareholders data.</p>
     *
     * @return a client for finance shareholders data
     */
    public FinanceShareholdersClient shareholders() {
        return this.financeShareholdersClient;
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "FM/";
    }

}
