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
 * <p>Model for generated waste data.</p>
 *
 * @since 0.2.0
 */
public class GeneratedWaste extends AbstractWaste {

    @JsonProperty("SNI2007MI")
    private String industrialClassification;

    /**
     * <p>Default constructor.</p>
     */
    public GeneratedWaste() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param industrialClassification
     *            the industrial classification
     * @param category
     *            the category
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public GeneratedWaste(String industrialClassification, String category, Integer year,
            List<ValueNode<String>> values) {
        super(category, year, values);
        this.industrialClassification = industrialClassification;
    }

    /**
     * <p>Getter for industrial classification.</p>
     *
     * @return the industrial classification
     */
    public String getIndustrialClassification() {
        return this.industrialClassification;
    }

    /**
     * <p>Setter for industrial classification.</p>
     *
     * @param industrialClassification
     *            the industrial classification
     */
    public void setIndustrialClassification(String industrialClassification) {
        this.industrialClassification = industrialClassification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.industrialClassification);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof GeneratedWaste)) {
            return false;
        }

        GeneratedWaste other = (GeneratedWaste) obj;
        return super.equals(obj) && Objects.equals(this.industrialClassification, other.industrialClassification);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [industrialClassification=");
        builder.append(this.industrialClassification);
        builder.append(", wasteCategory=");
        builder.append(getWasteCategory());
        builder.append(", time=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the generated waste data
     * from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("MI/MI0305/MI0305T01");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
