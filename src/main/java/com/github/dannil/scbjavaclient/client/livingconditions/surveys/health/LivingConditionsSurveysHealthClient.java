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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
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

    public List<PhysicalAndMentalHealth> getPhysicalAndMentalHealth() {
        return getPhysicalAndMentalHealth(null, null, null, null);
    }

    public List<PhysicalAndMentalHealth> getPhysicalAndMentalHealth(Collection<String> indicators,
            Collection<String> ages, Collection<Integer> sexes, Collection<String> periods) {
        return generate(Arrays.asList("LE0101FR", "LE0101FS", "LE0101FT", "LE0101FU"), indicators, ages, sexes, periods,
                "LE0101H01", PhysicalAndMentalHealth.class);
    }

    public List<LongTermIllness> getLongTermIllness() {
        return getLongTermIllness(null, null, null, null);
    }

    public List<LongTermIllness> getLongTermIllness(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(Arrays.asList("LE0101N7", "LE0101N8", "LE0101N9", "LE0101N0"), indicators, ages, sexes, periods,
                "LE0101H07", LongTermIllness.class);
    }

    public List<Disabilities> getDisabilities() {
        return getDisabilities(null, null, null, null);
    }

    public List<Disabilities> getDisabilities(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(Arrays.asList("LE0101OU", "LE0101OV", "LE0101OX", "LE0101OY"), indicators, ages, sexes, periods,
                "LE0101H13", Disabilities.class);
    }

    public List<DoctorAndDentistAppointments> getDoctorAndDentistAppointments() {
        return getDoctorAndDentistAppointments(null, null, null, null);
    }

    public List<DoctorAndDentistAppointments> getDoctorAndDentistAppointments(Collection<String> indicators,
            Collection<String> ages, Collection<Integer> sexes, Collection<String> periods) {
        return generate(Arrays.asList("LE0101PJ", "LE0101PK", "LE0101PL", "LE0101PM"), indicators, ages, sexes, periods,
                "LE0101H19", DoctorAndDentistAppointments.class);
    }

    public List<TobaccoHabits> getTobaccoHabits() {
        return getTobaccoHabits(null, null, null, null);
    }

    public List<TobaccoHabits> getTobaccoHabits(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(Arrays.asList("LE0101P9", "LE0101P0", "LE0101QA", "LE0101QB"), indicators, ages, sexes, periods,
                "LE0101H25", TobaccoHabits.class);
    }

    public List<BodyMassIndex> getBodyMassIndex() {
        return getBodyMassIndex(null, null, null, null);
    }

    public List<BodyMassIndex> getBodyMassIndex(Collection<String> indicators, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        return generate(Arrays.asList("00000032", "00000035", "00000033", "00000034"), indicators, ages, sexes, periods,
                "LE0101BMI01", BodyMassIndex.class);
    }

    /**
     * <p>Common generator method for the methods in this class.</p>
     *
     * @param contentCodes
     *            the content codes
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
    private <T> List<T> generate(Collection<String> contentCodes, Collection<String> indicators,
            Collection<String> ages, Collection<Integer> sexes, Collection<String> periods, String table,
            Class<T> clazz) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, contentCodes);
        mappings.put("Indikator", indicators);
        mappings.put("Alder", ages);
        mappings.put("Kon", sexes);
        mappings.put(APIConstants.TIME_CODE, periods);

        String response = doPostRequest(getUrl() + table, QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(clazz);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "LE/LE0101/LE0101H/";
    }

}
