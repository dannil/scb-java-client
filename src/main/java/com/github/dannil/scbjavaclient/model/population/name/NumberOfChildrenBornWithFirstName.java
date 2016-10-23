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

package com.github.dannil.scbjavaclient.model.population.name;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractYearAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.utility.requester.RequestMethod;
import com.github.dannil.scbjavaclient.utility.requester.RequesterFactory;

/**
 * Model for number of children born with first name.
 * 
 * @author Daniel Nilsson
 */
public class NumberOfChildrenBornWithFirstName extends AbstractYearAndValueModel<Integer, String> {

	@JsonProperty("tilltalsnamn")
	private String firstname;

	/**
	 * Default constructor.
	 */
	public NumberOfChildrenBornWithFirstName() {
		super();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param firstname
	 *            the firstname
	 * @param year
	 *            the year
	 * @param values
	 *            the values
	 */
	public NumberOfChildrenBornWithFirstName(String firstname, Integer year, List<ValueNode<String>> values) {
		super(year, values);
		this.firstname = firstname;
	}

	/**
	 * Getter for firstname.
	 * 
	 * @return the firstname
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * Setter for firstname.
	 * 
	 * @param firstname
	 *            the firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.firstname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof NumberOfChildrenBornWithFirstName)) {
			return false;
		}

		NumberOfChildrenBornWithFirstName other = (NumberOfChildrenBornWithFirstName) obj;
		return super.equals(other) && Objects.equals(this.firstname, other.firstname);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(128);

		builder.append(this.getClass().getSimpleName());
		builder.append(" [firstname=");
		builder.append(this.firstname);
		builder.append(", year=");
		builder.append(super.year);
		builder.append(", values=");
		builder.append(super.valueNodes);
		builder.append(']');

		return builder.toString();
	}

	/**
	 * Get the available codes and their respective values for the number of children born with
	 * first name data from the API.
	 *
	 * @return a list of the available codes and their values
	 */
	public static Map<String, List<String>> getCodes() {
		AbstractRequester get = RequesterFactory.getRequester(RequestMethod.GET);
		return JsonUtility.getInputs(get.getBodyAsStringFromTable("BE/BE0001/BE0001T04Ar"));
	}

}
