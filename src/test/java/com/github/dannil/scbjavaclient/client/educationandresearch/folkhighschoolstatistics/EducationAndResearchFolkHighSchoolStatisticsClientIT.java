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
public class EducationAndResearchFolkHighSchoolStatisticsClientIT {

    private EducationAndResearchFolkHighSchoolStatisticsClient client;

    @BeforeEach
    public void setup() {
        this.client = new EducationAndResearchFolkHighSchoolStatisticsClient();
    }

    @Test
    @Date("2018-11-01")
    public void getParticipants() {
        assertNotEquals(0, this.client.getParticipants().size());
    }

    @Test
    @Date("2018-11-01")
    public void getParticipantsWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getParticipants(Collections.<String>emptyList(), Collections.<String>emptyList(),
                Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2018-11-01")
    public void getParticipantsWithParameters() {
        List<String> regions = Arrays.asList("01", "09");
        List<String> sexes = Arrays.asList("1", "2");
        List<String> typesOfCourses = Arrays.asList("18", "SUM");
        List<Integer> years = Arrays.asList(2016, 2018);

        assertNotEquals(0, this.client.getParticipants(regions, sexes, typesOfCourses, years).size());
    }

}
