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

package com.github.dannil.scbjavaclient.client.publicfinances.localtaxes;

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
public class PublicFinancesLocalTaxesClientIT {

    private PublicFinancesLocalTaxesClient client;

    @BeforeEach
    public void setup() {
        this.client = new PublicFinancesLocalTaxesClient();
    }

    @Test
    @Date("2017-03-21")
    public void getLocalTaxRates() {
        assertNotEquals(0, this.client.getLocalTaxRates().size());
    }

    @Test
    @Date("2017-03-21")
    public void getLocalTaxRatesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getLocalTaxRates(Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-03-21")
    public void getLocalTaxRatesWithParameters() {
        List<String> regions = Arrays.asList("0182", "0305");
        List<Integer> years = Arrays.asList(2004, 2008);

        assertNotEquals(0, this.client.getLocalTaxRates(regions, years).size());
    }

}
