/*
 * Copyright 2020 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.financialmarkets.shareholders.restoftheworld;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Suite
@Remote
public class FinancialMarketsShareholdersRestOfTheWorldClientIT {

    private FinancialMarketsShareholdersRestOfTheWorldClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsShareholdersRestOfTheWorldClient();
    }

    @Test
    @Date("2020-03-06")
    public void getForeignOwnershipOfShares() {
        assertNotEquals(0, this.client.getForeignOwnershipOfShares().size());
    }

    @Test
    @Date("2020-03-06")
    public void getForeignOwnershipOfSharesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getForeignOwnershipOfShares(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2020-03-06")
    public void getForeignOwnershipOfSharesWithParameters() {
        List<String> countries = Arrays.asList("DE", "DK");
        List<String> twoTimesPerYears = Arrays.asList("2001M12", "2002M12");

        assertNotEquals(0, this.client.getForeignOwnershipOfShares(countries, twoTimesPerYears).size());
    }

}
