/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.businessactivities.productionvalueindex;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.businessactivities.productionvalueindex.productionvalueindex.BusinessActivitiesProductionValueIndexProductionValueIndexClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles business activities production value index data fetching.</p>
 *
 * @since 3.0.0
 */
public class BusinessActivitiesProductionValueIndexClient extends AbstractContainerClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesProductionValueIndexClient() {
        super();

        addClient("productionvalueindex", new BusinessActivitiesProductionValueIndexProductionValueIndexClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesProductionValueIndexClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with business activities production value
     * index production value index data.</p>
     *
     * @return a client for business activities production value index production value
     *         index data
     */
    public BusinessActivitiesProductionValueIndexProductionValueIndexClient productionValueIndex() {
        return (BusinessActivitiesProductionValueIndexProductionValueIndexClient) getClient("productionvalueindex");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0006/");
    }

}
