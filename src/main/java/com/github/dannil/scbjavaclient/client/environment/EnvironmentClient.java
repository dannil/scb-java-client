/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.environment;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.environment.industrialwateruse.EnvironmentIndustrialWaterUseClient;
import com.github.dannil.scbjavaclient.client.environment.landandwaterarea.EnvironmentLandAndWaterAreaClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.EnvironmentLandUseClient;
import com.github.dannil.scbjavaclient.client.environment.packagingandpackagingwaste.EnvironmentPackagingAndPackagingWasteClient;
import com.github.dannil.scbjavaclient.client.environment.waste.EnvironmentWasteClient;

/**
 * <p>Client which handles environment data fetching.</p>
 *
 * @since 0.0.2
 */
public class EnvironmentClient extends AbstractContainerClient {

    private EnvironmentIndustrialWaterUseClient environmentIndustrialWaterUseClient;

    private EnvironmentLandAndWaterAreaClient environmentLandAndWaterAreaClient;

    private EnvironmentLandUseClient environmentLandUseClient;

    private EnvironmentPackagingAndPackagingWasteClient environmentPackagingAndPackagingWasteClient;

    private EnvironmentWasteClient environmentWasteClient;

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public EnvironmentClient() {
        super();

        this.environmentIndustrialWaterUseClient = new EnvironmentIndustrialWaterUseClient();
        addClient(this.environmentIndustrialWaterUseClient);

        this.environmentLandAndWaterAreaClient = new EnvironmentLandAndWaterAreaClient();
        addClient(this.environmentLandAndWaterAreaClient);

        this.environmentLandUseClient = new EnvironmentLandUseClient();
        addClient(this.environmentLandUseClient);

        this.environmentPackagingAndPackagingWasteClient = new EnvironmentPackagingAndPackagingWasteClient();
        addClient(this.environmentPackagingAndPackagingWasteClient);

        this.environmentWasteClient = new EnvironmentWasteClient();
        addClient(this.environmentWasteClient);
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with environment industrial water use
     * data.</p>
     *
     * @return a client for environment industrial water use data
     */
    public EnvironmentIndustrialWaterUseClient industrialWaterUse() {
        return this.environmentIndustrialWaterUseClient;
    }

    /**
     * <p>Retrieve the client for interacting with environment land and water area
     * data.</p>
     *
     * @return a client for environment land and water area data
     */
    public EnvironmentLandAndWaterAreaClient landAndWaterArea() {
        return this.environmentLandAndWaterAreaClient;
    }

    /**
     * <p>Retrieve the client for interacting with environment land use data.</p>
     *
     * @return a client for environment land use data
     */
    public EnvironmentLandUseClient landUse() {
        return this.environmentLandUseClient;
    }

    /**
     * <p>Retrieve the client for interacting with environment packaging and packaging
     * waste data.</p>
     *
     * @return a client for environment packaging and packaging waste data
     */
    public EnvironmentPackagingAndPackagingWasteClient packagingAndPackagingWaste() {
        return this.environmentPackagingAndPackagingWasteClient;
    }

    /**
     * <p>Retrieve the client for interacting with environment waste data.</p>
     *
     * @return a client for environment waste data
     */
    public EnvironmentWasteClient waste() {
        return this.environmentWasteClient;
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "MI/";
    }

}
