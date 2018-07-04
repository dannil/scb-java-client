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

package com.github.dannil.scbjavaclient.format.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.exception.SCBClientParsingException;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class JsonConverterTest {

    private String json;

    private JsonConverter converter;

    @BeforeEach
    public void setup() {
        this.json = "{\"query\": [{\"code\": \"ContentsCode\",\"selection\": {\"filter\": \"item\",\"values\": [\"MI0802AA\"]}}],\"response\": {\"format\": \"json\"}}";

        this.converter = new JsonConverter();
    }

    @Test
    public void getNodeField() {
        JsonNode node = this.converter.toNode(this.json, "query");

        String comparison = "[{\"code\": \"ContentsCode\",\"selection\": {\"filter\": \"item\",\"values\": [\"MI0802AA\"]}}]";

        assertEquals(node.toString().replaceAll("\\s+", ""), comparison.replaceAll("\\s+", ""));
    }

    @Test
    public void getNodeInvalidJson() {
        assertThrows(SCBClientParsingException.class, () -> this.converter.toNode("hello world"));
    }

}
