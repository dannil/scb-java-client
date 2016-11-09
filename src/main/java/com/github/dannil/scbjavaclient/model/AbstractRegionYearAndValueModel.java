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

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>Abstract model which handles region, year and value. Since these values are used by almost
 * every single client response, this class will be extended by a majority of the implemented
 * models.</p>
 * 
 * @author Daniel Nilsson
 *
 * @param <R>
 *            the region
 * @param <Y>
 *            the year
 * @param <V>
 *            the value
 */
public abstract class AbstractRegionYearAndValueModel<R, Y, V> extends AbstractYearAndValueModel<Y, V> {

	@JsonProperty("region")
	protected R region;

	/**
	 * <p>Default constructor.</p>
	 */
	protected AbstractRegionYearAndValueModel() {
		// To enable derived classes to use their default constructor
		super();
	}

	/**
	 * <p>Overloaded constructor.</p>
	 * 
	 * @param region
	 *            the region
	 * @param year
	 *            the year
	 * @param values
	 *            the values
	 */
	protected AbstractRegionYearAndValueModel(R region, Y year, List<ValueNode<V>> values) {
		super(year, values);
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
		if (!(obj instanceof AbstractRegionYearAndValueModel<?, ?, ?>)) {
			return false;
		}

		AbstractRegionYearAndValueModel<?, ?, ?> other = (AbstractRegionYearAndValueModel<?, ?, ?>) obj;
		return super.equals(other) && Objects.equals(this.region, other.region);
	}

	@Override
	public abstract String toString();

}
