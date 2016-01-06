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

import com.github.dannil.scbapi.utility.JsonUtility;
import com.github.dannil.scbapi.utility.RequestPoster;

public class Statistic extends AbstractStatisticModel {

	private static List<String> codes;

	private RelationshipStatus relationshipStatus;
	private String age;
	private Gender gender;
	private Long amount;

	public Statistic() {
		super();
	}

	public Statistic(String region, RelationshipStatus relationshipStatus, String age, Gender gender, Integer year, Long amount) {
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
		return Objects.hash(super.hashCode(), this.age, this.amount, this.gender, this.relationshipStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Statistic)) {
			return false;
		}

		Statistic other = (Statistic) obj;
		return super.equals(other) && Objects.equals(this.age, other.age) && Objects.equals(this.amount, other.amount) && Objects.equals(this.gender, other.gender)
				&& Objects.equals(this.relationshipStatus, other.relationshipStatus);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Statistic ");
		builder.append("[");
		builder.append("region=" + super.region + ", ");
		builder.append("year=" + super.year + ", ");
		builder.append("relationshipStatus=" + (this.relationshipStatus != null ? this.relationshipStatus.toString() : null) + ", ");
		builder.append("age=" + this.age + ", ");
		builder.append("gender=" + (this.gender != null ? this.gender.toString() : null) + ", ");
		builder.append("amount=" + this.amount);
		builder.append("]");

		return builder.toString();
	}

	public static List<String> getCodes() {
		if (codes == null) {
			codes = JsonUtility.getCodes(RequestPoster.getCodes("BE/BE0101/BE0101A/BefolkningNy"));
		}
		return codes;
	}

	public enum RelationshipStatus {
		UNMARRIED("OG"), MARRIED("G"), DIVORCED("SK"), WIDOW("ÄNKL");

		private final String value;

		private RelationshipStatus(String value) {
			this.value = value;
		}

		public static RelationshipStatus of(String value) {
			if (value == null) {
				return null;
			}

			for (RelationshipStatus status : values()) {
				if (status.value.equals(value)) {
					return status;
				}
			}
			throw new IllegalArgumentException(value);
		}

		@Override
		public String toString() {
			return this.value;
		}
	}

	public enum Gender {
		MAN(1), WOMAN(2);

		private final Integer value;

		private Gender(Integer value) {
			this.value = value;
		}

		public static Gender of(Integer value) {
			if (value == null) {
				return null;
			}

			for (Gender gender : values()) {
				if (gender.value.equals(value)) {
					return gender;
				}
			}
			throw new IllegalArgumentException(String.valueOf(value));
		}

		@Override
		public String toString() {
			return this.value.toString();
		}
	}

}
