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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;

/**
 * <p>Abstract model which holds the values of the client response.</p>
 *
 * @param <V>
 *            the values
 * @since 0.0.1
 */
public abstract class AbstractValueModel<V> {

    @JsonProperty("Values")
    private List<ValueNode<V>> values;

    /**
     * <p>Default constructor.</p>
     */
    protected AbstractValueModel() {
        // To enable derived classes to use their default constructor
        this.values = new ArrayList<>();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param values
     *            the values
     */
    protected AbstractValueModel(List<ValueNode<V>> values) {
        this();
        this.values = values;
    }

    /**
     * <p>Getter for values.</p>
     *
     * @return the values
     */
    public List<ValueNode<V>> getValues() {
        return this.values;
    }

    /**
     * <p>Setter for values.</p>
     *
     * @param values
     *            the values
     */
    public void setValues(List<ValueNode<V>> values) {
        this.values = values;
    }

    /**
     * <p>Get the value node for a specific contents code.</p>
     *
     * @param key
     *            the contents code to get the {@link ValueNode ValueNode} for
     * @return the {@link ValueNode ValueNode} containing the contents code
     */
    public ValueNode<V> getValue(String key) {
        for (ValueNode<V> v : this.values) {
            if (Objects.equals(key, v.getCode())) {
                return v;
            }
        }
        return null;
    }

    /**
     * <p>Set the value for a specific contents code.</p>
     *
     * @param key
     *            the contents code to set the value for
     * @param value
     *            the value
     */
    public void setValue(String key, V value) {
        for (ValueNode<V> v : this.values) {
            if (Objects.equals(key, v.getCode())) {
                v.setValue(value);
            }
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.values);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractValueModel<?>)) {
            return false;
        }
        AbstractValueModel<?> other = (AbstractValueModel<?>) obj;
        return Objects.equals(this.values, other.values);
    }

    /**
     * <p>Builds a string which can be used for outputting the values for the variables of
     * the calling class.</p>
     *
     * <p>Every key-value pair in the input map <code>variables</code> is appended (equal
     * signs-separated) to a string and separated from the other key-value pairs by a
     * comma.</p>
     *
     * <p>Example: given the key-value pairs name=John, age=20, and this method called
     * from a class named HelloWorld, the result would be:</p>
     *
     * <p><b>HelloWorld [name=John, age=20, values=[...]]</b></p> <p>with appropriate
     * values also appended in the same fashion.</p>
     *
     * <p>Subclasses are expected to override this method and add its own variables,
     * thereby creating a chain where every subclass is only responsible for it's own
     * variables.</p>
     *
     * @param variables
     *            the variables to print
     * @return a string representation of the variables
     */
    public String buildToString(Map<String, Object> variables) {
        variables.put("values", this.values);

        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);
        builder.append(this.getClass().getSimpleName());
        builder.append(" [");
        for (Iterator<Entry<String, Object>> entries = variables.entrySet().iterator(); entries.hasNext();) {
            Entry<String, Object> entry = entries.next();
            builder.append(entry.getKey());
            builder.append('=');
            builder.append(entry.getValue());
            if (entries.hasNext()) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    @Override
    public abstract String toString();

}
