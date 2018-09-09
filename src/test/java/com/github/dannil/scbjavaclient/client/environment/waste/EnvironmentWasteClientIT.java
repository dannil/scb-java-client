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

package com.github.dannil.scbjavaclient.client.environment.waste;

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
public class EnvironmentWasteClientIT {

    private EnvironmentWasteClient client;

    @BeforeEach
    public void setup() {
        this.client = new EnvironmentWasteClient();
    }

    @Test
    @Date("2017-03-06")
    public void getGeneratedWaste() {
        assertNotEquals(0, this.client.getGeneratedWaste().size());
    }

    @Test
    @Date("2017-03-06")
    public void getGeneratedWasteWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getGeneratedWaste(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-03-06")
    public void getGeneratedWasteWasteWithParameters() {
        List<String> industrialClassifications = Arrays.asList("A01-03", "C16");
        List<String> wasteCategories = Arrays.asList("01.1", "03.2");
        List<Integer> years = Arrays.asList(2012, 2014);

        assertNotEquals(0, this.client.getGeneratedWaste(industrialClassifications, wasteCategories, years).size());
    }

    @Test
    @Date("2017-03-06")
    public void getTreatedWaste() {
        assertNotEquals(0, this.client.getTreatedWaste().size());
    }

    @Test
    @Date("2017-03-06")
    public void getTreatedWasteWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTreatedWaste(Collections.<Integer>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-03-06")
    public void getTreatedWasteWasteWithParameters() {
        List<Integer> treatmentCategories = Arrays.asList(40, 50);
        List<String> wasteCategories = Arrays.asList("01.1", "03.2");
        List<Integer> years = Arrays.asList(2012, 2014);

        assertNotEquals(0, this.client.getTreatedWaste(treatmentCategories, wasteCategories, years).size());
    }

}
