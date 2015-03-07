package org.dannil.scbapi.model.population;

public final class Statistic extends AbstractPopulationModel {

	private Long amount;

	public Statistic() {
		super();
	}

	public Statistic(String region, Integer year, Long amount) {
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
		return "Statistic [region=" + super.region + ", year=" + super.year + ", amount=" + this.amount + "]";
	}

}
