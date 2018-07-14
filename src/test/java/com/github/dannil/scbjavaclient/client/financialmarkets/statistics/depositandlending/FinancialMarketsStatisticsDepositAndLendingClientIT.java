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

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.exception.SCBClientResponseTooLargeException;
import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
@Remote
public class FinancialMarketsStatisticsDepositAndLendingClientIT {

    private FinancialMarketsStatisticsDepositAndLendingClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsStatisticsDepositAndLendingClient();
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

    // Daniel 2017-08-29:
    // Throws HTTP 403
    @Test
    @Date("2018-06-28")
    public void getLendingRatesToHouseholdsAndNonFinancialCorporationsBreakdownByMaturity() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getLendingRatesToHouseholdsAndNonFinancialCorporationsBreakdownByMaturity().size());
    }

    // Daniel 2017-08-29:
    // Throws HTTP 403
    @Test
    @Date("2018-06-28")
    public void getLendingRatesToHouseholdsAndNonFinancialCorporationsBreakdownByMaturityWithParametersEmptyLists() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getLendingRatesToHouseholdsAndNonFinancialCorporationsBreakdownByMaturity(
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-08-29")
    public void getLendingRatesToHouseholdsAndNonFinancialCorporationsBreakdownByMaturityWithParameters() {
        List<String> referenceSectors = Arrays.asList("1.", "1.2");
        List<String> counterpartySectors = Arrays.asList("2.1", "2.2");
        List<String> agreements = Arrays.asList("0100", "0200");
        List<String> originalRateFixations = Arrays.asList("1.1.1", "1.1.3");
        List<String> months = Arrays.asList("2013M05", "2013M06");

        assertNotEquals(0,
                this.client.getLendingRatesToHouseholdsAndNonFinancialCorporationsBreakdownByMaturity(referenceSectors,
                        counterpartySectors, agreements, originalRateFixations, months).size());
    }

    @Test
    @Date("2017-08-29")
    public void getLendingRatesBreakdownByPurpose() {
        assertNotEquals(0, this.client.getLendingRatesBreakdownByPurpose().size());
    }

    @Test
    @Date("2017-08-29")
    public void getLendingRatesBreakdownByPurposeWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getLendingRatesBreakdownByPurpose(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-08-29")
    public void getLendingRatesBreakdownByPurposeWithParameters() {
        List<String> referenceSectors = Arrays.asList("1.", "1.2");
        List<String> counterpartySectors = Arrays.asList("2.1b", "2.2b");
        List<String> agreements = Arrays.asList("0300", "0400");
        List<String> purposes = Arrays.asList("1.1", "1.2");
        List<String> months = Arrays.asList("2011M04", "2011M06");

        assertNotEquals(0, this.client.getLendingRatesBreakdownByPurpose(referenceSectors, counterpartySectors,
                agreements, purposes, months).size());
    }

    @Test
    @Date("2017-08-29")
    public void getBanksDepositRates() {
        assertNotEquals(0, this.client.getBanksDepositRates().size());
    }

    @Test
    @Date("2017-08-29")
    public void getBanksDepositRatesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getBanksDepositRates(Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-08-29")
    public void getBanksDepositRatesWithParameters() {
        List<String> referenceSectors = Arrays.asList("1.1b");
        List<Integer> counterpartySectors = Arrays.asList(1, 2);
        List<String> agreements = Arrays.asList("0100", "0200");
        List<Integer> originalRateFixations = Arrays.asList(21, 211, 212);
        List<String> months = Arrays.asList("2014M04", "2014M05");

        assertNotEquals(0, this.client.getBanksDepositRates(referenceSectors, counterpartySectors, agreements,
                originalRateFixations, months).size());
    }

}
