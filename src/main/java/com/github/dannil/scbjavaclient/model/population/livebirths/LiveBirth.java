/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.model.population.livebirths;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.AbstractRegionTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for live births data.</p>
 *
 * @since 0.1.0
 */
public class LiveBirth extends AbstractRegionTimeAndValueModel<String, Integer, Long> {

    @JsonProperty("AlderModer")
    private String motherAge;

    @JsonProperty("Kon")
    private Integer gender;

    /**
     * <p>Default constructor.</p>
     */
    public LiveBirth() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param region
     *            the region
     * @param motherAge
     *            the mother's age
     * @param gender
     *            the gender
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public LiveBirth(String region, String motherAge, Integer gender, Integer year, List<ValueNode<Long>> values) {
        super(region, year, values);
        this.motherAge = motherAge;
        this.gender = gender;
    }

    /**
     * <p>Getter for mother's age.</p>
     *
     * @return the mother's age.
     */
    public String getMotherAge() {
        return this.motherAge;
    }

    /**
     * <p>Setter for mother's age.</p>
     *
     * @param motherAge
     *            the mother's age
     */
    public void setMotherAge(String motherAge) {
        this.motherAge = motherAge;
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
        return Objects.hash(super.hashCode(), this.motherAge, this.gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LiveBirth)) {
            return false;
        }

        LiveBirth other = (LiveBirth) obj;
        return super.equals(other) && Objects.equals(this.motherAge, other.motherAge)
                && Objects.equals(this.gender, other.gender);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [motherAge=");
        builder.append(this.motherAge);
        builder.append(", gender=");
        builder.append(this.gender);
        builder.append(", region=");
        builder.append(getRegion());
        builder.append(", year=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the live birth data from
     * the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("BE/BE0101/BE0101H/FoddaK");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
