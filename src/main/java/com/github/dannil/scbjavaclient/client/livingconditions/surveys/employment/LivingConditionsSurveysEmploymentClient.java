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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.DistributionOfWorkingHours;
import com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.GainfullyEmployedPersons;
import com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.MainActivity;
import com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.TypeOfEmployment;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

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
     * @return the main activity data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.MainActivity
     *         MainActivity} objects
     *
     * @see #getMainActivity(Collection, Collection, Collection, Collection)
     */
    public List<MainActivity> getMainActivity() {
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
     * @return the main activity data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.MainActivity
     *         MainActivity} objects
     */
    public List<MainActivity> getMainActivity(Collection<String> activities, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("LE0101XF", "LE0101XG", "LE0101XH", "LE0101XI"));
        mappings.put("HuvSyss", activities);
        mappings.put("Kon", sexes);
        mappings.put(APIConstants.TIME_CODE, periods);

        String response = doPostRequest(getUrl() + "LE01012013S01", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(MainActivity.class);
    }

    /**
     * <p>Fetch all gainfully employed persons data.</p>
     *
     * @return the gainfully employed persons wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.GainfullyEmployedPersons
     *         GainfullyEmployedPersons} objects
     */
    public List<GainfullyEmployedPersons> getGainfullyEmployedPersons() {
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
     * @return the gainfully employed persons data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.GainfullyEmployedPersons
     *         GainfullyEmployedPersons} objects
     */
    public List<GainfullyEmployedPersons> getGainfullyEmployedPersons(Collection<String> fullAndPartTimes,
            Collection<String> ages, Collection<Integer> sexes, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("LE0101XL", "LE0101XM", "LE0101XP", "LE0101XQ"));
        mappings.put("Heltiddeltid", fullAndPartTimes);
        mappings.put("Kon", sexes);
        mappings.put(APIConstants.TIME_CODE, periods);

        String response = doPostRequest(getUrl() + "LE01012013S07", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(GainfullyEmployedPersons.class);
    }

    /**
     * <p>Fetch all type of employment data.</p>
     *
     * @return the type of employment data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.TypeOfEmployment
     *         TypeOfEmployment} objects
     */
    public List<TypeOfEmployment> getTypeOfEmployment() {
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
     * @return the type of employment data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.TypeOfEmployment
     *         TypeOfEmployment} objects
     */
    public List<TypeOfEmployment> getTypeOfEmployment(Collection<String> types, Collection<String> ages,
            Collection<Integer> sexes, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("LE0101YB", "LE0101YC", "LE0101YD", "LE0101YE"));
        mappings.put("AnstTyp", types);
        mappings.put("Kon", sexes);
        mappings.put(APIConstants.TIME_CODE, periods);

        String response = doPostRequest(getUrl() + "LE01012013S19", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(TypeOfEmployment.class);
    }

    /**
     * <p>Fetch all distribution of working hours for employees data.</p>
     *
     * @return the type of employment data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.DistributionOfWorkingHours
     *         DistributionOfWorkingHours} objects
     */
    public List<DistributionOfWorkingHours> getDistributionOfWorkingHoursForEmployees() {
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
     * @return the type of employment data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment.DistributionOfWorkingHours
     *         DistributionOfWorkingHours} objects
     */
    public List<DistributionOfWorkingHours> getDistributionOfWorkingHoursForEmployees(Collection<String> indicators,
            Collection<String> ages, Collection<Integer> sexes, Collection<String> periods) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("LE0101YN", "LE0101YO", "LE0101YP", "LE0101YQ"));
        mappings.put("Indikator", indicators);
        mappings.put("Kon", sexes);
        mappings.put(APIConstants.TIME_CODE, periods);

        String response = doPostRequest(getUrl() + "LE01012013A19", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(DistributionOfWorkingHours.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "LE/LE0101/LE0101S/";
    }

}
