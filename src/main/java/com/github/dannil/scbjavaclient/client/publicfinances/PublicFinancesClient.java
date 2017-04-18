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
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.AnnualAccountsClient;
import com.github.dannil.scbjavaclient.client.publicfinances.assetsandliabilities.AssetsAndLiabilitiesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.governmentdebt.GovernmentDebtClient;
import com.github.dannil.scbjavaclient.client.publicfinances.localtaxes.LocalTaxesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.publiclyownedenterprises.PubliclyOwnedEnterprisesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.taxassessment.TaxAssessmentClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles public finances data fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public PublicFinancesClient() {
        super();

        addClient("annualaccounts", new AnnualAccountsClient());
        addClient("assetsandliabilities", new AssetsAndLiabilitiesClient());
        addClient("governmentdebt", new GovernmentDebtClient());
        addClient("localtaxes", new LocalTaxesClient());
        addClient("publiclyownedenterprises", new PubliclyOwnedEnterprisesClient());
        addClient("taxassessment", new TaxAssessmentClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with public finances annual accounts
     * data.</p>
     *
     * @return a client for public finances annual accounts data
     */
    public AnnualAccountsClient annualAccounts() {
        return (AnnualAccountsClient) getClient("annualaccounts");
    }

    /**
     * <p>Retrieve the client for interacting with public finances assets and liabilities
     * data.</p>
     *
     * @return a client for public finances assets and liabilities data
     */
    public AssetsAndLiabilitiesClient assetsAndLiabilities() {
        return (AssetsAndLiabilitiesClient) getClient("assetsandliabilities");
    }

    /**
     * <p>Retrieve the client for interacting with public finances government debt
     * data.</p>
     *
     * @return a client for public finances government debt data
     */
    public GovernmentDebtClient governmentDebt() {
        return (GovernmentDebtClient) getClient("governmentdebt");
    }

    /**
     * <p>Retrieve the client for interacting with public finances local taxes data.</p>
     *
     * @return a client for public finances local taxes data
     */
    public LocalTaxesClient localTaxes() {
        return (LocalTaxesClient) getClient("localtaxes");
    }

    /**
     * <p>Retrieve the client for interacting with public finances publicly owned
     * enterprises data.</p>
     *
     * @return a client for public finances publicly owned enterprises data
     */
    public PubliclyOwnedEnterprisesClient publiclyOwnedEnterprises() {
        return (PubliclyOwnedEnterprisesClient) getClient("publiclyownedenterprises");
    }

    /**
     * <p>Retrieve the client for interacting with public finances tax assessment
     * data.</p>
     *
     * @return a client for public finances tax assessment data
     */
    public TaxAssessmentClient taxAssessment() {
        return (TaxAssessmentClient) getClient("taxassessment");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/");
    }

}
