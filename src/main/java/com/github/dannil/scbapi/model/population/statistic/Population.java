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

package com.github.dannil.scbapi.model.population.statistic;

import java.util.List;
import java.util.Objects;

import com.github.dannil.scbapi.model.AbstractRegionAndYearModel;
import com.github.dannil.scbapi.model.population.Gender;
import com.github.dannil.scbapi.model.population.RelationshipStatus;
import com.github.dannil.scbapi.utility.JsonUtility;
import com.github.dannil.scbapi.utility.RequestPoster;

public class Population extends AbstractRegionAndYearModel<String, Integer> {

	private RelationshipStatus relationshipStatus;
	private String age;
	private Gender gender;
	private Long amount;

	public Population() {
		super();
	}

	public Population(String region, RelationshipStatus relationshipStatus, String age, Gender gender, Integer year, Long amount) {
		super(region, year);
		this.relationshipStatus = relationshipStatus;
		this.age = age;
		this.gender = gender;
		this.amount = amount;
	}

	public RelationshipStatus getRelationshipStatus() {
		return this.relationshipStatus;
	}

	public void setRelationshipStatus(RelationshipStatus relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.relationshipStatus, this.age, this.gender, this.amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Population)) {
			return false;
		}

		Population other = (Population) obj;
		return super.equals(other) && Objects.equals(this.relationshipStatus, other.relationshipStatus) && Objects.equals(this.age, other.age) && Objects.equals(this.gender, other.gender)
				&& Objects.equals(this.amount, other.amount);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(128);

		builder.append("Population [relationshipStatus=");
		builder.append(this.relationshipStatus);
		builder.append(", age=");
		builder.append(this.age);
		builder.append(", gender=");
		builder.append(this.gender);
		builder.append(", amount=");
		builder.append(this.amount);
		builder.append(", region=");
		builder.append(super.region);
		builder.append(", year=");
		builder.append(super.year);
		builder.append(']');

		return builder.toString();
	}

	public static List<String> getCodes() {
		return JsonUtility.getCodes(RequestPoster.getCodes("BE/BE0101/BE0101A/BefolkningNy"));
	}

}
