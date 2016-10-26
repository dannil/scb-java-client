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
import com.github.dannil.scbjavaclient.model.AbstractRegionYearAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.utility.requester.RequestMethod;
import com.github.dannil.scbjavaclient.utility.requester.RequesterFactory;

/**
 * Model for live births data.
 * 
 * @author Daniel Nilsson
 */
public class LiveBirth extends AbstractRegionYearAndValueModel<String, Integer, Long> {

	@JsonProperty("alderModer")
	private String motherAge;

	@JsonProperty("kon")
	private Integer gender;

	/**
	 * Default constructor.
	 */
	public LiveBirth() {
		super();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param region
	 *            the region
	 * @param motherAge
	 *            the mother's age
	 * @param gender
	 *            the gender
	 * @param year
	 *            the year
	 * @param values
	 *            the values
	 */
	public LiveBirth(String region, String motherAge, Integer gender, Integer year, List<ValueNode<Long>> values) {
		super(region, year, values);
		this.motherAge = motherAge;
		this.gender = gender;
	}

	/**
	 * Getter for mother's age.
	 * 
	 * @return the mother's age.
	 */
	public String getMotherAge() {
		return this.motherAge;
	}

	/**
	 * Setter for mother's age.
	 * 
	 * @param motherAge
	 *            the mother's age
	 */
	public void setMotherAge(String motherAge) {
		this.motherAge = motherAge;
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
		return Objects.hash(super.hashCode(), this.motherAge, this.gender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LiveBirth)) {
			return false;
		}

		LiveBirth other = (LiveBirth) obj;
		return super.equals(other) && Objects.equals(this.motherAge, other.motherAge)
				&& Objects.equals(this.gender, other.gender);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(128);

		builder.append(this.getClass().getSimpleName());
		builder.append(" [motherAge=");
		builder.append(this.motherAge);
		builder.append(", gender=");
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
	 * Get the available codes and their respective values for the live birth data from the API.
	 *
	 * @return a list of the available codes and their values
	 */
	public static Map<String, Collection<?>> getInputs() {
		AbstractRequester get = RequesterFactory.getRequester(RequestMethod.GET);
		return QueryBuilder.generalizeInputs(JsonUtility.getInputs(get
				.getBodyAsStringFromTable("BE/BE0101/BE0101H/FoddaK")));
	}

}
