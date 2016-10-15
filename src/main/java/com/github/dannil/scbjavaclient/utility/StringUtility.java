/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.utility;

/**
 * Utility class for manipulation on <code>String</code> objects.
 * 
 * @author Daniel Nilsson
 */
public class StringUtility {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private StringUtility() {

	}

	/**
	 * Converts the first character in the <code>String<code> to its lower case equivalent.
	 * 
	 * @param str
	 *            the <code>String</code> to convert
	 * @return a <code>String</code> object with the first character as lower case
	 */
	public static String lowerCaseFirstLetter(String str) {
		char[] c = str.toCharArray();
		c[0] = Character.toLowerCase(c[0]);
		return new String(c);
	}

}
