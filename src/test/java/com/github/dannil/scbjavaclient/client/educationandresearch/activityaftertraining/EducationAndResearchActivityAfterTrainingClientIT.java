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

package com.github.dannil.scbjavaclient.client.educationandresearch.activityaftertraining;

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
public class EducationAndResearchActivityAfterTrainingClientIT {

    private EducationAndResearchActivityAfterTrainingClient client;

    @BeforeEach
    public void setup() {
        this.client = new EducationAndResearchActivityAfterTrainingClient();
    }

    @Test
    @Date("2017-07-11")
    public void getPersonsActivitiesAfterCompletingHigherEducation() {
        assertNotEquals(0, this.client.getPersonsActivitiesAfterCompletingHigherEducation().size());
    }

    @Test
    @Date("2017-07-11")
    public void getPersonsActivitiesAfterCompletingHigherEducationWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPersonsActivitiesAfterCompletingHigherEducation(Collections.<Integer>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-07-11")
    public void getPersonsActivitiesAfterCompletingHigherEducationWithParameters() {
        List<Integer> yearsAfterCompletedEducation = Arrays.asList(2, 3);
        List<Integer> levelsOfAcademicDegrees = Arrays.asList(14, 17);
        List<Integer> activities = Arrays.asList(3, 4);
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> agesAtExam = Arrays.asList("25-29", "30-34");
        List<String> yearsOfExam = Arrays.asList("2003/2004", "2005/2006");

        assertNotEquals(0, this.client.getPersonsActivitiesAfterCompletingHigherEducation(yearsAfterCompletedEducation,
                levelsOfAcademicDegrees, activities, sexes, agesAtExam, yearsOfExam).size());
    }

    @Test
    @Date("2017-07-11")
    public void getPersonsActivitiesAfterCompletingCompulsorySchool() {
        assertNotEquals(0, this.client.getPersonsActivitiesAfterCompletingCompulsorySchool().size());
    }

    @Test
    @Date("2017-07-11")
    public void getPersonsActivitiesAfterCompletingCompulsorySchoolWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPersonsActivitiesAfterCompletingCompulsorySchool(Collections.<Integer>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<Integer>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                        Collections.<Integer>emptyList(), Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-07-11")
    public void getPersonsActivitiesAfterCompletingCompulsorySchoolWithParameters() {
        List<Integer> yearsAfterCompletedEducation = Arrays.asList(2, 3);
        List<Integer> levelsOfEducations = Arrays.asList(1, 2);
        List<Integer> activities = Arrays.asList(3, 4);
        List<Integer> sexes = Arrays.asList(1, 2);
        List<String> counties = Arrays.asList("05", "06");
        List<Integer> municipalityGroups = Arrays.asList(7, 8);
        List<String> yearsOfExam = Arrays.asList("2003/2004", "2005/2006");

        assertNotEquals(0, this.client.getPersonsActivitiesAfterCompletingCompulsorySchool(yearsAfterCompletedEducation,
                levelsOfEducations, activities, sexes, counties, municipalityGroups, yearsOfExam).size());
    }

}
