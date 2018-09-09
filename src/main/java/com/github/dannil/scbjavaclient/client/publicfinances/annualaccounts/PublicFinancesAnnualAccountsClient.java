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

package com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetcounty.PublicFinancesAnnualAccountsBalanceSheetCountyClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetmunicipality.PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountscounty.PublicFinancesAnnualAccountsStatementAccountsCountyClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountsmunicipality.PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles public finances annual accounts data fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesAnnualAccountsClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public PublicFinancesAnnualAccountsClient() {
        super();

        addClient("balancesheetcounty", new PublicFinancesAnnualAccountsBalanceSheetCountyClient());
        addClient("balancesheetmunicipality", new PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient());
        addClient("statementaccountscounty", new PublicFinancesAnnualAccountsStatementAccountsCountyClient());
        addClient("statementaccountsmunicipality",
                new PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesAnnualAccountsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with public finances annual accounts balance
     * sheet county data.</p>
     *
     * @return a client for public finances annual accounts balance sheet county data
     */
    public PublicFinancesAnnualAccountsBalanceSheetCountyClient balanceSheetCounty() {
        return (PublicFinancesAnnualAccountsBalanceSheetCountyClient) getClient("balancesheetcounty");
    }

    /**
     * <p>Retrieve the client for interacting with public finances annual accounts balance
     * sheet municipality data.</p>
     *
     * @return a client for public finances annual accounts balance sheet municipality
     *         data
     */
    public PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient balanceSheetMunicipality() {
        return (PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient) getClient("balancesheetmunicipality");
    }

    /**
     * <p>Retrieve the client for interacting with public finances annual accounts
     * statement accounts county data.</p>
     *
     * @return a client for public finances annual accounts statement accounts county data
     */
    public PublicFinancesAnnualAccountsStatementAccountsCountyClient statementAccountsCounty() {
        return (PublicFinancesAnnualAccountsStatementAccountsCountyClient) getClient("statementaccountscounty");
    }

    /**
     * <p>Retrieve the client for interacting with public finances annual accounts
     * statement accounts municipality data.</p>
     *
     * @return a client for public finances annual accounts statement accounts
     *         municipality data
     */
    public PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient statementAccountsMunicipality() {
        return (PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient) getClient(
                "statementaccountsmunicipality");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/OE0107/");
    }

}
