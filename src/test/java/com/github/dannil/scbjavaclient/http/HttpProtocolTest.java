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

package com.github.dannil.scbjavaclient.http;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.Test;

@Suite
public class HttpProtocolTest {

    @Test
    public void getProtocol() {
        HttpProtocol httpProtocol = HttpProtocol.HTTP;

        assertEquals("http", httpProtocol.getProtocol());
    }

    @Test
    public void valueOf() {
        String protocol = "HTTP";
        HttpProtocol httpProtocol = HttpProtocol.valueOf(protocol);

        assertEquals("http", httpProtocol.getProtocol());
    }

    @Test
    public void valueOfIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> HttpProtocol.valueOf(""));
    }

    @Test
    public void values() {
        HttpProtocol[] protocols = HttpProtocol.values();

        assertArrayEquals(HttpProtocol.values(), protocols);
    }

}
