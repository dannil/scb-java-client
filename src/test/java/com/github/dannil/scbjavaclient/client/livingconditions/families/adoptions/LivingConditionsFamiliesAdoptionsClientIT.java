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

package com.github.dannil.scbjavaclient.client.livingconditions.families.adoptions;

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
public class LivingConditionsFamiliesAdoptionsClientIT {

    private LivingConditionsFamiliesAdoptionsClient client;

    @BeforeEach
    public void setup() {
        this.client = new LivingConditionsFamiliesAdoptionsClient();
    }
    
    @Test
    @Date("2018-06-15")
    public void getAllAdoptedChildrenAndYoungPersons() {
        assertNotEquals(0, this.client.getAllAdoptedChildrenAndYoungPersons().size());
    }

    @Test
    @Date("2018-06-15")
    public void getAllAdoptedChildrenAndYoungPersonsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAllAdoptedChildrenAndYoungPersons(Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-06-15")
    public void getAllAdoptedChildrenAndYoungPersonsWithParameters() {
        List<String> sexes = Arrays.asList("5", "6");
        List<String> ages = Arrays.asList("4", "5");
        List<String> birthCountries = Arrays.asList("LV", "RO");
        List<Integer> years = Arrays.asList(2005, 2009);

        assertNotEquals(0, this.client.getAllAdoptedChildrenAndYoungPersons(sexes, ages, birthCountries, years).size());
    }

}
