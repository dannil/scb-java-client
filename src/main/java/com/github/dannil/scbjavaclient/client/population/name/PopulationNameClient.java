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

package com.github.dannil.scbjavaclient.client.population.name;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.population.name.newborn.PopulationNameNewbornClient;
import com.github.dannil.scbjavaclient.client.population.name.registeredpersons.PopulationNameRegisteredPersonsClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles population name data fetching.</p>
 *
 * @since 0.5.0
 */
public class PopulationNameClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public PopulationNameClient() {
        super();

        addClient("newborn", new PopulationNameNewbornClient());
        addClient("registeredpersons", new PopulationNameRegisteredPersonsClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationNameClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with population name newborn data.</p>
     *
     * @return a client for population name newborn data
     */
    public PopulationNameNewbornClient newborn() {
        return (PopulationNameNewbornClient) getClient("newborn");
    }

    /**
     * <p>Retrieve the client for interacting with population name registered persons
     * data.</p>
     *
     * @return a client for population name registered persons data
     */
    public PopulationNameRegisteredPersonsClient registeredPersons() {
        return (PopulationNameRegisteredPersonsClient) getClient("registeredpersons");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0001/");
    }

}
