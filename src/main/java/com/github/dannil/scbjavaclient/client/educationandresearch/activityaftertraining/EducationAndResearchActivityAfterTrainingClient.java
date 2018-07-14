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
 * <p>Client which handles education and research activity after training data
 * fetching.</p>
 *
 * @since 0.5.0
 */
public class EducationAndResearchActivityAfterTrainingClient extends AbstractClient {

    private static final String ACTIVITY_CODE = "VerksEftUtbGGHS";

    private static final String YEARSAFTERCOMPLETEDEDUCATION_CODE = "ArEfterAvgangsar";

    /**
     * <p>Default constructor.</p>
     */
    public EducationAndResearchActivityAfterTrainingClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EducationAndResearchActivityAfterTrainingClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all persons' activities 1-3 years after completing higher education
     * data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPersonsActivitiesAfterCompletingHigherEducation(Collection, Collection,
     *      Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getPersonsActivitiesAfterCompletingHigherEducation() {
        return getPersonsActivitiesAfterCompletingHigherEducation(null, null, null, null, null, null);
    }

    /**
     * <p>Fetch all persons' activities 1-3 years after completing higher education data
     * which match the input constraints.</p>
     *
     * @param yearsAfterCompletedEducation
     *            the years after completed education
     * @param levelsOfAcademicDegrees
     *            the levels of academic degrees
     * @param activities
     *            the activities
     * @param sexes
     *            the sexes
     * @param agesAtExam
     *            the ages at exam
     * @param yearsOfExam
     *            the years of exam
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPersonsActivitiesAfterCompletingHigherEducation(
            Collection<Integer> yearsAfterCompletedEducation, Collection<Integer> levelsOfAcademicDegrees,
            Collection<Integer> activities, Collection<Integer> sexes, Collection<String> agesAtExam,
            Collection<String> yearsOfExam) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(YEARSAFTERCOMPLETEDEDUCATION_CODE, yearsAfterCompletedEducation);
        mappings.put("Examensniva", levelsOfAcademicDegrees);
        mappings.put(ACTIVITY_CODE, activities);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put("AldEx", agesAtExam);
        mappings.put(APIConstants.TIME_CODE, yearsOfExam);

        return getResponseModels("UF0503T01UH", mappings);
    }

    /**
     * <p>Fetch all persons' activities 1-3 years after completing compulsory school
     * data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPersonsActivitiesAfterCompletingCompulsorySchool(Collection, Collection,
     *      Collection, Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getPersonsActivitiesAfterCompletingCompulsorySchool() {
        return getPersonsActivitiesAfterCompletingCompulsorySchool(null, null, null, null, null, null, null);
    }

    /**
     * <p>Fetch all persons' activities 1-3 years after completing compulsory school data
     * which match the input constraints.</p>
     *
     * @param yearsAfterCompletedEducation
     *            the years after completed education
     * @param levelsOfEducations
     *            the levels of educations
     * @param activities
     *            the activities
     * @param sexes
     *            the sexes
     * @param counties
     *            the counties
     * @param municipalityGroups
     *            the municipality groups
     * @param yearsOfExam
     *            the years of exam
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPersonsActivitiesAfterCompletingCompulsorySchool(
            Collection<Integer> yearsAfterCompletedEducation, Collection<Integer> levelsOfEducations,
            Collection<Integer> activities, Collection<Integer> sexes, Collection<String> counties,
            Collection<Integer> municipalityGroups, Collection<String> yearsOfExam) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(YEARSAFTERCOMPLETEDEDUCATION_CODE, yearsAfterCompletedEducation);
        mappings.put("UtbildningsNiva", levelsOfEducations);
        mappings.put(ACTIVITY_CODE, activities);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put("Lan", counties);
        mappings.put("Kommunskl", municipalityGroups);
        mappings.put(APIConstants.TIME_CODE, yearsOfExam);

        return getResponseModels("UF0503T02GG", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("UF/UF0503/");
    }

}
