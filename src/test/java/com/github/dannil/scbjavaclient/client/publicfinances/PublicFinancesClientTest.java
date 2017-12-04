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

import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.PublicFinancesAnnualAccountsClient;
import com.github.dannil.scbjavaclient.client.publicfinances.assetsandliabilities.PublicFinancesAssetsAndLiabilitiesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.governmentdebt.PublicFinancesGovernmentDebtClient;
import com.github.dannil.scbjavaclient.client.publicfinances.localtaxes.PublicFinancesLocalTaxesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.publiclyownedenterprises.PublicFinancesPubliclyOwnedEnterprisesClient;
import com.github.dannil.scbjavaclient.client.publicfinances.taxassessment.PublicFinancesTaxAssessmentClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.TestSuite;

import org.junit.jupiter.api.Test;

@TestSuite
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

        assertEquals(client.annualAccounts().getClass(), PublicFinancesAnnualAccountsClient.class);
    }

    @Test
    public void assetsAndLiabilities() {
        PublicFinancesClient client = new PublicFinancesClient();

        assertEquals(client.assetsAndLiabilities().getClass(), PublicFinancesAssetsAndLiabilitiesClient.class);
    }

    @Test
    public void governmentDebtClient() {
        PublicFinancesClient client = new PublicFinancesClient();

        assertEquals(client.governmentDebt().getClass(), PublicFinancesGovernmentDebtClient.class);
    }

    @Test
    public void localTaxesClient() {
        PublicFinancesClient client = new PublicFinancesClient();

        assertEquals(client.localTaxes().getClass(), PublicFinancesLocalTaxesClient.class);
    }

    @Test
    public void publiclyOwnedEnterprisesClient() {
        PublicFinancesClient client = new PublicFinancesClient();

        assertEquals(client.publiclyOwnedEnterprises().getClass(), PublicFinancesPubliclyOwnedEnterprisesClient.class);
    }

    @Test
    public void taxAssessmentClient() {
        PublicFinancesClient client = new PublicFinancesClient();

        assertEquals(client.taxAssessment().getClass(), PublicFinancesTaxAssessmentClient.class);
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
