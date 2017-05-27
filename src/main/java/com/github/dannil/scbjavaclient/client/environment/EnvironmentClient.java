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
import com.github.dannil.scbjavaclient.client.environment.emissions.EnvironmentEmissionsClient;
import com.github.dannil.scbjavaclient.client.environment.industrialwateruse.EnvironmentIndustrialWaterUseClient;
import com.github.dannil.scbjavaclient.client.environment.landandwaterarea.EnvironmentLandAndWaterAreaClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.EnvironmentLandUseClient;
import com.github.dannil.scbjavaclient.client.environment.packagingandpackagingwaste.EnvironmentPackagingAndPackagingWasteClient;
import com.github.dannil.scbjavaclient.client.environment.protectednature.EnvironmentProtectedNatureClient;
import com.github.dannil.scbjavaclient.client.environment.smallerlocalities.EnvironmentSmallerLocalitiesClient;
import com.github.dannil.scbjavaclient.client.environment.waste.EnvironmentWasteClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles environment data fetching.</p>
 *
 * @since 0.0.2
 */
public class EnvironmentClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public EnvironmentClient() {
        super();

        addClient("emissions", new EnvironmentEmissionsClient());
        addClient("industrialwateruse", new EnvironmentIndustrialWaterUseClient());
        addClient("landandwaterarea", new EnvironmentLandAndWaterAreaClient());
        addClient("landuse", new EnvironmentLandUseClient());
        addClient("packagingandpackagingwaste", new EnvironmentPackagingAndPackagingWasteClient());
        addClient("protectednature", new EnvironmentProtectedNatureClient());
        addClient("smallerlocalities", new EnvironmentSmallerLocalitiesClient());
        addClient("waste", new EnvironmentWasteClient());
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
     * <p>Retrieve the client for interacting with environment emissions data.</p>
     *
     * @return a client for environment emissions data
     */
    public EnvironmentEmissionsClient emissions() {
        return (EnvironmentEmissionsClient) getClient("emissions");
    }

    /**
     * <p>Retrieve the client for interacting with environment industrial water use
     * data.</p>
     *
     * @return a client for environment industrial water use data
     */
    public EnvironmentIndustrialWaterUseClient industrialWaterUse() {
        return (EnvironmentIndustrialWaterUseClient) getClient("industrialwateruse");
    }

    /**
     * <p>Retrieve the client for interacting with environment land and water area
     * data.</p>
     *
     * @return a client for environment land and water area data
     */
    public EnvironmentLandAndWaterAreaClient landAndWaterArea() {
        return (EnvironmentLandAndWaterAreaClient) getClient("landandwaterarea");
    }

    /**
     * <p>Retrieve the client for interacting with environment land use data.</p>
     *
     * @return a client for environment land use data
     */
    public EnvironmentLandUseClient landUse() {
        return (EnvironmentLandUseClient) getClient("landuse");
    }

    /**
     * <p>Retrieve the client for interacting with environment packaging and packaging
     * waste data.</p>
     *
     * @return a client for environment packaging and packaging waste data
     */
    public EnvironmentPackagingAndPackagingWasteClient packagingAndPackagingWaste() {
        return (EnvironmentPackagingAndPackagingWasteClient) getClient("packagingandpackagingwaste");
    }

    /**
     * <p>Retrieve the client for interacting with environment protected nature data.</p>
     *
     * @return a client for environment protected nature data
     */
    public EnvironmentProtectedNatureClient protectedNature() {
        return (EnvironmentProtectedNatureClient) getClient("protectednature");
    }

    /**
     * <p>Retrieve the client for interacting with environment smaller localities
     * data.</p>
     *
     * @return a client for environment smaller localities data
     */
    public EnvironmentSmallerLocalitiesClient smallerLocalities() {
        return (EnvironmentSmallerLocalitiesClient) getClient("smallerlocalities");
    }

    /**
     * <p>Retrieve the client for interacting with environment waste data.</p>
     *
     * @return a client for environment waste data
     */
    public EnvironmentWasteClient waste() {
        return (EnvironmentWasteClient) getClient("waste");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/");
    }

}
