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

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Abstract model for waste data. Holds data which are common for all classes located
 * in this package.</p>
 *
 * @since 0.2.0
 */
public abstract class AbstractWaste extends AbstractTimeAndValueModel<Integer, String> {

    @JsonProperty("Avfallsslag")
    private String wasteCategory;

    /**
     * <p>Default constructor.</p>
     */
    public AbstractWaste() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param wasteCategory
     *            the waste category
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public AbstractWaste(String wasteCategory, Integer year, List<ValueNode<String>> values) {
        super(year, values);
        this.wasteCategory = wasteCategory;
    }

    /**
     * <p>Getter for waste category.</p>
     *
     * @return the waste category
     */
    public String getWasteCategory() {
        return this.wasteCategory;
    }

    /**
     * <p>Setter for waste category.</p>
     *
     * @param wasteCategory
     *            the waste category
     */
    public void setWasteCategory(String wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.wasteCategory);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractWaste)) {
            return false;
        }

        AbstractWaste other = (AbstractWaste) obj;
        return super.equals(obj) && Objects.equals(this.wasteCategory, other.wasteCategory);
    }

}
