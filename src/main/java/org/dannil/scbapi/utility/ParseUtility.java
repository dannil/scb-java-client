package org.dannil.scbapi.utility;

public class ParseUtility {

	public static Integer parseInteger(String string, Object defaultValue) {
		try {
			return Integer.valueOf(string);
		} catch (NumberFormatException e) {
			if (defaultValue == null) {
				return null;
			}
			return (int) defaultValue;
		}
	}

	public static Long parseLong(String string, Object defaultValue) {
		try {
			return Long.valueOf(string);
		} catch (NumberFormatException e) {
			if (defaultValue == null) {
				return null;
			}
			return (long) defaultValue;
		}
	}

	public static Double parseDouble(String string, Object defaultValue) {
		try {
			return Double.valueOf(string);
		} catch (NumberFormatException e) {
			if (defaultValue == null) {
				return null;
			}
			return (double) defaultValue;
		}
	}

}
