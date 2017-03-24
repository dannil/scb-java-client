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
import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractClient;

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
    
    public List<?> getMainActivity() {
        LE01012013S01
    }
    
    public List<?> getMainActivity(Collection<String> activities, Collection<String> ages, Collection<Integer> sexes, Collection<String> periods) {
        LE01012013S01
    }
    
    public List<?> getGainfullyEmployedPersons() {
        LE01012013S07
    }
    
    public List<?> getGainfullyEmployedPersons(Collection<String> fullAndPartTimes, Collection<String> ages, Collection<Integer> sexes, Collection<String> periods) {
        LE01012013S07
    }
    
    public List<?> getTypeOfEmployment() {
        LE01012013S19
    }
    
    public List<?> getTypeOfEmployment(Collection<String> types, Collection<String> ages, Collection<Integer> sexes, Collection<String> periods) {
        LE01012013S19
    }
    
    public List<?> getDistributionOfWorkingHoursForEmployees() {
        LE01012013A19
    }
    
    public List<?> getDistributionOfWorkingHoursForEmployees(Collection<String> indicators, Collection<String> ages, Collection<Integer> sexes, Collection<String> periods) {
        LE01012013A19
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "LE/LE0101/LE0101S/";
    }

}
