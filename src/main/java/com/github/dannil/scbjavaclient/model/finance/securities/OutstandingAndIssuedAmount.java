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

package com.github.dannil.scbjavaclient.model.finance.securities;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for outstanding and issued amount data.</p>
 *
 * @since 0.2.0
 */
public class OutstandingAndIssuedAmount extends AbstractSecurity<String> {

    @JsonProperty("Kontopost")
    private String item;

    /**
     * <p>Default constructor.</p>
     */
    public OutstandingAndIssuedAmount() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param sector
     *            the sector
     * @param item
     *            the item
     * @param currency
     *            the currency
     * @param month
     *            the month
     * @param values
     *            the values
     */
    public OutstandingAndIssuedAmount(Integer sector, String item, String currency, String month,
            List<ValueNode<String>> values) {
        super(sector, currency, month, values);
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
        if (!(obj instanceof OutstandingAndIssuedAmount)) {
            return false;
        }

        OutstandingAndIssuedAmount other = (OutstandingAndIssuedAmount) obj;
        return super.equals(obj) && Objects.equals(this.item, other.item);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [sector=");
        builder.append(getSector());
        builder.append(", item=");
        builder.append(this.item);
        builder.append(", currency=");
        builder.append(getCurrency());
        builder.append(", year=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the outstanding and
     * issued amount data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("FM/FM9998/FM9998T01");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
