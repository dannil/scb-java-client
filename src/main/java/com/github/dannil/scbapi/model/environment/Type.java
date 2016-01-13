package com.github.dannil.scbapi.model.environment;

public enum Type {
	LANDAREA("01"), INLANDWATEREXCLUDINGTHEFOURLARGELAKES("02"), THEFOURLARGELAKES("03"), SEAWATER("04");

	private final String value;

	private Type(String value) {
		this.value = value;
	}

	public static Type of(String value) {
		if (value == null) {
			return null;
		}

		for (Type type : values()) {
			if (type.value.equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException(value);
	}

	@Override
	public String toString() {
		return this.value;
	}
}
