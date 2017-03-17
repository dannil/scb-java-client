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

package com.github.dannil.scbjavaclient.model.financialmarkets.investmentfunds;

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
 * <p>Model for ownership of investment fund shares data.</p>
 *
 * @since 0.2.0
 */
public class OwnershipOfInvestmentFundShares extends AbstractTimeAndValueModel<String, Integer> {

    @JsonProperty("Fondtyp")
    private String type;

    @JsonProperty("Sektor")
    private String sector;

    /**
     * <p>Default constructor.</p>
     */
    public OwnershipOfInvestmentFundShares() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param type
     *            the type
     * @param sector
     *            the sector
     * @param quarter
     *            the quarter
     * @param values
     *            the values
     */
    public OwnershipOfInvestmentFundShares(String type, String sector, String quarter,
            List<ValueNode<Integer>> values) {
        super(quarter, values);
        this.type = type;
        this.sector = sector;
    }

    /**
     * <p>Getter for type.</p>
     *
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * <p>Setter for type.</p>
     *
     * @param type
     *            the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <p>Getter for sector.</p>
     *
     * @return the sector
     */
    public String getSector() {
        return this.sector;
    }

    /**
     * <p>Setter for sector.</p>
     *
     * @param sector
     *            the sector
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.type, this.sector);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof OwnershipOfInvestmentFundShares)) {
            return false;
        }

        OwnershipOfInvestmentFundShares other = (OwnershipOfInvestmentFundShares) obj;
        return super.equals(obj) && Objects.equals(this.type, other.type) && Objects.equals(this.sector, other.sector);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [type=");
        builder.append(this.type);
        builder.append(", sector=");
        builder.append(this.sector);
        builder.append(", time=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the ownership of
     * investment fund shares data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("FM/FM0403/VPfondKv");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
