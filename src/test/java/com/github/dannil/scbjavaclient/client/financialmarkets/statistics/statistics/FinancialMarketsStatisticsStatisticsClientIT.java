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

package com.github.dannil.scbjavaclient.client.financialmarkets.statistics.statistics;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FinancialMarketsStatisticsStatisticsClientIT extends RemoteIntegrationTestSuite {

    private FinancialMarketsStatisticsStatisticsClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().financialMarkets().statistics().statistics();
    }

    @Test
    public void getAssetsAndLiabilities() {
        assertNotEquals(0, this.client.getAssetsAndLiabilities().size());
    }

    @Test
    public void getAssetsAndLiabilitiesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAssetsAndLiabilities(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    public void getAssetsAndLiabilitiesWithParameters() {
        List<String> institutions = Arrays.asList("MFI", "RB");
        List<String> itemsAndCounterPartsSectors = Arrays.asList("5LM4A.1E.N11.V.A", "5LM4A.1E.N31.V.A");
        List<String> months = Arrays.asList("2008M08", "2009M08");

        assertNotEquals(0,
                this.client.getAssetsAndLiabilities(institutions, itemsAndCounterPartsSectors, months).size());
    }

    @Test
    public void getFinancialSoundnessIndicators() {
        assertNotEquals(0, this.client.getFinancialSoundnessIndicators().size());
    }

    @Test
    public void getFinancialSoundnessIndicatorsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFinancialSoundnessIndicators(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    public void getFinancialSoundnessIndicatorsWithParameters() {
        List<String> indicators = Arrays.asList("I004", "I006");
        List<String> quarters = Arrays.asList("2013k1", "2013k3");

        assertNotEquals(0, this.client.getFinancialSoundnessIndicators(indicators, quarters).size());
    }

    @Test
    public void getMoneySupply() {
        assertNotEquals(0, this.client.getMoneySupply().size());
    }

    @Test
    public void getMoneySupplyWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getMoneySupply(Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    public void getMoneySupplyWithParameters() {
        List<String> moneySupplies = Arrays.asList("5LLM1.1E.NEP.V.A", "5LLM3a.1E.NEP.V.A");
        List<String> months = Arrays.asList("2005M10", "2005M12");

        assertNotEquals(0, this.client.getMoneySupply(moneySupplies, months).size());
    }

}
