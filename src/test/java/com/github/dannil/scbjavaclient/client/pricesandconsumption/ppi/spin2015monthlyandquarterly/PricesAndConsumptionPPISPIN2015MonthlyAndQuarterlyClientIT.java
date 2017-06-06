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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2015monthlyandquarterly;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClientIT extends RemoteIntegrationTestSuite {

    private PricesAndConsumptionPPISPIN2015MonthlyAndQuarterlyClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().pricesAndConsumption().ppi().spin2015MonthlyAndQuarterly();
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test
    // public void getProducerPriceIndexHomeSales() {
    // assertNotEquals(0, this.client.getProducerPriceIndexHomeSales().size());
    // }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test
    // public void getProducerPriceIndexHomeSalesWithParametersEmptyLists() {
    // assertNotEquals(0,
    // this.client.getProducerPriceIndexHomeSales(Collections.<String>emptyList(),
    // Collections.<String>emptyList()).size());
    // }

    @Test
    public void getProducerPriceIndexHomeSalesWithParameters() {
        List<String> spin2015 = Arrays.asList("B", "C");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getProducerPriceIndexHomeSales(spin2015, months).size());
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test
    // public void getExportPriceIndex() {
    // assertNotEquals(0, this.client.getExportPriceIndex().size());
    // }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test
    // public void getExportPriceIndexWithParametersEmptyLists() {
    // assertNotEquals(0, this.client.getExportPriceIndex(Collections.<String>emptyList(),
    // Collections.<String>emptyList()).size());
    // }

    @Test
    public void getExportPriceIndexWithParameters() {
        List<String> spin2015 = Arrays.asList("A", "B");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getExportPriceIndex(spin2015, months).size());
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test
    // public void getImportPriceIndex() {
    // assertNotEquals(0, this.client.getImportPriceIndex().size());
    // }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test
    // public void getImportPriceIndexWithParametersEmptyLists() {
    // assertNotEquals(0, this.client.getImportPriceIndex(Collections.<String>emptyList(),
    // Collections.<String>emptyList()).size());
    // }

    @Test
    public void getImportPriceIndexWithParameters() {
        List<String> spin2015 = Arrays.asList("A", "B");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getImportPriceIndex(spin2015, months).size());
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test
    // public void getProducerPriceIndex() {
    // assertNotEquals(0, this.client.getProducerPriceIndex().size());
    // }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test
    // public void getProducerPriceIndexWithParametersEmptyLists() {
    // assertNotEquals(0,
    // this.client.getProducerPriceIndex(Collections.<String>emptyList(),
    // Collections.<String>emptyList()).size());
    // }

    @Test
    public void getProducerPriceIndexWithParameters() {
        List<String> spin2015 = Arrays.asList("A", "B");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getProducerPriceIndex(spin2015, months).size());
    }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test
    // public void getPriceIndexForDomesticSupply() {
    // assertNotEquals(0, this.client.getPriceIndexForDomesticSupply().size());
    // }

    // Daniel 2017-06-06:
    // Returns HTTP 403
    //
    // @Test
    // public void getPriceIndexForDomesticSupplyWithParametersEmptyLists() {
    // assertNotEquals(0,
    // this.client.getPriceIndexForDomesticSupply(Collections.<String>emptyList(),
    // Collections.<String>emptyList()).size());
    // }

    @Test
    public void getPriceIndexForDomesticSupplyWithParameters() {
        List<String> spin2015 = Arrays.asList("A", "B");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getPriceIndexForDomesticSupply(spin2015, months).size());
    }

}
