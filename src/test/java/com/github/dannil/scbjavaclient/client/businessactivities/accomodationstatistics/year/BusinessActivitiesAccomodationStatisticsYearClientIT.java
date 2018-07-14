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

package com.github.dannil.scbjavaclient.client.businessactivities.accomodationstatistics.year;

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
public class BusinessActivitiesAccomodationStatisticsYearClientIT {

    private BusinessActivitiesAccomodationStatisticsYearClient client;

    @BeforeEach
    public void setup() {
        this.client = new BusinessActivitiesAccomodationStatisticsYearClient();
    }

    @Test
    @Date("2017-04-13")
    public void getNumberOfHotels() {
        assertNotEquals(0, this.client.getNumberOfHotels().size());
    }

    @Test
    @Date("2017-04-13")
    public void getNumberOfHotelsParametersEmptyLists() {
        assertNotEquals(0, this.client.getNumberOfHotels(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getNumberOfHotelsWithParameters() {
        List<String> regions = Arrays.asList("06", "08");
        List<String> typesOfEstablishments = Arrays.asList("H", "S");
        List<Integer> years = Arrays.asList(2010, 2012);

        assertNotEquals(0, this.client.getNumberOfHotels(regions, typesOfEstablishments, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getCapacityForHotels() {
        assertNotEquals(0, this.client.getCapacityForHotels().size());
    }

    @Test
    @Date("2017-04-13")
    public void getCapacityForHotelsEmptyLists() {
        assertNotEquals(0, this.client.getCapacityForHotels(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getCapacityForHotelsWithParameters() {
        List<String> regions = Arrays.asList("0030", "07");
        List<String> typesOfHousing = Arrays.asList("012", "014");
        List<Integer> years = Arrays.asList(2010, 2012);

        assertNotEquals(0, this.client.getCapacityForHotels(regions, typesOfHousing, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getOccupancyRate() {
        assertNotEquals(0, this.client.getOccupancyRate().size());
    }

    @Test
    @Date("2017-04-13")
    public void getOccupancyRateEmptyLists() {
        assertNotEquals(0, this.client.getOccupancyRate(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getOccupancyRateWithParameters() {
        List<String> regions = Arrays.asList("0030", "07");
        List<String> typesOfHousing = Arrays.asList("012", "014");
        List<Integer> years = Arrays.asList(2010, 2012);

        assertNotEquals(0, this.client.getOccupancyRate(regions, typesOfHousing, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getNumberOfOccupiedRooms() {
        assertNotEquals(0, this.client.getNumberOfOccupiedRooms().size());
    }

    @Test
    @Date("2017-04-13")
    public void getNumberOfOccupiedRoomsEmptyLists() {
        assertNotEquals(0, this.client.getNumberOfOccupiedRooms(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getNumberOfOccupiedRoomsWithParameters() {
        List<String> regions = Arrays.asList("06", "08");
        List<Integer> years = Arrays.asList(2010, 2012);

        assertNotEquals(0, this.client.getNumberOfOccupiedRooms(regions, years).size());
    }

    @Test
    @Date("2017-04-13")
    public void getAccomodationRevenue() {
        assertNotEquals(0, this.client.getAccomodationRevenue().size());
    }

    @Test
    @Date("2017-04-13")
    public void getAccomodationRevenueEmptyLists() {
        assertNotEquals(0, this.client.getAccomodationRevenue(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-04-13")
    public void getAccomodationRevenueWithParameters() {
        List<String> regions = Arrays.asList("06", "08");
        List<Integer> years = Arrays.asList(2010, 2012);

        assertNotEquals(0, this.client.getAccomodationRevenue(regions, years).size());
    }

}
