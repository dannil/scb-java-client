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

package com.github.dannil.scbjavaclient.client.transport.registeredvehicles;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.transport.registeredvehicles.economicindicators.EconomicIndicatorsClient;
import com.github.dannil.scbjavaclient.client.transport.registeredvehicles.vehicles.VehiclesClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles transport registered vehicles data fetching.</p>
 *
 * @since 0.4.0
 */
public class RegisteredVehiclesClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public RegisteredVehiclesClient() {
        super();

        addClient("economicindicators", new EconomicIndicatorsClient());
        addClient("vehicles", new VehiclesClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public RegisteredVehiclesClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with transport registered vehicles economic
     * indicators data.</p>
     *
     * @return a client for transport registered vehicles economic indicators data
     */
    public EconomicIndicatorsClient economicIndicators() {
        return (EconomicIndicatorsClient) getClient("economicindicators");
    }

    /**
     * <p>Retrieve the client for interacting with transport registered vehicles vehicles
     * data.</p>
     *
     * @return a client for transport registered vehicles vehicles data
     */
    public VehiclesClient vehicles() {
        return (VehiclesClient) getClient("vehicles");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("TK/TK1001/");
    }

}
