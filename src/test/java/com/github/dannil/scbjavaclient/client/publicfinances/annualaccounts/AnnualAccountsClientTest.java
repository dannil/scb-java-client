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

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetcounty.BalanceSheetCountyClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetmunicipality.BalanceSheetMunicipalityClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountscounty.StatementAccountsCountyClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountsmunicipality.StatementAccountsMunicipalityClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AnnualAccountsClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        AnnualAccountsClient client = new AnnualAccountsClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void balanceSheetCountyClient() {
        AnnualAccountsClient client = new AnnualAccountsClient();

        assertEquals(client.balanceSheetCounty().getClass(),
                BalanceSheetCountyClient.class);
    }

    @Test
    public void balanceSheetMunicipalityClient() {
        AnnualAccountsClient client = new AnnualAccountsClient();

        assertEquals(client.balanceSheetMunicipality().getClass(),
                BalanceSheetMunicipalityClient.class);
    }

    @Test
    public void statementAccountsCountyClient() {
        AnnualAccountsClient client = new AnnualAccountsClient();

        assertEquals(client.statementAccountsCounty().getClass(),
                StatementAccountsCountyClient.class);
    }

    @Test
    public void statementAccountsMunicipalityClient() {
        AnnualAccountsClient client = new AnnualAccountsClient();

        assertEquals(client.statementAccountsMunicipality().getClass(),
                StatementAccountsMunicipalityClient.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        AnnualAccountsClient client = new AnnualAccountsClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("OE/OE0107/"), client.getUrl());
    }

}
