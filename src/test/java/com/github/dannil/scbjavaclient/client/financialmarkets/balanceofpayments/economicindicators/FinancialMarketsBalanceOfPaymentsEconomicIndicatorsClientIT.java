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

package com.github.dannil.scbjavaclient.client.financialmarkets.balanceofpayments.economicindicators;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
@Remote
public class FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClientIT {

    private FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsBalanceOfPaymentsEconomicIndicatorsClient();
    }

    @Test
    @Date("2018-06-05")
    public void getBalanceOfPaymentsNet() {
        assertNotEquals(0, this.client.getBalanceOfPaymentsNet().size());
    }

    @Test
    @Date("2018-06-05")
    public void getBalanceOfPaymentsNetWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getBalanceOfPaymentsNet(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2018-06-05")
    public void getBalanceOfPaymentsNetWithParameters() {
        List<String> indicators = Arrays.asList("FM120", "FM140");
        List<String> quarters = Arrays.asList("2017K4", "2018K1");

        assertNotEquals(0, this.client.getBalanceOfPaymentsNet(indicators, quarters).size());
    }

}
