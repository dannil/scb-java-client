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
import com.github.dannil.scbjavaclient.client.environment.landuse.buildings.EnvironmentLandUseBuildingsClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.infrastructurefortransport.EnvironmentLandUseInfrastructureForTransportClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.planning.EnvironmentLandUsePlanningClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.usage.EnvironmentLandUseUsageClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * Client which handles environment land use data fetching.
 *
 * @since 0.2.0
 */
public class EnvironmentLandUseClient extends AbstractContainerClient {

    /**
     * Default constructor. Initializes values and creates sub-clients.
     */
    public EnvironmentLandUseClient() {
        super();

        addClient("buildings", new EnvironmentLandUseBuildingsClient());
        addClient("infrastructurefortransport", new EnvironmentLandUseInfrastructureForTransportClient());
        addClient("planning", new EnvironmentLandUsePlanningClient());
        addClient("usage", new EnvironmentLandUseUsageClient());
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLandUseClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * Retrieve the client for interacting with environment land use buildings
     * data.
     *
     * @return a client for environment land use buildings data
     */
    public EnvironmentLandUseBuildingsClient buildings() {
        return (EnvironmentLandUseBuildingsClient) getClient("buildings");
    }

    /**
     * Retrieve the client for interacting with environment land use infrastructure for
     * transport data.
     *
     * @return a client for environment land use infrastructure for transport data
     */
    public EnvironmentLandUseInfrastructureForTransportClient infrastructureForTransport() {
        return (EnvironmentLandUseInfrastructureForTransportClient) getClient("infrastructurefortransport");
    }

    /**
     * Retrieve the client for interacting with environment land use planning data.
     *
     * @return a client for environment land use planning data
     */
    public EnvironmentLandUsePlanningClient planning() {
        return (EnvironmentLandUsePlanningClient) getClient("planning");
    }

    /**
     * Retrieve the client for interacting with environment land use usage data.
     *
     * @return a client for environment land use usage data
     */
    public EnvironmentLandUseUsageClient usage() {
        return (EnvironmentLandUseUsageClient) getClient("usage");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0803/");
    }

}
