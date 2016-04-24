/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.model.environment.landandwaterarea;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractRegionYearAndValueModel;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;

/**
 * Model for area data.
 * 
 * @author Daniel Nilsson
 */
public class Area extends AbstractRegionYearAndValueModel<String, Integer, Double> {

	@JsonProperty("arealTyp")
	private String type;

	/**
	 * Default constructor.
	 */
	public Area() {
		super();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param region
	 *            the region
	 * @param type
	 *            the type
	 * @param year
	 *            the year
	 * @param value
	 *            the value
	 */
	public Area(String region, String type, Integer year, Double value) {
		super(region, year, value);
		this.type = type;
	}

	/**
	 * Getter for type.
	 * 
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Setter for type.
	 * 
	 * @param type
	 *            the type
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Area)) {
			return false;
		}

		Area other = (Area) obj;
		return super.equals(obj) && Objects.equals(this.type, other.type);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(128);

		builder.append(this.getClass().getSimpleName());
		builder.append(" [type=");
		builder.append(this.type);
		builder.append(", region=");
		builder.append(super.region);
		builder.append(", year=");
		builder.append(super.year);
		builder.append(", value=");
		builder.append(super.value);
		builder.append(']');

		return builder.toString();
	}

	/**
	 * Get the codes for the area model from the API.
	 *
	 * @return a list of codes that is used by the API to index the values
	 */
	public static List<String> getCodes() {
		return JsonUtility.getCodes(AbstractRequester.getCodes("MI/MI0802/Areal2012"));
	}

}
