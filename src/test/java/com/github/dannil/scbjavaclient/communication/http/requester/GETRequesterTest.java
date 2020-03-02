/*
 * Copyright 2020 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.communication.http.requester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GETRequesterTest {

    private GETRequester mock;

    @BeforeEach
    public void setup() {
        this.mock = mock(GETRequester.class);
        when(this.mock.getResponse("IOException")).thenThrow(new UncheckedIOException(new IOException()));
    }

    @Test
    public void createWithDefaultConstructor() {
        GETRequester get = new GETRequester();

        assertEquals(StandardCharsets.UTF_8, get.getCharset());
    }

    @Test
    public void getCharset() {
        GETRequester get = new GETRequester();

        assertEquals(StandardCharsets.UTF_8, get.getCharset());
    }

    @Test
    public void doRequestIOException() {
        assertThrows(UncheckedIOException.class, () -> this.mock.getResponse("IOException"));
    }

}
