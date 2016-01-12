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

import com.github.dannil.scbapi.model.AbstractRegionAndYearModel;

public class AverageAgeFirstChild extends AbstractRegionAndYearModel<String, Integer> {

	private Integer gender;
	private Double averageAge;

	public AverageAgeFirstChild() {

	}

	public AverageAgeFirstChild(String region, Integer gender, Integer year, Double averageAge) {
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

}
