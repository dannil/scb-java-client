/*
 * Copyright 2017 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.livingconditions.families;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import com.github.dannil.scbjavaclient.utility.URLUtility;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LivingConditionsFamiliesClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        LivingConditionsFamiliesClient client = new LivingConditionsFamiliesClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void housingClient() {
        LivingConditionsFamiliesClient client = new LivingConditionsFamiliesClient();

        assertNotNull(client.housing());
    }

    @Test
    public void legalGuardiansClient() {
        LivingConditionsFamiliesClient client = new LivingConditionsFamiliesClient();

        assertNotNull(client.legalGuardians());
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        LivingConditionsFamiliesClient client = new LivingConditionsFamiliesClient(locale);

        assertEquals(URLUtility.getRootUrl(locale) + "LE/LE0102/", client.getUrl());
    }

}
