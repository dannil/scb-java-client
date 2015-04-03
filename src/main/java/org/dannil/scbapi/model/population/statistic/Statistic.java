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
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Statistic ");
		builder.append("[");
		builder.append("region=" + super.region + ", ");
		builder.append("year=" + super.year + ", ");
		builder.append("relationshipStatus=" + this.relationshipStatus.toString() + ", ");
		builder.append("age=" + this.age + ", ");
		builder.append("gender=" + this.gender.toString() + ", ");
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
