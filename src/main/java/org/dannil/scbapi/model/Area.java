package org.dannil.scbapi.model;

public final class Area {

	private String region;
	private String type;
	private Integer year;
	private Double squareKm;

	public Area() {

	}

	public Area(String region, String type, Integer year, Double squareKm) {
		this.region = region;
		this.type = type;
		this.year = year;
		this.squareKm = squareKm;
	}

	public final String getRegion() {
		return this.region;
	}

	public final void setRegion(String region) {
		this.region = region;
	}

	public final String getType() {
		return this.type;
	}

	public final void setType(String type) {
		this.type = type;
	}

	public final Integer getYear() {
		return this.year;
	}

	public final void setYear(Integer year) {
		this.year = year;
	}

	public final Double getSquareKm() {
		return this.squareKm;
	}

	public final void setSquareKm(Double squareKm) {
		this.squareKm = squareKm;
	}

	@Override
	public String toString() {
		return "Area [region=" + this.region + ", type=" + this.type + ", year=" + this.year + ", squareKm=" + this.squareKm + "]";
	}

}
