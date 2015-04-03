package org.dannil.scbapi.model.population.statistic;

import java.util.Arrays;
import java.util.List;

public final class Statistic extends AbstractStatisticModel {

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

	public final RelationshipStatus getRelationshipStatus() {
		return this.relationshipStatus;
	}

	public final void setRelationshipStatus(RelationshipStatus relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public final String getAge() {
		return this.age;
	}

	public final void setAge(String age) {
		this.age = age;
	}

	public final Gender getGender() {
		return this.gender;
	}

	public final void setGender(Gender gender) {
		this.gender = gender;
	}

	public final Long getAmount() {
		return this.amount;
	}

	public final void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = super.hashCode();
		result = prime * result + ((this.age == null) ? 0 : this.age.hashCode());
		result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
		result = prime * result + ((this.gender == null) ? 0 : this.gender.hashCode());
		result = prime * result + ((this.relationshipStatus == null) ? 0 : this.relationshipStatus.hashCode());
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
		if (!(obj instanceof Statistic)) {
			return false;
		}
		Statistic other = (Statistic) obj;
		if (!super.equals(obj)) {
			return false;
		}
		if (this.age == null) {
			if (other.age != null) {
				return false;
			}
		} else if (!this.age.equals(other.age)) {
			return false;
		}
		if (this.amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!this.amount.equals(other.amount)) {
			return false;
		}
		if (this.gender != other.gender) {
			return false;
		}
		if (this.relationshipStatus != other.relationshipStatus) {
			return false;
		}
		return true;
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
		return Arrays.asList("Region", "Civilstand", "Alder", "Kon", "Tid", "BE0101N1", "BE0101N2");
	}

	public enum RelationshipStatus {
		UNMARRIED("OG"), MARRIED("G"), DIVORCED("SK"), WIDOW("ÄNKL"), NULL(null);

		private final String value;

		private RelationshipStatus(String value) {
			this.value = value;
		}

		public static RelationshipStatus of(String value) {
			for (RelationshipStatus status : values()) {
				if (status.value != null && status.value.equals(value)) {
					return status;
				}
				return NULL;
			}
			throw new IllegalArgumentException(value);
		}

		@Override
		public String toString() {
			return this.value;
		}
	}

	public enum Gender {
		MAN(1), WOMAN(2), NULL(null);

		private final Integer value;

		private Gender(Integer value) {
			this.value = value;
		}

		public static Gender of(Integer value) {
			for (Gender gender : values()) {
				if (gender.value != null && gender.value.equals(value)) {
					return gender;
				}
				return NULL;
			}
			throw new IllegalArgumentException(value.toString());
		}

		@Override
		public String toString() {
			return (this.value != null ? this.value.toString() : null);
		}
	}

}
