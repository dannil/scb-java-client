/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.educationandresearch.folkhighschoolstatistics;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.model.ResponseModel;
import com.github.dannil.scbjavaclient.test.extensions.AllowFailure;
import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Suite
@Remote
public class EducationAndResearchFolkHighSchoolStatisticsClientIT {

    private EducationAndResearchFolkHighSchoolStatisticsClient client;

    @BeforeEach
    public void setup() {
        this.client = new EducationAndResearchFolkHighSchoolStatisticsClient();
    }

    @Test
    @Date("2020-03-20")
    @AllowFailure
    public void getParticipants() {
        assertNotEquals(0, this.client.getParticipants().size());
    }

    @Test
    @Date("2020-03-20")
    @AllowFailure
    public void getParticipantsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getParticipants(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2020-03-20")
    @AllowFailure
    public void getParticipantsWithParameters() {
        List<String> regions = Arrays.asList("01", "09");
        List<String> sexes = Arrays.asList("1", "2");
        List<String> typesOfCourses = Arrays.asList("18", "SUM");
        List<Integer> years = Arrays.asList(2016, 2018);

        assertNotEquals(0, this.client.getParticipants(regions, sexes, typesOfCourses, years).size());
    }

    @Test
    @Date("2020-03-20")
    public void getParticipantsInCourses() {
        List<ResponseModel> response = this.client.getParticipantsInCourses();

        assertNotEquals(0, response.size());
        assertTrue(response.stream().allMatch(model -> model.getVariables().keySet().containsAll(
                List.of("Kon", "KursTyp", "RegionUtb", "Aldersgrupp", "Tid"))));
    }

    @Test
    @Date("2020-03-20")
    public void getParticipantsInCoursesWithParametersEmptyLists() {
        List<ResponseModel> response = this.client.getParticipantsInCourses(Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList());

        assertNotEquals(0, response.size());
        assertTrue(response.stream().allMatch(model -> model.getVariables().keySet().containsAll(
                List.of("Kon", "KursTyp", "RegionUtb", "Aldersgrupp", "Tid"))));
    }

    @Test
    @Date("2020-03-20")
    public void getParticipantsInCoursesWithParameters() {
        List<String> sexes = Arrays.asList("1", "2");
        List<String> typesOfCourses = Arrays.asList("01", "02");
        List<String> nationalBackgrounds = Arrays.asList("IF", "USGR");
        List<String> regionOfEducations = Arrays.asList("404", "544");
        List<String> ageGroups = Arrays.asList("25-34", "45-64");
        List<Integer> years = Arrays.asList(2017, 2018);

        List<ResponseModel> response = this.client.getParticipantsInCourses(sexes, typesOfCourses, nationalBackgrounds,
                regionOfEducations, ageGroups, years);

        assertNotEquals(0, response.size());
        assertTrue(response.stream().allMatch(model -> model.getVariables().keySet().containsAll(
                List.of("Kon", "KursTyp", "NationellBakgrund", "RegionUtb", "Aldersgrupp", "Tid"))));
    }

}
