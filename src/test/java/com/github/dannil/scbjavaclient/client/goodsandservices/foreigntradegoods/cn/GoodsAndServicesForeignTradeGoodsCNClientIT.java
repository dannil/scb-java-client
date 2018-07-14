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

package com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.cn;

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
public class GoodsAndServicesForeignTradeGoodsCNClientIT {

    private GoodsAndServicesForeignTradeGoodsCNClient client;

    @BeforeEach
    public void setup() {
        this.client = new GoodsAndServicesForeignTradeGoodsCNClient();
    }

    // Daniel 2017-04-28: Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getImportsAndExportsOfGoods() {
        assertThrows(SCBClientResponseTooLargeException.class, () -> this.client.getImportsAndExportsOfGoods());
    }

    // Daniel 2017-04-28: Returns HTTP 403
    @Test
    @Date("2018-06-28")
    public void getImportsAndExportsOfGoodsWithParametersEmptyLists() {
        assertThrows(SCBClientResponseTooLargeException.class,
                () -> this.client.getImportsAndExportsOfGoods(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()));
    }

    @Test
    @Date("2017-04-28")
    public void getImportsAndExportsOfGoodsWithParameters() {
        List<String> commodityGroups = Arrays.asList("0101", "0104");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getImportsAndExportsOfGoods(commodityGroups, years).size());
    }

}
