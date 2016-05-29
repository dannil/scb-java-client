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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Class for handling localization for the clients.
 * 
 * @author Daniel Nilsson
 */
public class Localization {

	private Locale fallbackLocale;

	private ResourceBundle bundle;

	private ResourceBundleEncodingControl encodingControl;

	/**
	 * Private constructor. Initializes encoding control for the resource bundles.
	 */
	private Localization() {
		this.encodingControl = new ResourceBundleEncodingControl("UTF-8");
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param locale
	 *            the locale for this localization instance
	 */
	public Localization(Locale locale) {
		this();
		this.fallbackLocale = new Locale("en", "US");

		this.bundle = ResourceBundle.getBundle("language", locale, this.encodingControl);
	}

	/**
	 * Getter for the language for this localization instance. This is the same as the locale
	 * specified in {@link Localization#getLanguage() getLanguage()}.
	 * 
	 * @return the language for this localization instance.
	 */
	public Locale getLanguage() {
		return this.bundle.getLocale();
	}

	/**
	 * Setter for the language for this localization instance.
	 * 
	 * @param locale
	 *            the locale
	 */
	public void setLanguage(Locale locale) {
		this.bundle = ResourceBundle.getBundle("language", locale, this.encodingControl);
	}

	/**
	 * Returns the translation for the specified key. If it can't find the key in the current
	 * specified language's localization file, it attempts to use the fallback locale's localization
	 * file as the translation source.
	 * 
	 * @param key
	 *            the key to get the translation for
	 * @return the translated string
	 */
	public String getString(String key) {
		String s;
		try {
			s = this.bundle.getString(key);
		} catch (MissingResourceException e2) {
			s = ResourceBundle.getBundle("language", this.fallbackLocale).getString(key);
		}
		return s;
	}

	/**
	 * Returns a formatted translation for the specified key.
	 * 
	 * @param key
	 *            the key to get the translation for
	 * @param variables
	 *            the variables which shall be inserted into the translation
	 * @return the translated string
	 */
	public String getString(String key, Object... variables) {
		MessageFormat formatter = new MessageFormat("");

		Locale locale = getLanguage().equals(this.fallbackLocale) ? this.fallbackLocale : getLanguage();
		formatter.setLocale(locale);

		formatter.applyPattern(getString(key));
		return formatter.format(variables);
	}

	/**
	 * Class to handle non-ASCII encodings for {@link java.util.ResourceBundle ResourceBundle}, such
	 * as UTF-8.
	 * 
	 * @author Daniel Nilsson
	 */
	private class ResourceBundleEncodingControl extends ResourceBundle.Control {

		private String encoding;

		/**
		 * Overloaded constructor.
		 * 
		 * @param encoding
		 *            the encoding to use (i.e. UTF-8)
		 */
		protected ResourceBundleEncodingControl(String encoding) {
			this.encoding = encoding;
		}

		@Override
		public List<String> getFormats(String baseName) {
			if (baseName == null) {
				throw new IllegalArgumentException();
			}
			return Arrays.asList("properties");
		}

		@Override
		public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader,
				boolean reload) {

			if (baseName == null || locale == null || format == null || loader == null) {
				throw new IllegalArgumentException();
			}

			if (format.equals("properties")) {
				String bundleName = toBundleName(baseName, locale);
				String resourceName = toResourceName(bundleName, format);
				InputStream stream = null;

				try {
					stream = loader.getResourceAsStream(resourceName);

					if (stream != null) {
						try (InputStreamReader is2 = new InputStreamReader(stream, this.encoding)) {
							ResourceBundle bundle = new PropertyResourceBundle(is2);
							return bundle;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	}

}
