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

package com.github.dannil.scbjavaclient.model.environment.industrialwateruse;

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
public class WaterUsageTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<ValueNode<String>>();
        this.values2 = new ArrayList<ValueNode<String>>();

        ValueNode<String> value = new ValueNode<String>("400", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<String>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        WaterUsage water = new WaterUsage();

        assertNotNull(water);
    }

    @Test
    public void setRegion() {
        WaterUsage water = new WaterUsage();

        water.setRegion("05");

        assertNotNull(water.getRegion());
    }

    @Test
    public void getRegion() {
        WaterUsage water = new WaterUsage();

        water.setRegion("05");

        assertEquals("05", water.getRegion());
    }

    @Test
    public void setType() {
        WaterUsage water = new WaterUsage();

        water.setType(80);

        assertNotNull(water.getType());
    }

    @Test
    public void getType() {
        WaterUsage water = new WaterUsage();

        water.setType(80);

        assertEquals(Integer.valueOf(80), water.getType());
    }

    @Test
    public void setTime() {
        WaterUsage water = new WaterUsage();

        water.setTime(2010);

        assertNotNull(water.getTime());
    }

    @Test
    public void getTime() {
        WaterUsage water = new WaterUsage();

        water.setTime(2010);

        assertEquals(Integer.valueOf(2010), water.getTime());
    }

    @Test
    public void setValues() {
        WaterUsage water = new WaterUsage();

        water.setValues(this.values);

        assertNotNull(water.getValues());
    }

    @Test
    public void getValues() {
        WaterUsage water = new WaterUsage();

        water.setValues(this.values);

        assertEquals(this.values, water.getValues());
    }

    @Test
    public void equals() {
        WaterUsage water = new WaterUsage();
        WaterUsage water2 = new WaterUsage();

        assertEquals(water, water2);
    }

    @Test
    public void equalsItself() {
        WaterUsage water = new WaterUsage();

        assertEquals(water, water);
    }

    @Test
    public void notEqualsNull() {
        WaterUsage water = new WaterUsage();

        assertNotEquals(water, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        WaterUsage water = new WaterUsage();

        assertNotEquals(water, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        WaterUsage water = new WaterUsage("07", 70, 2010, this.values);
        WaterUsage water2 = new WaterUsage("07", 70, 2010, this.values2);

        assertEquals(water, water2);
    }

    @Test
    public void notEqualsOnRegion() {
        WaterUsage water = new WaterUsage("07", 70, 2010, this.values);

        WaterUsage water2 = new WaterUsage("07", 70, 2010, this.values2);
        water2.setRegion("09");

        assertNotEquals(water, water2);
    }

    @Test
    public void notEqualsOnType() {
        WaterUsage water = new WaterUsage("07", 70, 2010, this.values);

        WaterUsage water2 = new WaterUsage("07", 70, 2010, this.values2);
        water2.setType(40);

        assertNotEquals(water, water2);
    }

    @Test
    public void notEqualsOnTime() {
        WaterUsage water = new WaterUsage("07", 70, 2010, this.values);

        WaterUsage water2 = new WaterUsage("07", 70, 2010, this.values2);
        water2.setTime(2015);

        assertNotEquals(water, water2);
    }

    @Test
    public void notEqualsOnValue() {
        WaterUsage water = new WaterUsage("07", 70, 2010, this.values);

        WaterUsage water2 = new WaterUsage("07", 70, 2010, this.values2);
        water2.setValue(this.testContentsCode, "800");

        assertNotEquals(water, water2);
    }

    @Test
    public void equalsHashCode() {
        WaterUsage water = new WaterUsage("07", 70, 2010, this.values);
        WaterUsage water2 = new WaterUsage("07", 70, 2010, this.values2);

        assertEquals(water.hashCode(), water2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        WaterUsage water = new WaterUsage();
        WaterUsage water2 = new WaterUsage();

        assertEquals(water.hashCode(), water2.hashCode());
    }

    @Test
    public void convertToString() {
        WaterUsage water = new WaterUsage("07", 70, 2010, this.values);

        assertNotNull(water.toString());
    }

    @Test
    public void convertToStringNullValues() {
        WaterUsage water = new WaterUsage();

        assertNotNull(water.toString());
    }

}
