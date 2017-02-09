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
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.model.AbstractRegionYearAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.utility.requester.GETRequester;

/**
 * <p>Model for population data.</p>
 *
 * @since 0.1.0
 */
public class Population extends AbstractRegionYearAndValueModel<String, Integer, String> {

    @JsonProperty("civilstand")
    private String relationshipStatus;

    @JsonProperty("alder")
    private String age;

    @JsonProperty("kon")
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
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [relationshipStatus=");
        builder.append(this.relationshipStatus);
        builder.append(", age=");
        builder.append(this.age);
        builder.append(", gender=");
        builder.append(this.gender);
        builder.append(", region=");
        builder.append(super.getRegion());
        builder.append(", year=");
        builder.append(super.getYear());
        builder.append(", values=");
        builder.append(super.getValues());
        builder.append(']');

        return builder.toString();
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
