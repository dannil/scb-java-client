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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.ppi.spin2007monthlyandquarterly;

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
public class PricesAndConsumptionPPISPIN2007MonthlyAndQuarterlyClientIT {

    private PricesAndConsumptionPPISPIN2007MonthlyAndQuarterlyClient client;

    @BeforeEach
    public void setup() {
        this.client = new PricesAndConsumptionPPISPIN2007MonthlyAndQuarterlyClient();
    }

    @Test
    @Date("2017-06-05")
    public void getProducerPriceIndexHomeSales() {
        assertNotEquals(0, this.client.getProducerPriceIndexHomeSales().size());
    }

    @Test
    @Date("2017-06-05")
    public void getProducerPriceIndexHomeSalesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getProducerPriceIndexHomeSales(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-05")
    public void getProducerPriceIndexHomeSalesWithParameters() {
        List<String> spin2007 = Arrays.asList("MIG_CAG_ORD", "MIG_COG_ORD");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getProducerPriceIndexHomeSales(spin2007, months).size());
    }

    @Test
    @Date("2017-06-05")
    public void getExportPriceIndex() {
        assertNotEquals(0, this.client.getExportPriceIndex().size());
    }

    @Test
    @Date("2017-06-05")
    public void getExportPriceIndexWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getExportPriceIndex(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-05")
    public void getExportPriceIndexWithParameters() {
        List<String> spin2007 = Arrays.asList("MIG_CAG_ORD", "MIG_COG_ORD");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getExportPriceIndex(spin2007, months).size());
    }

    @Test
    @Date("2017-06-05")
    public void getImportPriceIndex() {
        assertNotEquals(0, this.client.getImportPriceIndex().size());
    }

    @Test
    @Date("2017-06-05")
    public void getImportPriceIndexWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getImportPriceIndex(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-05")
    public void getImportPriceIndexWithParameters() {
        List<String> spin2007 = Arrays.asList("MIG_CAG_ORD", "MIG_COG_ORD");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getImportPriceIndex(spin2007, months).size());
    }

    // Daniel 2018-05-12:
    // Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getProducerPriceIndex() {
        assertThrows(SCBClientResponseTooLargeException.class, () -> this.client.getProducerPriceIndex());
    }

    // Daniel 2018-05-12:
    // Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getProducerPriceIndexWithParametersEmptyLists() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getProducerPriceIndex(Collections.<String>emptyList(),
                        Collections.<String>emptyList()));
    }

    @Test
    @Date("2018-05-12")
    public void getProducerPriceIndexWithParameters() {
        List<String> spin2007 = Arrays.asList("MIG_CAG_ORD", "MIG_COG_ORD");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getProducerPriceIndex(spin2007, months).size());
    }

    // Daniel 2017-06-05:
    // Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getPriceIndexForDomesticSupply() {
        assertThrows(SCBClientResponseTooLargeException.class, () -> this.client.getPriceIndexForDomesticSupply());
    }

    // Daniel 2017-06-05:
    // Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getPriceIndexForDomesticSupplyWithParametersEmptyLists() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getPriceIndexForDomesticSupply(Collections.<String>emptyList(),
                        Collections.<String>emptyList()));
    }

    @Test
    @Date("2017-06-05")
    public void getPriceIndexForDomesticSupplyWithParameters() {
        List<String> spin2007 = Arrays.asList("MIG_CAG_ORD", "MIG_COG_ORD");
        List<String> months = Arrays.asList("2001M03", "2001M07");

        assertNotEquals(0, this.client.getPriceIndexForDomesticSupply(spin2007, months).size());
    }

    @Test
    @Date("2017-06-05")
    public void getProducerPriceIndexForServices() {
        assertNotEquals(0, this.client.getProducerPriceIndexForServices().size());
    }

    @Test
    @Date("2017-06-05")
    public void getProducerPriceIndexForServicesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getProducerPriceIndexForServices(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-05")
    public void getProducerPriceIndexForServicesWithParameters() {
        List<String> spin2007 = Arrays.asList("68.2B", "68.2D");
        List<String> quarters = Arrays.asList("2006K2", "2006K4");

        assertNotEquals(0, this.client.getProducerPriceIndexForServices(spin2007, quarters).size());
    }

}
