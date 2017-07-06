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

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles education and research community innovation survey innovation
 * activity among enterprises data fetching.</p>
 *
 * @since 0.5.0
 */
public class EducationAndResearchCommunityInnovationSurveyActivityClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EducationAndResearchCommunityInnovationSurveyActivityClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EducationAndResearchCommunityInnovationSurveyActivityClient(Locale locale) {
        super(locale);
    }

    // /**
    // * <p>Fetch all business production index data.</p>
    // *
    // * @return the data wrapped in a list of
    // * {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
    // * objects
    // *
    // * @see #getBusinessProductionIndex(Collection, Collection)
    // */
    // public List<ResponseModel> getBusinessProductionIndex() {
    // return getBusinessProductionIndex(null, null);
    // }
    //
    // /**
    // * <p>Fetch all business production index data which match the input
    // constraints.</p>
    // *
    // * @param industrialClassifications
    // * the industrial classifications
    // * @param months
    // * the months
    // * @return the data wrapped in a list of
    // * {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
    // * objects
    // */
    // public List<ResponseModel> getBusinessProductionIndex(Collection<String>
    // industrialClassifications,
    // Collection<String> months) {
    // Map<String, Collection<?>> mappings = new HashMap<>();
    // mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
    // mappings.put(APIConstants.TIME_CODE, months);
    //
    // return getResponseModels("NV0004T1", mappings);
    // }

    TODO
    
    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("UF/UF0315/UF0315A/");
    }

}
