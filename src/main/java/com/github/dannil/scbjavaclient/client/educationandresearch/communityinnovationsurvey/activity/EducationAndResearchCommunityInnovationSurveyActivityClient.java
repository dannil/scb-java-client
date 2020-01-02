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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles education and research community innovation survey innovation
 * activity among enterprises data fetching.</p>
 *
 * @since 0.5.0
 */
public class EducationAndResearchCommunityInnovationSurveyActivityClient extends AbstractClient {

    private static final String SIZECLASSES_CODE = "Storleksklass";

    private static final String TYPESOFVALUES_CODE = "VarTyp";

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

    /**
     * <p>Fetch all number of innovative enterprises data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfInnovativeEnterprises(Collection, Collection, Collection,
     *      Collection)
     * @deprecated table removed from API
     */
    @Deprecated
    public List<ResponseModel> getNumberOfInnovativeEnterprises() {
        return getNumberOfInnovativeEnterprises(null, null, null, null);
    }

    /**
     * <p>Fetch all number of innovative enterprises data which match the input
     * constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param sizeClasses
     *            the size classes
     * @param typesOfValues
     *            the types of values
     * @param periods
     *            the periods
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     * @deprecated table removed from API
     */
    @Deprecated
    public List<ResponseModel> getNumberOfInnovativeEnterprises(Collection<String> industrialClassifications,
            Collection<String> sizeClasses, Collection<String> typesOfValues, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(SIZECLASSES_CODE, sizeClasses);
        mappings.put(TYPESOFVALUES_CODE, typesOfValues);
        mappings.put(APIConstants.TIME_CODE, periods);

        return getResponseModels("ACISAntalSNIStrl", mappings);
    }

    /**
     * <p>Fetch all enterprises with product innovations data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnterprisesWithProductInnovations(Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getEnterprisesWithProductInnovations() {
        return getEnterprisesWithProductInnovations(null, null, null, null);
    }

    /**
     * <p>Fetch all enterprises with product innovations data which match the input
     * constraints.</p>
     *
     * @param sni2007s
     *            the SNI 2007s
     * @param sizeClasses
     *            the size classes
     * @param typesOfValues
     *            the types of values
     * @param periods
     *            the periods
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnterprisesWithProductInnovations(Collection<String> sni2007s,
            Collection<String> sizeClasses, Collection<String> typesOfValues, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, sni2007s);
        mappings.put(SIZECLASSES_CODE, sizeClasses);
        mappings.put(TYPESOFVALUES_CODE, typesOfValues);
        mappings.put(APIConstants.TIME_CODE, periods);

        return getResponseModels("NCISprodSNIStrl", mappings);
    }

    /**
     * <p>Fetch all platforms to acquire knowledge data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPlatformsToAcquireKnowledge(Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getPlatformsToAcquireKnowledge() {
        return getPlatformsToAcquireKnowledge(null, null, null, null);
    }

    /**
     * <p>Fetch all platforms to acquire knowledge data which match the input
     * constraints.</p>
     *
     * @param sni2007s
     *            the SNI 2007s
     * @param sizeClasses
     *            the size classes
     * @param typesOfValues
     *            the types of values
     * @param periods
     *            the periods
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPlatformsToAcquireKnowledge(Collection<String> sni2007s,
            Collection<String> sizeClasses, Collection<String> typesOfValues, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, sni2007s);
        mappings.put(SIZECLASSES_CODE, sizeClasses);
        mappings.put(TYPESOFVALUES_CODE, typesOfValues);
        mappings.put(APIConstants.TIME_CODE, periods);

        return getResponseModels("CKnoSNIStrl", mappings);
    }

    /**
     * <p>Fetch all obstacles to innovation data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getObstaclesToInnovation(Collection, Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getObstaclesToInnovation() {
        return getObstaclesToInnovation(null, null, null, null, null);
    }

    /**
     * <p>Fetch all obstacles to innovation data which match the input constraints.</p>
     *
     * @param degreesOfSignificances
     *            the degrees of significances
     * @param sni2007s
     *            the SNI 2007s
     * @param sizeClasses
     *            the size classes
     * @param typesOfValues
     *            the types of values
     * @param periods
     *            the periods
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getObstaclesToInnovation(Collection<Integer> degreesOfSignificances,
            Collection<String> sni2007s, Collection<String> sizeClasses, Collection<String> typesOfValues,
            Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Betydelse", degreesOfSignificances);
        mappings.put(APIConstants.SNI2007_CODE, sni2007s);
        mappings.put(SIZECLASSES_CODE, sizeClasses);
        mappings.put(TYPESOFVALUES_CODE, typesOfValues);
        mappings.put(APIConstants.TIME_CODE, periods);

        return getResponseModels("UF0315T20N", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("UF/UF0315/UF0315A/");
    }

}
