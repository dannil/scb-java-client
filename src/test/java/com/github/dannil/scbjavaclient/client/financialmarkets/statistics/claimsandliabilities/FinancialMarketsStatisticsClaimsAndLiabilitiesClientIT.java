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

package com.github.dannil.scbjavaclient.client.financialmarkets.statistics.claimsandliabilities;

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
public class FinancialMarketsStatisticsClaimsAndLiabilitiesClientIT {

    private FinancialMarketsStatisticsClaimsAndLiabilitiesClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsStatisticsClaimsAndLiabilitiesClient();
    }

    // Daniel 2017-05-30: Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getClaimsAndLiabilitiesOutsideSweden() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getClaimsAndLiabilitiesOutsideSweden());
    }

    // Daniel 2017-05-30: Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getClaimsAndLiabilitiesOutsideSwedenWithParametersEmptyLists() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getClaimsAndLiabilitiesOutsideSweden(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList()));
    }

    @Test
    @Date("2017-05-30")
    public void getClaimsAndLiabilitiesOutsideSwedenWithParameters() {
        List<String> positions = Arrays.asList("1", "1.1");
        List<String> countryGroups = Arrays.asList("5D", "5F");
        List<String> counterPartySectors = Arrays.asList("121b", "122");
        List<Integer> currencies = Arrays.asList(11, 12);
        List<String> quarters = Arrays.asList("2007K2", "2007K4");

        assertNotEquals(0, this.client.getClaimsAndLiabilitiesOutsideSweden(positions, countryGroups,
                counterPartySectors, currencies, quarters).size());
    }

    @Test
    @Date("2017-05-30")
    public void getConsolidatedClaimsOutsideSweden() {
        assertNotEquals(0, this.client.getConsolidatedClaimsOutsideSweden().size());
    }

    @Test
    @Date("2017-05-30")
    public void getConsolidatedClaimsOutsideSwedenWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getConsolidatedClaimsOutsideSweden(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-05-30")
    public void getConsolidatedClaimsOutsideSwedenWithParameters() {
        List<String> positions = Arrays.asList("1b", "2b");
        List<String> countryGroups = Arrays.asList("4A", "US");
        List<String> counterPartySectors = Arrays.asList("11b", "13");
        List<String> quarters = Arrays.asList("2007K2", "2007K4");

        assertNotEquals(0, this.client.getConsolidatedClaimsOutsideSweden(positions, countryGroups, counterPartySectors,
                quarters).size());
    }

}
