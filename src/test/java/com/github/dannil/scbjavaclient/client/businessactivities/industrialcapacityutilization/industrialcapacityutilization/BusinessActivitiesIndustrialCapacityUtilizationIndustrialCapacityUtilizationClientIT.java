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

package com.github.dannil.scbjavaclient.client.businessactivities.industrialcapacityutilization.industrialcapacityutilization;

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
public class BusinessActivitiesIndustrialCapacityUtilizationIndustrialCapacityUtilizationClientIT {

    private BusinessActivitiesIndustrialCapacityUtilizationIndustrialCapacityUtilizationClient client;

    @BeforeEach
    public void setup() {
        this.client = new BusinessActivitiesIndustrialCapacityUtilizationIndustrialCapacityUtilizationClient();
    }

    @Test
    @Date("2017-12-30")
    public void getIndustrialCapacityUtilisationSNI2007() {
        assertNotEquals(0, this.client.getIndustrialCapacityUtilisationSNI2007().size());
    }

    @Test
    @Date("2017-12-30")
    public void getIndustrialCapacityUtilisationSNI2007WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIndustrialCapacityUtilisationSNI2007(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-30")
    public void getIndustrialCapacityUtilisationSNI2007WithParameters() {
        List<String> industrialClassifications = Arrays.asList("IVKON", "VKON");
        List<String> quarters = Arrays.asList("1998K1", "1998K2");

        assertNotEquals(0,
                this.client.getIndustrialCapacityUtilisationSNI2007(industrialClassifications, quarters).size());
    }

    @Test
    @Date("2017-12-30")
    public void getIndustrialCapacityUtilisationSNI92() {
        assertNotEquals(0, this.client.getIndustrialCapacityUtilisationSNI92().size());
    }

    @Test
    @Date("2017-12-30")
    public void getIndustrialCapacityUtilisationSNI92WithParametersEmptyLists() {
        assertNotEquals(0, this.client.getIndustrialCapacityUtilisationSNI92(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-30")
    public void getIndustrialCapacityUtilisationSNI92WithParameters() {
        List<String> industrialClassifications = Arrays.asList("15+16", "17-19");
        List<String> quarters = Arrays.asList("2003K1", "2003K2");

        assertNotEquals(0,
                this.client.getIndustrialCapacityUtilisationSNI92(industrialClassifications, quarters).size());
    }

    @Test
    @Date("2017-12-30")
    public void getIndustrialCapacityUtilisationSNI2007HistoricalTimeSeries() {
        assertNotEquals(0, this.client.getIndustrialCapacityUtilisationSNI2007HistoricalTimeSeries().size());
    }

    @Test
    @Date("2017-12-30")
    public void getIndustrialCapacityUtilisationSNI2007HistoricalTimeSeriesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getIndustrialCapacityUtilisationSNI2007HistoricalTimeSeries(Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-12-30")
    public void getIndustrialCapacityUtilisationSNI2007HistoricalTimeSeriesWithParameters() {
        List<String> industrialClassifications = Arrays.asList("20-21", "B+C");
        List<String> quarters = Arrays.asList("1986K3", "1986K4");

        assertNotEquals(0,
                this.client.getIndustrialCapacityUtilisationSNI2007HistoricalTimeSeries(industrialClassifications,
                        quarters).size());
    }

}
