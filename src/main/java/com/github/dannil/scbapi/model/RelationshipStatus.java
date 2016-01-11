package com.github.dannil.scbapi.model;

public enum RelationshipStatus {
	UNMARRIED("OG"), MARRIED("G"), DIVORCED("SK"), WIDOW("ÄNKL");

	private final String value;

	private RelationshipStatus(String value) {
		this.value = value;
	}

	public static RelationshipStatus of(String value) {
		if (value == null) {
			return null;
		}

		for (RelationshipStatus status : values()) {
			if (status.value.equals(value)) {
				return status;
			}
		}
		throw new IllegalArgumentException(value);
	}

	@Override
	public String toString() {
		return this.value;
	}
}
