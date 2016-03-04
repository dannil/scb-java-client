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

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractYearAndValueModel<Y, V> extends AbstractValueModel<V> {

	@JsonProperty("tid")
	protected Y year;

	public AbstractYearAndValueModel() {
		// To enable derived classes to use their default constructor
		super();
	}

	public AbstractYearAndValueModel(Y year, V value) {
		super(value);
		this.year = year;
	}

	public Y getYear() {
		return this.year;
	}

	public void setYear(Y year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractYearAndValueModel<?, ?>)) {
			return false;
		}

		AbstractYearAndValueModel<?, ?> other = (AbstractYearAndValueModel<?, ?>) obj;
		return super.equals(other) && Objects.equals(this.year, other.year);
	}

	public abstract String toString();

}
