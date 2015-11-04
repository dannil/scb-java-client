/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package com.github.dannil.scbapi.utility;

public class ParseUtility {
	
	public static Integer parseInteger(String string) {
		return parseInteger(string, null);
	}

	public static Integer parseInteger(String string, Object defaultValue) {
		try {
			return Integer.valueOf(string);
		} catch (NumberFormatException e) {
			if (defaultValue == null) {
				return null;
			}
			return (Integer) defaultValue;
		}
	}
	
	public static Long parseLong(String string) {
		return parseLong(string, null);
	}

	public static Long parseLong(String string, Object defaultValue) {
		try {
			return Long.valueOf(string);
		} catch (NumberFormatException e) {
			if (defaultValue == null) {
				return null;
			}
			return (Long) defaultValue;
		}
	}
	
	public static Double parseDouble(String string) {
		return parseDouble(string, null);
	}

	public static Double parseDouble(String string, Object defaultValue) {
		try {
			return Double.valueOf(string);
		} catch (NumberFormatException e) {
			if (defaultValue == null) {
				return null;
			}
			return (Double) defaultValue;
		}
	}

}
