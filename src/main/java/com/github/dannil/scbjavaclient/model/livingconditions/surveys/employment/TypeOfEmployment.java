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
 * <p>Model for type of employment data.</p>
 *
 * @since 0.2.1
 */
public class TypeOfEmployment extends AbstractEmployment {

    @JsonProperty("AnstTyp")
    private String type;

    /**
     * <p>Default constructor.</p>
     */
    public TypeOfEmployment() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param type
     *            the type
     * @param age
     *            the age
     * @param sex
     *            the sex
     * @param period
     *            the period
     * @param values
     *            the values
     */
    public TypeOfEmployment(String type, String age, Integer sex, String period, List<ValueNode<Double>> values) {
        super(age, sex, period, values);
        this.type = type;
    }

    /**
     * <p>Getter for type.</p>
     *
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * <p>Setter for type.</p>
     *
     * @param type
     *            the type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TypeOfEmployment)) {
            return false;
        }
        TypeOfEmployment other = (TypeOfEmployment) obj;
        return super.equals(obj) && Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("type", this.type);
        return super.buildToString(variables);
    }

    /**
     * <p>Get the available codes and their respective values for the type of employment
     * data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("LE/LE0101/LE0101S/LE01012013S19");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
