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

package com.github.dannil.scbjavaclient.model.energy.annualstatistics;

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
 * <p>Model for electricity supply data.</p>
 *
 * @since 0.2.0
 */
public class ElectricitySupply extends AbstractTimeAndValueModel<Integer, Integer> {

    @JsonProperty("Prodslag")
    private String powerPlant;

    /**
     * <p>Default constructor.</p>
     */
    public ElectricitySupply() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param powerPlant
     *            the power plant
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public ElectricitySupply(String powerPlant, Integer year, List<ValueNode<Integer>> values) {
        super(year, values);
        this.powerPlant = powerPlant;
    }

    /**
     * <p>Getter for power plant.</p>
     *
     * @return the power plant
     */
    public String getPowerPlant() {
        return this.powerPlant;
    }

    /**
     * <p>Setter for power plant.</p>
     *
     * @param powerPlant
     *            the power plant
     */
    public void setPowerPlant(String powerPlant) {
        this.powerPlant = powerPlant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.powerPlant);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ElectricitySupply)) {
            return false;
        }

        ElectricitySupply other = (ElectricitySupply) obj;
        return super.equals(obj) && Objects.equals(this.powerPlant, other.powerPlant);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("powerPlant", this.powerPlant);
        return super.buildToString(variables);
    }

    /**
     * <p>Get the available codes and their respective values for the electricity supply
     * data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("EN/EN0105/ElProdAr");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
