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

package com.github.dannil.scbjavaclient.model.environment.landuse.usage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.github.dannil.scbjavaclient.model.ValueNode;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LandTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<String> value = new ValueNode<>("60000", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        Land land = new Land();

        assertNotNull(land);
    }

    @Test
    public void setRegion() {
        Land land = new Land();

        land.setRegion("1267");

        assertNotNull(land.getRegion());
    }

    @Test
    public void getRegion() {
        Land land = new Land();

        land.setRegion("1267");

        assertEquals("1267", land.getRegion());
    }

    @Test
    public void setCategory() {
        Land land = new Land();

        land.setCategory(4);

        assertNotNull(land.getCategory());
    }

    @Test
    public void getCategory() {
        Land land = new Land();

        land.setCategory(4);

        assertEquals(Integer.valueOf(4), land.getCategory());
    }

    @Test
    public void setYear() {
        Land land = new Land();

        land.setYear(2011);

        assertNotNull(land.getYear());
    }

    @Test
    public void getYear() {
        Land land = new Land();

        land.setYear(2011);

        assertEquals(Integer.valueOf(2011), land.getYear());
    }

    @Test
    public void setValues() {
        Land land = new Land();

        land.setValues(this.values);

        assertNotNull(land.getValues());
    }

    @Test
    public void getValues() {
        Land land = new Land();

        land.setValues(this.values);

        assertEquals(this.values, land.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(Land.getInputs());
    }

    @Test
    public void equals() {
        Land land = new Land();
        Land land2 = new Land();

        assertEquals(land, land2);
    }

    @Test
    public void equalsItself() {
        Land land = new Land();

        assertEquals(land, land);
    }

    @Test
    public void notEqualsNull() {
        Land land = new Land();

        assertNotEquals(land, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        Land land = new Land();

        assertNotEquals(land, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        Land land = new Land("04", 7, 2010, this.values);
        Land land2 = new Land("04", 7, 2010, this.values2);

        assertEquals(land, land2);
    }

    @Test
    public void notEqualsOnRegion() {
        Land land = new Land("04", 7, 2010, this.values);

        Land land2 = new Land("04", 7, 2010, this.values2);
        land2.setRegion("1263");

        assertNotEquals(land, land2);
    }

    @Test
    public void notEqualsOnCategory() {
        Land land = new Land("04", 7, 2010, this.values);

        Land land2 = new Land("04", 7, 2010, this.values2);
        land2.setCategory(2);

        assertNotEquals(land, land2);
    }

    @Test
    public void notEqualsOnYear() {
        Land land = new Land("04", 7, 2010, this.values);

        Land land2 = new Land("04", 7, 2010, this.values2);
        land2.setYear(2011);

        assertNotEquals(land, land2);
    }

    @Test
    public void notEqualsOnValue() {
        Land land = new Land("04", 7, 2010, this.values);

        Land land2 = new Land("04", 7, 2010, this.values2);
        land2.setValue(this.testContentsCode, "126452");

        assertNotEquals(land, land2);
    }

    @Test
    public void equalsHashCode() {
        Land land = new Land("04", 7, 2010, this.values);
        Land land2 = new Land("04", 7, 2010, this.values2);

        assertEquals(land.hashCode(), land2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        Land land = new Land();
        Land land2 = new Land();

        assertEquals(land.hashCode(), land2.hashCode());
    }

    @Test
    public void convertToString() {
        Land land = new Land("04", 7, 2010, this.values);

        assertNotNull(land.toString());
    }

    @Test
    public void convertToStringNullValues() {
        Land land = new Land();

        assertNotNull(land.toString());
    }

}
