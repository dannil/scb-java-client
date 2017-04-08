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

package com.github.dannil.scbjavaclient.client.livingconditions.surveys;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.livingconditions.surveys.employment.EmploymentClient;
import com.github.dannil.scbjavaclient.client.livingconditions.surveys.health.HealthClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles living conditions surveys data fetching.</p>
 *
 * @since 0.2.0
 */
public class SurveysClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public SurveysClient() {
        super();

        addClient("employment", new EmploymentClient());
        addClient("health", new HealthClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public SurveysClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with living conditions surveys employment
     * data.</p>
     *
     * @return a client for living conditions surveys employment data
     */
    public EmploymentClient employment() {
        return (EmploymentClient) getClient("employment");
    }

    /**
     * <p>Retrieve the client for interacting with living conditions surveys health
     * data.</p>
     *
     * @return a client for living conditions surveys health data
     */
    public HealthClient health() {
        return (HealthClient) getClient("health");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("LE/LE0101/");
    }

}
