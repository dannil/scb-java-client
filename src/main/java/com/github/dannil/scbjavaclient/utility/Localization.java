/*
 * Copyright 2016 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.utility;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.github.dannil.scbjavaclient.constants.ClientConstants;

/**
 * <p>Class for handling localization for the clients.</p>
 *
 * @since 0.0.1
 */
public class Localization {

    private String baseName;

    private Locale fallbackLocale;

    private ResourceBundle bundle;

    /**
     * <p>Private constructor. Initializes encoding control for the resource bundles.</p>
     */
    private Localization() {
        this.baseName = ClientConstants.LOCALIZATION_TRANSLATION_FILE_PREFIX;
        this.fallbackLocale = ClientConstants.LOCALIZATION_FALLBACK_LOCALE;
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this localization instance
     */
    public Localization(Locale locale) {
        this();
        this.bundle = ResourceBundle.getBundle(this.baseName, locale);
    }

    /**
     * <p>Getter for the <code>Locale</code> of this localization instance.</p>
     *
     * @return the <code>Locale</code> for this localization instance.
     */
    public Locale getLocale() {
        return this.bundle.getLocale();
    }

    /**
     * <p>Setter for the <code>Locale</code> for this localization instance.</p>
     *
     * @param locale
     *            the <code>Locale</code>
     */
    public void setLocale(Locale locale) {
        this.bundle = ResourceBundle.getBundle(this.baseName, locale);
    }

    /**
     * <p>Returns the translation for the specified key. If it can't find the key in the
     * current specified language's localization file, it attempts to use the fallback
     * <code>Locale</code>'s localization file as the translation source.</p>
     *
     * @param key
     *            the key to get the translation for
     * @return the translated string
     */
    public String getString(String key) {
        try {
            return this.bundle.getString(key);
        } catch (MissingResourceException e) {
            return ResourceBundle.getBundle(this.baseName, this.fallbackLocale).getString(key);
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

}
