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

package com.github.dannil.scbjavaclient.client.businessactivities.accomodationstatistics.month;

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
public class MonthClientIT extends RemoteIntegrationTestSuite {

    private MonthClient client;

    @Before
    public void setup() {
        this.client = new SCBClient().businessActivities().accomodationStatistics().month();
    }

    @Test
    public void getTotalCapacity() {
        assertNotEquals(0, this.client.getTotalCapacity().size());
    }

    @Test
    public void getTotalCapacityWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getTotalCapacity(Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    public void getTotalCapacityWithParameters() {
        List<String> typesOfEstablishments = Arrays.asList("H", "S");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getTotalCapacity(typesOfEstablishments, months).size());
    }

    @Test
    public void getAvailableBeds() {
        assertNotEquals(0, this.client.getAvailableBeds().size());
    }

    @Test
    public void getAvailableBedsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAvailableBeds(Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    public void getAvailableBedsWithParameters() {
        List<String> regions = Arrays.asList("03", "05");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getAvailableBeds(regions, months).size());
    }

    @Test
    public void getNumberOfAvailableRooms() {
        assertNotEquals(0, this.client.getNumberOfAvailableRooms().size());
    }

    @Test
    public void getNumberOfAvailableRoomsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNumberOfAvailableRooms(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    public void getNumberOfAvailableRoomsWithParameters() {
        List<String> regions = Arrays.asList("03", "05");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getNumberOfAvailableRooms(regions, months).size());
    }

    @Test
    public void getNightsSpent() {
        assertNotEquals(0, this.client.getNightsSpent().size());
    }

    @Test
    public void getNightsSpentWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNightsSpent(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    public void getNightsSpentWithParameters() {
        List<String> regions = Arrays.asList("03", "05");
        List<String> typesOfEstablishments = Arrays.asList("H", "S");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getNightsSpent(regions, typesOfEstablishments, months).size());
    }

    @Test
    public void getOccupancy() {
        assertNotEquals(0, this.client.getOccupancy().size());
    }

    @Test
    public void getOccupancyWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getOccupancy(Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    public void getOccupancyWithParameters() {
        List<String> typesOfHousing = Arrays.asList("014", "016");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getOccupancy(typesOfHousing, months).size());
    }

    @Test
    public void getOccupiedRooms() {
        assertNotEquals(0, this.client.getOccupiedRooms().size());
    }

    @Test
    public void getOccupiedRoomsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getOccupiedRooms(Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    public void getOccupiedRoomsWithParameters() {
        List<String> regions = Arrays.asList("03", "05");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getOccupiedRooms(regions, months).size());
    }

    @Test
    public void getRevenueOfOccupiedRooms() {
        assertNotEquals(0, this.client.getRevenueOfOccupiedRooms().size());
    }

    @Test
    public void getRevenueOfOccupiedRoomsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRevenueOfOccupiedRooms(Collections.<String>emptyList()).size());
    }

    @Test
    public void getRevenueOfOccupiedRoomsWithParameters() {
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getRevenueOfOccupiedRooms(months).size());
    }

}
