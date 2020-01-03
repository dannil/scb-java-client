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
 * <p>Client which handles education and research community innovation survey co-operation
 * activity among enterprises data fetching.</p>
 *
 * @since 0.5.0
 */
public class EducationAndResearchCommunityInnovationSurveyCooperationClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EducationAndResearchCommunityInnovationSurveyCooperationClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EducationAndResearchCommunityInnovationSurveyCooperationClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all enterprises innovation cooperation in private sector data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnterprisesInnovationCooperationInPrivateSector(Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getEnterprisesInnovationCooperationInPrivateSector() {
        return getEnterprisesInnovationCooperationInPrivateSector(null, null, null, null);
    }

    /**
     * <p>Fetch all enterprises innovation cooperation in private sector data which match
     * the input constraints.</p>
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
    public List<ResponseModel> getEnterprisesInnovationCooperationInPrivateSector(Collection<String> sni2007s,
            Collection<String> sizeClasses, Collection<String> typesOfValues, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, sni2007s);
        mappings.put(APIConstants.SIZECLASS_CODE, sizeClasses);
        mappings.put(APIConstants.TYPEOFVALUE_CODE, typesOfValues);
        mappings.put(APIConstants.TIME_CODE, periods);

        return getResponseModels("CoopPrvSNIStr", mappings);
    }

    /**
     * <p>Fetch all enterprises innovation cooperation in public sector data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnterprisesInnovationCooperationInPublicSector(Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getEnterprisesInnovationCooperationInPublicSector() {
        return getEnterprisesInnovationCooperationInPublicSector(null, null, null, null);
    }

    /**
     * <p>Fetch all enterprises innovation cooperation in public sector data which match
     * the input constraints.</p>
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
    public List<ResponseModel> getEnterprisesInnovationCooperationInPublicSector(Collection<String> sni2007s,
            Collection<String> sizeClasses, Collection<String> typesOfValues, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, sni2007s);
        mappings.put(APIConstants.SIZECLASS_CODE, sizeClasses);
        mappings.put(APIConstants.TYPEOFVALUE_CODE, typesOfValues);
        mappings.put(APIConstants.TIME_CODE, periods);

        return getResponseModels("CoopPublSNIStr", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("UF/UF0315/UF0315C/");
    }

}
