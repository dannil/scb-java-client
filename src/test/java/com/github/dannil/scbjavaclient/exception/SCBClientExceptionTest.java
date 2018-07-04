/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class SCBClientExceptionTest {

    @Test
    public void constructor() {
        SCBClientException e = new SCBClientException();

        assertEquals(e.getClass().getName(), e.toString());
    }

    @Test
    public void message() {
        SCBClientException e = new SCBClientException("This is the error message");

        assertEquals("This is the error message", e.getMessage());
    }

    @Test
    public void messageAndCause() {
        Throwable c = new Throwable();
        SCBClientException e = new SCBClientException("This is the error message", c);

        assertEquals("This is the error message", e.getMessage());
        assertEquals(c, e.getCause());
    }

    @Test
    public void cause() {
        Throwable c = new Throwable();
        SCBClientException e = new SCBClientException(c);

        assertEquals(c, e.getCause());
    }

}
