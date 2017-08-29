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

package com.github.dannil.scbjavaclient.client.financialmarkets.statistics.depositandlending;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class FinancialMarketsStatisticsDepositAndLendingClientIT extends RemoteIntegrationTestSuite {

    private FinancialMarketsStatisticsDepositAndLendingClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().financialMarkets().statistics().depositAndLending();
    }

    @Test
    @Date("2017-08-23")
    public void getLendingRatesBreakdownByRemainingMaturity() {
        assertNotEquals(0, this.client.getLendingRatesBreakdownByRemainingMaturity().size());
    }

    @Test
    @Date("2017-08-23")
    public void getLendingRatesBreakdownByRemainingMaturityWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getLendingRatesBreakdownByRemainingMaturity(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-08-23")
    public void getLendingRatesBreakdownByRemainingMaturityWithParameters() {
        List<String> referenceSectors = Arrays.asList("1", "1.1");
        List<Integer> counterpartySectors = Arrays.asList(1, 2);
        List<String> remainingMaturity = Arrays.asList("1.2", "1.3");
        List<String> months = Arrays.asList("2012M04", "2012M06");

        assertNotEquals(0, this.client.getLendingRatesBreakdownByRemainingMaturity(referenceSectors,
                counterpartySectors, remainingMaturity, months).size());
    }

    @Test
    @Date("2017-08-29")
    public void getLendingRatesToHouseholdsForHousingLoansBreakdownByMaturity() {
        assertNotEquals(0, this.client.getLendingRatesToHouseholdsForHousingLoansBreakdownByMaturity().size());
    }

    @Test
    @Date("2017-08-29")
    public void getLendingRatesToHouseholdsForHousingLoansBreakdownByMaturityWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getLendingRatesToHouseholdsForHousingLoansBreakdownByMaturity(
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-08-29")
    public void getLendingRatesToHouseholdsForHousingLoansBreakdownByMaturityWithParameters() {
        List<String> referenceSectors = Arrays.asList("1.");
        List<String> counterpartySectors = Arrays.asList("2c");
        List<String> agreements = Arrays.asList("0100", "0200");
        List<String> originalRateFixations = Arrays.asList("1.1.1", "1.1.3");
        List<String> months = Arrays.asList("2007M06", "2007M07");

        assertNotEquals(0, this.client.getLendingRatesToHouseholdsForHousingLoansBreakdownByMaturity(referenceSectors,
                counterpartySectors, agreements, originalRateFixations, months).size());
    }

    //
    // @Test
    // @Date("2017-05-30")
    // public void getConsolidatedClaimsOutsideSweden() {
    // assertNotEquals(0, this.client.getConsolidatedClaimsOutsideSweden().size());
    // }
    //
    // @Test
    // @Date("2017-05-30")
    // public void getConsolidatedClaimsOutsideSwedenWithParametersEmptyLists() {
    // assertNotEquals(0,
    // this.client.getConsolidatedClaimsOutsideSweden(Collections.<String>emptyList(),
    // Collections.<String>emptyList(), Collections.<String>emptyList(),
    // Collections.<String>emptyList()).size());
    // }
    //
    // @Test
    // @Date("2017-05-30")
    // public void getConsolidatedClaimsOutsideSwedenWithParameters() {
    // List<String> positions = Arrays.asList("1b", "2b");
    // List<String> countryGroups = Arrays.asList("4A", "US");
    // List<String> counterPartySectors = Arrays.asList("11b", "13");
    // List<String> quarters = Arrays.asList("2007K2", "2007K4");
    //
    // assertNotEquals(0, this.client.getConsolidatedClaimsOutsideSweden(positions,
    // countryGroups, counterPartySectors,
    // quarters).size());
    // }

}
