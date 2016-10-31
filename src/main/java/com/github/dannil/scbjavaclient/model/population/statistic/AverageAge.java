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

package com.github.dannil.scbjavaclient.model.population.statistic;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.format.JsonConventionalFormat;
import com.github.dannil.scbjavaclient.model.AbstractRegionYearAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.utility.requester.RequestMethod;
import com.github.dannil.scbjavaclient.utility.requester.RequesterFactory;

/**
 * <p>
 * Model for average age.
 * </p>
 * 
 * @author Daniel Nilsson
 */
public class AverageAge extends AbstractRegionYearAndValueModel<String, Integer, Double> {

	@JsonProperty("kon")
	private String gender;

	/**
	 * <p>
	 * Default constructor.
	 * </p>
	 */
	public AverageAge() {
		super();
	}

	/**
	 * <p>
	 * Overloaded constructor.
	 * </p>
	 * 
	 * @param region
	 *            the region
	 * @param gender
	 *            the gender
	 * @param year
	 *            the year
	 * @param values
	 *            the values
	 */
	public AverageAge(String region, String gender, Integer year, List<ValueNode<Double>> values) {
		super(region, year, values);
		this.gender = gender;
	}

	/**
	 * <p>
	 * Getter for gender.
	 * </p>
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * <p>
	 * Setter for gender.
	 * </p>
	 * 
	 * @param gender
	 *            the gender
	 */
	public void setGender(String gender) {
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
		if (!(obj instanceof AverageAge)) {
			return false;
		}

		AverageAge other = (AverageAge) obj;
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
		builder.append(", values=");
		builder.append(super.valueNodes);
		builder.append(']');

		return builder.toString();
	}

	/**
	 * <p>
	 * Get the available codes and their respective values for the average age data from the API.
	 * </p>
	 * 
	 * @return a list of the available codes and their values
	 */
	public static Map<String, Collection<String>> getInputs() {
		AbstractRequester get = RequesterFactory.getRequester(RequestMethod.GET);
		return JsonConventionalFormat.getInputs(get.getBodyAsStringFromTable("BE/BE0101/BE0101B/BefolkningMedelAlder"));
	}

}
