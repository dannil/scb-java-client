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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Locale;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.Test;

@Suite
public class LocalizationTest {

    @Test
    public void createWithConstructor() {
        Localization localization = new Localization(new Locale("sv", "SE"));

        assertEquals(new Locale("sv", "SE"), localization.getLocale());
    }

    @Test
    public void createWithConstructorNullArgument() {
        assertThrows(NullPointerException.class, () -> new Localization(null));
    }
    
    @Test
    public void getStringNullArgument() {
        Localization localization = new Localization(new Locale("sv", "SE"));

        assertThrows(NullPointerException.class, () -> localization.getString(null));
    }

    @Test
    public void getString() {
        Localization localization = new Localization(new Locale("sv", "SE"));

        assertEquals("TestSvenska", localization.getString("test"));
    }
    
    @Test
    public void getStringBritishEnglish() {
        Localization localization = new Localization(new Locale("en", "GB"));
        
        assertEquals("TestBritishEnglish", localization.getString("test"));
    }
    
    @Test
    public void getStringAmericanEnglish() {
        Localization localization = new Localization(new Locale("en", "US"));

        assertEquals("TestAmericanEnglish", localization.getString("test"));
    }
    
    @Test
    public void getStringFallback() {
        Localization localization = new Localization(new Locale("sv", "SE"));

        assertNotEquals(new Locale("en", "US"), localization.getLocale());
        assertEquals("UniqueAmericanEnglish", localization.getString("unique_american"));
    }
    
    @Test
    public void getStringUniqueWithSetLocale() {
        Localization localization = new Localization(new Locale("sv", "SE"));
        
        assertEquals("TestSvenska", localization.getString("test"));
        localization.setLocale(new Locale("en", "GB"));
        assertEquals("UniqueEnglishBritish", localization.getString("unique_british"));
    }

    @Test
    public void getStringFormatAmericanEnglish() {
        Localization localization = new Localization(new Locale("en", "US"));

        Object[] variables = new Object[] { "http://www.abc.com" };

        String translation = localization.getString("regions_is_not_supported_for_url", variables);

        assertEquals("Regions is not supported for URL " + variables[0], translation);
    }

    @Test
    public void getStringFormatSwedish() {
        Localization localization = new Localization(new Locale("sv", "SE"));

        Object[] variables = new Object[] { "http://www.abc.com" };

        String translation = localization.getString("regions_is_not_supported_for_url", variables);

        assertEquals("Regioner stöds inte för URL " + variables[0], translation);
    }

    @Test
    public void getStringFormatFrenchEscapedCharacters() {
        Localization localization = new Localization(new Locale("fr", "FR"));

        Object[] variables = new Object[] { "http://www.abc.com" };

        String translation = localization.getString("regions_is_not_supported_for_url", variables);

        assertEquals("Les régions ne sont pas prises en charge pour l'URL " + variables[0], translation);
    }

    @Test
    public void setLanguage() {
        Localization localization = new Localization(new Locale("sv", "SE"));

        assertEquals("TestSvenska", localization.getString("test"));
        localization.setLocale(new Locale("en", "US"));
        assertEquals("TestAmericanEnglish", localization.getString("test"));
    }

}
