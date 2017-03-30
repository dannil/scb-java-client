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
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.BodyMassIndex;
import com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.Disabilities;
import com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.DoctorAndDentistAppointments;
import com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.LongTermIllness;
import com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.PhysicalAndMentalHealth;
import com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.TobaccoHabits;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles living conditions surveys health data fetching.</p>
 *
 * @since 0.2.0
 */
public class LivingConditionsSurveysHealthClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public LivingConditionsSurveysHealthClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LivingConditionsSurveysHealthClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all physical and mental health data.</p>
     *
     * @return the physical and mental health data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.PhysicalAndMentalHealth
     *         PhysicalAndMentalHealth} objects
     *
     * @see #getPhysicalAndMentalHealth(Collection, Collection, Collection, Collection)
     */
    public List<PhysicalAndMentalHealth> getPhysicalAndMentalHealth() {
        return getPhysicalAndMentalHealth(null, null, null, null);
    }

    /**
     * <p>Fetch all physical and mental health data which match the input constraints.</p>
     *
     * @param indicators
     *            the indicators
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param periods
     *            the periods
     * @return the physical and mental health data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.PhysicalAndMentalHealth
     *         PhysicalAndMentalHealth} objects
     */
    public List<PhysicalAndMentalHealth> getPhysicalAndMentalHealth(Collection<String> indicators,
            Collection<String> ages, Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101H01", PhysicalAndMentalHealth.class);
    }

    /**
     * <p>Fetch all long term illness data.</p>
     *
     * @return the long term illness data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.LongTermIllness
     *         LongTermIllness} objects
     *
     * @see #getLongTermIllness(Collection, Collection, Collection, Collection)
     */
    public List<LongTermIllness> getLongTermIllness() {
        return getLongTermIllness(null, null, null, null);
    }

    /**
     * <p>Fetch all long term illness data which match the input constraints.</p>
     *
     * @param indicators
     *            the indicators
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param periods
     *            the periods
     * @return the long term illness data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.LongTermIllness
     *         LongTermIllness} objects
     */
    public List<LongTermIllness> getLongTermIllness(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101H07", LongTermIllness.class);
    }

    /**
     * <p>Fetch all disabilities data.</p>
     *
     * @return the disabilities data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.Disabilities
     *         Disabilities} objects
     *
     * @see #getDisabilities(Collection, Collection, Collection, Collection)
     */
    public List<Disabilities> getDisabilities() {
        return getDisabilities(null, null, null, null);
    }

    /**
     * <p>Fetch all disabilities data which match the input constraints.</p>
     *
     * @param indicators
     *            the indicators
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param periods
     *            the periods
     * @return the disabilities data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.Disabilities
     *         Disabilities} objects
     */
    public List<Disabilities> getDisabilities(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101H13", Disabilities.class);
    }

    /**
     * <p>Fetch all doctor and dentist appointments data.</p>
     *
     * @return the doctor and dentist appointments data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.DoctorAndDentistAppointments
     *         DoctorAndDentistAppointments} objects
     *
     * @see #getDoctorAndDentistAppointments(Collection, Collection, Collection,
     *      Collection)
     */
    public List<DoctorAndDentistAppointments> getDoctorAndDentistAppointments() {
        return getDoctorAndDentistAppointments(null, null, null, null);
    }

    /**
     * <p>Fetch all doctor and dentist appointments data which match the input
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
     * @return the doctor and dentist appointments data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.DoctorAndDentistAppointments
     *         DoctorAndDentistAppointments} objects
     */
    public List<DoctorAndDentistAppointments> getDoctorAndDentistAppointments(Collection<String> indicators,
            Collection<String> ages, Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101H19", DoctorAndDentistAppointments.class);
    }

    /**
     * <p>Fetch all tobacco habits data.</p>
     *
     * @return the tobacco habits data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.TobaccoHabits
     *         TobaccoHabits} objects
     *
     * @see #getTobaccoHabits(Collection, Collection, Collection, Collection)
     */
    public List<TobaccoHabits> getTobaccoHabits() {
        return getTobaccoHabits(null, null, null, null);
    }

    /**
     * <p>Fetch all tobacco habits data which match the input constraints.</p>
     *
     * @param indicators
     *            the indicators
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param periods
     *            the periods
     * @return the tobacco habits data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.TobaccoHabits
     *         TobaccoHabits} objects
     */
    public List<TobaccoHabits> getTobaccoHabits(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101H25", TobaccoHabits.class);
    }

    /**
     * <p>Fetch all body mass index data.</p>
     *
     * @return the body mass index data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.BodyMassIndex
     *         BodyMassIndex} objects
     *
     * @see #getBodyMassIndex(Collection, Collection, Collection, Collection)
     */
    public List<BodyMassIndex> getBodyMassIndex() {
        return getBodyMassIndex(null, null, null, null);
    }

    /**
     * <p>Fetch all body mass index data which match the input constraints.</p>
     *
     * @param indicators
     *            the indicators
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param periods
     *            the periods
     * @return the body mass index data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.health.BodyMassIndex
     *         BodyMassIndex} objects
     */
    public List<BodyMassIndex> getBodyMassIndex(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(indicators, ages, sexes, periods, "LE0101BMI01", BodyMassIndex.class);
    }

    /**
     * <p>Common generator method for the methods in this class.</p>
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
     * @param clazz
     *            the class to convert the generated data to
     * @param <T>
     *            the data type of the list
     * @return a <code>List</code> of the specified class
     */
    private <T> List<T> generate(Collection<String> indicators, Collection<String> ages, Collection<Integer> sexes,
            Collection<String> periods, String table, Class<T> clazz) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Indikator", indicators);
        mappings.put("Alder", ages);
        mappings.put("Kon", sexes);
        mappings.put(APIConstants.TIME_CODE, periods);

        String response = doPostRequest(getUrl() + table, QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(clazz);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("LE/LE0101/LE0101H/");
    }

}
