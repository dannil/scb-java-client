/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = super.hashCode();
		result = prime * result + ((this.squareKm == null) ? 0 : this.squareKm.hashCode());
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Area)) {
			return false;
		}
		Area other = (Area) obj;
		if (!super.equals(obj)) {
			return false;
		}
		if (this.squareKm == null) {
			if (other.squareKm != null) {
				return false;
			}
		} else if (!this.squareKm.equals(other.squareKm)) {
			return false;
		}
		if (this.type != other.type) {
			return false;
		}
		return true;
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
			if (value == null) {
				return null;
			}

			for (Type type : values()) {
				if (type.value.equals(value)) {
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
