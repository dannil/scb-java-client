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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2007year;

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
public class PricesAndConsumptionPPISPIN2007YearClientIT {

    private PricesAndConsumptionPPISPIN2007YearClient client;

    @BeforeEach
    public void setup() {
        this.client = new PricesAndConsumptionPPISPIN2007YearClient();
    }

    @Test
    @Date("2017-06-06")
    public void getProducerPriceIndexHomeSales() {
        assertNotEquals(0, this.client.getProducerPriceIndexHomeSales().size());
    }

    @Test
    @Date("2017-06-06")
    public void getProducerPriceIndexHomeSalesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getProducerPriceIndexHomeSales(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-06")
    public void getProducerPriceIndexHomeSalesWithParameters() {
        List<String> spin2007 = Arrays.asList("MIG_CAG_ORD", "MIG_ING_ORD");
        List<Integer> years = Arrays.asList(1998, 2000);

        assertNotEquals(0, this.client.getProducerPriceIndexHomeSales(spin2007, years).size());
    }

    @Test
    @Date("2017-06-06")
    public void getExportPriceIndex() {
        assertNotEquals(0, this.client.getExportPriceIndex().size());
    }

    @Test
    @Date("2017-06-06")
    public void getExportPriceIndexWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getExportPriceIndex(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-06")
    public void getExportPriceIndexWithParameters() {
        List<String> spin2007 = Arrays.asList("MIG_CAG_ORD", "MIG_ING_ORD");
        List<Integer> years = Arrays.asList(1998, 2000);

        assertNotEquals(0, this.client.getExportPriceIndex(spin2007, years).size());
    }

    @Test
    @Date("2017-06-06")
    public void getImportPriceIndex() {
        assertNotEquals(0, this.client.getImportPriceIndex().size());
    }

    @Test
    @Date("2017-06-06")
    public void getImportPriceIndexWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getImportPriceIndex(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-06")
    public void getImportPriceIndexWithParameters() {
        List<String> spin2007 = Arrays.asList("MIG_CAG_ORD", "MIG_ING_ORD");
        List<Integer> years = Arrays.asList(1998, 2000);

        assertNotEquals(0, this.client.getImportPriceIndex(spin2007, years).size());
    }

    @Test
    @Date("2017-06-06")
    public void getProducerPriceIndex() {
        assertNotEquals(0, this.client.getProducerPriceIndex().size());
    }

    @Test
    @Date("2017-06-06")
    public void getProducerPriceIndexWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getProducerPriceIndex(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-06")
    public void getProducerPriceIndexWithParameters() {
        List<String> spin2007 = Arrays.asList("MIG_CAG_ORD", "MIG_ING_ORD");
        List<Integer> years = Arrays.asList(1998, 2000);

        assertNotEquals(0, this.client.getProducerPriceIndex(spin2007, years).size());
    }

    @Test
    @Date("2017-06-06")
    public void getPriceIndexForDomesticSupply() {
        assertNotEquals(0, this.client.getPriceIndexForDomesticSupply().size());
    }

    @Test
    @Date("2017-06-06")
    public void getPriceIndexForDomesticSupplyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPriceIndexForDomesticSupply(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-06")
    public void getPriceIndexForDomesticSupplyWithParameters() {
        List<String> spin2007 = Arrays.asList("MIG_CAG_ORD", "MIG_ING_ORD");
        List<Integer> years = Arrays.asList(1998, 2000);

        assertNotEquals(0, this.client.getPriceIndexForDomesticSupply(spin2007, years).size());
    }

    @Test
    @Date("2017-06-06")
    public void getWeightsForDifferentIndices() {
        assertNotEquals(0, this.client.getWeightsForDifferentIndices().size());
    }

    @Test
    @Date("2017-06-06")
    public void getWeightsForDifferentIndicesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getWeightsForDifferentIndices(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-06")
    public void getWeightsForDifferentIndicesWithParameters() {
        List<String> spin2007 = Arrays.asList("07", "08");
        List<Integer> years = Arrays.asList(2012, 2013);

        assertNotEquals(0, this.client.getWeightsForDifferentIndices(spin2007, years).size());
    }

    @Test
    @Date("2017-06-06")
    public void getProducerPriceIndexForServices() {
        assertNotEquals(0, this.client.getProducerPriceIndexForServices().size());
    }

    @Test
    @Date("2017-06-06")
    public void getProducerPriceIndexForServicesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getProducerPriceIndexForServices(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-06")
    public void getProducerPriceIndexForServicesWithParameters() {
        List<String> spin2007 = Arrays.asList("77.1A", "77.1B");
        List<Integer> years = Arrays.asList(1998, 2000);

        assertNotEquals(0, this.client.getProducerPriceIndexForServices(spin2007, years).size());
    }

}
