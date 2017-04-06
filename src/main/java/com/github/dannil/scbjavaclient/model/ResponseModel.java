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

package com.github.dannil.scbjavaclient.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;

/**
 * <p>Class which encapsulates data retrieved from the API.</p>
 *
 * @since 0.3.0
 */
public class ResponseModel {

    @JsonProperty("Variables")
    private Map<String, String> variables;

    @JsonProperty("Values")
    private Collection<ValueNode<String>> values;

    /**
     * <p>Default constructor.</p>
     */
    public ResponseModel() {
        this.variables = new LinkedHashMap<>();
        this.values = new ArrayList<>();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param variables
     *            the variables
     * @param values
     *            the values
     */
    public ResponseModel(Map<String, String> variables, Collection<ValueNode<String>> values) {
        this();
        this.variables = variables;
        this.values = values;
    }

    /**
     * <p>Getter for variables.</p>
     *
     * @return the variables
     */
    public Map<String, String> getVariables() {
        return this.variables;
    }

    /**
     * <p>Setter for variables.</p>
     *
     * @param variables
     *            the variables
     */
    public void setVariables(Map<String, String> variables) {
        this.variables = variables;
    }

    /**
     * <p>Getter for values.</p>
     *
     * @return the values
     */
    public Collection<ValueNode<String>> getValues() {
        return this.values;
    }

    /**
     * <p>Setter for values.</p>
     *
     * @param values
     *            the values
     */
    public void setValues(Collection<ValueNode<String>> values) {
        this.values = values;
    }

    /**
     * <p>Get the variable value for a specific key.</p>
     *
     * @param key
     *            the key
     * @return the value
     */
    public String getVariable(String key) {
        return this.variables.get(key);
    }

    /**
     * <p>Set the variable value for a specific key.</p>
     *
     * @param key
     *            the key
     * @param value
     *            the value
     */
    public void setVariable(String key, String value) {
        this.variables.put(key, value);
    }

    /**
     * <p>Get the value node for a specific contents code.</p>
     *
     * @param code
     *            the contents code to get the {@link ValueNode ValueNode} for
     * @return the {@link ValueNode ValueNode} containing the contents code
     */
    public ValueNode<String> getValue(String code) {
        for (ValueNode<String> v : this.values) {
            if (Objects.equals(code, v.getCode())) {
                return v;
            }
        }
        return null;
    }

    /**
     * <p>Set the value for a specific contents code.</p>
     *
     * @param code
     *            the contents code to set the value for
     * @param value
     *            the value
     */
    public void setValue(String code, String value) {
        ValueNode<String> v = getValue(code);
        if (v != null) {
            v.setValue(value);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.variables, this.values);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ResponseModel)) {
            return false;
        }
        ResponseModel other = (ResponseModel) obj;
        return Objects.equals(this.variables, other.variables) && Objects.equals(this.values, other.values);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);
        builder.append("ResponseModel [variables=");
        builder.append(this.variables);
        builder.append(", values=");
        builder.append(this.values);
        builder.append(']');
        return builder.toString();
    }

}
