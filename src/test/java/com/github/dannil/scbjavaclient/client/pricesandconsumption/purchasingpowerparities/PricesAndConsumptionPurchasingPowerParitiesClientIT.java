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

package com.github.dannil.scbjavaclient.client.pricesandconsumption.purchasingpowerparities;

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
public class PricesAndConsumptionPurchasingPowerParitiesClientIT {

    private PricesAndConsumptionPurchasingPowerParitiesClient client;

    @BeforeEach
    public void setup() {
        this.client = new PricesAndConsumptionPurchasingPowerParitiesClient();
    }

    @Test
    @Date("2017-06-04")
    public void getExtrapolatedPriceLevelIndices() {
        assertNotEquals(0, this.client.getExtrapolatedPriceLevelIndices().size());
    }

    @Test
    @Date("2017-06-04")
    public void getExtrapolatedPriceLevelIndicesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getExtrapolatedPriceLevelIndices(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-04")
    public void getExtrapolatedPriceLevelIndicesWithParameters() {
        List<String> countryGroups = Arrays.asList("DE", "GR");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getExtrapolatedPriceLevelIndices(countryGroups, years).size());
    }

    @Test
    @Date("2017-06-04")
    public void getPurchasingPowerParities() {
        assertNotEquals(0, this.client.getPurchasingPowerParities().size());
    }

    @Test
    @Date("2017-06-04")
    public void getPurchasingPowerParitiesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPurchasingPowerParities(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-06-04")
    public void getPurchasingPowerParitiesWithParameters() {
        List<String> countries = Arrays.asList("MT", "ME");
        List<String> esaClassifications = Arrays.asList("A01010106", "A010603");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getPurchasingPowerParities(countries, esaClassifications, years).size());
    }

}
