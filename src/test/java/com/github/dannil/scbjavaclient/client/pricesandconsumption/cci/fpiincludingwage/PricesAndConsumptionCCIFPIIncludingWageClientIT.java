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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cci.fpiincludingwage;

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
public class PricesAndConsumptionCCIFPIIncludingWageClientIT {

    private PricesAndConsumptionCCIFPIIncludingWageClient client;

    @BeforeEach
    public void setup() {
        this.client = new PricesAndConsumptionCCIFPIIncludingWageClient();
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings1968Years() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings1968Years().size());
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings1968YearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings1968Years(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings1968YearsWithParameters() {
        List<String> typesOfBuildings = Arrays.asList("FLERBO", "GRUPPSMÅ");
        List<String> typesOfExpenditures = Arrays.asList("TOTIM", "ARBL");
        List<Integer> years = Arrays.asList(1989, 1991);

        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings1968Years(typesOfBuildings, typesOfExpenditures,
                years).size());
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings2004Years() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings2004Years().size());
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings2004YearsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings2004Years(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings2004YearsWithParameters() {
        List<String> typesOfBuildings = Arrays.asList("FLERBO", "GRUPPSMÅ");
        List<String> typesOfExpenditures = Arrays.asList("TOTIM", "ARBL");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings2004Years(typesOfBuildings, typesOfExpenditures,
                years).size());
    }

}
