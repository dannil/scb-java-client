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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.region == null) ? 0 : this.region.hashCode());
		result = prime * result + ((this.year == null) ? 0 : this.year.hashCode());
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
		if (!(obj instanceof AbstractLandAndWaterAreaModel)) {
			return false;
		}
		AbstractLandAndWaterAreaModel other = (AbstractLandAndWaterAreaModel) obj;
		if (this.region == null) {
			if (other.region != null) {
				return false;
			}
		} else if (!this.region.equals(other.region)) {
			return false;
		}
		if (this.year == null) {
			if (other.year != null) {
				return false;
			}
		} else if (!this.year.equals(other.year)) {
			return false;
		}
		return true;
	}

}
