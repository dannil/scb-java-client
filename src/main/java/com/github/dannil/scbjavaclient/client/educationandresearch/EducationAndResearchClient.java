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

package com.github.dannil.scbjavaclient.client.educationandresearch;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.educationandresearch.activityaftertraining.EducationAndResearchActivityAfterTrainingClient;
import com.github.dannil.scbjavaclient.client.educationandresearch.communityinnovationsurvey.EducationAndResearchCommunityInnovationSurveyClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles education and research data fetching.</p>
 *
 * @since 0.5.0
 */
public class EducationAndResearchClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public EducationAndResearchClient() {
        super();

        addClient("activityaftertraining", new EducationAndResearchActivityAfterTrainingClient());
        addClient("communityinnovationsurvey", new EducationAndResearchCommunityInnovationSurveyClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EducationAndResearchClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with education and research activity after
     * training data.</p>
     *
     * @return a client for education and research activity after training data
     */
    public EducationAndResearchActivityAfterTrainingClient activityAfterTraining() {
        return (EducationAndResearchActivityAfterTrainingClient) getClient("activityaftertraining");
    }

    /**
     * <p>Retrieve the client for interacting with education and research community
     * innovation survey data.</p>
     *
     * @return a client for education and research community innovation survey data
     */
    public EducationAndResearchCommunityInnovationSurveyClient communityInnovationSurvey() {
        return (EducationAndResearchCommunityInnovationSurveyClient) getClient("communityinnovationsurvey");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("UF/");
    }

}
