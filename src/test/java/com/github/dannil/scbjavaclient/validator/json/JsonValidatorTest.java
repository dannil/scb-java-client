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

package com.github.dannil.scbjavaclient.validator.json;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.format.json.JsonConverter;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class JsonValidatorTest {

    @Test
    public void callPrivateConstructor()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = JsonValidator.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        Object o = cons[0].newInstance();
        cons[0].setAccessible(false);

        assertNotNull(o);
    }

    @Test
    public void isQuery() {
        String json = "{\"query\": [{\"code\": \"ContentsCode\",\"selection\": {\"filter\": \"item\",\"values\": [\"MI0802AA\"]}}],\"response\": {\"format\": \"json\"}}";

        JsonConverter converter = new JsonConverter();
        JsonNode node = converter.toNode(json);

        assertTrue(JsonValidator.isQuery(node));
    }

    @Test
    public void isNotQuery() {
        String json = "[{\"code\": \"ContentsCode\",\"selection\": {\"filter\": \"item\",\"values\": [\"MI0802AA\"]}}]";

        JsonConverter converter = new JsonConverter();
        JsonNode node = converter.toNode(json);

        assertFalse(JsonValidator.isQuery(node));
    }
}
