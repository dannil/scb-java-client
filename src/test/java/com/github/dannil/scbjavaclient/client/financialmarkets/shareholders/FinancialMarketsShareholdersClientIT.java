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

package com.github.dannil.scbjavaclient.client.financialmarkets.shareholders;

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
public class FinancialMarketsShareholdersClientIT {

    private FinancialMarketsShareholdersClient client;

    @BeforeEach
    public void setup() {
        this.client = new FinancialMarketsShareholdersClient();
    }

    @Test
    @Date("2017-09-07")
    public void getOwnershipOfShares() {
        assertNotEquals(0, this.client.getOwnershipOfShares().size());
    }

    @Test
    @Date("2017-09-07")
    public void getOwnershipOfSharesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOwnershipOfShares(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-09-07")
    public void getOwnershipOfSharesWithParameters() {
        List<String> sectors = Arrays.asList("S12", "S1254");
        List<String> halfYears = Arrays.asList("2012M12", "2013M06");

        assertNotEquals(0, this.client.getOwnershipOfShares(sectors, halfYears).size());
    }

    @Test
    @Date("2017-03-08")
    public void getOwnershipOfSharesByMarketplace() {
        assertNotEquals(0, this.client.getOwnershipOfSharesByMarketplace().size());
    }

    @Test
    @Date("2017-03-08")
    public void getOwnershipOfSharesByMarketplaceWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOwnershipOfSharesByMarketplace(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-08")
    public void getOwnershipOfSharesByMarketplaceWithParameters() {
        List<String> sectors = Arrays.asList("100", "200");
        List<String> marketplaces = Arrays.asList("AUKTMPTORGTORG");
        List<String> halfYears = Arrays.asList("2001M12", "2002M12");

        assertNotEquals(0, this.client.getOwnershipOfSharesByMarketplace(sectors, marketplaces, halfYears).size());
    }

    @Test
    @Date("2017-09-07")
    public void getOwnershipOfSharesBySeries() {
        assertNotEquals(0, this.client.getOwnershipOfSharesBySeries().size());
    }

    @Test
    @Date("2017-09-07")
    public void getOwnershipOfSharesBySeriesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOwnershipOfSharesBySeries(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-09-07")
    public void getOwnershipOfSharesBySeriesWithParameters() {
        List<String> sectors = Arrays.asList("S1311", "S1313");
        List<String> classesOfShares = Arrays.asList("Noterad");
        List<String> halfYears = Arrays.asList("2008M12", "2009M12");

        assertNotEquals(0, this.client.getOwnershipOfSharesBySeries(sectors, classesOfShares, halfYears).size());
    }

    @Test
    @Date("2017-03-08")
    public void getForeignOwnershipOfShares() {
        assertNotEquals(0, this.client.getForeignOwnershipOfShares().size());
    }

    @Test
    @Date("2017-03-08")
    public void getForeignOwnershipOfSharesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getForeignOwnershipOfShares(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-08")
    public void getForeignOwnershipOfSharesWithParameters() {
        List<String> countries = Arrays.asList("BE", "DK");
        List<String> halfYears = Arrays.asList("2001M12", "2002M12");

        assertNotEquals(0, this.client.getForeignOwnershipOfShares(countries, halfYears).size());
    }

}
