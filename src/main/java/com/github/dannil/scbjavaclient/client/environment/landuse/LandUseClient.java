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

package com.github.dannil.scbjavaclient.client.environment.landuse;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.buildings.LandUseBuildingsClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.planning.LandUsePlanningClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.usage.LandUseUsageClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles environment land use data fetching.</p>
 *
 * @since 0.2.0
 */
public class LandUseClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public LandUseClient() {
        super();

        addClient("buildings", new LandUseBuildingsClient());
        addClient("planning", new LandUsePlanningClient());
        addClient("usage", new LandUseUsageClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LandUseClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with environment land use buildings
     * data.</p>
     *
     * @return a client for environment land use buildings data
     */
    public LandUseBuildingsClient buildings() {
        return (LandUseBuildingsClient) getClient("buildings");
    }

    /**
     * <p>Retrieve the client for interacting with environment land use planning data.</p>
     *
     * @return a client for environment land use planning data
     */
    public LandUsePlanningClient planning() {
        return (LandUsePlanningClient) getClient("planning");
    }

    /**
     * <p>Retrieve the client for interacting with environment land use usage data.</p>
     *
     * @return a client for environment land use usage data
     */
    public LandUseUsageClient usage() {
        return (LandUseUsageClient) getClient("usage");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0803/");
    }

}
