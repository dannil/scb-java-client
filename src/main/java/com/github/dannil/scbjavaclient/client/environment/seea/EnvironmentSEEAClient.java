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

package com.github.dannil.scbjavaclient.client.environment.seea;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.environment.seea.airemissionsaccounts.EnvironmentSEEAAirEmissionsAccountsClient;
import com.github.dannil.scbjavaclient.client.environment.seea.energyaccounts.EnvironmentSEEAEnergyAccountsClient;
import com.github.dannil.scbjavaclient.client.environment.seea.goodsandservicessector.EnvironmentSEEAGoodsAndServicesSectorClient;
import com.github.dannil.scbjavaclient.client.environment.seea.materialflowaccounts.EnvironmentSEEAMaterialFlowAccountsClient;
import com.github.dannil.scbjavaclient.client.environment.seea.taxes.EnvironmentSEEATaxesClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles environment System of Environmental-Economic Accounting (SEEA)
 * data fetching.</p>
 *
 * @since 0.4.0
 */
public class EnvironmentSEEAClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public EnvironmentSEEAClient() {
        super();

        addClient("airemissionsaccounts", new EnvironmentSEEAAirEmissionsAccountsClient());
        addClient("energyaccounts", new EnvironmentSEEAEnergyAccountsClient());
        addClient("goodsandservicessector", new EnvironmentSEEAGoodsAndServicesSectorClient());
        addClient("materialflowaccounts", new EnvironmentSEEAMaterialFlowAccountsClient());
        addClient("taxes", new EnvironmentSEEATaxesClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentSEEAClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with environment System of
     * Environmental-Economic Accounting (SEEA) air emissions accounts data.</p>
     *
     * @return a client for environment System of Environmental-Economic Accounting (SEEA)
     *         air emissions accounts data
     */
    public EnvironmentSEEAAirEmissionsAccountsClient airEmissionsAccounts() {
        return (EnvironmentSEEAAirEmissionsAccountsClient) getClient("airemissionsaccounts");
    }

    /**
     * <p>Retrieve the client for interacting with environment System of
     * Environmental-Economic Accounting (SEEA) energy accounts data.</p>
     *
     * @return a client for environment System of Environmental-Economic Accounting (SEEA)
     *         energy accounts data
     */
    public EnvironmentSEEAEnergyAccountsClient energyAccounts() {
        return (EnvironmentSEEAEnergyAccountsClient) getClient("energyaccounts");
    }

    /**
     * <p>Retrieve the client for interacting with environment System of
     * Environmental-Economic Accounting (SEEA) goods and services sector data.</p>
     *
     * @return a client for environment System of Environmental-Economic Accounting (SEEA)
     *         goods and services sector data
     */
    public EnvironmentSEEAGoodsAndServicesSectorClient goodsAndServicesSector() {
        return (EnvironmentSEEAGoodsAndServicesSectorClient) getClient("goodsandservicessector");
    }

    /**
     * <p>Retrieve the client for interacting with environment System of
     * Environmental-Economic Accounting (SEEA) material flow accounts data.</p>
     *
     * @return a client for environment System of Environmental-Economic Accounting (SEEA)
     *         material flow accounts data
     */
    public EnvironmentSEEAMaterialFlowAccountsClient materialFlowAccounts() {
        return (EnvironmentSEEAMaterialFlowAccountsClient) getClient("materialflowaccounts");
    }

    /**
     * <p>Retrieve the client for interacting with environment System of
     * Environmental-Economic Accounting (SEEA) taxes data.</p>
     *
     * @return a client for environment System of Environmental-Economic Accounting (SEEA)
     *         taxes data
     */
    public EnvironmentSEEATaxesClient taxes() {
        return (EnvironmentSEEATaxesClient) getClient("taxes");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI1301/");
    }

}
