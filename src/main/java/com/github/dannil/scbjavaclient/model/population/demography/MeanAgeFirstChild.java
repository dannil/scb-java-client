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

package com.github.dannil.scbjavaclient.model.population.demography;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractRegionYearAndValueModel;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.RequestPoster;

/**
 * Model for mean age first child data.
 * 
 * @author Daniel Nilsson
 */
public class MeanAgeFirstChild extends AbstractRegionYearAndValueModel<String, Integer, Double> {

	@JsonProperty("kon")
	private Integer gender;

	/**
	 * Default constructor.
	 */
	public MeanAgeFirstChild() {
		super();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param region
	 *            the region
	 * @param gender
	 *            the gender
	 * @param year
	 *            the year
	 * @param value
	 *            the value
	 */
	public MeanAgeFirstChild(String region, Integer gender, Integer year, Double value) {
		super(region, year, value);
		this.gender = gender;
	}

	/**
	 * Getter for gender.
	 * 
	 * @return the gender
	 */
	public Integer getGender() {
		return this.gender;
	}

	/**
	 * Setter for gender.
	 * 
	 * @param gender
	 *            the gender
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.gender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MeanAgeFirstChild)) {
			return false;
		}

		MeanAgeFirstChild other = (MeanAgeFirstChild) obj;
		return super.equals(other) && Objects.equals(this.gender, other.gender);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(128);

		builder.append(this.getClass().getSimpleName());
		builder.append(" [gender=");
		builder.append(this.gender);
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
	 * Get the codes for the mean age first child model from the API.
	 *
	 * @return a list of codes that is used by the API to index the values
	 */
	public static List<String> getCodes() {
		return JsonUtility.getCodes(RequestPoster.getCodes("BE/BE0701/MedelAlderNY"));
	}

}
