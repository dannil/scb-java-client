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

package com.github.dannil.scbjavaclient.model.environment.industrialwateruse;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;
import com.github.dannil.scbjavaclient.model.AbstractRegionTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for water usage data.</p>
 *
 * @since 0.2.0
 */
public class WaterUsage extends AbstractRegionTimeAndValueModel<String, Integer, String> {

    @JsonProperty("VattenTyp")
    private Integer type;

    /**
     * <p>Default constructor.</p>
     */
    public WaterUsage() {
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
    public WaterUsage(String region, Integer type, Integer year, List<ValueNode<String>> values) {
        super(region, year, values);
        this.type = type;
    }

    /**
     * <p>Getter for type.</p>
     *
     * @return the type
     */
    public Integer getType() {
        return this.type;
    }

    /**
     * <p>Setter for type.</p>
     *
     * @param type
     *            the type
     */
    public void setType(Integer type) {
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
        if (!(obj instanceof WaterUsage)) {
            return false;
        }

        WaterUsage other = (WaterUsage) obj;
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
        builder.append(", year=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

}
