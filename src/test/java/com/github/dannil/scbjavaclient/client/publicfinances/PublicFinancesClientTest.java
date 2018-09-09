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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.PublicFinancesAnnualAccountsClient;
import com.github.dannil.scbjavaclient.client.publicfinances.assetsandliabilities.PublicFinancesAssetsAndLiabilitiesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.governmentdebt.PublicFinancesGovernmentDebtClient;
import com.github.dannil.scbjavaclient.client.publicfinances.localtaxes.PublicFinancesLocalTaxesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.publiclyownedenterprises.PublicFinancesPubliclyOwnedEnterprisesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.taxassessment.PublicFinancesTaxAssessmentClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class PublicFinancesClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        PublicFinancesClient client = new PublicFinancesClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void annualAccountsClient() {
        PublicFinancesClient client = new PublicFinancesClient();

        assertEquals(PublicFinancesAnnualAccountsClient.class, client.annualAccounts().getClass());
    }

    @Test
    public void assetsAndLiabilities() {
        PublicFinancesClient client = new PublicFinancesClient();

        assertEquals(PublicFinancesAssetsAndLiabilitiesClient.class, client.assetsAndLiabilities().getClass());
    }

    @Test
    public void governmentDebtClient() {
        PublicFinancesClient client = new PublicFinancesClient();

        assertEquals(PublicFinancesGovernmentDebtClient.class, client.governmentDebt().getClass());
    }

    @Test
    public void localTaxesClient() {
        PublicFinancesClient client = new PublicFinancesClient();

        assertEquals(PublicFinancesLocalTaxesClient.class, client.localTaxes().getClass());
    }

    @Test
    public void publiclyOwnedEnterprisesClient() {
        PublicFinancesClient client = new PublicFinancesClient();

        assertEquals(PublicFinancesPubliclyOwnedEnterprisesClient.class, client.publiclyOwnedEnterprises().getClass());
    }

    @Test
    public void taxAssessmentClient() {
        PublicFinancesClient client = new PublicFinancesClient();

        assertEquals(PublicFinancesTaxAssessmentClient.class, client.taxAssessment().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        PublicFinancesClient client = new PublicFinancesClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("OE/"), client.getUrl());
    }

}
