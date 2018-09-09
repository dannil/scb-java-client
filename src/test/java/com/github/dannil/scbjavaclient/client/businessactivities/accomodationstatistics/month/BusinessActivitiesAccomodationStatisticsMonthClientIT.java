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
public class BusinessActivitiesAccomodationStatisticsMonthClientIT {

    private BusinessActivitiesAccomodationStatisticsMonthClient client;

    @BeforeEach
    public void setup() {
        this.client = new BusinessActivitiesAccomodationStatisticsMonthClient();
    }

    @Test
    @Date("2017-04-13")
    public void getTotalCapacity() {
        assertNotEquals(0, this.client.getTotalCapacity().size());
    }

    @Test
    @Date("2017-04-13")
    public void getTotalCapacityWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getTotalCapacity(Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getTotalCapacityWithParameters() {
        List<String> typesOfEstablishments = Arrays.asList("H", "S");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getTotalCapacity(typesOfEstablishments, months).size());
    }

    @Test
    @Date("2017-04-13")
    public void getAvailableBeds() {
        assertNotEquals(0, this.client.getAvailableBeds().size());
    }

    @Test
    @Date("2017-04-13")
    public void getAvailableBedsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getAvailableBeds(Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getAvailableBedsWithParameters() {
        List<String> regions = Arrays.asList("03", "05");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getAvailableBeds(regions, months).size());
    }

    @Test
    @Date("2017-04-13")
    public void getNumberOfAvailableRooms() {
        assertNotEquals(0, this.client.getNumberOfAvailableRooms().size());
    }

    @Test
    @Date("2017-04-13")
    public void getNumberOfAvailableRoomsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNumberOfAvailableRooms(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getNumberOfAvailableRoomsWithParameters() {
        List<String> regions = Arrays.asList("03", "05");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getNumberOfAvailableRooms(regions, months).size());
    }

    @Test
    @Date("2017-04-13")
    public void getNightsSpent() {
        assertNotEquals(0, this.client.getNightsSpent().size());
    }

    @Test
    @Date("2017-04-13")
    public void getNightsSpentWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getNightsSpent(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getNightsSpentWithParameters() {
        List<String> regions = Arrays.asList("03", "05");
        List<String> typesOfEstablishments = Arrays.asList("H", "S");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getNightsSpent(regions, typesOfEstablishments, months).size());
    }

    @Test
    @Date("2017-04-13")
    public void getOccupancy() {
        assertNotEquals(0, this.client.getOccupancy().size());
    }

    @Test
    @Date("2017-04-13")
    public void getOccupancyWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getOccupancy(Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getOccupancyWithParameters() {
        List<String> typesOfHousing = Arrays.asList("014", "016");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getOccupancy(typesOfHousing, months).size());
    }

    @Test
    @Date("2017-04-13")
    public void getOccupiedRooms() {
        assertNotEquals(0, this.client.getOccupiedRooms().size());
    }

    @Test
    @Date("2017-04-13")
    public void getOccupiedRoomsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getOccupiedRooms(Collections.<String>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getOccupiedRoomsWithParameters() {
        List<String> regions = Arrays.asList("03", "05");
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getOccupiedRooms(regions, months).size());
    }

    @Test
    @Date("2017-04-13")
    public void getRevenueOfOccupiedRooms() {
        assertNotEquals(0, this.client.getRevenueOfOccupiedRooms().size());
    }

    @Test
    @Date("2017-04-13")
    public void getRevenueOfOccupiedRoomsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getRevenueOfOccupiedRooms(Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getRevenueOfOccupiedRoomsWithParameters() {
        List<String> months = Arrays.asList("2008M06", "2009M06");

        assertNotEquals(0, this.client.getRevenueOfOccupiedRooms(months).size());
    }

}
