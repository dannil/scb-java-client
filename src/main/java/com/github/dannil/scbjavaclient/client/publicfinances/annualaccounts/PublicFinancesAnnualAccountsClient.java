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
import com.github.dannil.scbjavaclient.client.publicfinances.assetsandliabilities.PublicFinancesAssetsAndLiabilitiesClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

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

        TODO

        // addClient("assetsandliabilities", new
        // PublicFinancesAssetsAndLiabilitiesClient());
        // addClient("governmentdebt", new PublicFinancesGovernmentDebtClient());
        // addClient("localtaxes", new PublicFinancesLocalTaxesClient());
        // addClient("publiclyownedenterprises", new
        // PublicFinancesPubliclyOwnedEnterprisesClient());
        // addClient("taxassessment", new PublicFinancesTaxAssessmentClient());
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

    // /**
    // * <p>Retrieve the client for interacting with public finances annual accounts
    // * data.</p>
    // *
    // * @return a client for public finances annual accounts data
    // */
    // public PublicFinancesAssetsAndLiabilitiesClient assetsAndLiabilities() {
    // return (PublicFinancesAssetsAndLiabilitiesClient)
    // getClient("assetsandliabilities");
    // }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/OE0107/");
    }

}
