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

import java.util.Locale;

/**
 * Utility class which handles URL operations.
 * 
 * @author Daniel Nilsson
 */
public class URLUtility {

	private URLUtility() {

	}

	/**
	 * Generates a new URL to the API by replacing the current locale in the URL with the default
	 * fallback locale's language (swedish).
	 *
	 * @param url
	 *            the URL to edit
	 * @return the modified URL
	 */
	public static String changeLanguageForUrl(String url) {
		Locale fallback = new Locale("sv", "SE");
		return changeLanguageForUrl(url, fallback);
	}

	/**
	 * Generates a new URL to the API by replacing the current locale in the URL with the specified
	 * fallback locale.
	 *
	 * @param url
	 *            the URL to edit
	 * @param fallback
	 *            the fallback locale to use
	 * @return the modified URL
	 */
	public static String changeLanguageForUrl(String url, Locale fallback) {
		String startPoint = "doris";

		int start = url.indexOf(startPoint) + startPoint.length() + 1;
		int end = start + url.substring(start).indexOf('/');

		StringBuilder builder = new StringBuilder(url);
		builder.replace(start, end, fallback.getLanguage());

		return builder.toString();
	}

}
