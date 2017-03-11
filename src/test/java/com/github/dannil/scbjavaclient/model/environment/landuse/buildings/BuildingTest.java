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
        Building building = new Building();

        assertNotNull(building);
    }

    @Test
    public void setRegion() {
        Building building = new Building();

        building.setRegion("1267");

        assertNotNull(building.getRegion());
    }

    @Test
    public void getRegion() {
        Building building = new Building();

        building.setRegion("1267");

        assertEquals("1267", building.getRegion());
    }

    @Test
    public void setType() {
        Building building = new Building();

        building.setType(4);

        assertNotNull(building.getType());
    }

    @Test
    public void getType() {
        Building building = new Building();

        building.setType(4);

        assertEquals(Integer.valueOf(4), building.getType());
    }

    @Test
    public void setTime() {
        Building building = new Building();

        building.setTime(2011);

        assertNotNull(building.getTime());
    }

    @Test
    public void getTime() {
        Building building = new Building();

        building.setTime(2011);

        assertEquals(Integer.valueOf(2011), building.getTime());
    }

    @Test
    public void setValues() {
        Building building = new Building();

        building.setValues(this.values);

        assertNotNull(building.getValues());
    }

    @Test
    public void getValues() {
        Building building = new Building();

        building.setValues(this.values);

        assertEquals(this.values, building.getValues());
    }

    @Test
    public void equals() {
        Building building = new Building();
        Building building2 = new Building();

        assertEquals(building, building2);
    }

    @Test
    public void equalsItself() {
        Building building = new Building();

        assertEquals(building, building);
    }

    @Test
    public void notEqualsNull() {
        Building building = new Building();

        assertNotEquals(building, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        Building building = new Building();

        assertNotEquals(building, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        Building building = new Building("0114", 3, 2010, this.values);
        Building building2 = new Building("0114", 3, 2010, this.values2);

        assertEquals(building, building2);
    }

    @Test
    public void notEqualsOnRegion() {
        Building building = new Building("0114", 3, 2010, this.values);

        Building building2 = new Building("0114", 3, 2010, this.values2);
        building2.setRegion("1263");

        assertNotEquals(building, building2);
    }

    @Test
    public void notEqualsOnType() {
        Building building = new Building("0114", 3, 2010, this.values);

        Building building2 = new Building("0114", 3, 2010, this.values2);
        building2.setType(2);

        assertNotEquals(building, building2);
    }

    @Test
    public void notEqualsOnTime() {
        Building building = new Building("0114", 3, 2010, this.values);

        Building building2 = new Building("0114", 3, 2010, this.values2);
        building2.setTime(2011);

        assertNotEquals(building, building2);
    }

    @Test
    public void notEqualsOnValue() {
        Building building = new Building("0114", 3, 2010, this.values);

        Building building2 = new Building("0114", 3, 2010, this.values2);
        building2.setValue(this.testContentsCode, "65432");

        assertNotEquals(building, building2);
    }

    @Test
    public void equalsHashCode() {
        Building building = new Building("0114", 3, 2010, this.values);
        Building building2 = new Building("0114", 3, 2010, this.values2);

        assertEquals(building.hashCode(), building2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        Building building = new Building();
        Building building2 = new Building();

        assertEquals(building.hashCode(), building2.hashCode());
    }

    @Test
    public void convertToString() {
        Building building = new Building("0114", 3, 2010, this.values);

        assertNotNull(building.toString());
    }

    @Test
    public void convertToStringNullValues() {
        Building building = new Building();

        assertNotNull(building.toString());
    }

}
