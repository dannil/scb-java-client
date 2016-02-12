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

package com.github.dannil.scbapi.utility;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {

	private static ResourceBundle bundle;

	public static void setLanguage(Locale locale) {
		bundle = ResourceBundle.getBundle("language", locale);
	}

	public static String getString(String key, Object... args) {
		String s = bundle.getString(key);
		if (s == null) {
			s = ResourceBundle.getBundle("language", new Locale("en", "US")).getString(key);
		}

		return String.format(s, args);

		// return s;
	}
}
