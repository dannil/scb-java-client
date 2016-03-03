package com.github.dannil.scbjavaclient.model.population;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractYearAndValueModel;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.RequestPoster;

public class NumberOfChildrenBornByFirstName extends AbstractYearAndValueModel<Integer, String> {

	@JsonProperty("tilltalsnamn")
	private String firstname;

	public NumberOfChildrenBornByFirstName() {
		super();
	}

	public NumberOfChildrenBornByFirstName(String firstname, Integer year, String value) {
		super(year, value);
		this.firstname = firstname;
	}

	public String getFirstname() {
		return this.firstname;
	}

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
		if (!(obj instanceof NumberOfChildrenBornByFirstName)) {
			return false;
		}

		NumberOfChildrenBornByFirstName other = (NumberOfChildrenBornByFirstName) obj;
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
		builder.append(", value=");
		builder.append(super.value);
		builder.append(']');

		return builder.toString();
	}

	/**
	 * Get the codes for the live births from the API.
	 * 
	 * @return a list of codes that is used by the API to index the live births values
	 */
	public static List<String> getCodes() {
		return JsonUtility.getCodes(RequestPoster.getCodes("BE/BE0001/BE0001T04Ar"));
	}

}
