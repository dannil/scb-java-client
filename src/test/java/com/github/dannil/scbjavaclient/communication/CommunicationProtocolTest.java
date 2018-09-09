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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class CommunicationProtocolTest {

    @Test
    public void getProtocolHttp() {
        CommunicationProtocol protocol = CommunicationProtocol.HTTP;

        assertEquals("http", protocol.getProtocol());
    }
    
    @Test
    public void getProtocolHttps() {
        CommunicationProtocol protocol = CommunicationProtocol.HTTPS;

        assertEquals("https", protocol.getProtocol());
    }

    @Test
    public void valueOf() {
        String protocol = "HTTP";
        CommunicationProtocol httpProtocol = CommunicationProtocol.valueOf(protocol);

        assertEquals("http", httpProtocol.getProtocol());
    }

    @Test
    public void valueOfIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> CommunicationProtocol.valueOf(""));
    }

    @Test
    public void values() {
        CommunicationProtocol[] protocols = CommunicationProtocol.values();

        assertArrayEquals(CommunicationProtocol.values(), protocols);
    }

}
