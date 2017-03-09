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

package com.github.dannil.scbjavaclient.model.environment.landuse.buildings;

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
public class BuildingTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<String> value = new ValueNode<>("40000", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<String>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        Building b = new Building();

        assertNotNull(b);
    }

    @Test
    public void setRegion() {
        Building b = new Building();

        b.setRegion("1267");

        assertNotNull(b.getRegion());
    }

    @Test
    public void getRegion() {
        Building b = new Building();

        b.setRegion("1267");

        assertEquals("1267", b.getRegion());
    }

    @Test
    public void setType() {
        Building b = new Building();

        b.setType(4);

        assertNotNull(b.getType());
    }

    @Test
    public void getType() {
        Building b = new Building();

        b.setType(4);

        assertEquals(Integer.valueOf(4), b.getType());
    }

    @Test
    public void setTime() {
        Building b = new Building();

        b.setTime(2011);

        assertNotNull(b.getTime());
    }

    @Test
    public void getTime() {
        Building b = new Building();

        b.setTime(2011);

        assertEquals(Integer.valueOf(2011), b.getTime());
    }

    @Test
    public void setValues() {
        Building b = new Building();

        b.setValues(this.values);

        assertNotNull(b.getValues());
    }

    @Test
    public void getValues() {
        Building b = new Building();

        b.setValues(this.values);

        assertEquals(this.values, b.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(Building.getInputs());
    }

    @Test
    public void equals() {
        Building b = new Building();
        Building b2 = new Building();

        assertEquals(b, b2);
    }

    @Test
    public void equalsItself() {
        Building b = new Building();

        assertEquals(b, b);
    }

    @Test
    public void notEqualsNull() {
        Building b = new Building();

        assertNotEquals(b, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        Building b = new Building();

        assertNotEquals(b, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        Building b = new Building("0114", 3, 2010, this.values);
        Building b2 = new Building("0114", 3, 2010, this.values2);

        assertEquals(b, b2);
    }

    @Test
    public void notEqualsOnRegion() {
        Building b = new Building("0114", 3, 2010, this.values);

        Building b2 = new Building("0114", 3, 2010, this.values2);
        b2.setRegion("1263");

        assertNotEquals(b, b2);
    }

    @Test
    public void notEqualsOnType() {
        Building b = new Building("0114", 3, 2010, this.values);

        Building b2 = new Building("0114", 3, 2010, this.values2);
        b2.setType(2);

        assertNotEquals(b, b2);
    }

    @Test
    public void notEqualsOnTime() {
        Building b = new Building("0114", 3, 2010, this.values);

        Building b2 = new Building("0114", 3, 2010, this.values2);
        b2.setTime(2011);

        assertNotEquals(b, b2);
    }

    @Test
    public void notEqualsOnValue() {
        Building b = new Building("0114", 3, 2010, this.values);

        Building b2 = new Building("0114", 3, 2010, this.values2);
        b2.setValue(this.testContentsCode, "65432");

        assertNotEquals(b, b2);
    }

    @Test
    public void equalsHashCode() {
        Building b = new Building("0114", 3, 2010, this.values);
        Building b2 = new Building("0114", 3, 2010, this.values2);

        assertEquals(b.hashCode(), b2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        Building b = new Building();
        Building b2 = new Building();

        assertEquals(b.hashCode(), b2.hashCode());
    }

    @Test
    public void convertToString() {
        Building b = new Building("0114", 3, 2010, this.values);

        assertNotNull(b.toString());
    }

    @Test
    public void convertToStringNullValues() {
        Building b = new Building();

        assertNotNull(b.toString());
    }

}
