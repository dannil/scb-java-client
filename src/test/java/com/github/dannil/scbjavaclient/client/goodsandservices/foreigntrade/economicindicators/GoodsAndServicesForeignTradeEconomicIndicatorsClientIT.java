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

package com.github.dannil.scbjavaclient.client.goodsandservices.foreigntrade.economicindicators;

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
@SuppressWarnings("deprecation")
public class GoodsAndServicesForeignTradeEconomicIndicatorsClientIT {

    private GoodsAndServicesForeignTradeEconomicIndicatorsClient client;

    @BeforeEach
    public void setup() {
        this.client = new GoodsAndServicesForeignTradeEconomicIndicatorsClient();
    }

    @Test
    @Date("2017-04-28")
    public void getImportsAndExportsOfGoods() {
        assertNotEquals(0, this.client.getImportsAndExportsOfGoods().size());
    }

    @Test
    @Date("2017-04-28")
    public void getImportsAndExportsOfGoodsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getImportsAndExportsOfGoods(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-28")
    public void getImportsAndExportsOfGoodsWithParameters() {
        List<String> economicIndicators = Arrays.asList("HAH10", "HAH20");
        List<String> months = Arrays.asList("2014M09", "2014M11");

        assertNotEquals(0, this.client.getImportsAndExportsOfGoods(economicIndicators, months).size());
    }

    @Test
    @Date("2017-04-28")
    public void getTrendsInVolumeOfExportsAndImportsOfGoods() {
        assertNotEquals(0, this.client.getTrendsInVolumeOfExportsAndImportsOfGoods().size());
    }

    @Test
    @Date("2017-04-28")
    public void getTrendsInVolumeOfExportsAndImportsOfGoodsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTrendsInVolumeOfExportsAndImportsOfGoods(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-28")
    public void getTrendsInVolumeOfExportsAndImportsOfGoodsWithParameters() {
        List<String> economicIndicators = Arrays.asList("HAV10", "HAV20");
        List<String> quarters = Arrays.asList("2013K3", "2014K3");

        assertNotEquals(0,
                this.client.getTrendsInVolumeOfExportsAndImportsOfGoods(economicIndicators, quarters).size());
    }

}
