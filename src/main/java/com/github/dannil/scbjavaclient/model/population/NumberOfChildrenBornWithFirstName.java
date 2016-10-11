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

package com.github.dannil.scbjavaclient.model.population;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractYearAndValueModel;
import com.github.dannil.scbjavaclient.model.Value;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;

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
	public NumberOfChildrenBornWithFirstName(String firstname, Integer year, List<Value<String>> values) {
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
		builder.append(super.values);
		builder.append(']');

		return builder.toString();
	}

	/**
	 * Get the codes for the number of children born with first name from the API.
	 * 
	 * @return a list of codes that is used by the API to index the values
	 */
	public static List<String> getCodes() {
		return JsonUtility.getCodes(AbstractRequester.getCodes("BE/BE0001/BE0001T04Ar"));
	}

}
