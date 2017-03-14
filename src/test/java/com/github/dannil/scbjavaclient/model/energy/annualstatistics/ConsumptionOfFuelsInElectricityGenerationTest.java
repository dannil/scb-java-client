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
public class ConsumptionOfFuelsInElectricityGenerationTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<String> value = new ValueNode<>("46321", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();

        assertNotNull(consumption);
    }

    @Test
    public void setPowerPlant() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();

        consumption.setPowerPlant("Annan");

        assertNotNull(consumption.getPowerPlant());
    }

    @Test
    public void getPowerPlant() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();

        consumption.setPowerPlant("Annan");

        assertEquals("Annan", consumption.getPowerPlant());
    }

    @Test
    public void setFuel() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();

        consumption.setFuel("E02");

        assertNotNull(consumption.getFuel());
    }

    @Test
    public void getFuel() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();

        consumption.setFuel("E02");

        assertEquals("E02", consumption.getFuel());
    }

    @Test
    public void setValues() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();

        consumption.setValues(this.values);

        assertNotNull(consumption.getValues());
    }

    @Test
    public void getValues() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();

        consumption.setValues(this.values);

        assertEquals(this.values, consumption.getValues());
    }

    @Test
    public void equals() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();
        ConsumptionOfFuelsInElectricityGeneration consumption2 = new ConsumptionOfFuelsInElectricityGeneration();

        assertEquals(consumption, consumption2);
    }

    @Test
    public void equalsItself() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();

        assertEquals(consumption, consumption);
    }

    @Test
    public void notEqualsNull() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();

        assertNotEquals(consumption, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();

        assertNotEquals(consumption, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration(
                "Kraftvvarmkond", "E5", 2013, this.values);
        ConsumptionOfFuelsInElectricityGeneration consumption2 = new ConsumptionOfFuelsInElectricityGeneration(
                "Kraftvvarmkond", "E5", 2013, this.values2);

        assertEquals(consumption, consumption2);
    }

    @Test
    public void notEqualsOnPowerPlant() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration(
                "Kraftvvarmkond", "E5", 2013, this.values);

        ConsumptionOfFuelsInElectricityGeneration consumption2 = new ConsumptionOfFuelsInElectricityGeneration(
                "Kraftvvarmkond", "E5", 2013, this.values2);
        consumption2.setPowerPlant("E2");

        assertNotEquals(consumption, consumption2);
    }

    @Test
    public void notEqualsOnFuel() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration(
                "Kraftvvarmkond", "E5", 2013, this.values);

        ConsumptionOfFuelsInElectricityGeneration consumption2 = new ConsumptionOfFuelsInElectricityGeneration(
                "Kraftvvarmkond", "E5", 2013, this.values2);
        consumption2.setFuel("fot");

        assertNotEquals(consumption, consumption2);
    }

    @Test
    public void notEqualsOnValue() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration(
                "Kraftvvarmkond", "E5", 2013, this.values);

        ConsumptionOfFuelsInElectricityGeneration consumption2 = new ConsumptionOfFuelsInElectricityGeneration(
                "Kraftvvarmkond", "E5", 2013, this.values2);
        consumption2.setValue(this.testContentsCode, "99999");

        assertNotEquals(consumption, consumption2);
    }

    @Test
    public void equalsHashCode() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration(
                "Kraftvvarmkond", "E5", 2013, this.values);
        ConsumptionOfFuelsInElectricityGeneration consumption2 = new ConsumptionOfFuelsInElectricityGeneration(
                "Kraftvvarmkond", "E5", 2013, this.values2);

        assertEquals(consumption.hashCode(), consumption2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();
        ConsumptionOfFuelsInElectricityGeneration consumption2 = new ConsumptionOfFuelsInElectricityGeneration();

        assertEquals(consumption.hashCode(), consumption2.hashCode());
    }

    @Test
    public void convertToString() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration(
                "Kraftvvarmkond", "E5", 2013, this.values);

        assertTrue(consumption.toString().contains("Kraftvvarmkond"));
        assertTrue(consumption.toString().contains("E5"));
        assertTrue(consumption.toString().contains("2013"));
    }

    @Test
    public void convertToStringNullValues() {
        ConsumptionOfFuelsInElectricityGeneration consumption = new ConsumptionOfFuelsInElectricityGeneration();

        assertNotNull(consumption.toString());
    }

}
