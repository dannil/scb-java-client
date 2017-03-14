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

package com.github.dannil.scbjavaclient.model.energy.annualstatistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.github.dannil.scbjavaclient.model.ValueNode;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ElectricitySupplyTest {

    private String testContentsCode;

    private List<ValueNode<Integer>> values;
    private List<ValueNode<Integer>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<Integer> value = new ValueNode<>(1661, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Integer> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        ElectricitySupply supply = new ElectricitySupply();

        assertNotNull(supply);
    }

    @Test
    public void setPowerPlant() {
        ElectricitySupply supply = new ElectricitySupply();

        supply.setPowerPlant("Annan");

        assertNotNull(supply.getPowerPlant());
    }

    @Test
    public void getPowerPlant() {
        ElectricitySupply supply = new ElectricitySupply();

        supply.setPowerPlant("Annan");

        assertEquals("Annan", supply.getPowerPlant());
    }

    @Test
    public void setValues() {
        ElectricitySupply supply = new ElectricitySupply();

        supply.setValues(this.values);

        assertNotNull(supply.getValues());
    }

    @Test
    public void getValues() {
        ElectricitySupply supply = new ElectricitySupply();

        supply.setValues(this.values);

        assertEquals(this.values, supply.getValues());
    }

    @Test
    public void equals() {
        ElectricitySupply supply = new ElectricitySupply();
        ElectricitySupply supply2 = new ElectricitySupply();

        assertEquals(supply, supply2);
    }

    @Test
    public void equalsItself() {
        ElectricitySupply supply = new ElectricitySupply();

        assertEquals(supply, supply);
    }

    @Test
    public void notEqualsNull() {
        ElectricitySupply supply = new ElectricitySupply();

        assertNotEquals(supply, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        ElectricitySupply supply = new ElectricitySupply();

        assertNotEquals(supply, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        ElectricitySupply supply = new ElectricitySupply("Kondens", 2013, this.values);
        ElectricitySupply supply2 = new ElectricitySupply("Kondens", 2013, this.values2);

        assertEquals(supply, supply2);
    }

    @Test
    public void notEqualsOnPowerPlant() {
        ElectricitySupply supply = new ElectricitySupply("Kondens", 2013, this.values);

        ElectricitySupply supply2 = new ElectricitySupply("Kondens", 2013, this.values2);
        supply2.setPowerPlant("E2");

        assertNotEquals(supply, supply2);
    }

    @Test
    public void notEqualsOnValue() {
        ElectricitySupply supply = new ElectricitySupply("Kondens", 2013, this.values);

        ElectricitySupply supply2 = new ElectricitySupply("Kondens", 2013, this.values2);
        supply2.setValue(this.testContentsCode, 99009);

        assertNotEquals(supply, supply2);
    }

    @Test
    public void equalsHashCode() {
        ElectricitySupply supply = new ElectricitySupply("Kondens", 2013, this.values);
        ElectricitySupply supply2 = new ElectricitySupply("Kondens", 2013, this.values2);

        assertEquals(supply.hashCode(), supply2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        ElectricitySupply supply = new ElectricitySupply();
        ElectricitySupply supply2 = new ElectricitySupply();

        assertEquals(supply.hashCode(), supply2.hashCode());
    }

    @Test
    public void convertToString() {
        ElectricitySupply supply = new ElectricitySupply("Kondens", 2013, this.values);

        assertTrue(supply.toString().contains("Kondens"));
        assertTrue(supply.toString().contains("2013"));
    }

    @Test
    public void convertToStringNullValues() {
        ElectricitySupply supply = new ElectricitySupply();

        assertNotNull(supply.toString());
    }

}
