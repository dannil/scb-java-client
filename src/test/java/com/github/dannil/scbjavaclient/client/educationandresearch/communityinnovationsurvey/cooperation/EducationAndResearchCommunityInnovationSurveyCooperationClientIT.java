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

package com.github.dannil.scbjavaclient.client.educationandresearch.communityinnovationsurvey.cooperation;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Suite
@Remote
public class EducationAndResearchCommunityInnovationSurveyCooperationClientIT {

    private EducationAndResearchCommunityInnovationSurveyCooperationClient client;

    @BeforeEach
    public void setup() {
        this.client = new EducationAndResearchCommunityInnovationSurveyCooperationClient();
    }

    @Test
    @Date("2017-07-11")
    public void getNumberOfInnovativeEnterprises() {
        assertNotEquals(0, this.client.getNumberOfInnovativeEnterprises().size());
    }

    @Test
    @Date("2017-07-11")
    public void getNumberOfInnovativeEnterprisesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getNumberOfInnovativeEnterprises(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-07-11")
    public void getNumberOfInnovativeEnterprisesWithParameters() {
        List<String> industrialClassifications = Arrays.asList("64-66", "71+72");
        List<String> sizeClasses = Arrays.asList("10-49", "50-249");
        List<String> typesOfValues = Arrays.asList("PS", "KI");
        List<String> periods = Arrays.asList("2010-2012", "2012-2014");

        assertNotEquals(0, this.client.getNumberOfInnovativeEnterprises(industrialClassifications, sizeClasses,
                typesOfValues, periods).size());
    }

}
