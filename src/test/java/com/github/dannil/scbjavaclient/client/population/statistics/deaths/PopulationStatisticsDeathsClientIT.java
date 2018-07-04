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

package com.github.dannil.scbjavaclient.client.population.statistics.deaths;

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
public class PopulationStatisticsDeathsClientIT {

    private PopulationStatisticsDeathsClient client;

    @BeforeEach
    public void setup() {
        this.client = new PopulationStatisticsDeathsClient();
    }

    @Test
    @Date("2017-04-27")
    public void getMortalityRate() {
        assertNotEquals(0, this.client.getMortalityRate().size());
    }

    @Test
    @Date("2017-04-27")
    public void getMortalityRateWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getMortalityRate(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-27")
    public void getMortalityRateWithParameters() {
        List<String> ages = Arrays.asList("30-34", "40-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2000, 2002);

        assertNotEquals(0, this.client.getMortalityRate(ages, sexes, years).size());
    }

    @Test
    @Date("2017-04-27")
    public void getStillborn() {
        assertNotEquals(0, this.client.getStillborn().size());
    }

    @Test
    @Date("2017-04-27")
    public void getStillbornWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getStillborn(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-27")
    public void getStillbornWithParameters() {
        List<String> regions = Arrays.asList("1263");
        List<String> motherAges = Arrays.asList("30-34");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> years = Arrays.asList(2010);

        assertNotEquals(0, this.client.getStillborn(regions, motherAges, sexes, years).size());
    }

    @Test
    @Date("2017-04-27")
    public void getLifeExpectency() {
        assertNotEquals(0, this.client.getLifeExpectency().size());
    }

    @Test
    @Date("2017-04-27")
    public void getLifeExpectencyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getLifeExpectency(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-27")
    public void getLifeExpectencyWithParameters() {
        List<String> regions = Arrays.asList("1263");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> years = Arrays.asList("2004-2008");

        assertNotEquals(0, this.client.getLifeExpectency(regions, sexes, years).size());
    }

    @Test
    @Date("2017-04-27")
    public void getLifeTable() {
        assertNotEquals(0, this.client.getLifeTable().size());
    }

    @Test
    @Date("2017-04-27")
    public void getLifeTableWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getLifeTable(Collections.<Integer>emptyList(), Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-27")
    public void getLifeTableWithParameters() {
        List<Integer> sexes = Arrays.asList(1, 2);
        List<Integer> ages = Arrays.asList(20, 22);
        List<Integer> years = Arrays.asList(2000, 2002);

        assertNotEquals(0, this.client.getLifeTable(sexes, ages, years).size());
    }

    @Test
    @Date("2017-04-27")
    public void getInfantMortality() {
        assertNotEquals(0, this.client.getInfantMortality().size());
    }

    @Test
    @Date("2017-04-27")
    public void getInfantMortalityWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getInfantMortality(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-27")
    public void getInfantMortalityWithParameters() {
        List<String> sexes = Arrays.asList("5+6");
        List<String> infantMortalities = Arrays.asList("0020", "0040");
        List<Integer> years = Arrays.asList(2000, 2002);

        assertNotEquals(0, this.client.getInfantMortality(sexes, infantMortalities, years).size());
    }

}
