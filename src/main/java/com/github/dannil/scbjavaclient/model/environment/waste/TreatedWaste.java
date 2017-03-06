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

package com.github.dannil.scbjavaclient.model.environment.waste;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for treated waste data.</p>
 *
 * @since 0.2.0
 */
public class TreatedWaste extends Waste {

    @JsonProperty("behTyp")
    private Integer treatmentCategory;

    /**
     * <p>Default constructor.</p>
     */
    public TreatedWaste() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param treatmentCategory
     *            the treatment category
     * @param wasteCategory
     *            the waste category
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public TreatedWaste(Integer treatmentCategory, String wasteCategory, Integer year, List<ValueNode<String>> values) {
        super(wasteCategory, year, values);
        this.treatmentCategory = treatmentCategory;
    }

    /**
     * <p>Getter for treatment category.</p>
     *
     * @return the treatment category
     */
    public Integer getTreatmentCategory() {
        return this.treatmentCategory;
    }

    /**
     * <p>Setter for treatment category.</p>
     *
     * @param treatmentCategory
     *            the treatment category
     */
    public void setTreatmentCategory(Integer treatmentCategory) {
        this.treatmentCategory = treatmentCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.treatmentCategory);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TreatedWaste)) {
            return false;
        }

        TreatedWaste other = (TreatedWaste) obj;
        return super.equals(obj) && Objects.equals(this.treatmentCategory, other.treatmentCategory);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [treatmentCategory=");
        builder.append(this.treatmentCategory);
        builder.append(", wasteCategory=");
        builder.append(getWasteCategory());
        builder.append(", year=");
        builder.append(getYear());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the treated waste data
     * from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("MI/MI0305/MI0305T02");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
