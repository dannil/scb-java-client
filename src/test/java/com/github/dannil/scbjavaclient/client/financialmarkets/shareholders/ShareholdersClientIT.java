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
public class ShareholdersClientIT extends RemoteIntegrationTestSuite {

    private ShareholdersClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().financialMarkets().shareholders();
    }

    @Test
    public void getOwnershipOfShares() {
        assertNotEquals(0, this.client.getOwnershipOfShares().size());
    }

    @Test
    public void getOwnershipOfSharesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOwnershipOfShares(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    public void getOwnershipOfSharesWithParameters() {
        List<String> sectors = Arrays.asList("100", "200");
        List<String> halfYears = Arrays.asList("2001M12", "2002M12");

        assertNotEquals(0, this.client.getOwnershipOfShares(sectors, halfYears).size());
    }

    @Test
    public void getOwnershipOfSharesByMarketplace() {
        assertNotEquals(0, this.client.getOwnershipOfSharesByMarketplace().size());
    }

    @Test
    public void getOwnershipOfSharesByMarketplaceWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOwnershipOfSharesByMarketplace(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    public void getOwnershipOfSharesByMarketplaceWithParameters() {
        List<String> sectors = Arrays.asList("100", "200");
        List<String> marketplaces = Arrays.asList("AUKTMPTORGTORG");
        List<String> halfYears = Arrays.asList("2001M12", "2002M12");

        assertNotEquals(0, this.client.getOwnershipOfSharesByMarketplace(sectors, marketplaces, halfYears).size());
    }

    @Test
    public void getOwnershipOfSharesBySeries() {
        assertNotEquals(0, this.client.getOwnershipOfSharesBySeries().size());
    }

    @Test
    public void getOwnershipOfSharesBySeriesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getOwnershipOfSharesBySeries(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    public void getOwnershipOfSharesBySeriesWithParameters() {
        List<String> sectors = Arrays.asList("300", "400");
        List<String> series = Arrays.asList("Noterad");
        List<String> halfYears = Arrays.asList("2001M12", "2002M12");

        assertNotEquals(0, this.client.getOwnershipOfSharesBySeries(sectors, series, halfYears).size());
    }

    @Test
    public void getForeignOwnershipOfShares() {
        assertNotEquals(0, this.client.getForeignOwnershipOfShares().size());
    }

    @Test
    public void getForeignOwnershipOfSharesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getForeignOwnershipOfShares(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    public void getForeignOwnershipOfSharesWithParameters() {
        List<String> countries = Arrays.asList("BE", "DK");
        List<String> halfYears = Arrays.asList("2001M12", "2002M12");

        assertNotEquals(0, this.client.getForeignOwnershipOfShares(countries, halfYears).size());
    }

}
