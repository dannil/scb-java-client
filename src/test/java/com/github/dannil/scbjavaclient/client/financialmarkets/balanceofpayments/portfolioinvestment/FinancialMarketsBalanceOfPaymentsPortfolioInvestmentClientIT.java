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

package com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.portfolioinvestment;

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
public class FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClientIT {

    private FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsBalanceOfPaymentsPortfolioInvestmentClient();
    }

    @Test
    @Date("2017-06-11")
    public void getNetFlowsYears() {
        assertNotEquals(0, this.client.getNetFlowsYears().size());
    }

    @Test
    @Date("2017-06-11")
    public void getNetFlowsYearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNetFlowsYears(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-11")
    public void getNetFlowsYearsWithParameters() {
        List<String> currencies = Arrays.asList("v1", "v2");
        List<String> items = Arrays.asList("P2", "P3");
        List<Integer> years = Arrays.asList(2008, 2009);

        assertNotEquals(0, this.client.getNetFlowsYears(currencies, items, years).size());
    }

    // Daniel 2017-06-11: Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getNonResidentTradeInSwedishShares() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getNonResidentTradeInSwedishShares());
    }

    // Daniel 2017-06-11: Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getNonResidentTradeInSwedishSharesWithParametersEmptyLists() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getNonResidentTradeInSwedishShares(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()));
    }

    @Test
    @Date("2017-06-11")
    public void getNonResidentTradeInSwedishSharesWithParameters() {
        List<String> typesOfTrades = Arrays.asList("AI", "AN");
        List<String> typesOfShares = Arrays.asList("SE0000937682", "SE0000472268");
        List<String> months = Arrays.asList("2010M06", "2012M02");

        assertNotEquals(0, this.client.getNonResidentTradeInSwedishShares(typesOfTrades, typesOfShares, months).size());
    }

    @Test
    @Date("2017-06-11")
    public void getNonResidentHoldingsOfSwedishInterestBearingSecurities() {
        assertNotEquals(0, this.client.getNonResidentHoldingsOfSwedishInterestBearingSecurities().size());
    }

    @Test
    @Date("2017-06-11")
    public void getNonResidentHoldingsOfSwedishInterestBearingSecuritiesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getNonResidentHoldingsOfSwedishInterestBearingSecurities(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-11")
    public void getNonResidentHoldingsOfSwedishInterestBearingSecuritiesWithParameters() {
        List<String> holdings = Arrays.asList("Q2", "Q4");
        List<String> sectors = Arrays.asList("S", "M");
        List<String> maturities = Arrays.asList("Z1", "Z2");
        List<String> months = Arrays.asList("2013M06", "2013M08");

        assertNotEquals(0, this.client.getNonResidentHoldingsOfSwedishInterestBearingSecurities(holdings, sectors,
                maturities, months).size());
    }

    @Test
    @Date("2017-06-11")
    public void getNetFlowsQuarters() {
        assertNotEquals(0, this.client.getNetFlowsQuarters().size());
    }

    @Test
    @Date("2017-06-11")
    public void getNetFlowsQuartersWithParametersWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNetFlowsQuarters(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-11")
    public void getNetFlowsQuartersWithParameters() {
        List<String> currencies = Arrays.asList("v1", "v2");
        List<String> items = Arrays.asList("P2", "P3");
        List<String> quarters = Arrays.asList("2005K3", "2006K1");

        assertNotEquals(0, this.client.getNetFlowsQuarters(currencies, items, quarters).size());
    }

    @Test
    @Date("2017-06-11")
    public void getSwedishPortfolioHoldingsOfForeignSecurities() {
        assertNotEquals(0, this.client.getSwedishPortfolioHoldingsOfForeignSecurities().size());
    }

    @Test
    @Date("2017-06-11")
    public void getSwedishPortfolioHoldingsOfForeignSecuritiesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getSwedishPortfolioHoldingsOfForeignSecurities(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-11")
    public void getSwedishPortfolioHoldingsOfForeignSecuritiesParameters() {
        List<String> countries = Arrays.asList("ES", "LV");
        List<String> securities = Arrays.asList("12.1.1", "12.1.2");
        List<String> halfYears = Arrays.asList("2010H2", "2011H2");

        assertNotEquals(0,
                this.client.getSwedishPortfolioHoldingsOfForeignSecurities(countries, securities, halfYears).size());
    }

}
