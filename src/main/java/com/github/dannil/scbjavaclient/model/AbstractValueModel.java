/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Abstract model which holds the values of the client response.
 * 
 * @author Daniel Nilsson
 *
 * @param <V>
 *            the values
 */
public abstract class AbstractValueModel<V> {

	@JsonProperty("values")
	protected List<ValueNode<V>> valueNodes;

	/**
	 * Default constructor.
	 */
	protected AbstractValueModel() {
		// To enable derived classes to use their default constructor
		this.valueNodes = new ArrayList<ValueNode<V>>();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param values
	 *            the values
	 */
	protected AbstractValueModel(List<ValueNode<V>> values) {
		this();

		for (ValueNode<V> value : values) {
			ValueNode<V> v = new ValueNode<V>(value.getValue(), value.getCode(), value.getText());
			this.valueNodes.add(v);
		}
	}

	/**
	 * Getter for values.
	 * 
	 * @return the values
	 */
	public List<ValueNode<V>> getValues() {
		return this.valueNodes;
	}

	/**
	 * Setter for values.
	 * 
	 * @param values
	 *            the values
	 */
	public void setValues(List<ValueNode<V>> values) {
		this.valueNodes = new ArrayList<ValueNode<V>>(values);
	}

	/**
	 * Get the value node for a specific contents code.
	 *
	 * @param key
	 *            the contents code to get the value node for
	 * @return the value node
	 */
	public ValueNode<V> getValue(String key) {
		for (ValueNode<V> v : this.valueNodes) {
			if (v.getCode().equals(key)) {
				return v;
			}
		}
		return null;
	}

	/**
	 * Set the value for a specific contents code.
	 *
	 * @param key
	 *            the contents code to set the value for
	 * @param value
	 *            the value
	 */
	public void setValue(String key, V value) {
		for (ValueNode<V> v : this.valueNodes) {
			if (v.getCode().equals(key)) {
				v.setValue(value);
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.valueNodes);
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
		return Objects.equals(this.valueNodes, other.valueNodes);
	}

	@Override
	public abstract String toString();

}
