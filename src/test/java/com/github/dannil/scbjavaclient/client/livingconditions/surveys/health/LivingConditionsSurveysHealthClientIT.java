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

package com.github.dannil.scbjavaclient.client.livingconditions.surveys.health;

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
public class LivingConditionsSurveysHealthClientIT {

    private LivingConditionsSurveysHealthClient client;

    @BeforeEach
    public void setup() {
        this.client = new LivingConditionsSurveysHealthClient();
    }

    @Test
    @Date("2017-03-25")
    public void getPhysicalAndMentalHealth() {
        assertNotEquals(0, this.client.getPhysicalAndMentalHealth().size());
    }

    @Test
    @Date("2017-03-25")
    public void getPhysicalAndMentalHealthWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPhysicalAndMentalHealth(Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-25")
    public void getPhysicalAndMentalHealthWithParameters() {
        List<String> indicators = Arrays.asList("H656", "H680");
        List<String> ages = Arrays.asList("35-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> periods = Arrays.asList("2008-2009", "2014-2015");

        assertNotEquals(0, this.client.getPhysicalAndMentalHealth(indicators, ages, sexes, periods).size());
    }

    @Test
    @Date("2017-03-25")
    public void getLongTermIllness() {
        assertNotEquals(0, this.client.getLongTermIllness().size());
    }

    @Test
    @Date("2017-03-25")
    public void getLongTermIllnessWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getLongTermIllness(Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-25")
    public void getLongTermIllnessWithParameters() {
        List<String> indicators = Arrays.asList("H755", "H760");
        List<String> ages = Arrays.asList("35-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> periods = Arrays.asList("2008-2009", "2010-2011");

        assertNotEquals(0, this.client.getLongTermIllness(indicators, ages, sexes, periods).size());
    }

    @Test
    @Date("2017-03-25")
    public void getDisabilities() {
        assertNotEquals(0, this.client.getDisabilities().size());
    }

    @Test
    @Date("2017-03-25")
    public void getDisabilitiesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDisabilities(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-25")
    public void getDisabilitiesWithParameters() {
        List<String> indicators = Arrays.asList("H780", "H840");
        List<String> ages = Arrays.asList("35-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> periods = Arrays.asList("2008-2009", "2014-2015");

        assertNotEquals(0, this.client.getDisabilities(indicators, ages, sexes, periods).size());
    }

    @Test
    @Date("2017-03-25")
    public void getDoctorAndDentistAppointments() {
        assertNotEquals(0, this.client.getDoctorAndDentistAppointments().size());
    }

    @Test
    @Date("2017-03-25")
    public void getDoctorAndDentistAppointmentsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getDoctorAndDentistAppointments(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-25")
    public void getDoctorAndDentistAppointmentsWithParameters() {
        List<String> indicators = Arrays.asList("H812", "H820");
        List<String> ages = Arrays.asList("35-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> periods = Arrays.asList("2008-2009", "2014-2015");

        assertNotEquals(0, this.client.getDoctorAndDentistAppointments(indicators, ages, sexes, periods).size());
    }

    @Test
    @Date("2017-03-25")
    public void getTobaccoHabits() {
        assertNotEquals(0, this.client.getTobaccoHabits().size());
    }

    @Test
    @Date("2017-03-25")
    public void getTobaccoHabitsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getTobaccoHabits(Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-25")
    public void getTobaccoHabitsWithParameters() {
        List<String> indicators = Arrays.asList("H825", "H830");
        List<String> ages = Arrays.asList("35-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> periods = Arrays.asList("2008-2009", "2014-2015");

        assertNotEquals(0, this.client.getTobaccoHabits(indicators, ages, sexes, periods).size());
    }

    @Test
    @Date("2017-03-25")
    public void getBodyMassIndex() {
        assertNotEquals(0, this.client.getBodyMassIndex().size());
    }

    @Test
    @Date("2017-03-25")
    public void getBodyMassIndexWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getBodyMassIndex(Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-03-25")
    public void getBodyMassIndexWithParameters() {
        List<String> indicators = Arrays.asList("H785", "H787");
        List<String> ages = Arrays.asList("35-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> periods = Arrays.asList("2014-2015");

        assertNotEquals(0, this.client.getBodyMassIndex(indicators, ages, sexes, periods).size());
    }

}
