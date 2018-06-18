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

package com.github.dannil.scbjavaclient.client;

import java.util.Locale;

import com.github.dannil.scbjavaclient.http.HttpProtocol;

/**
 * <p>Builder class for constructing new clients.</p>
 *
 * @since 1.2.0
 */
public class SCBClientBuilder {

    private SCBClient client;

    /**
     * <p>Default constructor.</p>
     */
    public SCBClientBuilder() {
        this.client = new SCBClient();
    }

    /**
     * <p>Sets the <code>Locale</code> for this builder, and therefore the client
     * generated from this builder.</p>
     *
     * @param locale
     *            the <code>Locale</code> to use
     * @return the instance of this builder
     */
    public SCBClientBuilder setLocale(Locale locale) {
        this.client.setLocale(locale);
        return this;
    }

    /**
     * <p>Sets the {@link com.github.dannil.scbjavaclient.http.HttpProtocol HttpProtocol}
     * for this builder, and therefore the client generated from this builder.</p>
     *
     * @param httpProtocol
     *            the {@link com.github.dannil.scbjavaclient.http.HttpProtocol
     *            HttpProtocol} to use
     * @return the instance of this builder
     */
    public SCBClientBuilder setHttpProtocol(HttpProtocol httpProtocol) {
        this.client.setHttpProtocol(httpProtocol);
        return this;
    }

    /**
     * <p>Generates a {@link SCBClient} with the previously assigned parameters.</p>
     *
     * @return a {@link SCBClient} with specified parameters
     */
    public SCBClient build() {
        return this.client;
    }

}
