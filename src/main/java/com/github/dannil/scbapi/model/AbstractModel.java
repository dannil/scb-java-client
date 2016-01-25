package com.github.dannil.scbapi.model;

import java.util.Objects;

public abstract class AbstractModel<Y> {

	protected Y value;

	protected AbstractModel() {

	}

	protected AbstractModel(Y value) {
		this.value = value;
	}

	public Y getValue() {
		return this.value;
	}

	public void setValue(Y value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractModel<?>)) {
			return false;
		}

		AbstractModel<?> other = (AbstractModel<?>) obj;
		return Objects.equals(this.value, other.value);
	}

}
