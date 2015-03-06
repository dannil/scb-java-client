package org.dannil.scbapi.model.population;

public final class Statistic {

	private String region;
	private Integer year;
	private Long amount;

	public Statistic() {

	}

	public Statistic(String region, Integer year, Long amount) {
		this.region = region;
		this.year = year;
		this.amount = amount;
	}

	public final String getRegion() {
		return this.region;
	}

	public final void setRegion(String region) {
		this.region = region;
	}

	public final Integer getYear() {
		return this.year;
	}

	public final void setYear(Integer year) {
		this.year = year;
	}

	public final Long getAmount() {
		return this.amount;
	}

	public final void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Population [region=" + this.region + ", year=" + this.year + ", amount=" + this.amount + "]";
	}

}
