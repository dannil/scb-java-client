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

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.livingconditions.families.adoptions.LivingConditionsFamiliesAdoptionsClient;
import com.github.dannil.scbjavaclient.client.livingconditions.families.housing.LivingConditionsFamiliesHousingClient;
import com.github.dannil.scbjavaclient.client.livingconditions.families.legalguardians.LivingConditionsFamiliesLegalGuardiansClient;
import com.github.dannil.scbjavaclient.client.livingconditions.families.siblings.LivingConditionsFamiliesSiblingsClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

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
    public void adoptionsClient() {
        LivingConditionsFamiliesClient client = new LivingConditionsFamiliesClient();

        assertEquals(client.adoptions().getClass(), LivingConditionsFamiliesAdoptionsClient.class);
    }

    @Test
    public void housingClient() {
        LivingConditionsFamiliesClient client = new LivingConditionsFamiliesClient();

        assertEquals(client.housing().getClass(), LivingConditionsFamiliesHousingClient.class);
    }

    @Test
    public void legalGuardiansClient() {
        LivingConditionsFamiliesClient client = new LivingConditionsFamiliesClient();

        assertEquals(client.legalGuardians().getClass(), LivingConditionsFamiliesLegalGuardiansClient.class);
    }

    @Test
    public void siblingsClient() {
        LivingConditionsFamiliesClient client = new LivingConditionsFamiliesClient();

        assertEquals(client.siblings().getClass(), LivingConditionsFamiliesSiblingsClient.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        LivingConditionsFamiliesClient client = new LivingConditionsFamiliesClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("LE/LE0102/"), client.getUrl());
    }

}
