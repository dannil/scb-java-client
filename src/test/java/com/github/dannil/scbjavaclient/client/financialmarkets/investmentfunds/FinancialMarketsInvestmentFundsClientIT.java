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

package com.github.dannil.scbjavaclient.client.financialmarkets.investmentfunds;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.AllowFailure;
import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.NoticeStrategy;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
@Remote
public class FinancialMarketsInvestmentFundsClientIT {

    private FinancialMarketsInvestmentFundsClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsInvestmentFundsClient();
    }

    @Test
    @Date("2017-12-22")
    @AllowFailure(notice = NoticeStrategy.ALWAYS)
    public void getOwnershipOfInvestmentFund() {
        assertNotEquals(0, this.client.getOwnershipOfInvestmentFund().size());
    }

    @Test
    @Date("2017-12-22")
    @AllowFailure(notice = NoticeStrategy.ALWAYS)
    public void getOwnershipOfInvestmentFundWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getOwnershipOfInvestmentFund(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-22")
    @AllowFailure(notice = NoticeStrategy.ALWAYS)
    public void getOwnershipOfInvestmentFundWithParameters() {
        List<String> observations = Arrays.asList("inbet", "utbet");
        List<String> types = Arrays.asList("S12251", "S12354");
        List<String> sectors = Arrays.asList("S14", "S15");
        List<String> quarters = Arrays.asList("2011K1", "2011K2");

        assertNotEquals(0, this.client.getOwnershipOfInvestmentFund(observations, types, sectors, quarters).size());
    }

}
