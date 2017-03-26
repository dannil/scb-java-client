package com.github.dannil.scbjavaclient.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;

public class ResponseModel {

    @JsonProperty("Keys")
    private Map<String, String> keys;

    @JsonProperty("Values")
    private List<ValueNode<String>> values;

    public ResponseModel() {
        this.keys = new LinkedHashMap<>();
        this.values = new ArrayList<>();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param keys
     *            the keys
     * @param values
     *            the values
     */
    public ResponseModel(Map<String, String> keys, List<ValueNode<String>> values) {
        this();
        this.keys = keys;
        this.values = values;
    }

    /**
     * <p>Getter for keys.</p>
     *
     * @return the keys
     */
    public Map<String, String> getKeys() {
        return this.keys;
    }

    /**
     * <p>Setter for keys.</p>
     *
     * @param keys
     *            the keys
     */
    public void setKeys(Map<String, String> keys) {
        this.keys = keys;
    }

    /**
     * <p>Getter for values.</p>
     *
     * @return the values
     */
    public List<ValueNode<String>> getValues() {
        return this.values;
    }

    /**
     * <p>Setter for values.</p>
     *
     * @param values
     *            the values
     */
    public void setValues(List<ValueNode<String>> values) {
        this.values = values;
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
        for (ValueNode<String> v : this.values) {
            if (Objects.equals(code, v.getCode())) {
                v.setValue(value);
            }
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.keys, this.values);
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
        return Objects.equals(this.keys, other.keys) && Objects.equals(this.values, other.values);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);
        builder.append(getClass().getSimpleName());
        builder.append(" [");
        for (Iterator<Entry<String, String>> entries = this.keys.entrySet().iterator(); entries.hasNext();) {
            Entry<String, String> entry = entries.next();
            builder.append(entry.getKey());
            builder.append('=');
            builder.append(entry.getValue());
            builder.append(", ");
        }
        builder.append("values=");
        builder.append(this.values);
        builder.append(']');
        return builder.toString();
    }

    private static ResponseModel fromJson(String json) {
        // JsonCustomResponseFormat format = new JsonCustomResponseFormat(json);
        // return format.toListOf(ResponseModel.class);
        return null;
    }

}
