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

package com.github.dannil.scbapi.model.population.demography;

import java.util.List;
import java.util.Objects;

import com.github.dannil.scbapi.model.AbstractRegionAndYearModel;
import com.github.dannil.scbapi.utility.JsonUtility;
import com.github.dannil.scbapi.utility.RequestPoster;

public class MeanAgeFirstChild extends AbstractRegionAndYearModel<String, Integer> {

	private Integer gender;
	private Double averageAge;

	public MeanAgeFirstChild() {
		super();
	}

	public MeanAgeFirstChild(String region, Integer gender, Integer year, Double averageAge) {
		super(region, year);
		this.gender = gender;
		this.averageAge = averageAge;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Double getAverageAge() {
		return this.averageAge;
	}

	public void setAverageAge(Double averageAge) {
		this.averageAge = averageAge;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.gender, this.averageAge);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MeanAgeFirstChild)) {
			return false;
		}

		MeanAgeFirstChild other = (MeanAgeFirstChild) obj;
		return super.equals(other) && Objects.equals(this.gender, other.gender) && Objects.equals(this.averageAge, other.averageAge);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(128);

		builder.append(MeanAgeFirstChild.class.getSimpleName() + " [gender=");
		builder.append(this.gender);
		builder.append(", averageAge=");
		builder.append(this.averageAge);
		builder.append(", region=");
		builder.append(super.region);
		builder.append(", year=");
		builder.append(super.year);
		builder.append(']');

		return builder.toString();
	}

	public static List<String> getCodes() {
		return JsonUtility.getCodes(RequestPoster.getCodes("BE/BE0701/MedelAlderNY"));
	}

}
