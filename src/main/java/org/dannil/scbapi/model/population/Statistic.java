package org.dannil.scbapi.model.population;

public final class Statistic extends AbstractPopulationModel {

	private Long amount;

	public Statistic() {

	}

	public Statistic(String region, Integer year, Long amount) {
		super.region = region;
		super.year = year;
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
		return "Population [region=" + super.region + ", year=" + super.year + ", amount=" + this.amount + "]";
	}

}
