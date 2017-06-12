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

package com.github.dannil.scbjavaclient.client.transport.registeredvehicles.vehicles;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class TransportRegisteredVehiclesVehiclesClientIT extends RemoteIntegrationTestSuite {

    private TransportRegisteredVehiclesVehiclesClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().transport().registeredVehicles().vehicles();
    }

    @Test
    @Date("2017-05-08")
    public void getVehiclesInUse() {
        assertNotEquals(0, this.client.getVehiclesInUse().size());
    }

    @Test
    @Date("2017-05-08")
    public void getVehiclesInUseWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getVehiclesInUse(Collections.<Integer>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-08")
    public void getVehiclesInUseWithParameters() {
        List<Integer> typesOfVehicles = Arrays.asList(30, 40);
        List<Integer> years = Arrays.asList(2008, 2010);

        assertNotEquals(0, this.client.getVehiclesInUse(typesOfVehicles, years).size());
    }

    @Test
    @Date("2017-05-08")
    public void getNewRegistrationsOfPassengerCars() {
        assertNotEquals(0, this.client.getNewRegistrationsOfPassengerCars().size());
    }

    @Test
    @Date("2017-05-08")
    public void getNewRegistrationsOfPassengerCarsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNewRegistrationsOfPassengerCars(Collections.<String>emptyList(),
                Collections.<Integer>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-05-08")
    public void getNewRegistrationsOfPassengerCarsWithParameters() {
        List<String> regions = Arrays.asList("09", "0114");
        List<Integer> fuels = Arrays.asList(140, 160);
        List<String> months = Arrays.asList("2008M06", "2010M06");

        assertNotEquals(0, this.client.getNewRegistrationsOfPassengerCars(regions, fuels, months).size());
    }

    @Test
    @Date("2017-05-08")
    public void getVehiclesFromTheVehicleRegister() {
        assertNotEquals(0, this.client.getVehiclesFromTheVehicleRegister().size());
    }

    @Test
    @Date("2017-05-08")
    public void getVehiclesFromTheVehicleRegisterWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getVehiclesFromTheVehicleRegister(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-05-08")
    public void getVehiclesFromTheVehicleRegisterWithParameters() {
        List<String> typesOfVehicles = Arrays.asList("PERS", "LAST");
        List<String> statuses = Arrays.asList("AVST", "NYREG");
        List<String> months = Arrays.asList("2008M06", "2010M06");

        assertNotEquals(0, this.client.getVehiclesFromTheVehicleRegister(typesOfVehicles, statuses, months).size());
    }

    @Test
    @Date("2017-05-08")
    public void getPassengerCarsInUse() {
        assertNotEquals(0, this.client.getPassengerCarsInUse().size());
    }

    @Test
    @Date("2017-05-08")
    public void getPassengerCarsInUseWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getPassengerCarsInUse(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-08")
    public void getPassengerCarsInUseWithParameters() {
        List<String> regions = Arrays.asList("09", "0114");
        List<String> typesOfOwnerships = Arrays.asList("030", "040");
        List<Integer> years = Arrays.asList(2008, 2010);

        assertNotEquals(0, this.client.getPassengerCarsInUse(regions, typesOfOwnerships, years).size());
    }

}
