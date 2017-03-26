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

package com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment;

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
public class GainfullyEmployedPersonsTest {

    private String testContentsCode;

    private List<ValueNode<Double>> values;
    private List<ValueNode<Double>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<Double> value = new ValueNode<>(567.4321, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Double> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        assertNotNull(employed);
    }

    @Test
    public void setFullAndPartTime() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        employed.setFullAndPartTime("S238");

        assertNotNull(employed.getFullAndPartTime());
    }

    @Test
    public void getFullAndPartTime() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        employed.setFullAndPartTime("S238");

        assertEquals("S238", employed.getFullAndPartTime());
    }

    @Test
    public void setAge() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        employed.setAge("55-64");

        assertNotNull(employed.getAge());
    }

    @Test
    public void getAge() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        employed.setAge("55-64");

        assertEquals("55-64", employed.getAge());
    }

    @Test
    public void setSex() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        employed.setSex(1);

        assertNotNull(employed.getSex());
    }

    @Test
    public void getSex() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        employed.setSex(1);

        assertEquals(Integer.valueOf(1), employed.getSex());
    }

    @Test
    public void setTime() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        employed.setTime("2012-2013");

        assertNotNull(employed.getTime());
    }

    @Test
    public void getTime() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        employed.setTime("2012-2013");

        assertEquals("2012-2013", employed.getTime());
    }

    @Test
    public void setValues() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        employed.setValues(this.values);

        assertNotNull(employed.getValues());
    }

    @Test
    public void getValues() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        employed.setValues(this.values);

        assertEquals(this.values, employed.getValues());
    }

    @Test
    public void equals() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();
        GainfullyEmployedPersons employed2 = new GainfullyEmployedPersons();

        assertEquals(employed, employed2);
    }

    @Test
    public void equalsItself() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        assertEquals(employed, employed);
    }

    @Test
    public void notEqualsNull() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        assertNotEquals(employed, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        assertNotEquals(employed, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);
        GainfullyEmployedPersons employed2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009",
                this.values2);

        assertEquals(employed, employed2);
    }

    @Test
    public void notEqualsOnFullAndPartTime() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);

        GainfullyEmployedPersons employed2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009",
                this.values2);
        employed2.setFullAndPartTime("S237");

        assertNotEquals(employed, employed2);
    }

    @Test
    public void notEqualsOnAge() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);

        GainfullyEmployedPersons employed2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009",
                this.values2);
        employed2.setAge("45-54");

        assertNotEquals(employed, employed2);
    }

    @Test
    public void notEqualsOnSex() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);

        GainfullyEmployedPersons employed2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009",
                this.values2);
        employed2.setSex(1);

        assertNotEquals(employed, employed2);
    }

    @Test
    public void notEqualsOnTime() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);

        GainfullyEmployedPersons employed2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009",
                this.values2);
        employed2.setTime("2010-2011");

        assertNotEquals(employed, employed2);
    }

    @Test
    public void notEqualsOnValue() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);

        GainfullyEmployedPersons employed2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009",
                this.values2);
        employed2.setValue(this.testContentsCode, 65.65);

        assertNotEquals(employed, employed2);
    }

    @Test
    public void equalsHashCode() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);
        GainfullyEmployedPersons employed2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009",
                this.values2);

        assertEquals(employed.hashCode(), employed2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();
        GainfullyEmployedPersons employed2 = new GainfullyEmployedPersons();

        assertEquals(employed.hashCode(), employed2.hashCode());
    }

    @Test
    public void convertToString() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);

        assertTrue(employed.toString().contains("S240"));
        assertTrue(employed.toString().contains("25-34"));
        assertTrue(employed.toString().contains("2"));
        assertTrue(employed.toString().contains("2008-2009"));
    }

    @Test
    public void convertToStringNullValues() {
        GainfullyEmployedPersons employed = new GainfullyEmployedPersons();

        assertNotNull(employed.toString());
    }

}
