package com.github.dannil.scbapi.model;

import java.util.Objects;

public abstract class AbstractRegionAndYearModel<R, Y> {

	protected R region;
	protected Y year;

	protected AbstractRegionAndYearModel() {
		// To enable derived classes to use their default constructor
	}

	protected AbstractRegionAndYearModel(R region, Y year) {
		this.region = region;
		this.year = year;
	}

	public R getRegion() {
		return this.region;
	}

	public void setRegion(R region) {
		this.region = region;
	}

	public Y getYear() {
		return this.year;
	}

	public void setYear(Y year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.region, this.year);
	}

	@Override
	public boolean equals(Object obj) {
		AbstractRegionAndYearModel<?, ?> other = (AbstractRegionAndYearModel<?, ?>) obj;
		return Objects.equals(this.region, other.region) && Objects.equals(this.year, other.year);
	}

}
