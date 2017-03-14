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

package com.github.dannil.scbjavaclient.client.energy;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.energy.monthlystatistics.EnergyMonthlyStatisticsClient;

/**
 * <p>Client which handles energy data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnergyClient extends AbstractContainerClient {

    private EnergyMonthlyStatisticsClient energyMonthlyStatisticsClient;

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public EnergyClient() {
        super();

        this.energyMonthlyStatisticsClient = new EnergyMonthlyStatisticsClient();
        addClient(this.energyMonthlyStatisticsClient);
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnergyClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with energy monthly statistics data.</p>
     *
     * @return a client for energy monthly statistics water use data
     */
    public EnergyMonthlyStatisticsClient monthlyStatistics() {
        return this.energyMonthlyStatisticsClient;
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "EN/";
    }

}
