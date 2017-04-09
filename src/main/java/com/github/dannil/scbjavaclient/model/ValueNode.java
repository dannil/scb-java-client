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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;

/**
 * <p>Class which holds all data for a specific value.</p>
 *
 * @param <V>
 *            the data type of the value
 * @since 0.0.4
 */
public class ValueNode<V> {

    @JsonProperty("Value")
    private V value;

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Text")
    private String text;

    /**
     * <p>Default constructor.</p>
     */
    public ValueNode() {
        // Constructor to use when some of the values are missing, such as text
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param value
     *            the value
     * @param code
     *            the code
     * @param text
     *            the text
     */
    public ValueNode(V value, String code, String text) {
        this.value = value;
        this.code = code;
        this.text = text;
    }

    /**
     * <p>Getter for value.</p>
     *
     * @return the value
     */
    public V getValue() {
        return this.value;
    }

    /**
     * <p>Setter for value.</p>
     *
     * @param value
     *            the value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * <p>Getter for code.</p>
     *
     * @return the code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * <p>Setter for code.</p>
     *
     * @param code
     *            the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * <p>Getter for text.</p>
     *
     * @return the text
     */
    public String getText() {
        return this.text;
    }

    /**
     * <p>Setter for text.</p>
     *
     * @param text
     *            the text
     */
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.code, this.value, this.text);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ValueNode<?>)) {
            return false;
        }
        ValueNode<?> other = (ValueNode<?>) obj;
        return Objects.equals(this.code, other.code) && Objects.equals(this.value, other.value)
                && Objects.equals(this.text, other.text);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);
        builder.append("[code=");
        builder.append(this.code);
        builder.append(", value=");
        builder.append(this.value);
        builder.append(", text=");
        builder.append(this.text);
        builder.append(']');
        return builder.toString();
    }

}
