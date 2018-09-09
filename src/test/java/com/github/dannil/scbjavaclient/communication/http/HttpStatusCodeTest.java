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

package com.github.dannil.scbjavaclient.communication.http;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class HttpStatusCodeTest {

    @Test
    public void getCode() {
        HttpStatusCode httpStatusCode = HttpStatusCode.NOT_FOUND;

        assertEquals(404, httpStatusCode.getCode());
    }

    @Test
    public void getDescription() {
        HttpStatusCode httpStatusCode = HttpStatusCode.NOT_FOUND;

        assertEquals("Not Found", httpStatusCode.getDescription());
    }

    @Test
    public void asText() {
        HttpStatusCode httpStatusCode = HttpStatusCode.NOT_FOUND;

        assertEquals("404", httpStatusCode.asText());
    }

    @Test
    public void valueOf() {
        int code = 404;
        HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(code);

        assertEquals(404, httpStatusCode.getCode());
        assertEquals("Not Found", httpStatusCode.getDescription());
        assertEquals("404", httpStatusCode.asText());
    }

    @Test
    public void valueOfIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> HttpStatusCode.valueOf(-1));
    }

    @Test
    public void valueOfString() {
        HttpStatusCode httpStatusCode = HttpStatusCode.valueOf("OK");

        assertEquals(200, httpStatusCode.getCode());
        assertEquals("OK", httpStatusCode.getDescription());
        assertEquals("200", httpStatusCode.asText());
    }

    @Test
    public void values() {
        HttpStatusCode[] statuses = HttpStatusCode.values();

        assertArrayEquals(HttpStatusCode.values(), statuses);
    }

}
