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

package com.github.dannil.scbjavaclient.model.financialmarkets.institutions;

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
 * <p>Model for monetary assets data.</p>
 *
 * @since 0.2.0
 */
public class MonetaryAssets extends AbstractTimeAndValueModel<String, String> {

    @JsonProperty("Institut")
    private String institution;

    @JsonProperty("Kontopost")
    private String item;

    @JsonProperty("Valuta")
    private String currency;

    /**
     * <p>Default constructor.</p>
     */
    public MonetaryAssets() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param institution
     *            the institution
     * @param item
     *            the item
     * @param currency
     *            the currency
     * @param month
     *            the month
     * @param values
     *            the values
     */
    public MonetaryAssets(String institution, String item, String currency, String month,
            List<ValueNode<String>> values) {
        super(month, values);
        this.institution = institution;
        this.item = item;
        this.currency = currency;
    }

    /**
     * <p>Getter for institution.</p>
     *
     * @return the institution
     */
    public String getInstitution() {
        return this.institution;
    }

    /**
     * <p>Setter for institution.</p>
     *
     * @param institution
     *            the institution
     */
    public void setInstitution(String institution) {
        this.institution = institution;
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

    /**
     * <p>Getter for currency.</p>
     *
     * @return the currency
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * <p>Setter for currency.</p>
     *
     * @param currency
     *            the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.institution, this.item, this.currency);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MonetaryAssets)) {
            return false;
        }

        MonetaryAssets other = (MonetaryAssets) obj;
        return super.equals(obj) && Objects.equals(this.institution, other.institution)
                && Objects.equals(this.item, other.item) && Objects.equals(this.currency, other.currency);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("institution", this.institution);
        variables.put("item", this.item);
        variables.put("currency", this.currency);
        return super.buildToString(variables);
    }

    /**
     * <p>Get the available codes and their respective values for the monetary assets data
     * from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("FM/FM0401/MFIM1");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
