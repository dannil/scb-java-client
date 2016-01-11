package com.github.dannil.scbapi.model;

public enum Gender {
	MAN(1), WOMAN(2);

	private final Integer value;

	private Gender(Integer value) {
		this.value = value;
	}

	public static Gender of(Integer value) {
		if (value == null) {
			return null;
		}

		for (Gender gender : values()) {
			if (gender.value.equals(value)) {
				return gender;
			}
		}
		throw new IllegalArgumentException(String.valueOf(value));
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}
