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
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Localization {

	private Locale fallbackLocale;

	private ResourceBundle bundle;

	public Localization(Locale locale) {
		this.fallbackLocale = new Locale("en", "US");

		this.bundle = ResourceBundle.getBundle("language", locale);
	}

	public Locale getLanguage() {
		return this.bundle.getLocale();
	}

	public void setLanguage(Locale locale) {
		this.bundle = ResourceBundle.getBundle("language", locale);
	}

	public String getString(String key) {
		String s;
		try {
			s = this.bundle.getString(key);
		} catch (MissingResourceException e2) {
			s = ResourceBundle.getBundle("language", this.fallbackLocale).getString(key);
		}
		return s;
	}

	public String getString(String key, Object... args) {
		return String.format(getString(key), args);
		// return s;
	}

}
