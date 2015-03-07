package org.dannil.scbapi.model.population.statistic;

public abstract class AbstractStatisticModel {

	protected String region;
	protected Integer year;

	protected AbstractStatisticModel() {

	}

	protected AbstractStatisticModel(String region, Integer year) {
		this();
		this.region = region;
		this.year = year;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
