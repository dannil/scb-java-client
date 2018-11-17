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

package com.github.dannil.scbjavaclient.client.financialmarkets.enterprises;

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
public class FinancialMarketsEnterprisesClientIT {

    private FinancialMarketsEnterprisesClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsEnterprisesClient();
    }

    @Test
    @Date("2017-05-27")
    public void getIncomeStatements() {
        assertNotEquals(0, this.client.getIncomeStatements().size());
    }

    @Test
    @Date("2017-05-27")
    public void getIncomeStatementsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIncomeStatements(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-27")
    public void getIncomeStatementsWithParameters() {
        List<String> institutes = Arrays.asList("S201", "S2123");
        List<String> items = Arrays.asList("E00130", "E00051");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getIncomeStatements(institutes, items, years).size());
    }

    @Test
    @Date("2017-05-27")
    public void getBalanceSheet() {
        assertNotEquals(0, this.client.getBalanceSheet().size());
    }

    @Test
    @Date("2017-05-27")
    public void getBalanceSheetWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getBalanceSheet(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-27")
    public void getBalanceSheetWithParameters() {
        List<String> institutes = Arrays.asList("S201", "S2123");
        List<String> items = Arrays.asList("E02003", "E09901");
        List<Integer> years = Arrays.asList(2014, 2015);

        assertNotEquals(0, this.client.getBalanceSheet(institutes, items, years).size());
    }

}
