package org.dannil.scbapi.model.population.statistic;

public final class PopulationStatistic extends AbstractPopulationStatisticModel {

	private Long amount;

	public PopulationStatistic() {
		super();
	}

	public PopulationStatistic(String region, Integer year, Long amount) {
		super(region, year);
		this.amount = amount;
	}

	public final Long getAmount() {
		return this.amount;
	}

	public final void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PopulationStatistic [region=" + super.region + ", year=" + super.year + ", amount=" + this.amount + "]";
	}

}
