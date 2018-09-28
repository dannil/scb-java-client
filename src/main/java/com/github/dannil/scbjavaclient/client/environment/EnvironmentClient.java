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
import com.github.dannil.scbjavaclient.client.environment.airpollutants.EnvironmentAirPollutantsClient;
import com.github.dannil.scbjavaclient.client.environment.greenhousegas.EnvironmentGreenhouseGasClient;
import com.github.dannil.scbjavaclient.client.environment.islands.EnvironmentIslandsClient;
import com.github.dannil.scbjavaclient.client.environment.landandwaterarea.EnvironmentLandAndWaterAreaClient;
import com.github.dannil.scbjavaclient.client.environment.landuse.EnvironmentLandUseClient;
import com.github.dannil.scbjavaclient.client.environment.landusedfortransport.EnvironmentLandUsedForTransportClient;
import com.github.dannil.scbjavaclient.client.environment.packagingandpackagingwaste.EnvironmentPackagingAndPackagingWasteClient;
import com.github.dannil.scbjavaclient.client.environment.protectednature.EnvironmentProtectedNatureClient;
import com.github.dannil.scbjavaclient.client.environment.seea.EnvironmentSEEAClient;
import com.github.dannil.scbjavaclient.client.environment.smallerlocalities.EnvironmentSmallerLocalitiesClient;
import com.github.dannil.scbjavaclient.client.environment.waste.EnvironmentWasteClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

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

        addClient("airpollutants", new EnvironmentAirPollutantsClient());
        addClient("greenhousegas", new EnvironmentGreenhouseGasClient());
        addClient("islands", new EnvironmentIslandsClient());
        addClient("landandwaterarea", new EnvironmentLandAndWaterAreaClient());
        addClient("landuse", new EnvironmentLandUseClient());
        addClient("landusedfortransport", new EnvironmentLandUsedForTransportClient());
        addClient("packagingandpackagingwaste", new EnvironmentPackagingAndPackagingWasteClient());
        addClient("protectednature", new EnvironmentProtectedNatureClient());
        addClient("seea", new EnvironmentSEEAClient());
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
     * <p>Retrieve the client for interacting with environment air pollutants data.</p>
     *
     * @return a client for environment air pollutants data
     */
    public EnvironmentAirPollutantsClient airPollutants() {
        return (EnvironmentAirPollutantsClient) getClient("airpollutants");
    }

    /**
     * <p>Retrieve the client for interacting with environment greenhouse gas data.</p>
     *
     * @return a client for environment greenhouse gas data
     */
    public EnvironmentGreenhouseGasClient greenhouseGas() {
        return (EnvironmentGreenhouseGasClient) getClient("greenhousegas");
    }

    /**
     * <p>Retrieve the client for interacting with environment islands data.</p>
     *
     * @return a client for environment islands data
     */
    public EnvironmentIslandsClient islands() {
        return (EnvironmentIslandsClient) getClient("islands");
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
     * <p>Retrieve the client for interacting with environment land used for transport
     * data.</p>
     *
     * @return a client for environment land used for transport data
     *
     * @deprecated use
     *             {@link com.github.dannil.scbjavaclient.client.environment.landuse.EnvironmentLandUseClient#infrastructureForTransport()
     *             EnvironmentLandUseClient#infrastructureForTransport()} instead.
     */
    @Deprecated
    public EnvironmentLandUsedForTransportClient landUsedForTransport() {
        return (EnvironmentLandUsedForTransportClient) getClient("landusedfortransport");
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
     * <p>Retrieve the client for interacting with environment System of
     * Environmental-Economic Accounting (SEEA) data.</p>
     *
     * @return a client for environment System of Environmental-Economic Accounting (SEEA)
     *         data
     */
    public EnvironmentSEEAClient seea() {
        return (EnvironmentSEEAClient) getClient("seea");
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
