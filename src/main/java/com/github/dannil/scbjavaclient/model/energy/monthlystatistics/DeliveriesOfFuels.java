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

package com.github.dannil.scbjavaclient.model.energy.monthlystatistics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for deliveries of fuels data.</p>
 *
 * @since 0.2.0
 */
public class DeliveriesOfFuels extends AbstractTimeAndValueModel<String, String> {

    @JsonProperty("Varuslag")
    private Integer commodity;

    @JsonProperty("Forbrukarkat")
    private String userCategory;

    /**
     * <p>Default constructor.</p>
     */
    public DeliveriesOfFuels() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param commodity
     *            the commodity
     * @param userCategory
     *            the user category
     * @param month
     *            the month
     * @param values
     *            the values
     */
    public DeliveriesOfFuels(Integer commodity, String userCategory, String month, List<ValueNode<String>> values) {
        super(month, values);
        this.commodity = commodity;
        this.userCategory = userCategory;
    }

    /**
     * <p>Getter for commodity.</p>
     *
     * @return the commodity
     */
    public Integer getCommodity() {
        return this.commodity;
    }

    /**
     * <p>Setter for commodity.</p>
     *
     * @param commodity
     *            the commodity
     */
    public void setCommodity(Integer commodity) {
        this.commodity = commodity;
    }

    /**
     * <p>Getter for user category.</p>
     *
     * @return the user category
     */
    public String getUserCategory() {
        return userCategory;
    }

    /**
     * <p>Setter for user category.</p>
     *
     * @param userCategory
     *            the user category
     */
    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.commodity, this.userCategory);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DeliveriesOfFuels)) {
            return false;
        }

        DeliveriesOfFuels other = (DeliveriesOfFuels) obj;
        return super.equals(obj) && Objects.equals(this.commodity, other.commodity)
                && Objects.equals(this.userCategory, other.userCategory);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("commodity", this.commodity);
        variables.put("userCategory", this.userCategory);
        return super.buildToString(variables);
    }

}
