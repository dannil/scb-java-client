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

package com.github.dannil.scbjavaclient.client.livingconditions.families;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.livingconditions.families.adoptions.AdoptionsClient;
import com.github.dannil.scbjavaclient.client.livingconditions.families.housing.HousingClient;
import com.github.dannil.scbjavaclient.client.livingconditions.families.legalguardians.LegalGuardiansClient;
import com.github.dannil.scbjavaclient.client.livingconditions.families.siblings.SiblingsClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;

/**
 * <p>Client which handles living conditions families data fetching.</p>
 *
 * @since 0.2.0
 */
public class FamiliesClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public FamiliesClient() {
        super();

        addClient("adoptions", new AdoptionsClient());
        addClient("housing", new HousingClient());
        addClient("legalguardians", new LegalGuardiansClient());
        addClient("siblings", new SiblingsClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FamiliesClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with living conditions families adoptions
     * data.</p>
     *
     * @return a client for living conditions families adoptions data
     */
    public AdoptionsClient adoptions() {
        return (AdoptionsClient) getClient("adoptions");
    }

    /**
     * <p>Retrieve the client for interacting with living conditions families housing
     * data.</p>
     *
     * @return a client for living conditions families housing data
     */
    public HousingClient housing() {
        return (HousingClient) getClient("housing");
    }

    /**
     * <p>Retrieve the client for interacting with living conditions families legal
     * guardians data.</p>
     *
     * @return a client for living conditions families legal guardians data
     */
    public LegalGuardiansClient legalGuardians() {
        return (LegalGuardiansClient) getClient("legalguardians");
    }

    /**
     * <p>Retrieve the client for interacting with living conditions families siblings
     * data.</p>
     *
     * @return a client for living conditions families siblings data
     */
    public SiblingsClient siblings() {
        return (SiblingsClient) getClient("siblings");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("LE/LE0102/");
    }

}
