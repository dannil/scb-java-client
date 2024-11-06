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

package com.github.dannil.scbjavaclient.client.livingconditions;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.livingconditions.families.LivingConditionsFamiliesClient;
import com.github.dannil.scbjavaclient.client.livingconditions.surveys.LivingConditionsSurveysClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * Client which handles living conditions data fetching.
 *
 * @since 0.2.0
 */
public class LivingConditionsClient extends AbstractContainerClient {

    /**
     * Default constructor. Initializes values and creates sub-clients.
     */
    public LivingConditionsClient() {
        super();

        addClient("families", new LivingConditionsFamiliesClient());
        addClient("surveys", new LivingConditionsSurveysClient());
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LivingConditionsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * Retrieve the client for interacting with living conditions families data.
     *
     * @return a client for living conditions families data
     */
    public LivingConditionsFamiliesClient families() {
        return (LivingConditionsFamiliesClient) getClient("families");
    }

    /**
     * Retrieve the client for interacting with living conditions surveys data.
     *
     * @return a client for living conditions surveys data
     */
    public LivingConditionsSurveysClient surveys() {
        return (LivingConditionsSurveysClient) getClient("surveys");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("LE/");
    }

}
