package org.dannil.scbapi.model;

public final class AverageAgeFirstChild {

	private String region;
	private Integer year;
	private Integer gender;

	public AverageAgeFirstChild() {

	}

	public AverageAgeFirstChild(String region, Integer year, Integer gender) {
		this.region = region;
		this.year = year;
		this.gender = gender;
	}

	public final String getRegion() {
		return this.region;
	}

	public final void setRegion(String region) {
		this.region = region;
	}

	public final Integer getYear() {
		return this.year;
	}

	public final void setYear(Integer year) {
		this.year = year;
	}

	public final Integer getGender() {
		return this.gender;
	}

	public final void setGender(Integer gender) {
		this.gender = gender;
	}

}
