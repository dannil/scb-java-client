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

package com.github.dannil.scbjavaclient.model.environment.landandwaterarea;

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
 * <p>Model for area data.</p>
 *
 * @since 0.0.1
 */
public class Area extends AbstractRegionTimeAndValueModel<String, Integer, Double> {

    @JsonProperty("ArealTyp")
    private String type;

    /**
     * <p>Default constructor.</p>
     */
    public Area() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param region
     *            the region
     * @param type
     *            the type
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public Area(String region, String type, Integer year, List<ValueNode<Double>> values) {
        super(region, year, values);
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
        if (!(obj instanceof Area)) {
            return false;
        }

        Area other = (Area) obj;
        return super.equals(obj) && Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [type=");
        builder.append(this.type);
        builder.append(", region=");
        builder.append(getRegion());
        builder.append(", time=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the area data from the
     * API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("MI/MI0802/Areal2012");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
