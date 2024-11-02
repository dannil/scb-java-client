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

package com.github.dannil.scbjavaclient.client.livingconditions.surveys.health;

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
 * Client which handles living conditions surveys health data fetching.
 *
 * @since 0.2.0
 */
public class LivingConditionsSurveysHealthClient extends AbstractClient {

    /**
     * Default constructor.
     */
    public LivingConditionsSurveysHealthClient() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LivingConditionsSurveysHealthClient(Locale locale) {
        super(locale);
    }

    /**
     * Fetch all physical and mental health data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPhysicalAndMentalHealth(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getPhysicalAndMentalHealth() {
        return getPhysicalAndMentalHealth(null, null, null, null);
    }

    /**
     * Fetch all physical and mental health data which match the input constraints.
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
    public List<ResponseModel> getPhysicalAndMentalHealth(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101H01");
    }

    /**
     * Fetch all long term illness data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getLongTermIllness(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getLongTermIllness() {
        return getLongTermIllness(null, null, null, null);
    }

    /**
     * Fetch all long term illness data which match the input constraints.
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
    public List<ResponseModel> getLongTermIllness(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101H07");
    }

    /**
     * Fetch all disabilities data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getDisabilities(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getDisabilities() {
        return getDisabilities(null, null, null, null);
    }

    /**
     * Fetch all disabilities data which match the input constraints.
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
    public List<ResponseModel> getDisabilities(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101H13");
    }

    /**
     * Fetch all doctor and dentist appointments data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getDoctorAndDentistAppointments(Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getDoctorAndDentistAppointments() {
        return getDoctorAndDentistAppointments(null, null, null, null);
    }

    /**
     * Fetch all doctor and dentist appointments data which match the input
     * constraints.
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
    public List<ResponseModel> getDoctorAndDentistAppointments(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101H19");
    }

    /**
     * Fetch all tobacco habits data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getTobaccoHabits(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getTobaccoHabits() {
        return getTobaccoHabits(null, null, null, null);
    }

    /**
     * Fetch all tobacco habits data which match the input constraints.
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
    public List<ResponseModel> getTobaccoHabits(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101H25");
    }

    /**
     * Fetch all body mass index data.
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getBodyMassIndex(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getBodyMassIndex() {
        return getBodyMassIndex(null, null, null, null);
    }

    /**
     * Fetch all body mass index data which match the input constraints.
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
    public List<ResponseModel> getBodyMassIndex(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101BMI01");
    }

    /**
     * Common generator method for the methods in this class.
     *
     * @param indicators
     *            the indicators
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param periods
     *            the periods
     * @param table
     *            the table
     * @return a <code>List</code> of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    private List<ResponseModel> generate(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods, String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Indikator", indicators);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, periods);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("LE/LE0101/LE0101H/");
    }

}
