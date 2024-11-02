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

package com.github.dannil.scbjavaclient.client.agriculture;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.agriculture.cerealcrops.AgricultureCerealCropsClient;
import com.github.dannil.scbjavaclient.client.agriculture.holdings.AgricultureHoldingsClient;
import com.github.dannil.scbjavaclient.client.agriculture.landuse.AgricultureLandUseClient;
import com.github.dannil.scbjavaclient.client.agriculture.livestock.AgricultureLivestockClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * Client which handles agriculture data fetching.
 *
 * @since 0.4.0
 */
public class AgricultureClient extends AbstractContainerClient {

    /**
     * Default constructor. Initializes values and creates sub-clients.
     */
    public AgricultureClient() {
        super();

        addClient("cerealcrops", new AgricultureCerealCropsClient());
        addClient("holdings", new AgricultureHoldingsClient());
        addClient("landuse", new AgricultureLandUseClient());
        addClient("livestock", new AgricultureLivestockClient());
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public AgricultureClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * Retrieve the client for interacting with agriculture cereal crops data.
     *
     * @return a client for agriculture cereal crops data
     */
    public AgricultureCerealCropsClient cerealCrops() {
        return (AgricultureCerealCropsClient) getClient("cerealcrops");
    }

    /**
     * Retrieve the client for interacting with agriculture holdings data.
     *
     * @return a client for agriculture holdings data
     */
    public AgricultureHoldingsClient holdings() {
        return (AgricultureHoldingsClient) getClient("holdings");
    }

    /**
     * Retrieve the client for interacting with agriculture land use data.
     *
     * @return a client for agriculture land use data
     */
    public AgricultureLandUseClient landUse() {
        return (AgricultureLandUseClient) getClient("landuse");
    }

    /**
     * Retrieve the client for interacting with agriculture livestock data.
     *
     * @return a client for agriculture livestock data
     */
    public AgricultureLivestockClient livestock() {
        return (AgricultureLivestockClient) getClient("livestock");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("JO/");
    }

}
