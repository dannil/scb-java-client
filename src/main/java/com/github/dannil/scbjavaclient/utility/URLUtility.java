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
public final class URLUtility {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private URLUtility() {

	}

	/**
	 * Generates a new URL to the API using the fallback locale (Swedish). See
	 * {@link #changeLanguageForUrl(String, String) } for implementation details.
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
	 * Generates a new URL to the API using the specified locale. See
	 * {@link #changeLanguageForUrl(String, String) } for implementation details.
	 *
	 * @param url
	 *            the URL to edit
	 * @param locale
	 *            the locale to use
	 * @return the modified URL
	 */
	public static String changeLanguageForUrl(String url, Locale locale) {
		return changeLanguageForUrl(url, locale.getLanguage());
	}

	/**
	 * Generates a new URL to the API by replacing the current language tag in the URL with
	 * the specified language.
	 * 
	 * @param url
	 *            the URL to edit
	 * @param language
	 *            the language to use
	 * @return the modified URL
	 */
	public static String changeLanguageForUrl(String url, String language) {
		// Specify the starting point. For this implementation, the starting point is the segment
		// preceding the language tag segment in the URL
		String startPoint = "doris";

		// Find the index where the language tag starts
		int start = url.indexOf(startPoint) + startPoint.length() + 1;
		// Find the index where the language tag ends
		int end = start + language.length();

		// Replace the contents between start and end index with our new language tag
		StringBuilder builder = new StringBuilder(url);
		builder.replace(start, end, language);

		return builder.toString();
	}
}
