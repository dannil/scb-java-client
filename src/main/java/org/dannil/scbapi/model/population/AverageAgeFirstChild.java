package org.dannil.scbapi.model.population;

public final class AverageAgeFirstChild {

	private String region;
	private Integer gender;
	private Integer year;

	public AverageAgeFirstChild() {

	}

	public AverageAgeFirstChild(String region, Integer gender, Integer year) {
		this.region = region;
		this.gender = gender;
		this.year = year;
	}

	public final String getRegion() {
		return this.region;
	}

	public final void setRegion(String region) {
		this.region = region;
	}

	public final Integer getGender() {
		return this.gender;
	}

	public final void setGender(Integer gender) {
		this.gender = gender;
	}

	public final Integer getYear() {
		return this.year;
	}

	public final void setYear(Integer year) {
		this.year = year;
	}

}
