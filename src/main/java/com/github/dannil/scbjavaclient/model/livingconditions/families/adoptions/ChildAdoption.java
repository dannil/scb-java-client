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

package com.github.dannil.scbjavaclient.model.livingconditions.families.adoptions;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.AbstractTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for siblings data.</p>
 *
 * @since 0.2.0
 */
public class ChildAdoption extends AbstractTimeAndValueModel<Integer, Integer> {

    @JsonProperty("Kon")
    private String sex;

    @JsonProperty("Alder")
    private String age;

    @JsonProperty("Fodelseland")
    private String birthCountry;

    /**
     * <p>Default constructor.</p>
     */
    public ChildAdoption() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param sex
     *            the sex
     * @param age
     *            the age
     * @param birthCountry
     *            the birth country
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public ChildAdoption(String sex, String age, String birthCountry, Integer year, List<ValueNode<Integer>> values) {
        super(year, values);
        this.sex = sex;
        this.age = age;
        this.birthCountry = birthCountry;
    }

    /**
     * <p>Getter for sex.</p>
     *
     * @return the sex
     */
    public String getSex() {
        return this.sex;
    }

    /**
     * <p>Setter for sex.</p>
     *
     * @param sex
     *            the sex
     */
    public void setSex(String sex) {
        this.sex = sex;
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
     * <p>Getter for birth country.</p>
     *
     * @return the birth country
     */
    public String getBirthCountry() {
        return this.birthCountry;
    }

    /**
     * <p>Setter for birth country.</p>
     *
     * @param birthCountry
     *            the birth country
     */
    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.sex, this.age, this.birthCountry);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ChildAdoption)) {
            return false;
        }

        ChildAdoption other = (ChildAdoption) obj;
        return super.equals(obj) && Objects.equals(this.sex, other.sex) && Objects.equals(this.age, other.age)
                && Objects.equals(this.birthCountry, other.birthCountry);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [sex=");
        builder.append(this.sex);
        builder.append(" [age=");
        builder.append(this.age);
        builder.append(" [birthCountry=");
        builder.append(this.birthCountry);
        builder.append(", time=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the child adoption data
     * from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("LE/LE0102/LE0102I/BarnAdoption");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
