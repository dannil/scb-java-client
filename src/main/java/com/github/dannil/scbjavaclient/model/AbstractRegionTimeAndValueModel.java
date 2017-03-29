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

package com.github.dannil.scbjavaclient.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>Abstract model which handles region, time and value. Since these values are often
 * present in client responses, this class will be extended by many implementing
 * models.</p>
 *
 * @param <R>
 *            the region
 * @param <T>
 *            the time
 * @param <V>
 *            the value
 * @since 0.0.1
 */
public abstract class AbstractRegionTimeAndValueModel<R, T, V> extends AbstractTimeAndValueModel<T, V> {

    @JsonProperty("Region")
    private R region;

    /**
     * <p>Default constructor.</p>
     */
    protected AbstractRegionTimeAndValueModel() {
        // To enable derived classes to use their default constructor
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param region
     *            the region
     * @param time
     *            the time
     * @param values
     *            the values
     */
    protected AbstractRegionTimeAndValueModel(R region, T time, List<ValueNode<V>> values) {
        super(time, values);
        this.region = region;
    }

    /**
     * <p>Getter for region.</p>
     *
     * @return the region
     */
    public R getRegion() {
        return this.region;
    }

    /**
     * <p>Setter for region.</p>
     *
     * @param region
     *            the region
     */
    public void setRegion(R region) {
        this.region = region;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.region);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractRegionTimeAndValueModel<?, ?, ?>)) {
            return false;
        }
        AbstractRegionTimeAndValueModel<?, ?, ?> other = (AbstractRegionTimeAndValueModel<?, ?, ?>) obj;
        return super.equals(other) && Objects.equals(this.region, other.region);
    }

    @Override
    public String buildToString(Map<String, Object> variables) {
        variables.put("region", this.region);
        return super.buildToString(variables);
    }

    @Override
    public abstract String toString();

}
