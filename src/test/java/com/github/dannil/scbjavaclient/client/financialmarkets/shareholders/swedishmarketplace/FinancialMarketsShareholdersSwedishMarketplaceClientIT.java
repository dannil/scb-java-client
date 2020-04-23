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

package com.github.dannil.scbjavaclient.client.financialmarkets.shareholders.swedishmarketplace;

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
public class FinancialMarketsShareholdersSwedishMarketplaceClientIT {

    private FinancialMarketsShareholdersSwedishMarketplaceClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsShareholdersSwedishMarketplaceClient();
    }

    @Test
    @Date("2020-03-06")
    public void getOwnershipOfSharesByMarketplace() {
        assertNotEquals(0, this.client.getOwnershipOfSharesByMarketplace().size());
    }

    @Test
    @Date("2020-03-06")
    public void getOwnershipOfSharesByMarketplaceWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOwnershipOfSharesByMarketplace(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2020-03-06")
    public void getOwnershipOfSharesByMarketplaceWithParameters() {
        List<String> sectors = Arrays.asList("100", "200");
        List<String> marketplaces = Arrays.asList("AUKTMPTORGTORG");
        List<String> twoTimesPerYears = Arrays.asList("2001M12", "2002M12");

        assertNotEquals(0,
                this.client.getOwnershipOfSharesByMarketplace(sectors, marketplaces, twoTimesPerYears).size());
    }

    @Test
    @Date("2020-03-06")
    public void getOwnershipOfSharesBySeries() {
        assertNotEquals(0, this.client.getOwnershipOfSharesBySeries().size());
    }

    @Test
    @Date("2020-03-06")
    public void getOwnershipOfSharesBySeriesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOwnershipOfSharesBySeries(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2020-03-06")
    public void getOwnershipOfSharesBySeriesWithParameters() {
        List<String> sectors = Arrays.asList("S1311", "S1313");
        List<String> classesOfShares = Arrays.asList("Noterad");
        List<String> twoTimesPerYears = Arrays.asList("2008M12", "2009M12");

        assertNotEquals(0, this.client.getOwnershipOfSharesBySeries(sectors, classesOfShares, twoTimesPerYears).size());
    }

}
