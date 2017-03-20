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
import com.github.dannil.scbjavaclient.client.publicfinances.governmentdebt.PublicFinancesGovernmentDebtClient;
import com.github.dannil.scbjavaclient.client.publicfinances.localtaxes.PublicFinancesLocalTaxesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.taxassessment.PublicFinancesTaxAssessmentClient;

/**
 * <p>Client which handles public finances data fetching.</p>
 *
 * @since 0.2.0
 */
public class PublicFinancesClient extends AbstractContainerClient {

    private PublicFinancesGovernmentDebtClient publicFinancesGovernmentDebtClient;

    private PublicFinancesLocalTaxesClient publicFinancesLocalTaxesClient;

    private PublicFinancesTaxAssessmentClient publicFinancesTaxAssessmentClient;

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public PublicFinancesClient() {
        super();

        this.publicFinancesGovernmentDebtClient = new PublicFinancesGovernmentDebtClient();
        addClient(this.publicFinancesGovernmentDebtClient);

        this.publicFinancesLocalTaxesClient = new PublicFinancesLocalTaxesClient();
        addClient(this.publicFinancesLocalTaxesClient);

        this.publicFinancesTaxAssessmentClient = new PublicFinancesTaxAssessmentClient();
        addClient(this.publicFinancesTaxAssessmentClient);
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
     * <p>Retrieve the client for interacting with public finances government debt
     * data.</p>
     *
     * @return a client for public finances government debt data
     */
    public PublicFinancesGovernmentDebtClient governmentDebt() {
        return this.publicFinancesGovernmentDebtClient;
    }

    /**
     * <p>Retrieve the client for interacting with public finances local taxes data.</p>
     *
     * @return a client for public finances local taxes data
     */
    public PublicFinancesLocalTaxesClient localTaxes() {
        return this.publicFinancesLocalTaxesClient;
    }

    /**
     * <p>Retrieve the client for interacting with public finances tax assessment
     * data.</p>
     *
     * @return a client for public finances tax assessment data
     */
    public PublicFinancesTaxAssessmentClient taxAssessment() {
        return this.publicFinancesTaxAssessmentClient;
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "OE/";
    }

}
