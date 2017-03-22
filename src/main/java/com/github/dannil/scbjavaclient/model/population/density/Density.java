/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.model.population.density;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.AbstractRegionTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for density data.</p>
 *
 * @since 0.1.0
 */
public class Density extends AbstractRegionTimeAndValueModel<String, Integer, Double> {

    @JsonProperty("Kon")
    private String sex;

    /**
     * <p>Default constructor.</p>
     */
    public Density() {
        super();
    }

    /**
     * Overloaded constructor.
     *
     * @param region
     *            the region
     * @param sex
     *            the sex
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public Density(String region, String sex, Integer year, List<ValueNode<Double>> values) {
        super(region, year, values);
        this.sex = sex;
    }

    /**
     * <p>Getter for sex.</p>
     *
     * @return the sex
     */
    public String getSex() {
        return this.sex;
    }

    /**
     * <p>Setter for sex.</p>
     *
     * @param sex
     *            the sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.sex);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Density)) {
            return false;
        }

        Density other = (Density) obj;
        return super.equals(other) && Objects.equals(this.sex, other.sex);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("sex", this.sex);
        return super.buildToString(variables);
    }

    /**
     * <p>Get the available codes and their respective values for the density data from
     * the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("BE/BE0101/BE0101C/BefArealTathetKon");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
