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

public class URLUtility {

	private URLUtility() {

	}

	/**
	 * Generates a new URL to the API by replacing the current locale present in the URL (defined
	 * by the input locale) with the fallback locale.
	 *
	 * @param url
	 *            the URL to edit
	 * @return the modified URL
	 */
	public static String changeUrlLocale(String url) {
		String apiName = "doris";

		int start = url.indexOf(apiName) + apiName.length() + 1;
		String atLanguage = url.substring(start);
		int end = start + atLanguage.indexOf('/');

		Locale fallback = new Locale("sv", "SE");

		StringBuilder builder = new StringBuilder(url);
		builder.replace(start, end, fallback.getLanguage());

		return builder.toString();
	}
}
