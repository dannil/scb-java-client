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

package com.github.dannil.scbjavaclient.model.environment.packagingandpackagingwaste;

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
 * <p>Model for packaging and packaging waste data.</p>
 *
 * @since 0.2.0
 */
public class PackagingAndPackagingWaste extends AbstractTimeAndValueModel<Integer, Integer> {

    @JsonProperty("Forpackning")
    private Integer type;

    /**
     * <p>Default constructor.</p>
     */
    public PackagingAndPackagingWaste() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param type
     *            the type
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public PackagingAndPackagingWaste(Integer type, Integer year, List<ValueNode<Integer>> values) {
        super(year, values);
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
        if (!(obj instanceof PackagingAndPackagingWaste)) {
            return false;
        }

        PackagingAndPackagingWaste other = (PackagingAndPackagingWaste) obj;
        return super.equals(obj) && Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("type", this.type);
        return super.buildToString(variables);
    }

    /**
     * <p>Get the available codes and their respective values for the packaging and
     * packaging waste data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("MI/MI0307/MI0307T1");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
