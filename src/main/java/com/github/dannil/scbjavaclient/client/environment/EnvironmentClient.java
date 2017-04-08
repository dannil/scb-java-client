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
import com.github.dannil.scbjavaclient.client.environment.industrialwateruse.IndustrialWaterUseClient;
import com.github.dannil.scbjavaclient.client.environment.landandwaterarea.LandAndWaterAreaClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.LandUseClient;
import com.github.dannil.scbjavaclient.client.environment.packagingandpackagingwaste.PackagingAndPackagingWasteClient;
import com.github.dannil.scbjavaclient.client.environment.waste.WasteClient;
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

        addClient("industrialwateruse", new IndustrialWaterUseClient());
        addClient("landandwaterarea", new LandAndWaterAreaClient());
        addClient("landuse", new LandUseClient());
        addClient("packagingandpackagingwaste", new PackagingAndPackagingWasteClient());
        addClient("waste", new WasteClient());
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
    public IndustrialWaterUseClient industrialWaterUse() {
        return (IndustrialWaterUseClient) getClient("industrialwateruse");
    }

    /**
     * <p>Retrieve the client for interacting with environment land and water area
     * data.</p>
     *
     * @return a client for environment land and water area data
     */
    public LandAndWaterAreaClient landAndWaterArea() {
        return (LandAndWaterAreaClient) getClient("landandwaterarea");
    }

    /**
     * <p>Retrieve the client for interacting with environment land use data.</p>
     *
     * @return a client for environment land use data
     */
    public LandUseClient landUse() {
        return (LandUseClient) getClient("landuse");
    }

    /**
     * <p>Retrieve the client for interacting with environment packaging and packaging
     * waste data.</p>
     *
     * @return a client for environment packaging and packaging waste data
     */
    public PackagingAndPackagingWasteClient packagingAndPackagingWaste() {
        return (PackagingAndPackagingWasteClient) getClient("packagingandpackagingwaste");
    }

    /**
     * <p>Retrieve the client for interacting with environment waste data.</p>
     *
     * @return a client for environment waste data
     */
    public WasteClient waste() {
        return (WasteClient) getClient("waste");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/");
    }

}
