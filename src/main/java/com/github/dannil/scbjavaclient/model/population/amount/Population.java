/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.model.population.amount;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.AbstractRegionTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for population data.</p>
 *
 * @since 0.1.0
 */
public class Population extends AbstractRegionTimeAndValueModel<String, Integer, String> {

    @JsonProperty("Civilstand")
    private String relationshipStatus;

    @JsonProperty("Alder")
    private String age;

    @JsonProperty("Kon")
    private Integer gender;

    /**
     * <p>Default constructor.</p>
     */
    public Population() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param region
     *            the region
     * @param relationshipStatus
     *            the relationship status
     * @param age
     *            the age
     * @param gender
     *            the gender
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public Population(String region, String relationshipStatus, String age, Integer gender, Integer year,
            List<ValueNode<String>> values) {
        super(region, year, values);
        this.relationshipStatus = relationshipStatus;
        this.age = age;
        this.gender = gender;
    }

    /**
     * <p>Getter for relationship status.</p>
     *
     * @return the relationship status
     */
    public String getRelationshipStatus() {
        return this.relationshipStatus;
    }

    /**
     * <p>Setter for relationship status.</p>
     *
     * @param relationshipStatus
     *            the relationship status
     */
    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    /**
     * <p>Getter for age.</p>
     *
     * @return the age
     */
    public String getAge() {
        return this.age;
    }

    /**
     * <p>Setter for age.</p>
     *
     * @param age
     *            the age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * <p>Getter for gender.</p>
     *
     * @return the gender
     */
    public Integer getGender() {
        return this.gender;
    }

    /**
     * <p>Setter for gender.</p>
     *
     * @param gender
     *            the gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.relationshipStatus, this.age, this.gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Population)) {
            return false;
        }

        Population other = (Population) obj;
        return super.equals(other) && Objects.equals(this.relationshipStatus, other.relationshipStatus)
                && Objects.equals(this.age, other.age) && Objects.equals(this.gender, other.gender);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("relationshipStatus", this.relationshipStatus);
        variables.put("age", this.age);
        variables.put("gender", this.gender);
        return super.buildToString(variables);
    }

    /**
     * <p>Get the available codes and their respective values for the population data from
     * the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("BE/BE0101/BE0101A/BefolkningNy");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
