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

package com.github.dannil.scbjavaclient.client.publicfinances;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.PublicFinancesAnnualAccountsClient;
import com.github.dannil.scbjavaclient.client.publicfinances.assetsandliabilities.PublicFinancesAssetsAndLiabilitiesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.governmentdebt.PublicFinancesGovernmentDebtClient;
import com.github.dannil.scbjavaclient.client.publicfinances.localtaxes.PublicFinancesLocalTaxesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.publiclyownedenterprises.PublicFinancesPubliclyOwnedEnterprisesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.taxassessment.PublicFinancesTaxAssessmentClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * Client which handles public finances data fetching.
 *
 * @since 0.3.0
 */
public class PublicFinancesClient extends AbstractContainerClient {

    /**
     * Default constructor. Initializes values and creates sub-clients.
     */
    public PublicFinancesClient() {
        super();

        addClient("annualaccounts", new PublicFinancesAnnualAccountsClient());
        addClient("assetsandliabilities", new PublicFinancesAssetsAndLiabilitiesClient());
        addClient("governmentdebt", new PublicFinancesGovernmentDebtClient());
        addClient("localtaxes", new PublicFinancesLocalTaxesClient());
        addClient("publiclyownedenterprises", new PublicFinancesPubliclyOwnedEnterprisesClient());
        addClient("taxassessment", new PublicFinancesTaxAssessmentClient());
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * Retrieve the client for interacting with public finances annual accounts
     * data.
     *
     * @return a client for public finances annual accounts data
     */
    public PublicFinancesAnnualAccountsClient annualAccounts() {
        return (PublicFinancesAnnualAccountsClient) getClient("annualaccounts");
    }

    /**
     * Retrieve the client for interacting with public finances assets and liabilities
     * data.
     *
     * @return a client for public finances assets and liabilities data
     */
    public PublicFinancesAssetsAndLiabilitiesClient assetsAndLiabilities() {
        return (PublicFinancesAssetsAndLiabilitiesClient) getClient("assetsandliabilities");
    }

    /**
     * Retrieve the client for interacting with public finances government debt
     * data.
     *
     * @return a client for public finances government debt data
     */
    public PublicFinancesGovernmentDebtClient governmentDebt() {
        return (PublicFinancesGovernmentDebtClient) getClient("governmentdebt");
    }

    /**
     * Retrieve the client for interacting with public finances local taxes data.
     *
     * @return a client for public finances local taxes data
     */
    public PublicFinancesLocalTaxesClient localTaxes() {
        return (PublicFinancesLocalTaxesClient) getClient("localtaxes");
    }

    /**
     * Retrieve the client for interacting with public finances publicly owned
     * enterprises data.
     *
     * @return a client for public finances publicly owned enterprises data
     */
    public PublicFinancesPubliclyOwnedEnterprisesClient publiclyOwnedEnterprises() {
        return (PublicFinancesPubliclyOwnedEnterprisesClient) getClient("publiclyownedenterprises");
    }

    /**
     * Retrieve the client for interacting with public finances tax assessment
     * data.
     *
     * @return a client for public finances tax assessment data
     */
    public PublicFinancesTaxAssessmentClient taxAssessment() {
        return (PublicFinancesTaxAssessmentClient) getClient("taxassessment");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/");
    }

}
