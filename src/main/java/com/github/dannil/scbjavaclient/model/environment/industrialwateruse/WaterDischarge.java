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

package com.github.dannil.scbjavaclient.model.environment.industrialwateruse;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.AbstractRegionTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for water discharge data.</p>
 *
 * @since 0.2.0
 */
public class WaterDischarge extends AbstractRegionTimeAndValueModel<String, Integer, String> {

    @JsonProperty("Recipient")
    private Integer recipient;

    /**
     * <p>Default constructor.</p>
     */
    public WaterDischarge() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param region
     *            the region
     * @param recipient
     *            the recipient
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public WaterDischarge(String region, Integer recipient, Integer year, List<ValueNode<String>> values) {
        super(region, year, values);
        this.recipient = recipient;
    }

    /**
     * <p>Getter for recipient.</p>
     *
     * @return the recipient
     */
    public Integer getRecipient() {
        return this.recipient;
    }

    /**
     * <p>Setter for recipient.</p>
     *
     * @param recipient
     *            the recipient
     */
    public void setRecipient(Integer recipient) {
        this.recipient = recipient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.recipient);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof WaterDischarge)) {
            return false;
        }

        WaterDischarge other = (WaterDischarge) obj;
        return super.equals(obj) && Objects.equals(this.recipient, other.recipient);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [recipient=");
        builder.append(this.recipient);
        builder.append(", region=");
        builder.append(getRegion());
        builder.append(", year=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the water discharge data
     * from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("MI/MI0903/UtslappVatten");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
