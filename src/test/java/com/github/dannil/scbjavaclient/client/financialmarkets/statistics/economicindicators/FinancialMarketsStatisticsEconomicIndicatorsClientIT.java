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

package com.github.dannil.scbjavaclient.client.financialmarkets.statistics.economicindicators;

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
public class FinancialMarketsStatisticsEconomicIndicatorsClientIT extends RemoteIntegrationTestSuite {

    private FinancialMarketsStatisticsEconomicIndicatorsClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().financialMarkets().statistics().economicIndicators();
    }

    @Test
    @Date("2017-09-01")
    public void getFinancialMarketStatisticsGrowthRate() {
        assertNotEquals(0, this.client.getFinancialMarketStatisticsGrowthRate().size());
    }

    @Test
    @Date("2017-09-01")
    public void getFinancialMarketStatisticsGrowthRateWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFinancialMarketStatisticsGrowthRate(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-09-01")
    public void getFinancialMarketStatisticsGrowthRateWithParameters() {
        List<String> economicIndicators = Arrays.asList("FMF10", "FMF20");
        List<String> months = Arrays.asList("2015M12", "2016M01");

        assertNotEquals(0, this.client.getFinancialMarketStatisticsGrowthRate(economicIndicators, months).size());
    }

}
