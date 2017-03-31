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

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dannil.scbjavaclient.exception.SCBClientParsingException;

/**
 * <p>Class which encapsulates methods for converting JSON.</p>
 *
 * @since 0.1.0
 */
public class JsonConverter {

    private ObjectMapper mapper;

    /**
     * <p>Default constructor. Initializes the
     * {@link com.fasterxml.jackson.databind.ObjectMapper ObjectMapper} needed for
     * converting objects.</p>
     */
    public JsonConverter() {
        this.mapper = new ObjectMapper();
    }

    /**
     * <p>Converts the specified object to the specified class.</p>
     *
     * @param fromValue
     *            the object to convert
     * @param toValueType
     *            the class to convert to
     * @param <T>
     *            the data type of the list
     * @return a converted object
     */
    public <T> T convertValue(Object fromValue, Class<T> toValueType) {
        return this.mapper.convertValue(fromValue, toValueType);
    }

    /**
     * <p>Converts the JSON string into a list of the specified class.</p>
     *
     * @param json
     *            the JSON string to convert
     * @param clazz
     *            the class to convert each JSON entry to
     * @param <T>
     *            the data type of the list
     * @return a list of elements, which type is the specified class. Each element
     *         represents the corresponding entry in the JSON
     */
    public <T> List<T> toListOf(String json, Class<T> clazz) {
        try {
            JavaType type = this.mapper.getTypeFactory().constructCollectionType(List.class, clazz);
            return this.mapper.readValue(json, type);
        } catch (IOException e) {
            throw new SCBClientParsingException(e);
        }
    }

    /**
     * <p>Parse the JSON string into a {@link JsonNode} object.</p>
     *
     * @param json
     *            the JSON content
     *
     * @return a {@link JsonNode} object
     */
    public JsonNode toNode(String json) {
        return toNode(json, null);
    }

    /**
     * <p>Parse the JSON string into a {@link JsonNode} object with the specified field as
     * root field.</p>
     *
     * @param json
     *            the JSON content
     * @param field
     *            the field in the JSON to become the root
     * @return a {@link JsonNode} object with the specified field as root.
     */
    public JsonNode toNode(String json, String field) {
        try {
            JsonNode node = this.mapper.readTree(json);
            if (field != null) {
                return node.get(field);
            }
            return node;
        } catch (IOException e) {
            throw new SCBClientParsingException(e);
        }
    }
}
