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

package com.github.dannil.scbjavaclient.communication;

/**
 * <p>Enumerable for the available communication protocols which the API (and in extension
 * this library) can accept.</p>
 *
 * @since 1.2.0
 */
public enum CommunicationProtocol {

    HTTP("http"), HTTPS("https");

    private String protocol;

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param protocol
     *            the protocol
     */
    CommunicationProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * <p>Returns the protocol.</p>
     *
     * @return the protocol
     */
    public String getProtocol() {
        return this.protocol;
    }

}
