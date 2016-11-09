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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.dannil.scbjavaclient.constants.ClientConstants;

/**
 * <p>Class for handling localization for the clients.</p>
 * 
 * @author Daniel Nilsson
 */
public class Localization {

	private ResourceBundle bundle;

	private ResourceBundleEncodingControl encodingControl;

	/**
	 * <p>Private constructor. Initializes encoding control for the resource bundles.</p>
	 */
	private Localization() {
		this.encodingControl = new ResourceBundleEncodingControl("UTF-8");
	}

	/**
	 * <p>Overloaded constructor.</p>
	 * 
	 * @param locale
	 *            the <code>Locale</code> for this localization instance
	 */
	public Localization(Locale locale) {
		this();
		this.bundle = ResourceBundle.getBundle(ClientConstants.LOCALIZATION_TRANSLATION_FILE_PREFIX, locale, this.encodingControl);
	}

	/**
	 * <p>Getter for the <code>Locale</code> of this localization instance. <p>
	 * 
	 * @return the <code>Locale</code> for this localization instance.
	 */
	public Locale getLocale() {
		return this.bundle.getLocale();
	}

	/**
	 * <p>Setter for the <code>Locale</code> for this localization instance. </p>
	 * 
	 * @param locale
	 *            the <code>Locale</code>
	 */
	public void setLocale(Locale locale) {
		this.bundle = ResourceBundle.getBundle(ClientConstants.LOCALIZATION_TRANSLATION_FILE_PREFIX, locale, this.encodingControl);
	}

	/**
	 * <p>Returns the translation for the specified key. If it can't find the key in the current
	 * specified language's localization file, it attempts to use the fallback <code>Locale</code>'s
	 * localization file as the translation source.</p>
	 * 
	 * @param key
	 *            the key to get the translation for
	 * @return the translated string
	 */
	public String getString(String key) {
		try {
			return this.bundle.getString(key);
		} catch (MissingResourceException e2) {
			return ResourceBundle
					.getBundle(ClientConstants.LOCALIZATION_TRANSLATION_FILE_PREFIX, ClientConstants.LOCALIZATION_FALLBACK_LOCALE, this.encodingControl)
					.getString(key);
		}
	}

	/**
	 * <p>Returns a formatted translation for the specified key.</p>
	 * 
	 * @param key
	 *            the key to get the translation for
	 * @param variables
	 *            the variables which shall be inserted into the translation
	 * @return the translated string
	 */
	public String getString(String key, Object... variables) {
		MessageFormat formatter = new MessageFormat("");

		formatter.setLocale(getLocale());

		formatter.applyPattern(getString(key));
		return formatter.format(variables);
	}

	/**
	 * <p>Class to handle non-ASCII encodings for {@link java.util.ResourceBundle ResourceBundle},
	 * such as UTF-8.</p>
	 * 
	 * @author Daniel Nilsson
	 */
	private static class ResourceBundleEncodingControl extends ResourceBundle.Control {

		private static final Logger LOGGER = LogManager.getLogger(ResourceBundleEncodingControl.class);

		private String encoding;

		/**
		 * <p>Overloaded constructor.</p>
		 * 
		 * @param encoding
		 *            the encoding to use (i.e. UTF-8)
		 */
		protected ResourceBundleEncodingControl(String encoding) {
			super();
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
		public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) {
			if (baseName == null || locale == null || format == null || loader == null) {
				throw new IllegalArgumentException();
			}

			if ("properties".equals(format)) {
				String bundleName = toBundleName(baseName, locale);
				String resourceName = toResourceName(bundleName, format);

				try (InputStream stream = loader.getResourceAsStream(resourceName)) {
					try (InputStreamReader streamReader = new InputStreamReader(stream, this.encoding)) {
						ResourceBundle bundle = new PropertyResourceBundle(streamReader);
						return bundle;
					}
				} catch (IOException e) {
					LOGGER.error(e);
				}
			}
			return null;
		}
	}

}
