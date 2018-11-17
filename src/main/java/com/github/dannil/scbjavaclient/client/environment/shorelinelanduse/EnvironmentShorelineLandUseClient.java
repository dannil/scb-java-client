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

package com.github.dannil.scbjavaclient.client.environment.shorelinelanduse;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.environment.shorelinelanduse.landuse.EnvironmentShorelineLandUseLandUseClient;
import com.github.dannil.scbjavaclient.client.environment.shorelinelanduse.oldtables.EnvironmentShorelineLandUseOldTablesClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles environment shoreline land use data fetching.</p>
 *
 * @since 2.1.0
 */
public class EnvironmentShorelineLandUseClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public EnvironmentShorelineLandUseClient() {
        super();

        addClient("landuse", new EnvironmentShorelineLandUseLandUseClient());
        addClient("oldtables", new EnvironmentShorelineLandUseOldTablesClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentShorelineLandUseClient(Locale locale) {
        super(locale);

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with environment shoreline land use land use
     * data.</p>
     *
     * @return a client for environment shoreline land use land use data
     */
    public EnvironmentShorelineLandUseLandUseClient landUse() {
        return (EnvironmentShorelineLandUseLandUseClient) getClient("landuse");
    }

    /**
     * <p>Retrieve the client for interacting with environment shoreline land use old
     * tables data.</p>
     *
     * @return a client for environment shoreline land use old tables data
     */
    public EnvironmentShorelineLandUseOldTablesClient oldTables() {
        return (EnvironmentShorelineLandUseOldTablesClient) getClient("oldtables");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0812/");
    }

}
