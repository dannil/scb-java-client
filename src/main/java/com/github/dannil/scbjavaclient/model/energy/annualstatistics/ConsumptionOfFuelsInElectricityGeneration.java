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
 * <p>Model for consumption of fuels in electricity generation data.</p>
 *
 * @since 0.2.0
 */
public class ConsumptionOfFuelsInElectricityGeneration extends AbstractTimeAndValueModel<Integer, String> {

    @JsonProperty("Prodslag")
    private String powerPlant;

    @JsonProperty("Bransle")
    private String fuel;

    /**
     * <p>Default constructor.</p>
     */
    public ConsumptionOfFuelsInElectricityGeneration() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param powerPlant
     *            the power plant
     * @param fuel
     *            the fuel
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public ConsumptionOfFuelsInElectricityGeneration(String powerPlant, String fuel, Integer year,
            List<ValueNode<String>> values) {
        super(year, values);
        this.powerPlant = powerPlant;
        this.fuel = fuel;
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

    /**
     * <p>Getter for fuel.</p>
     *
     * @return the fuel
     */
    public String getFuel() {
        return this.fuel;
    }

    /**
     * <p>Setter for fuel.</p>
     *
     * @param fuel
     *            the fuel
     */
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.powerPlant, this.fuel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ConsumptionOfFuelsInElectricityGeneration)) {
            return false;
        }

        ConsumptionOfFuelsInElectricityGeneration other = (ConsumptionOfFuelsInElectricityGeneration) obj;
        return super.equals(obj) && Objects.equals(this.powerPlant, other.powerPlant)
                && Objects.equals(this.fuel, other.fuel);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [powerPlant=");
        builder.append(this.powerPlant);
        builder.append(", fuel=");
        builder.append(this.fuel);
        builder.append(", time=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the consumption of fuels
     * in electricity generation data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("EN/EN0105/BrforelAR");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
