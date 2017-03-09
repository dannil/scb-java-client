/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.model.population.amount;

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
public class PopulationTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<ValueNode<String>>();
        this.values2 = new ArrayList<ValueNode<String>>();

        ValueNode<String> value = new ValueNode<String>("12345", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<String>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        Population population = new Population();

        assertNotNull(population);
    }

    @Test
    public void setRegion() {
        Population population = new Population();

        population.setRegion("1267");

        assertNotNull(population.getRegion());
    }

    @Test
    public void getRegion() {
        Population population = new Population();

        population.setRegion("1267");

        assertEquals("1267", population.getRegion());
    }

    @Test
    public void setRelationshipStatus() {
        Population population = new Population();

        population.setRelationshipStatus("G");

        assertNotNull(population.getRelationshipStatus());
    }

    @Test
    public void getRelationshipStatus() {
        Population population = new Population();

        population.setRelationshipStatus("G");

        assertEquals("G", population.getRelationshipStatus());
    }

    @Test
    public void setAge() {
        Population population = new Population();

        population.setAge("20");

        assertNotNull(population.getAge());
    }

    @Test
    public void getAge() {
        Population population = new Population();

        population.setAge("20");

        assertEquals("20", population.getAge());
    }

    @Test
    public void setGender() {
        Population population = new Population();

        population.setGender(1);

        assertNotNull(population.getGender());
    }

    @Test
    public void getGender() {
        Population population = new Population();

        population.setGender(1);

        assertEquals(Integer.valueOf(1), population.getGender());
    }

    @Test
    public void setTime() {
        Population population = new Population();

        population.setTime(2011);

        assertNotNull(population.getTime());
    }

    @Test
    public void getTime() {
        Population population = new Population();

        population.setTime(2011);

        assertEquals(Integer.valueOf(2011), population.getTime());
    }

    @Test
    public void setValues() {
        Population population = new Population();

        population.setValues(this.values);

        assertNotNull(population.getValues());
    }

    @Test
    public void getValues() {
        Population population = new Population();

        population.setValues(this.values);

        assertEquals(this.values, population.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(Population.getInputs());
    }

    @Test
    public void equals() {
        Population population = new Population();
        Population population2 = new Population();

        assertEquals(population, population2);
    }

    @Test
    public void equalsItself() {
        Population population = new Population();

        assertEquals(population, population);
    }

    @Test
    public void notEqualsNull() {
        Population population = new Population();

        assertNotEquals(population, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        Population population = new Population();

        assertNotEquals(population, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);

        assertEquals(population, population2);
    }

    @Test
    public void notEqualsOnRegion() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        Population population2 = new Population("1452", "G", "20", 1, 2011, this.values2);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnFirstNullRegion() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        population.setRegion(null);

        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnSecondNullRegion() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);

        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);
        population2.setRegion(null);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnRelationshipStatus() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        Population population2 = new Population("1267", "SK", "20", 1, 2011, this.values2);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnFirstNullRelationshipStatus() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        population.setRelationshipStatus(null);

        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnSecondNullRelationshipStatus() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);

        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);
        population2.setRelationshipStatus(null);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnAge() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        Population population2 = new Population("1267", "G", "56", 1, 2011, this.values2);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnFirstNullAge() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values2);
        population.setAge(null);

        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnSecondNullAge() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);

        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);
        population2.setAge(null);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnGender() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        Population population2 = new Population("1267", "G", "20", 2, 2011, this.values2);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnFirstNullGender() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        population.setGender(null);

        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnSecondNullGender() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);

        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);
        population2.setGender(null);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnTime() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        Population population2 = new Population("1267", "G", "20", 1, 1999, this.values2);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnFirstNullTime() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        population.setTime(null);

        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnSecondNullTime() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);

        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);
        population2.setTime(null);

        assertNotEquals(population, population2);
    }

    @Test
    public void notEqualsOnValues() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);
        population2.setValue(this.testContentsCode, "54321");

        assertNotEquals(population, population2);
    }

    @Test
    public void equalsHashCode() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);
        Population population2 = new Population("1267", "G", "20", 1, 2011, this.values2);

        assertEquals(population.hashCode(), population2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        Population population = new Population();
        Population population2 = new Population();

        assertEquals(population.hashCode(), population2.hashCode());
    }

    @Test
    public void convertToStringNullValues() {
        Population population = new Population();

        assertNotNull(population.toString());
    }

    @Test
    public void convertToString() {
        Population population = new Population("1267", "G", "20", 1, 2011, this.values);

        assertTrue(population.toString().contains("1267"));
        assertTrue(population.toString().contains("G"));
        assertTrue(population.toString().contains("20"));
        assertTrue(population.toString().contains("1"));
        assertTrue(population.toString().contains("2011"));
        assertTrue(population.toString().contains("12345"));
    }

}
