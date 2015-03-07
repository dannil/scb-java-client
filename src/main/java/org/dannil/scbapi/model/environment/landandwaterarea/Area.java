package org.dannil.scbapi.model.environment.landandwaterarea;

public final class Area extends AbstractLandAndWaterAreaModel {

	private String type;
	private Double squareKm;

	public Area() {
		super();
	}

	public Area(String region, String type, Integer year, Double squareKm) {
		super(region, year);
		this.type = type;
		this.squareKm = squareKm;
	}

	public final String getType() {
		return this.type;
	}

	public final void setType(String type) {
		this.type = type;
	}

	public final Double getSquareKm() {
		return this.squareKm;
	}

	public final void setSquareKm(Double squareKm) {
		this.squareKm = squareKm;
	}

	@Override
	public String toString() {
		return "Area [region=" + super.region + ", year=" + super.year + ", type=" + this.type + ", squareKm=" + this.squareKm + "]";
	}

}
