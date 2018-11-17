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

package com.github.dannil.scbjavaclient.client.environment.seea.goodsandservicessector;

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
public class EnvironmentSEEAGoodsAndServicesSectorClientIT {

    private EnvironmentSEEAGoodsAndServicesSectorClient client;

    @BeforeEach
    public void setup() {
        this.client = new EnvironmentSEEAGoodsAndServicesSectorClient();
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorByEnvironmentalArea() {
        assertNotEquals(0, this.client.getEnvironmentalSectorByEnvironmentalArea().size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorByEnvironmentalAreaWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEnvironmentalSectorByEnvironmentalArea(Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorByEnvironmentalAreaWithParameters() {
        List<Integer> environmentalAreas = Arrays.asList(1400, 1600);
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getEnvironmentalSectorByEnvironmentalArea(environmentalAreas, years).size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorByCounty() {
        assertNotEquals(0, this.client.getEnvironmentalSectorByCounty().size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorByCountyWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getEnvironmentalSectorByCounty(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorByCountyWithParameters() {
        List<String> counties = Arrays.asList("04", "06");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getEnvironmentalSectorByCounty(counties, years).size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorNetTurnoverByIndustrialClassification() {
        assertNotEquals(0, this.client.getEnvironmentalSectorNetTurnoverByIndustrialClassification().size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorNetTurnoverByIndustrialClassificationWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getEnvironmentalSectorNetTurnoverByIndustrialClassification(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorNetTurnoverByIndustrialClassificationWithParameters() {
        List<String> industrialClassifications = Arrays.asList("A01", "S96");
        List<Integer> years = Arrays.asList(2006, 2007);

        assertNotEquals(0,
                this.client.getEnvironmentalSectorNetTurnoverByIndustrialClassification(industrialClassifications,
                        years).size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorValueAddedByIndustrialClassification() {
        assertNotEquals(0, this.client.getEnvironmentalSectorValueAddedByIndustrialClassification().size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorValueAddedByIndustrialClassificationWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getEnvironmentalSectorValueAddedByIndustrialClassification(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorValueAddedByIndustrialClassificationWithParameters() {
        List<String> industrialClassifications = Arrays.asList("L68", "S94-T98");
        List<Integer> years = Arrays.asList(2008, 2009);

        assertNotEquals(0,
                this.client.getEnvironmentalSectorValueAddedByIndustrialClassification(industrialClassifications,
                        years).size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorExportByIndustrialClassification() {
        assertNotEquals(0, this.client.getEnvironmentalSectorExportByIndustrialClassification().size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorExportByIndustrialClassificationWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getEnvironmentalSectorExportByIndustrialClassification(Collections.<String>emptyList(),
                        Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-06-26")
    public void getEnvironmentalSectorExportByIndustrialClassificationWithParameters() {
        List<String> industrialClassifications = Arrays.asList("F41-F43", "R90-T98");
        List<Integer> years = Arrays.asList(2010, 2011);

        assertNotEquals(0, this.client.getEnvironmentalSectorExportByIndustrialClassification(industrialClassifications,
                years).size());
    }

}
