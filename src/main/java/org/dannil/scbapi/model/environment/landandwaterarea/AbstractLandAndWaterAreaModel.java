package org.dannil.scbapi.model.environment.landandwaterarea;

public abstract class AbstractLandAndWaterAreaModel {

	protected String region;
	protected Integer year;

	protected AbstractLandAndWaterAreaModel() {

	}

	protected AbstractLandAndWaterAreaModel(String region, Integer year) {
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
