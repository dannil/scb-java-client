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

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;

/**
 * <p>Client which handles living conditions families data fetching.</p>
 *
 * @since 0.2.0
 */
public class LivingConditionsFamiliesClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public LivingConditionsFamiliesClient() {
        super();

        //
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LivingConditionsFamiliesClient(Locale locale) {
        this();

        setLocale(locale);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "LE/LE0102/";
    }

}