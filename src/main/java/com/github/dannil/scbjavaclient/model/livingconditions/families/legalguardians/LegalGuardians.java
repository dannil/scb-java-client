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

package com.github.dannil.scbjavaclient.model.livingconditions.families.legalguardians;

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
 * <p>Model for legal guardians data.</p>
 *
 * @since 0.2.0
 */
public class LegalGuardians extends AbstractTimeAndValueModel<Integer, String> {

    @JsonProperty("Kon")
    private String sex;

    @JsonProperty("Vardnadshavare")
    private String caregiver;

    @JsonProperty("Familjetyp")
    private String familyType;

    /**
     * <p>Default constructor.</p>
     */
    public LegalGuardians() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param sex
     *            the sex
     * @param familyType
     *            the family type
     * @param caregiver
     *            the caregiver
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public LegalGuardians(String sex, String caregiver, String familyType, Integer year,
            List<ValueNode<String>> values) {
        super(year, values);
        this.sex = sex;
        this.caregiver = caregiver;
        this.familyType = familyType;
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
     * <p>Getter for caregiver.</p>
     *
     * @return the caregiver
     */
    public String getCaregiver() {
        return this.caregiver;
    }

    /**
     * <p>Setter for caregiver.</p>
     *
     * @param caregiver
     *            the caregiver
     */
    public void setCaregiver(String caregiver) {
        this.caregiver = caregiver;
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

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.sex, this.caregiver, this.familyType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LegalGuardians)) {
            return false;
        }

        LegalGuardians other = (LegalGuardians) obj;
        return super.equals(obj) && Objects.equals(this.sex, other.sex)
                && Objects.equals(this.caregiver, other.caregiver) && Objects.equals(this.familyType, other.familyType);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [sex=");
        builder.append(this.sex);
        builder.append(" [caregiver=");
        builder.append(this.caregiver);
        builder.append(" [familyType=");
        builder.append(this.familyType);
        builder.append(", time=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the legal guardians data
     * from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("LE/LE0102/LE0102O/LE0102T28");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
