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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.exception.SCBClientParsingException;
import com.github.dannil.scbjavaclient.model.ResponseModel;
import com.github.dannil.scbjavaclient.model.ValueNode;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class JsonCustomResponseFormatTest {

    private String json;

    private JsonCustomResponseFormat format;

    @BeforeEach
    public void setup() {
        this.json = "{\"columns\":[{\"code\":\"Region\",\"text\":\"region\",\"type\":\"d\"},{\"code\":\"Civilstand\",\"text\":\"marital status\",\"type\":\"d\"},{\"code\":\"Alder\",\"text\":\"age\",\"type\":\"d\"},{\"code\":\"Tid\",\"text\":\"year\",\"type\":\"t\"},{\"code\":\"BE0101N1\",\"text\":\"Population\",\"comment\":\"The tables show the conditions on December 31st for each respective year according to administrative subdivisions of January 1st of the following year\\r\\n\",\"type\":\"c\"},{\"code\":\"BE0101N2\",\"text\":\"Population growth\",\"comment\":\"Population growth is defined as the difference between the population at the beginning of the year and at the end of the year.\\r\\n\",\"type\":\"c\"}],\"comments\":[],\"data\":[{\"key\":[\"00\",\"OG\",\"45\",\"2011\"],\"values\":[\"48403\",\"1007\"]}]}";
        this.format = new JsonCustomResponseFormat(this.json);
    }

    @Test
    public void toListNonConventionalJson() {
        List<ResponseModel> convertedPopulations = this.format.toListOf(ResponseModel.class);

        Map<String, String> keys = new HashMap<String, String>();
        keys.put("Region", "00");
        keys.put("Civilstand", "OG");
        keys.put("Alder", "45");
        // keys.put("Kon", "null");
        keys.put("Tid", "2011");

        List<ValueNode<String>> values = new ArrayList<ValueNode<String>>();

        ValueNode<String> value1 = new ValueNode<String>("48403", "BE0101N1", "Population");
        values.add(value1);

        ValueNode<String> value2 = new ValueNode<String>("1007", "BE0101N2", "Population growth");
        values.add(value2);

        ResponseModel p = new ResponseModel(keys, values);
        List<ResponseModel> staticPopulations = Arrays.asList(p);

        assertEquals(convertedPopulations, staticPopulations);
    }

    @Test
    public void toListOfInvalidJson() {
        assertThrows(SCBClientParsingException.class, () -> {
            new JsonCustomResponseFormat("dadawdawgnjhggggggg");
        });
    }

    @Test
    public void toListOfInvalidConversionClass() {
        JsonCustomResponseFormat format = new JsonCustomResponseFormat(this.json);

        assertThrows(SCBClientParsingException.class, () -> format.toListOf(Locale.class));
    }

    @Test
    public void toStringEquals() {
        String input = "{\"columns\":[{\"code\":\"Region\",\"text\":\"region\",\"type\":\"d\"},{\"code\":\"Civilstand\",\"text\":\"marital status\",\"type\":\"d\"},{\"code\":\"Alder\",\"text\":\"age\",\"type\":\"d\"},{\"code\":\"Tid\",\"text\":\"year\",\"type\":\"t\"},{\"code\":\"BE0101N1\",\"text\":\"Population\",\"comment\":\"The tables show the conditions on December 31st for each respective year according to administrative subdivisions of January 1st of the following year\\r\\n\",\"type\":\"c\"},{\"code\":\"BE0101N2\",\"text\":\"Population growth\",\"comment\":\"Population growth is defined as the difference between the population at the beginning of the year and at the end of the year.\\r\\n\",\"type\":\"c\"}],\"comments\":[],\"data\":[{\"key\":[\"00\",\"OG\",\"45\",\"2011\"],\"values\":[\"48403\",\"1007\"]}]}";

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(input);

        String expected = "[{\"Variables\":{\"Alder\":\"45\",\"Region\":\"00\",\"Civilstand\":\"OG\",\"Tid\":\"2011\"},\"Values\":[{\"Value\":\"48403\",\"Text\":\"Population\",\"Code\":\"BE0101N1\"},{\"Value\":\"1007\",\"Text\":\"Populationgrowth\",\"Code\":\"BE0101N2\"}]}]";
        String toString = format.toString();

        // Remove whitespace for easier comparison; JSON is still valid
        expected = expected.replace(" ", "");
        toString = toString.replace(" ", "");

        assertEquals(expected, toString);
    }

}
