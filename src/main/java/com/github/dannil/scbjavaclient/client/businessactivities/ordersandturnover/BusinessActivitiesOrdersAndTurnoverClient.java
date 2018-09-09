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

package com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover.oldtablessni2002.BusinessActivitiesOrdersAndTurnoverOldTablesSNI2002Client;
import com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover.oldtablessni2007.BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007Client;
import com.github.dannil.scbjavaclient.client.businessactivities.ordersandturnover.ordersandturnover.BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles business activities orders and turnover data fetching.</p>
 *
 * @since 0.7.0
 */
public class BusinessActivitiesOrdersAndTurnoverClient extends AbstractContainerClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesOrdersAndTurnoverClient() {
        super();

        addClient("oldtablessni2002", new BusinessActivitiesOrdersAndTurnoverOldTablesSNI2002Client());
        addClient("oldtablessni2007", new BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007Client());
        addClient("ordersandturnover", new BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesOrdersAndTurnoverClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with business activities orders and turnover
     * old tables SNI 2002 data.</p>
     *
     * @return a client for business activities orders and turnover old tables SNI 2002
     *         data
     */
    public BusinessActivitiesOrdersAndTurnoverOldTablesSNI2002Client oldTablesSNI2002() {
        return (BusinessActivitiesOrdersAndTurnoverOldTablesSNI2002Client) getClient("oldtablessni2002");
    }

    /**
     * <p>Retrieve the client for interacting with business activities orders and turnover
     * old tables SNI 2007 data.</p>
     *
     * @return a client for business activities orders and turnover old tables SNI 2007
     *         data
     */
    public BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007Client oldTablesSNI2007() {
        return (BusinessActivitiesOrdersAndTurnoverOldTablesSNI2007Client) getClient("oldtablessni2007");
    }

    /**
     * <p>Retrieve the client for interacting with business activities orders and turnover
     * orders and turnover data.</p>
     *
     * @return a client for business activities orders and turnover orders and turnover
     *         data
     */
    public BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClient ordersAndTurnover() {
        return (BusinessActivitiesOrdersAndTurnoverOrdersAndTurnoverClient) getClient("ordersandturnover");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0501/");
    }

}
