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

package com.github.dannil.scbjavaclient.client.educationandresearch.communityinnovationsurvey.activity;

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
public class EducationAndResearchCommunityInnovationSurveyActivityClientIT {

    private EducationAndResearchCommunityInnovationSurveyActivityClient client;

    @BeforeEach
    public void setup() {
        this.client = new EducationAndResearchCommunityInnovationSurveyActivityClient();
    }

    @Test
    @Date("2020-01-03")
    public void getNumberOfInnovativeEnterprises() {
        assertNotEquals(0, this.client.getNumberOfInnovativeEnterprises().size());
    }

    @Test
    @Date("2020-01-03")
    public void getNumberOfInnovativeEnterprisesWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getNumberOfInnovativeEnterprises(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2020-01-03")
    public void getNumberOfInnovativeEnterprisesWithParameters() {
        List<String> industrialClassifications = Arrays.asList("SA14", "SA12");
        List<String> sizeClasses = Arrays.asList("10-49", "50-249");
        List<String> typesOfValues = Arrays.asList("PS", "KI");
        List<String> periods = Arrays.asList("2016-2018");

        assertNotEquals(0, this.client.getNumberOfInnovativeEnterprises(industrialClassifications, sizeClasses,
                typesOfValues, periods).size());
    }

    @Test
    @Date("2019-12-25")
    public void getEnterprisesWithProductInnovations() {
        assertNotEquals(0, this.client.getEnterprisesWithProductInnovations().size());
    }

    @Test
    @Date("2019-12-25")
    public void getEnterprisesWithProductInnovationsWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getEnterprisesWithProductInnovations(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2019-12-25")
    public void getEnterprisesWithProductInnovationsWithParameters() {
        List<String> sni2007s = Arrays.asList("46+H+J-K+71+72", "58+61-63");
        List<String> sizeClasses = Arrays.asList("10-49", "50-249");
        List<String> typesOfValues = Arrays.asList("PS", "KI");
        List<String> periods = Arrays.asList("2012-2014", "2014-2016");

        assertNotEquals(0,
                this.client.getEnterprisesWithProductInnovations(sni2007s, sizeClasses, typesOfValues, periods).size());
    }

    @Test
    @Date("2019-12-25")
    public void getPlatformsToAcquireKnowledge() {
        assertNotEquals(0, this.client.getPlatformsToAcquireKnowledge().size());
    }

    @Test
    @Date("2019-12-25")
    public void getPlatformsToAcquireKnowledgeWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getPlatformsToAcquireKnowledge(Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2019-12-25")
    public void getPlatformsToAcquireKnowledgeWithParameters() {
        List<String> sni2007s = Arrays.asList("58+61-63", "71-73");
        List<String> sizeClasses = Arrays.asList("10-49", "50-249");
        List<String> typesOfValues = Arrays.asList("PS", "KI");
        List<String> periods = Arrays.asList("2016-2018");

        assertNotEquals(0,
                this.client.getPlatformsToAcquireKnowledge(sni2007s, sizeClasses, typesOfValues, periods).size());
    }

    @Test
    @Date("2019-12-25")
    public void getObstaclesToInnovation() {
        assertNotEquals(0, this.client.getObstaclesToInnovation().size());
    }

    @Test
    @Date("2019-12-25")
    public void getObstaclesToInnovationWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getObstaclesToInnovation(Collections.<Integer>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList(), Collections.<String>emptyList(),
                        Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2019-12-25")
    public void getObstaclesToInnovationWithParameters() {
        List<Integer> degreesOfSignificances = Arrays.asList(220, 260);
        List<String> sni2007s = Arrays.asList("SA14", "G+H+I+J+K+69-74+N");
        List<String> sizeClasses = Arrays.asList("10-49", "50-249");
        List<String> typesOfValues = Arrays.asList("PS", "KI");
        List<String> periods = Arrays.asList("2016-2018");

        assertNotEquals(0, this.client.getObstaclesToInnovation(degreesOfSignificances, sni2007s, sizeClasses,
                typesOfValues, periods).size());
    }

}
