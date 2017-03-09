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

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Abstract model for finance security data. Holds data which are common for all
 * classes located in this package.</p>
 *
 * @param <V>
 *            the value
 * @since 0.2.0
 */
public abstract class AbstractSecurity<V> extends AbstractTimeAndValueModel<String, V> {

    @JsonProperty("Sektor")
    private Integer sector;

    @JsonProperty("Valuta")
    private String currency;

    /**
     * <p>Default constructor.</p>
     */
    public AbstractSecurity() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param sector
     *            the sector
     * @param currency
     *            the currency
     * @param month
     *            the month
     * @param values
     *            the values
     */
    public AbstractSecurity(Integer sector, String currency, String month, List<ValueNode<V>> values) {
        super(month, values);
        this.sector = sector;
        this.currency = currency;
    }

    /**
     * <p>Getter for sector.</p>
     *
     * @return the sector
     */
    public Integer getSector() {
        return this.sector;
    }

    /**
     * <p>Setter for sector.</p>
     *
     * @param sector
     *            the sector
     */
    public void setSector(Integer sector) {
        this.sector = sector;
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
        return Objects.hash(super.hashCode(), this.sector, this.currency);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractSecurity)) {
            return false;
        }

        AbstractSecurity<?> other = (AbstractSecurity<?>) obj;
        return super.equals(obj) && Objects.equals(this.sector, other.sector)
                && Objects.equals(this.currency, other.currency);
    }

}
