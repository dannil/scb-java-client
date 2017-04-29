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

package com.github.dannil.scbjavaclient.client.labourmarket.shorttermemployment;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.labourmarket.shorttermemployment.population.PopulationClient;
import com.github.dannil.scbjavaclient.client.labourmarket.shorttermemployment.sickleave.SickLeaveClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles labour market short-term employment data fetching.</p>
 *
 * @since 0.3.0
 */
public class ShortTermEmploymentClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public ShortTermEmploymentClient() {
        super();

        addClient("population", new PopulationClient());
        addClient("sickleave", new SickLeaveClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public ShortTermEmploymentClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with labour market short-term employment
     * population data.</p>
     *
     * @return a client for labour market short-term employment population data
     */
    public PopulationClient population() {
        return (PopulationClient) getClient("population");
    }

    /**
     * <p>Retrieve the client for interacting with labour market short-term employment
     * sick leave data.</p>
     *
     * @return a client for labour market short-term employment sick leave data
     */
    public SickLeaveClient sickLeave() {
        return (SickLeaveClient) getClient("sickleave");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("AM/AM0201/");
    }

}
