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
public class WaterDischargeTest {

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
        WaterDischarge water = new WaterDischarge();

        assertNotNull(water);
    }

    @Test
    public void setRegion() {
        WaterDischarge water = new WaterDischarge();

        water.setRegion("05");

        assertNotNull(water.getRegion());
    }

    @Test
    public void getRegion() {
        WaterDischarge water = new WaterDischarge();

        water.setRegion("05");

        assertEquals("05", water.getRegion());
    }

    @Test
    public void setRecipient() {
        WaterDischarge water = new WaterDischarge();

        water.setRecipient(90);

        assertNotNull(water.getRecipient());
    }

    @Test
    public void getRecipient() {
        WaterDischarge water = new WaterDischarge();

        water.setRecipient(190);

        assertEquals(Integer.valueOf(190), water.getRecipient());
    }

    @Test
    public void setTime() {
        WaterDischarge water = new WaterDischarge();

        water.setTime(2015);

        assertNotNull(water.getTime());
    }

    @Test
    public void getTime() {
        WaterDischarge water = new WaterDischarge();

        water.setTime(2015);

        assertEquals(Integer.valueOf(2015), water.getTime());
    }

    @Test
    public void setValues() {
        WaterDischarge water = new WaterDischarge();

        water.setValues(this.values);

        assertNotNull(water.getValues());
    }

    @Test
    public void getValues() {
        WaterDischarge water = new WaterDischarge();

        water.setValues(this.values);

        assertEquals(this.values, water.getValues());
    }

    @Test
    public void equals() {
        WaterDischarge water = new WaterDischarge();
        WaterDischarge water2 = new WaterDischarge();

        assertEquals(water, water2);
    }

    @Test
    public void equalsItself() {
        WaterDischarge water = new WaterDischarge();

        assertEquals(water, water);
    }

    @Test
    public void notEqualsNull() {
        WaterDischarge water = new WaterDischarge();

        assertNotEquals(water, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        WaterDischarge water = new WaterDischarge();

        assertNotEquals(water, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        WaterDischarge water = new WaterDischarge("07", 160, 2010, this.values);
        WaterDischarge water2 = new WaterDischarge("07", 160, 2010, this.values2);

        assertEquals(water, water2);
    }

    @Test
    public void notEqualsOnRegion() {
        WaterDischarge water = new WaterDischarge("07", 160, 2010, this.values);

        WaterDischarge water2 = new WaterDischarge("07", 160, 2010, this.values2);
        water2.setRegion("1263");

        assertNotEquals(water, water2);
    }

    @Test
    public void notEqualsOnType() {
        WaterDischarge water = new WaterDischarge("07", 160, 2010, this.values);

        WaterDischarge water2 = new WaterDischarge("07", 160, 2010, this.values2);
        water2.setRecipient(100);

        assertNotEquals(water, water2);
    }

    @Test
    public void notEqualsOnTime() {
        WaterDischarge water = new WaterDischarge("07", 160, 2010, this.values);

        WaterDischarge water2 = new WaterDischarge("07", 160, 2010, this.values2);
        water2.setTime(2011);

        assertNotEquals(water, water2);
    }

    @Test
    public void notEqualsOnValue() {
        WaterDischarge water = new WaterDischarge("07", 160, 2010, this.values);

        WaterDischarge water2 = new WaterDischarge("07", 160, 2010, this.values2);
        water2.setValue(this.testContentsCode, "800");

        assertNotEquals(water, water2);
    }

    @Test
    public void equalsHashCode() {
        WaterDischarge water = new WaterDischarge("07", 160, 2010, this.values);
        WaterDischarge water2 = new WaterDischarge("07", 160, 2010, this.values2);

        assertEquals(water.hashCode(), water2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        WaterDischarge water = new WaterDischarge();
        WaterDischarge water2 = new WaterDischarge();

        assertEquals(water.hashCode(), water2.hashCode());
    }

    @Test
    public void convertToString() {
        WaterDischarge water = new WaterDischarge("07", 160, 2010, this.values);

        assertNotNull(water.toString());
    }

    @Test
    public void convertToStringNullValues() {
        WaterDischarge water = new WaterDischarge();

        assertNotNull(water.toString());
    }

}
