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

package com.github.dannil.scbjavaclient.client;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Abstract class which specifies how methods by container clients (a client that has
 * sub-clients) should operate.
 *
 * @since 0.0.2
 */
public abstract class AbstractContainerClient extends AbstractClient {

    private Map<String, AbstractClient> clients;

    /**
     * Default constructor.
     */
    protected AbstractContainerClient() {
        super();

        this.clients = new HashMap<>();
    }

    /**
     * Overloaded constructor.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    protected AbstractContainerClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * Set the <code>Locale</code> for all sub-clients.
     */
    @Override
    public final void setLocale(Locale locale) {
        super.setLocale(locale);

        for (AbstractClient client : this.clients.values()) {
            client.setLocale(getLocale());
        }
    }

    /**
     * Add a sub-client to this client.
     *
     * @param key
     *            the key
     * @param client
     *            the client
     * @throws IllegalArgumentException
     *             if <code>this</code> client adds itself as a sub-client, such that the
     *             expression <code>this == client</code> is true
     */
    public void addClient(String key, AbstractClient client) {
        if (this == client) {
            throw new IllegalArgumentException("Can't add itself as a sub-client.");
        }
        this.clients.put(key, client);
    }

    /**
     * Get a sub-client from this client.
     *
     * @param key
     *            the key
     * @return a client which is mapped to this key
     */
    public AbstractClient getClient(String key) {
        return this.clients.get(key);
    }

}
