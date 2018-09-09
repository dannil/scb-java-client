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

package com.github.dannil.scbjavaclient.client.agriculture.holdings;

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
public class AgricultureHoldingsClientIT {

    private AgricultureHoldingsClient client;

    @BeforeEach
    public void setup() {
        this.client = new AgricultureHoldingsClient();
    }

    @Test
    @Date("2017-05-21")
    public void getAgriculturalEnterprisesByMunicipalityAndSizeClass() {
        assertNotEquals(0, this.client.getAgriculturalEnterprisesByMunicipalityAndSizeClass().size());
    }

    @Test
    @Date("2017-05-21")
    public void getAgriculturalEnterprisesByMunicipalityAndSizeClassWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAgriculturalEnterprisesByMunicipalityAndSizeClass(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-21")
    public void getAgriculturalEnterprisesByMunicipalityAndSizeClassWithParameters() {
        List<String> regions = Arrays.asList("0128", "0136");
        List<String> sizeClasses = Arrays.asList("20,1-30,0", "100,1+");
        List<Integer> years = Arrays.asList(1992, 1993);

        assertNotEquals(0,
                this.client.getAgriculturalEnterprisesByMunicipalityAndSizeClass(regions, sizeClasses, years).size());
    }

    @Test
    @Date("2017-05-21")
    public void getAgriculturalEnterprisesByCountyAndSizeClass() {
        assertNotEquals(0, this.client.getAgriculturalEnterprisesByCountyAndSizeClass().size());
    }

    @Test
    @Date("2017-05-21")
    public void getAgriculturalEnterprisesByCountyAndSizeClassWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAgriculturalEnterprisesByCountyAndSizeClass(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-21")
    public void getAgriculturalEnterprisesByCountyAndSizeClassWithParameters() {
        List<String> regions = Arrays.asList("04", "06");
        List<String> sizeClasses = Arrays.asList("-2,0", "5,1-10,0");
        List<Integer> years = Arrays.asList(1992, 1993);

        assertNotEquals(0,
                this.client.getAgriculturalEnterprisesByCountyAndSizeClass(regions, sizeClasses, years).size());
    }

    @Test
    @Date("2017-05-21")
    public void getAgriculturalEnterprisesByCountyAndJuridicalForm() {
        assertNotEquals(0, this.client.getAgriculturalEnterprisesByCountyAndJuridicalForm().size());
    }

    @Test
    @Date("2017-05-21")
    public void getAgriculturalEnterprisesByCountyAndJuridicalFormWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAgriculturalEnterprisesByCountyAndJuridicalForm(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-21")
    public void getAgriculturalEnterprisesByCountyAndJuridicalFormWithParameters() {
        List<String> regions = Arrays.asList("04", "06");
        List<String> typesOfHoldings = Arrays.asList("AB", "EF");
        List<Integer> years = Arrays.asList(1992, 1993);

        assertNotEquals(0,
                this.client.getAgriculturalEnterprisesByCountyAndJuridicalForm(regions, typesOfHoldings, years).size());
    }

}
