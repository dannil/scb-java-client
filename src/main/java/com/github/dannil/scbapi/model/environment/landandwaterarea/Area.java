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

package com.github.dannil.scbapi.model.environment.landandwaterarea;

import java.util.List;
import java.util.Objects;

import com.github.dannil.scbapi.model.AbstractRegionAndYearModel;
import com.github.dannil.scbapi.model.environment.Type;
import com.github.dannil.scbapi.utility.JsonUtility;
import com.github.dannil.scbapi.utility.RequestPoster;

public class Area extends AbstractRegionAndYearModel<String, Integer> {

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

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Double getSquareKm() {
		return this.squareKm;
	}

	public void setSquareKm(Double squareKm) {
		this.squareKm = squareKm;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.type, this.squareKm);
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
		return super.equals(obj) && Objects.equals(this.type, other.type) && Objects.equals(this.squareKm, other.squareKm);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(128);

		builder.append("Area [type=");
		builder.append(this.type);
		builder.append(", squareKm=");
		builder.append(this.squareKm);
		builder.append(", region=");
		builder.append(super.region);
		builder.append(", year=");
		builder.append(super.year);
		builder.append(']');

		return builder.toString();
	}

	public static List<String> getCodes() {
		if (codes == null) {
			codes = JsonUtility.getCodes(RequestPoster.getCodes("MI/MI0802/Areal2012"));
		}
		return codes;
	}

}
