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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.exception.SCBClientParsingException;
import com.github.dannil.scbjavaclient.model.ValueNode;
import com.github.dannil.scbjavaclient.model.population.amount.Population;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JsonCustomResponseFormatTest {

    private String json;

    private JsonCustomResponseFormat format;

    @Before
    public void setup() {
        this.json = "{\"columns\":[{\"code\":\"Region\",\"text\":\"region\",\"type\":\"d\"},{\"code\":\"Civilstand\",\"text\":\"marital status\",\"type\":\"d\"},{\"code\":\"Alder\",\"text\":\"age\",\"type\":\"d\"},{\"code\":\"Tid\",\"text\":\"year\",\"type\":\"t\"},{\"code\":\"BE0101N1\",\"text\":\"Population\",\"comment\":\"The tables show the conditions on December 31st for each respective year according to administrative subdivisions of January 1st of the following year\\r\\n\",\"type\":\"c\"},{\"code\":\"BE0101N2\",\"text\":\"Population growth\",\"comment\":\"Population growth is defined as the difference between the population at the beginning of the year and at the end of the year.\\r\\n\",\"type\":\"c\"}],\"comments\":[],\"data\":[{\"key\":[\"00\",\"OG\",\"45\",\"2011\"],\"values\":[\"48403\",\"1007\"]}]}";
        this.format = new JsonCustomResponseFormat(this.json);
    }

    @Test
    public void toListNonConventionalJson() {
        List<Population> convertedPopulations = this.format.toListOf(Population.class);

        List<ValueNode<String>> values = new ArrayList<ValueNode<String>>();

        ValueNode<String> value1 = new ValueNode<String>("48403", "BE0101N1", "Population");
        values.add(value1);

        ValueNode<String> value2 = new ValueNode<String>("1007", "BE0101N2", "Population growth");
        values.add(value2);

        Population p = new Population("00", "OG", "45", null, 2011, values);
        List<Population> staticPopulations = Arrays.asList(p);

        assertEquals(convertedPopulations, staticPopulations);
    }

    @Test(expected = SCBClientParsingException.class)
    public void toListOfInvalidJson() {
        JsonCustomResponseFormat format = new JsonCustomResponseFormat("dadawdawgnjhgggggggggggggggggggggggg");
        List<Population> populations = format.toListOf(Population.class);

        assertNull(populations);
    }

    @Test
    public void isFormatted() {
        String nonConventionalJson = "{\"columns\":[{\"code\":\"Region\",\"text\":\"region\",\"type\":\"d\"},{\"code\":\"Civilstand\",\"text\":\"marital status\",\"type\":\"d\"},{\"code\":\"Alder\",\"text\":\"age\",\"type\":\"d\"},{\"code\":\"Tid\",\"text\":\"year\",\"type\":\"t\"},{\"code\":\"BE0101N1\",\"text\":\"Population\",\"comment\":\"The tables show the conditions on December 31st for each respective year according to administrative subdivisions of January 1st of the following year\\r\\n\",\"type\":\"c\"},{\"code\":\"BE0101N2\",\"text\":\"Population growth\",\"comment\":\"Population growth is defined as the difference between the population at the beginning of the year and at the end of the year.\\r\\n\",\"type\":\"c\"}],\"comments\":[],\"data\":[{\"key\":[\"00\",\"OG\",\"45\",\"2011\"],\"values\":[\"48403\",\"1007\"]}]}";
        JsonCustomResponseFormat format = new JsonCustomResponseFormat(nonConventionalJson);

        assertTrue(format.isFormatted());
    }

    @Test
    public void isFormattedCache() {
        String nonConventionalJson = "{\"columns\":[{\"code\":\"Region\",\"text\":\"region\",\"type\":\"d\"},{\"code\":\"Civilstand\",\"text\":\"marital status\",\"type\":\"d\"},{\"code\":\"Alder\",\"text\":\"age\",\"type\":\"d\"},{\"code\":\"Tid\",\"text\":\"year\",\"type\":\"t\"},{\"code\":\"BE0101N1\",\"text\":\"Population\",\"comment\":\"The tables show the conditions on December 31st for each respective year according to administrative subdivisions of January 1st of the following year\\r\\n\",\"type\":\"c\"},{\"code\":\"BE0101N2\",\"text\":\"Population growth\",\"comment\":\"Population growth is defined as the difference between the population at the beginning of the year and at the end of the year.\\r\\n\",\"type\":\"c\"}],\"comments\":[],\"data\":[{\"key\":[\"00\",\"OG\",\"45\",\"2011\"],\"values\":[\"48403\",\"1007\"]}]}";
        JsonCustomResponseFormat format = new JsonCustomResponseFormat(nonConventionalJson);

        // A second call to format() triggers the return of the cache
        JsonNode node = format.format();

        assertEquals(node.toString(), format.toString());
    }

    @Test
    public void toStringEquals() {
        String input = "{\"columns\":[{\"code\":\"Region\",\"text\":\"region\",\"type\":\"d\"},{\"code\":\"Civilstand\",\"text\":\"marital status\",\"type\":\"d\"},{\"code\":\"Alder\",\"text\":\"age\",\"type\":\"d\"},{\"code\":\"Tid\",\"text\":\"year\",\"type\":\"t\"},{\"code\":\"BE0101N1\",\"text\":\"Population\",\"comment\":\"The tables show the conditions on December 31st for each respective year according to administrative subdivisions of January 1st of the following year\\r\\n\",\"type\":\"c\"},{\"code\":\"BE0101N2\",\"text\":\"Population growth\",\"comment\":\"Population growth is defined as the difference between the population at the beginning of the year and at the end of the year.\\r\\n\",\"type\":\"c\"}],\"comments\":[],\"data\":[{\"key\":[\"00\",\"OG\",\"45\",\"2011\"],\"values\":[\"48403\",\"1007\"]}]}";

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(input);

        String expected = "[{\"region\": \"00\",\"values\":[{\"text\": \"Population\",\"value\": \"48403\",\"code\":\"BE0101N1\"},{\"text\":\"Population growth\",\"value\":\"1007\",\"code\":\"BE0101N2\"}],\"alder\":\"45\",\"tid\":\"2011\",\"civilstand\":\"OG\"}]";
        String toString = format.toString();

        // Remove whitespace for easier comparison; JSON is still valid
        expected = expected.replace(" ", "");
        toString = expected.replace(" ", "");

        assertEquals(expected, toString);
    }
}
