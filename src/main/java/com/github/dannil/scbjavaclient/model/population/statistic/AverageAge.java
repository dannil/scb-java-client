package com.github.dannil.scbjavaclient.model.population.statistic;

import java.util.List;
import java.util.Objects;

import com.github.dannil.scbjavaclient.model.AbstractRegionAndYearModel;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.RequestPoster;

public class AverageAge extends AbstractRegionAndYearModel<String, Integer, Double> {

	private String gender;

	public AverageAge() {
		super();
	}

	public AverageAge(String region, String gender, Integer year, Double value) {
		super(region, year, value);
		this.gender = gender;
	}

	public String getGender() {
		return this.gender;
	}

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
		return JsonUtility.getCodes(RequestPoster.getCodes("BE/BE0101/BE0101B/BefolkningMedelAlder"));
	}

}
