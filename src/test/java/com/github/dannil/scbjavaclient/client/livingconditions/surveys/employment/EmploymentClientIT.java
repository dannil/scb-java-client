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

package com.github.dannil.scbjavaclient.client.livingconditions.surveys.employment;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EmploymentClientIT extends RemoteIntegrationTestSuite {

    private EmploymentClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().livingConditions().surveys().employment();
    }

    @Test
    public void getMainActivity() {
        assertNotEquals(0, this.client.getMainActivity().size());
    }

    @Test
    public void getMainActivityWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getMainActivity(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<String>emptyList()));
    }

    @Test
    public void getMainActivityWithParameters() {
        List<String> activities = Arrays.asList("S215", "S225");
        List<String> ages = Arrays.asList("35-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> periods = Arrays.asList("2008-2009", "2014-2015");

        assertNotEquals(0, this.client.getMainActivity(activities, ages, sexes, periods).size());
    }

    @Test
    public void getGainfullyEmployedPersons() {
        assertNotEquals(0, this.client.getGainfullyEmployedPersons().size());
    }

    @Test
    public void getGainfullyEmployedPersonsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getGainfullyEmployedPersons(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList(), Collections.<String>emptyList()));
    }

    @Test
    public void getGainfullyEmployedPersonsWithParameters() {
        List<String> fullAndPartTimes = Arrays.asList("S238", "S240");
        List<String> ages = Arrays.asList("35-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> periods = Arrays.asList("2008-2009", "2014-2015");

        assertNotEquals(0, this.client.getGainfullyEmployedPersons(fullAndPartTimes, ages, sexes, periods).size());
    }

    @Test
    public void getTypeOfEmployment() {
        assertNotEquals(0, this.client.getTypeOfEmployment().size());
    }

    @Test
    public void getTypeOfEmploymentWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getTypeOfEmployment(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList(), Collections.<String>emptyList()));
    }

    @Test
    public void getTypeOfEmploymentWithParameters() {
        List<String> types = Arrays.asList("S265", "S365");
        List<String> ages = Arrays.asList("35-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> periods = Arrays.asList("2008-2009", "2014-2015");

        assertNotEquals(0, this.client.getTypeOfEmployment(types, ages, sexes, periods).size());
    }

    @Test
    public void getDistributionOfWorkingHoursForEmployees() {
        assertNotEquals(0, this.client.getDistributionOfWorkingHoursForEmployees().size());
    }

    @Test
    public void getDistributionOfWorkingHoursForEmployeesWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getDistributionOfWorkingHoursForEmployees(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList(), Collections.<String>emptyList()));
    }

    @Test
    public void getDistributionOfWorkingHoursForEmployeesWithParameters() {
        List<String> types = Arrays.asList("A437", "A445");
        List<String> ages = Arrays.asList("35-44");
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> periods = Arrays.asList("2008-2009", "2014-2015");

        assertNotEquals(0, this.client.getDistributionOfWorkingHoursForEmployees(types, ages, sexes, periods).size());
    }

}
