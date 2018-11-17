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

package com.github.dannil.scbjavaclient.client.livingconditions.surveys.employment;

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
 * <p>Client which handles living conditions surveys employment data fetching.</p>
 *
 * @since 0.2.0
 */
public class LivingConditionsSurveysEmploymentClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public LivingConditionsSurveysEmploymentClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LivingConditionsSurveysEmploymentClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all main activity data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getMainActivity(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getMainActivity() {
        return getMainActivity(null, null, null, null);
    }

    /**
     * <p>Fetch all main activity data which match the input constraints.</p>
     *
     * @param activities
     *            the activities
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param periods
     *            the periods
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getMainActivity(Collection<String> activities, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("HuvSyss", activities);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, periods);

        return getResponseModels("LE01012013S01", mappings);
    }

    /**
     * <p>Fetch all gainfully employed persons data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getGainfullyEmployedPersons() {
        return getGainfullyEmployedPersons(null, null, null, null);
    }

    /**
     * <p>Fetch all gainfully employed persons data which match the input constraints.</p>
     *
     * @param fullAndPartTimes
     *            the full and part times
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param periods
     *            the periods
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getGainfullyEmployedPersons(Collection<String> fullAndPartTimes, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Heltiddeltid", fullAndPartTimes);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, periods);

        return getResponseModels("LE01012013S07", mappings);
    }

    /**
     * <p>Fetch all type of employment data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTypeOfEmployment() {
        return getTypeOfEmployment(null, null, null, null);
    }

    /**
     * <p>Fetch all type of employment data which match the input constraints.</p>
     *
     * @param types
     *            the types
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param periods
     *            the periods
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getTypeOfEmployment(Collection<String> types, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("AnstTyp", types);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, periods);

        return getResponseModels("LE01012013S19", mappings);
    }

    /**
     * <p>Fetch all distribution of working hours for employees data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getDistributionOfWorkingHoursForEmployees() {
        return getDistributionOfWorkingHoursForEmployees(null, null, null, null);
    }

    /**
     * <p>Fetch all distribution of working hours for employees data which match the input
     * constraints.</p>
     *
     * @param indicators
     *            the indicators
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param periods
     *            the periods
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getDistributionOfWorkingHoursForEmployees(Collection<String> indicators,
            Collection<String> ages, Collection<Integer> sexes, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Indikator", indicators);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, periods);

        return getResponseModels("LE01012013A19", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("LE/LE0101/LE0101S/");
    }

}
