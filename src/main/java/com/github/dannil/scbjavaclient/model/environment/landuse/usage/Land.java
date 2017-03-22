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

package com.github.dannil.scbjavaclient.model.environment.landuse.usage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractRegionTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for land data. Holds data which are common for all classes located in this
 * package.</p>
 *
 * @since 0.2.0
 */
public class Land extends AbstractRegionTimeAndValueModel<String, Integer, String> {

    @JsonProperty("Markanvandningsklass")
    private Integer category;

    /**
     * <p>Default constructor.</p>
     */
    public Land() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param region
     *            the region
     * @param category
     *            the category
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public Land(String region, Integer category, Integer year, List<ValueNode<String>> values) {
        super(region, year, values);
        this.category = category;
    }

    /**
     * <p>Getter for category.</p>
     *
     * @return the category
     */
    public Integer getCategory() {
        return this.category;
    }

    /**
     * <p>Setter for category.</p>
     *
     * @param category
     *            the category
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.category);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Land)) {
            return false;
        }

        Land other = (Land) obj;
        return super.equals(obj) && Objects.equals(this.category, other.category);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("category", this.category);
        return super.buildToString(variables);
    }

}
