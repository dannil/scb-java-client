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
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>Abstract model which handles time and value.</p>
 *
 * @param <T>
 *            the time
 * @param <V>
 *            the value
 * @since 0.0.2
 */
public abstract class AbstractTimeAndValueModel<T, V> extends AbstractValueModel<V> {

    @JsonProperty("Tid")
    private T time;

    /**
     * <p>Default constructor.</p>
     */
    public AbstractTimeAndValueModel() {
        // To enable derived classes to use their default constructor
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param time
     *            the time
     * @param values
     *            the values
     */
    public AbstractTimeAndValueModel(T time, List<ValueNode<V>> values) {
        super(values);
        this.time = time;
    }

    /**
     * <p>Getter for time.</p>
     *
     * @return the time
     */
    public T getTime() {
        return this.time;
    }

    /**
     * <p>Setter for time.</p>
     *
     * @param time
     *            the time
     */
    public void setTime(T time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.time);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractTimeAndValueModel<?, ?>)) {
            return false;
        }
        AbstractTimeAndValueModel<?, ?> other = (AbstractTimeAndValueModel<?, ?>) obj;
        return super.equals(other) && Objects.equals(this.time, other.time);
    }

    @Override
    public abstract String toString();

}
