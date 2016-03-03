package com.github.dannil.scbjavaclient.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbstractYearAndValueModel<Y, V> extends AbstractValueModel<V> {

	@JsonProperty("tid")
	protected Y year;

	public AbstractYearAndValueModel() {
		// To enable derived classes to use their default constructor
		super();
	}

	public AbstractYearAndValueModel(Y year, V value) {
		super(value);
		this.year = year;
	}

	public Y getYear() {
		return this.year;
	}

	public void setYear(Y year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractYearAndValueModel<?, ?>)) {
			return false;
		}

		AbstractYearAndValueModel<?, ?> other = (AbstractYearAndValueModel<?, ?>) obj;
		return super.equals(other) && Objects.equals(this.year, other.year);
	}

}
