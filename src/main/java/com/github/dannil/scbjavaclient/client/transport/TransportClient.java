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

package com.github.dannil.scbjavaclient.client.transport;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.transport.registeredvehicles.TransportRegisteredVehiclesClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles transport data fetching.</p>
 *
 * @since 0.4.0
 */
public class TransportClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public TransportClient() {
        super();

        addClient("registeredvehicles", new TransportRegisteredVehiclesClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public TransportClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with transport registered vehicles data.</p>
     *
     * @return a client for transport registered vehicles data
     */
    public TransportRegisteredVehiclesClient registeredVehicles() {
        return (TransportRegisteredVehiclesClient) getClient("registeredvehicles");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("TK/");
    }

}
