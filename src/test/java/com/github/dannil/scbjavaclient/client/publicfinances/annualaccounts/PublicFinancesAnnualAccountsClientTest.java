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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetcounty.PublicFinancesAnnualAccountsBalanceSheetCountyClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetmunicipality.PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountscounty.PublicFinancesAnnualAccountsStatementAccountsCountyClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountsmunicipality.PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class PublicFinancesAnnualAccountsClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void balanceSheetCountyClient() {
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient();

        assertEquals(PublicFinancesAnnualAccountsBalanceSheetCountyClient.class,
                client.balanceSheetCounty().getClass());
    }

    @Test
    public void balanceSheetMunicipalityClient() {
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient();

        assertEquals(PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient.class,
                client.balanceSheetMunicipality().getClass());
    }

    @Test
    public void statementAccountsCountyClient() {
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient();

        assertEquals(PublicFinancesAnnualAccountsStatementAccountsCountyClient.class,
                client.statementAccountsCounty().getClass());
    }

    @Test
    public void statementAccountsMunicipalityClient() {
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient();

        assertEquals(PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient.class,
                client.statementAccountsMunicipality().getClass());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("OE/OE0107/"), client.getUrl());
    }

}
