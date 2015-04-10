package org.dannil.scbapi.model.environment.landandwaterarea;

import java.util.List;

import org.dannil.scbapi.utility.JsonUtility;
import org.dannil.scbapi.utility.RequestPoster;

public final class Area extends AbstractLandAndWaterAreaModel {

	private static List<String> codes;

	private Type type;
	private Double squareKm;

	public Area() {
		super();
	}

	public Area(String region, Type type, Integer year, Double squareKm) {
		super(region, year);
		this.type = type;
		this.squareKm = squareKm;
	}

	public final Type getType() {
		return this.type;
	}

	public final void setType(Type type) {
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
		StringBuilder builder = new StringBuilder();

		builder.append("Area ");
		builder.append("[");
		builder.append("region=" + super.region + ", ");
		builder.append("year=" + super.year + ", ");
		builder.append("type=" + (this.type != null ? this.type.toString() : null) + ", ");
		builder.append("squareKm=" + this.squareKm);
		builder.append("]");

		return builder.toString();
	}

	public static List<String> getCodes() {
		if (codes == null) {
			codes = JsonUtility.getCodes(RequestPoster.getCodes("MI/MI0802/Areal2012"));
		}
		return codes;
	}

	public enum Type {
		LANDAREA("01"), INLANDWATEREXCLUDINGTHEFOURLARGELAKES("02"), THEFOURLARGELAKES("03"), SEAWATER("04");

		private final String value;

		private Type(String value) {
			this.value = value;
		}

		public static Type of(String value) {
			for (Type type : values()) {
				if (type.value != null && type.value.equals(value)) {
					return type;
				}
			}
			throw new IllegalArgumentException(value);
		}

		@Override
		public String toString() {
			return this.value;
		}
	}

}
