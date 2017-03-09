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

package com.github.dannil.scbjavaclient.model.finance.shareholders;

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
 * <p>Model for ownership of shares by series data.</p>
 *
 * @since 0.2.0
 */
public class OwnershipOfSharesBySeries extends OwnershipOfShares {

    @JsonProperty("Aktieserie")
    private String shareClass;

    /**
     * <p>Default constructor.</p>
     */
    public OwnershipOfSharesBySeries() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param sector
     *            the sector
     * @param shareClass
     *            the share class
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public OwnershipOfSharesBySeries(String sector, String shareClass, String year, List<ValueNode<Double>> values) {
        super(sector, year, values);
        this.shareClass = shareClass;
    }

    /**
     * <p>Getter for share class.</p>
     *
     * @return the share class
     */
    public String getShareClass() {
        return this.shareClass;
    }

    /**
     * <p>Setter for share class.</p>
     *
     * @param shareClass
     *            the share class
     */
    public void setShareClass(String shareClass) {
        this.shareClass = shareClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.shareClass);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof OwnershipOfSharesBySeries)) {
            return false;
        }

        OwnershipOfSharesBySeries other = (OwnershipOfSharesBySeries) obj;
        return super.equals(obj) && Objects.equals(this.shareClass, other.shareClass);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [sector=");
        builder.append(getSector());
        builder.append(", shareClass=");
        builder.append(this.shareClass);
        builder.append(", year=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the ownership of shares
     * by series data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("FM/FM0201/AktieAgarSerie");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
