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

import java.util.Objects;

/**
 * Class which holds all data for a specific value.
 * 
 * @author Daniel Nilsson
 *
 * @param <V>
 *            the data type of the value
 */
public class ValueNode<V> {

	private V value;
	private String code;
	private String text;

	/**
	 * Default constructor.
	 */
	public ValueNode() {

	}

	/**
	 * Overloaded constructor.
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
	 * Copy constructor.
	 * 
	 * @param value
	 *            the value to copy
	 */
	public ValueNode(ValueNode<V> value) {
		this(value.value, value.code, value.text);
	}

	/**
	 * Getter for value.
	 * 
	 * @return the value
	 */
	public V getValue() {
		return this.value;
	}

	/**
	 * Setter for value.
	 * 
	 * @param value
	 *            the value
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * Getter for code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * Setter for code.
	 * 
	 * @param code
	 *            the code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getter for text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Setter for text.
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
		StringBuilder builder = new StringBuilder(128);

		// builder.append("Value [code=");
		builder.append("code=");
		builder.append(this.code);
		builder.append(", value=");
		builder.append(this.value);
		builder.append(", text=");
		builder.append(this.text);
		builder.append(']');

		return builder.toString();
	}

}
