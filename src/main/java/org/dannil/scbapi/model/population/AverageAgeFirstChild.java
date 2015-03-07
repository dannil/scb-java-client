package org.dannil.scbapi.model.population;

public final class AverageAgeFirstChild extends AbstractPopulationModel {

	private Integer gender;
	private Double averageAge;

	public AverageAgeFirstChild() {
		super();
	}

	public AverageAgeFirstChild(String region, Integer gender, Integer year, Double averageAge) {
		super(region, year);
		this.gender = gender;
		this.averageAge = averageAge;
	}

	public final Integer getGender() {
		return this.gender;
	}

	public final void setGender(Integer gender) {
		this.gender = gender;
	}

	public final Double getAverageAge() {
		return this.averageAge;
	}

	public final void setAverageAge(Double averageAge) {
		this.averageAge = averageAge;
	}

}
