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

package com.github.dannil.scbjavaclient.model.financialmarkets.shareholders;

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
 * <p>Model for foreign ownership of shares data.</p>
 *
 * @since 0.2.0
 */
public class ForeignOwnershipOfShares extends AbstractTimeAndValueModel<String, Double> {

    @JsonProperty("Agarland")
    private String country;

    /**
     * <p>Default constructor.</p>
     */
    public ForeignOwnershipOfShares() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param country
     *            the country
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public ForeignOwnershipOfShares(String country, String year, List<ValueNode<Double>> values) {
        super(year, values);
        this.country = country;
    }

    /**
     * <p>Getter for country.</p>
     *
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * <p>Setter for country.</p>
     *
     * @param country
     *            the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.country);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ForeignOwnershipOfShares)) {
            return false;
        }

        ForeignOwnershipOfShares other = (ForeignOwnershipOfShares) obj;
        return super.equals(obj) && Objects.equals(this.country, other.country);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [country=");
        builder.append(this.country);
        builder.append(", time=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the foreign ownership of
     * shares data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("FM/FM0201/AktieAgarUtland");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
