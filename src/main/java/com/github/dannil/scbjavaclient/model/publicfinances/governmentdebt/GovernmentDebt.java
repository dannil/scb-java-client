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

package com.github.dannil.scbjavaclient.model.publicfinances.governmentdebt;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.AbstractTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for government debt data.</p>
 *
 * @since 0.2.1
 */
public class GovernmentDebt extends AbstractTimeAndValueModel<String, Double> {

    @JsonProperty("Kontopost")
    private String item;

    /**
     * <p>Default constructor.</p>
     */
    public GovernmentDebt() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param item
     *            the item
     * @param month
     *            the month
     * @param values
     *            the values
     */
    public GovernmentDebt(String item, String month, List<ValueNode<Double>> values) {
        super(month, values);
        this.item = item;
    }

    /**
     * <p>Getter for item.</p>
     *
     * @return the item
     */
    public String getItem() {
        return this.item;
    }

    /**
     * <p>Setter for item.</p>
     *
     * @param item
     *            the item
     */
    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.item);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof GovernmentDebt)) {
            return false;
        }

        GovernmentDebt other = (GovernmentDebt) obj;
        return super.equals(obj) && Objects.equals(this.item, other.item);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("item", this.item);
        return super.buildToString(variables);
    }

    /**
     * <p>Get the available codes and their respective values for the government debt data
     * from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("OE/OE0202/Statsskuld");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
