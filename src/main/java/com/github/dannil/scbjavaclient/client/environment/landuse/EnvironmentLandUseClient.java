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
import com.github.dannil.scbjavaclient.client.environment.landuse.planning.EnvironmentLandUsePlanningClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.usage.EnvironmentLandUseUsageClient;

/**
 * <p>Client which handles environment land use data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnvironmentLandUseClient extends AbstractContainerClient {

    private EnvironmentLandUseBuildingsClient environmentLandUseBuildingsClient;

    private EnvironmentLandUsePlanningClient environmentLandUsePlanningClient;

    private EnvironmentLandUseUsageClient environmentLandUseUsageClient;

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public EnvironmentLandUseClient() {
        super();

        this.environmentLandUseBuildingsClient = new EnvironmentLandUseBuildingsClient();
        addClient(this.environmentLandUseBuildingsClient);

        this.environmentLandUsePlanningClient = new EnvironmentLandUsePlanningClient();
        addClient(this.environmentLandUsePlanningClient);

        this.environmentLandUseUsageClient = new EnvironmentLandUseUsageClient();
        addClient(this.environmentLandUseUsageClient);
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentLandUseClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with environment land use buildings
     * data.</p>
     *
     * @return a client for environment land use buildings data
     */
    public EnvironmentLandUseBuildingsClient buildings() {
        return this.environmentLandUseBuildingsClient;
    }

    /**
     * <p>Retrieve the client for interacting with environment land use planning data.</p>
     *
     * @return a client for environment land use planning data
     */
    public EnvironmentLandUsePlanningClient planning() {
        return this.environmentLandUsePlanningClient;
    }

    /**
     * <p>Retrieve the client for interacting with environment land use usage data.</p>
     *
     * @return a client for environment land use usage data
     */
    public EnvironmentLandUseUsageClient usage() {
        return this.environmentLandUseUsageClient;
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "MI/MI0803/";
    }

}
