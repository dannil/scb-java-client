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
 * <p>Client which handles education and research folk high school statistics data
 * fetching.</p>
 *
 * @since 2.2.0
 */
public class EducationAndResearchFolkHighSchoolStatisticsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EducationAndResearchFolkHighSchoolStatisticsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EducationAndResearchFolkHighSchoolStatisticsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all participants in long folk high school courses data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getParticipants(Collection, Collection, Collection, Collection)
     *
     * @deprecated use {@link #getParticipantsInCourses()
     *             EducationAndResearchFolkHighSchoolStatisticsClient#getParticipantsInCourses()}
     *             instead.
     */
    @Deprecated
    public List<ResponseModel> getParticipants() {
        return getParticipants(null, null, null, null);
    }

    /**
     * <p>Fetch all participants in long folk high school courses data which match the
     * input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param sexes
     *            the sexes
     * @param typesOfCourses
     *            the types of courses
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @deprecated use
     *             {@link #getParticipantsInCourses(Collection, Collection, Collection, Collection, Collection, Collection)
     *             EducationAndResearchFolkHighSchoolStatisticsClient#getParticipantsInCourses(Collection,
     *             Collection, Collection, Collection, Collection, Collection)} instead.
     */
    @Deprecated
    public List<ResponseModel> getParticipants(Collection<String> regions, Collection<String> sexes,
            Collection<String> typesOfCourses, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put("KursTyp", typesOfCourses);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("UF0510Tab1", mappings);
    }

    /**
     * <p>Fetch all participants in folk high school courses data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getParticipantsInCourses(Collection, Collection, Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getParticipantsInCourses() {
        return getParticipantsInCourses(null, null, null, null, null, null);
    }

    /**
     * <p>Fetch all participants in folk high school courses data which match the input
     * constraints.</p>
     *
     * @param sexes
     *            the sexes to fetch data for
     * @param typesOfCourses
     *            the types of courses to fetch data for
     * @param nationalBackgrounds
     *            the national backgrounds to fetch data for
     * @param regionOfEducations
     *            the region of educations to fetch data for
     * @param ageGroups
     *            the age groups to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getParticipantsInCourses(Collection<String> sexes, Collection<String> typesOfCourses,
            Collection<String> nationalBackgrounds, Collection<String> regionOfEducations, Collection<String> ageGroups,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put("KursTyp", typesOfCourses);
        mappings.put("NationellBakgrund", nationalBackgrounds);
        mappings.put("RegionUtb", regionOfEducations);
        mappings.put("Aldersgrupp", ageGroups);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("UF0601T01b", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("UF/UF0601/");
    }

}
