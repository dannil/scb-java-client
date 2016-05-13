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
	protected List<Value<V>> values;

	/**
	 * Default constructor.
	 */
	protected AbstractValueModel() {
		// To enable derived classes to use their default constructor
		this.values = new ArrayList<Value<V>>();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param values
	 *            the values
	 */
	protected AbstractValueModel(List<Value<V>> values) {
		this.values = new ArrayList<Value<V>>(values);
	}

	/**
	 * Getter for values.
	 * 
	 * @return the values
	 */
	public List<Value<V>> getValues() {
		return this.values;
	}

	/**
	 * Setter for values.
	 * 
	 * @param values
	 *            the values
	 */
	public void setValues(List<Value<V>> values) {
		this.values = new ArrayList<Value<V>>(values);
	}

	/**
	 * Get the value node for a specific contents code.
	 *
	 * @param key
	 *            the contents code to get the value node for
	 * @return the value node
	 */
	public Value<V> getValue(String key) {
		for (int i = 0; i < this.values.size(); i++) {
			Value<V> v = this.values.get(i);
			if (v.getCode().equals(key)) {
				return v;
			}
		}
		return null;
	}

	// /**
	// * Set the value for a specific contents code.
	// *
	// * @param key
	// * the contents code to set the value for
	// * @param value
	// * the value
	// */
	// public void setValue(String key, V value) {
	// this.values.put(key, value);
	// }

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

	@Override
	public abstract String toString();

}
