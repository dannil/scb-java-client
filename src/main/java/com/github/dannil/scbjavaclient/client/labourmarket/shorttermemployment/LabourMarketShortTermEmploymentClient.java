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
import com.github.dannil.scbjavaclient.client.labourmarket.shorttermemployment.population.LabourMarketShortTermEmploymentPopulationClient;
import com.github.dannil.scbjavaclient.client.labourmarket.shorttermemployment.sickleave.LabourMarketShortTermEmploymentSickLeaveClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * Client which handles labour market short-term employment data fetching.
 *
 * @since 0.3.0
 */
public class LabourMarketShortTermEmploymentClient extends AbstractContainerClient {

    /**
     * Default constructor. Initializes values and creates sub-clients.
     */
    public LabourMarketShortTermEmploymentClient() {
        super();

        addClient("population", new LabourMarketShortTermEmploymentPopulationClient());
        addClient("sickleave", new LabourMarketShortTermEmploymentSickLeaveClient());
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LabourMarketShortTermEmploymentClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * Retrieve the client for interacting with labour market short-term employment
     * population data.
     *
     * @return a client for labour market short-term employment population data
     */
    public LabourMarketShortTermEmploymentPopulationClient population() {
        return (LabourMarketShortTermEmploymentPopulationClient) getClient("population");
    }

    /**
     * Retrieve the client for interacting with labour market short-term employment
     * sick leave data.
     *
     * @return a client for labour market short-term employment sick leave data
     */
    public LabourMarketShortTermEmploymentSickLeaveClient sickLeave() {
        return (LabourMarketShortTermEmploymentSickLeaveClient) getClient("sickleave");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("AM/AM0201/");
    }

}
