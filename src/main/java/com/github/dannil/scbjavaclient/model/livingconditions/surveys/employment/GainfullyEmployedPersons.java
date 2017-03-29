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

package com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for gainfully employed persons data.</p>
 *
 * @since 0.3.0
 */
public class GainfullyEmployedPersons extends AbstractEmployment {

    @JsonProperty("Heltiddeltid")
    private String fullAndPartTime;

    /**
     * <p>Default constructor.</p>
     */
    public GainfullyEmployedPersons() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param fullAndPartTime
     *            the full and part time
     * @param age
     *            the age
     * @param sex
     *            the sex
     * @param period
     *            the period
     * @param values
     *            the values
     */
    public GainfullyEmployedPersons(String fullAndPartTime, String age, Integer sex, String period,
            List<ValueNode<Double>> values) {
        super(age, sex, period, values);
        this.fullAndPartTime = fullAndPartTime;
    }

    /**
     * <p>Getter for full and part time.</p>
     *
     * @return the full and part time
     */
    public String getFullAndPartTime() {
        return this.fullAndPartTime;
    }

    /**
     * <p>Setter for full and part time.</p>
     *
     * @param fullAndPartTime
     *            the full and part time
     */
    public void setFullAndPartTime(String fullAndPartTime) {
        this.fullAndPartTime = fullAndPartTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.fullAndPartTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof GainfullyEmployedPersons)) {
            return false;
        }
        GainfullyEmployedPersons other = (GainfullyEmployedPersons) obj;
        return super.equals(obj) && Objects.equals(this.fullAndPartTime, other.fullAndPartTime);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("fullAndPartTime", this.fullAndPartTime);
        return super.buildToString(variables);
    }

    /**
     * <p>Get the available codes and their respective values for the gainfully employed
     * persons data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("LE/LE0101/LE0101S/LE01012013S07");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
