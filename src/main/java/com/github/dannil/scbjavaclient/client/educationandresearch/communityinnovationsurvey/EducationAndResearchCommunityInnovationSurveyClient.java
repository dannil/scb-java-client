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

package com.github.dannil.scbjavaclient.client.educationandresearch.communityinnovationsurvey;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.educationandresearch.communityinnovationsurvey.activity.EducationAndResearchCommunityInnovationSurveyActivityClient;
import com.github.dannil.scbjavaclient.client.educationandresearch.communityinnovationsurvey.cooperation.EducationAndResearchCommunityInnovationSurveyCooperationClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles education and research community innovation survey data
 * fetching.</p>
 *
 * @since 0.5.0
 */
public class EducationAndResearchCommunityInnovationSurveyClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public EducationAndResearchCommunityInnovationSurveyClient() {
        super();

        addClient("activity", new EducationAndResearchCommunityInnovationSurveyActivityClient());
        addClient("cooperation", new EducationAndResearchCommunityInnovationSurveyCooperationClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EducationAndResearchCommunityInnovationSurveyClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with education and research community
     * innovation survey innovation activity among enterprises data.</p>
     *
     * @return a client for education and research community innovation survey innovation
     *         activity among enterprises data
     */
    public EducationAndResearchCommunityInnovationSurveyActivityClient activity() {
        return (EducationAndResearchCommunityInnovationSurveyActivityClient) getClient("activity");
    }

    /**
     * <p>Retrieve the client for interacting with education and research community
     * innovation survey co-operation activity among enterprises data.</p>
     *
     * @return a client for education and research community innovation survey
     *         co-operation activity among enterprises data
     */
    public EducationAndResearchCommunityInnovationSurveyCooperationClient cooperation() {
        return (EducationAndResearchCommunityInnovationSurveyCooperationClient) getClient("cooperation");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("UF/UF0315/");
    }

}
