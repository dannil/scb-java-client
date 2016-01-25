package com.github.dannil.scbapi.model;

import java.util.Objects;

public class AbstractRegionAndYearModel<R, Y, V> extends AbstractModel<V> {

	protected R region;
	protected Y year;

	protected AbstractRegionAndYearModel() {
		// To enable derived classes to use their default constructor
	}

	protected AbstractRegionAndYearModel(R region, Y year, V value) {
		super(value);
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractRegionAndYearModel<?, ?, ?>)) {
			return false;
		}

		AbstractRegionAndYearModel<?, ?, ?> other = (AbstractRegionAndYearModel<?, ?, ?>) obj;
		return super.equals(other) && Objects.equals(this.region, other.region) && Objects.equals(this.year, other.year);
	}

}
