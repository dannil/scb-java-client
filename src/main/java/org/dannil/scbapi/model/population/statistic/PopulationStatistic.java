package org.dannil.scbapi.model.population.statistic;

public final class PopulationStatistic extends AbstractPopulationStatisticModel {

	private Integer gender;
	private Long amount;

	public PopulationStatistic() {
		super();
	}

	public PopulationStatistic(String region, Integer gender, Integer year, Long amount) {
		super(region, year);
		this.gender = gender;
		this.amount = amount;
	}

	public final Integer getGender() {
		return this.gender;
	}

	public final void setGender(Integer gender) {
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
		return "PopulationStatistic [region=" + super.region + ", year=" + super.year + ", gender=" + this.gender + ", amount=" + this.amount + "]";
	}

}
