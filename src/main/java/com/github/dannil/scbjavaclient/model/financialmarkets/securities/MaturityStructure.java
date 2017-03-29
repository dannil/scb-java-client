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

package com.github.dannil.scbjavaclient.model.financialmarkets.securities;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for maturity structure data.</p>
 *
 * @since 0.2.0
 */
public class MaturityStructure extends AbstractSecurity<Integer> {

    @JsonProperty("Forfall")
    private String maturity;

    /**
     * <p>Default constructor.</p>
     */
    public MaturityStructure() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param sector
     *            the sector
     * @param maturity
     *            the maturity
     * @param currency
     *            the currency
     * @param month
     *            the month
     * @param values
     *            the values
     */
    public MaturityStructure(Integer sector, String maturity, String currency, String month,
            List<ValueNode<Integer>> values) {
        super(sector, currency, month, values);
        this.maturity = maturity;
    }

    /**
     * <p>Getter for maturity.</p>
     *
     * @return the maturity
     */
    public String getMaturity() {
        return this.maturity;
    }

    /**
     * <p>Setter for maturity.</p>
     *
     * @param maturity
     *            the maturity
     */
    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.maturity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MaturityStructure)) {
            return false;
        }

        MaturityStructure other = (MaturityStructure) obj;
        return super.equals(obj) && Objects.equals(this.maturity, other.maturity);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("maturity", this.maturity);
        return super.buildToString(variables);
    }

    /**
     * <p>Get the available codes and their respective values for the maturity structure
     * data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("FM/FM9998/FM9998T02");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
