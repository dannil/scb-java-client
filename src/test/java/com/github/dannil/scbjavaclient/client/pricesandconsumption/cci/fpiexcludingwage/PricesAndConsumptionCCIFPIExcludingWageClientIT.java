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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.cci.fpiexcludingwage;

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
public class PricesAndConsumptionCCIFPIExcludingWageClientIT {

    private PricesAndConsumptionCCIFPIExcludingWageClient client;

    @BeforeEach
    public void setup() {
        this.client = new PricesAndConsumptionCCIFPIExcludingWageClient();
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings1968Months() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings1968Months().size());
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings1968MonthsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings1968Months(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings1968MonthsWithParameters() {
        List<String> typesOfBuildings = Arrays.asList("FLERBO", "GRUPPSMÅ");
        List<String> typesOfExpenditures = Arrays.asList("MATERIAL", "BYGGKOST");
        List<String> months = Arrays.asList("1995M07", "1996M07");

        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings1968Months(typesOfBuildings, typesOfExpenditures,
                months).size());
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings2015Months() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings2015Months().size());
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings2015MonthsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings2015Months(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-06-10")
    public void getFactorPriceIndexForBuildings2015MonthsWithParameters() {
        List<String> typesOfBuildings = Arrays.asList("FLERBO", "GRUPPSMÅ");
        List<String> typesOfExpenditures = Arrays.asList("MATERIAL", "BYGGKOST");
        List<String> months = Arrays.asList("2015M04", "2015M06");

        assertNotEquals(0, this.client.getFactorPriceIndexForBuildings2015Months(typesOfBuildings, typesOfExpenditures,
                months).size());
    }

}
