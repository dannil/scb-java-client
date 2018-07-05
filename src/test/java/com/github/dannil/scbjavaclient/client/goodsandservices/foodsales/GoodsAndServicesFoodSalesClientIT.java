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

package com.github.dannil.scbjavaclient.client.goodsandservices.foodsales;

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
public class GoodsAndServicesFoodSalesClientIT {

    private GoodsAndServicesFoodSalesClient client;

    @BeforeEach
    public void setup() {
        this.client = new GoodsAndServicesFoodSalesClient();
    }

    @Test
    @Date("2017-04-28")
    public void getTurnoverOfFoodAndDrinks() {
        assertNotEquals(0, this.client.getTurnoverOfFoodAndDrinks().size());
    }

    @Test
    @Date("2017-04-28")
    public void getTurnoverOfFoodAndDrinksWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverOfFoodAndDrinks(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-28")
    public void getTurnoverOfFoodAndDrinksWithParameters() {
        List<String> productGroups = Arrays.asList("01.1.6.1-7", "01.1.9.3+4");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getTurnoverOfFoodAndDrinks(productGroups, years).size());
    }

    @Test
    @Date("2017-04-28")
    public void getTurnoverOfEcologicalFoodAndNonAlcoholicDrinks() {
        assertNotEquals(0, this.client.getTurnoverOfEcologicalFoodAndNonAlcoholicDrinks().size());
    }

    @Test
    @Date("2017-04-28")
    public void getTurnoverOfEcologicalFoodAndNonAlcoholicDrinksWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTurnoverOfEcologicalFoodAndNonAlcoholicDrinks(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-28")
    public void getTurnoverOfEcologicalFoodAndNonAlcoholicDrinksWithParameters() {
        List<String> productGroups = Arrays.asList("01.1.6", "01.1.7");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getTurnoverOfEcologicalFoodAndNonAlcoholicDrinks(productGroups, years).size());
    }

}
