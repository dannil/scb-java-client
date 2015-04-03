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
		return "Statistic [region=" + super.region + ", year=" + super.year + ", relationshipStatus=" + this.relationshipStatus + ", " + "age=" + this.age + ", gender=" + this.gender + ", amount="
				+ this.amount + "]";
	}

	public static List<String> getCodes() {
		return Arrays.asList("Region", "Civilstand", "Alder", "Kon", "Tid", "BE0101N1", "BE0101N2");
	}

	public enum RelationshipStatus {
		UNMARRIED("OG"), MARRIED("G"), DIVORCED("SK"), WIDOW("ÄNKL"), NULL(null);

		private final String status;

		private RelationshipStatus(String status) {
			this.status = status;
		}

		public static RelationshipStatus of(String name) {
			for (RelationshipStatus status : values()) {
				if (status.status != null && status.status.equals(name)) {
					return status;
				}
				return NULL;
			}
			throw new IllegalArgumentException(name);
		}

		@Override
		public String toString() {
			return this.status;
		}
	}

	public enum Gender {
		MAN(1), WOMAN(2), NULL(null);

		private final Integer gender;

		private Gender(Integer gender) {
			this.gender = gender;
		}

		public static Gender of(Integer name) {
			for (Gender gender : values()) {
				if (gender.gender != null && gender.gender.equals(name)) {
					return gender;
				}
				return NULL;
			}
			throw new IllegalArgumentException(name.toString());
		}

		@Override
		public String toString() {
			return this.gender.toString();
		}
	}

}
