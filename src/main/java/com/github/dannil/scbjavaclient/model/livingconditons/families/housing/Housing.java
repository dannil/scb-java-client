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

package com.github.dannil.scbjavaclient.model.livingconditons.families.housing;

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
 * <p>Model for housing data.</p>
 *
 * @since 0.2.0
 */
public class Housing extends AbstractTimeAndValueModel<Integer, String> {

    @JsonProperty("Kon")
    private String sex;

    @JsonProperty("Alder")
    private String age;

    @JsonProperty("Boendeform")
    private String housingType;

    @JsonProperty("Familjetyp")
    private String familyType;

    @JsonProperty("UtlBakgrund")
    private String background;

    @JsonProperty("Foraldrarinkniv")
    private Integer parentIncome;

    /**
     * <p>Default constructor.</p>
     */
    public Housing() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param sex
     *            the sex
     * @param age
     *            the age
     * @param housingType
     *            the housing type
     * @param familyType
     *            the family type
     * @param background
     *            the background
     * @param parentIncome
     *            the parent income
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public Housing(String sex, String age, String housingType, String familyType, String background,
            Integer parentIncome, Integer year, List<ValueNode<String>> values) {
        super(year, values);
        this.sex = sex;
        this.age = age;
        this.housingType = housingType;
        this.familyType = familyType;
        this.background = background;
        this.parentIncome = parentIncome;
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
     * <p>Getter for housing type.</p>
     *
     * @return the housing type
     */
    public String getHousingType() {
        return this.housingType;
    }

    /**
     * <p>Setter for housing type.</p>
     *
     * @param housingType
     *            the housing type
     */
    public void setHousingType(String housingType) {
        this.housingType = housingType;
    }

    /**
     * <p>Getter for family type.</p>
     *
     * @return the family type
     */
    public String getFamilyType() {
        return familyType;
    }

    /**
     * <p>Setter for family type.</p>
     *
     * @param familyType
     *            the family type
     */
    public void setFamilyType(String familyType) {
        this.familyType = familyType;
    }

    /**
     * <p>Getter for background.</p>
     *
     * @return the background
     */
    public String getBackground() {
        return this.background;
    }

    /**
     * <p>Setter for background.</p>
     *
     * @param background
     *            the background
     */
    public void setBackground(String background) {
        this.background = background;
    }

    /**
     * <p>Getter for parent income.</p>
     *
     * @return the parent income
     */
    public Integer getParentIncome() {
        return this.parentIncome;
    }

    /**
     * <p>Setter for parent income.</p>
     *
     * @param parentIncome
     *            the parent income
     */
    public void setParentIncome(Integer parentIncome) {
        this.parentIncome = parentIncome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.sex, this.age, this.housingType, this.familyType, this.background,
                this.parentIncome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Housing)) {
            return false;
        }

        Housing other = (Housing) obj;
        return super.equals(obj) && Objects.equals(this.sex, other.sex) && Objects.equals(this.age, other.age)
                && Objects.equals(this.housingType, other.housingType)
                && Objects.equals(this.familyType, other.familyType)
                && Objects.equals(this.background, other.background)
                && Objects.equals(this.parentIncome, other.parentIncome);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [sex=");
        builder.append(this.sex);
        builder.append(" [age=");
        builder.append(this.age);
        builder.append(" [housingType=");
        builder.append(this.housingType);
        builder.append(" [familyType=");
        builder.append(this.familyType);
        builder.append(" [background=");
        builder.append(this.background);
        builder.append(" [parentIncome=");
        builder.append(this.parentIncome);
        builder.append(", time=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the housing data from
     * the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("LE/LE0102/LE0102M/LE0102T34");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
