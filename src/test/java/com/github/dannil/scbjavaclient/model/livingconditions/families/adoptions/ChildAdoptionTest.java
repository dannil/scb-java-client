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

package com.github.dannil.scbjavaclient.model.livingconditions.families.adoptions;

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
public class ChildAdoptionTest {

    private String testContentsCode;

    private List<ValueNode<Integer>> values;
    private List<ValueNode<Integer>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<Integer> value = new ValueNode<>(1234, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Integer> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        ChildAdoption adoption = new ChildAdoption();

        assertNotNull(adoption);
    }

    @Test
    public void setSex() {
        ChildAdoption adoption = new ChildAdoption();

        adoption.setSex("5");

        assertNotNull(adoption.getSex());
    }

    @Test
    public void getSex() {
        ChildAdoption adoption = new ChildAdoption();

        adoption.setSex("5");

        assertEquals("5", adoption.getSex());
    }

    @Test
    public void setAge() {
        ChildAdoption adoption = new ChildAdoption();

        adoption.setAge("18-21");

        assertNotNull(adoption.getAge());
    }

    @Test
    public void getAge() {
        ChildAdoption adoption = new ChildAdoption();

        adoption.setAge("18-21");

        assertEquals("18-21", adoption.getAge());
    }

    @Test
    public void setBirthCountry() {
        ChildAdoption adoption = new ChildAdoption();

        adoption.setBirthCountry("VN");

        assertNotNull(adoption.getBirthCountry());
    }

    @Test
    public void getFamilyType() {
        ChildAdoption adoption = new ChildAdoption();

        adoption.setBirthCountry("VN");

        assertEquals("VN", adoption.getBirthCountry());
    }

    @Test
    public void setTime() {
        ChildAdoption adoption = new ChildAdoption();

        adoption.setTime(2015);

        assertNotNull(adoption.getTime());
    }

    @Test
    public void getTime() {
        ChildAdoption adoption = new ChildAdoption();

        adoption.setTime(2015);

        assertEquals(Integer.valueOf(2015), adoption.getTime());
    }

    @Test
    public void setValues() {
        ChildAdoption adoption = new ChildAdoption();

        adoption.setValues(this.values);

        assertNotNull(adoption.getValues());
    }

    @Test
    public void getValues() {
        ChildAdoption adoption = new ChildAdoption();

        adoption.setValues(this.values);

        assertEquals(this.values, adoption.getValues());
    }

    @Test
    public void equals() {
        ChildAdoption adoption = new ChildAdoption();
        ChildAdoption adoption2 = new ChildAdoption();

        assertEquals(adoption, adoption2);
    }

    @Test
    public void equalsItself() {
        ChildAdoption adoption = new ChildAdoption();

        assertEquals(adoption, adoption);
    }

    @Test
    public void notEqualsNull() {
        ChildAdoption adoption = new ChildAdoption();

        assertNotEquals(adoption, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        ChildAdoption adoption = new ChildAdoption();

        assertNotEquals(adoption, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        ChildAdoption adoption = new ChildAdoption("6", "12", "ET", 2009, this.values);
        ChildAdoption adoption2 = new ChildAdoption("6", "12", "ET", 2009, this.values2);

        assertEquals(adoption, adoption2);
    }

    @Test
    public void notEqualsOnSex() {
        ChildAdoption adoption = new ChildAdoption("6", "12", "ET", 2009, this.values);

        ChildAdoption adoption2 = new ChildAdoption("6", "12", "ET", 2009, this.values2);
        adoption2.setSex("5");

        assertNotEquals(adoption, adoption2);
    }

    @Test
    public void notEqualsOnAge() {
        ChildAdoption adoption = new ChildAdoption("6", "12", "ET", 2009, this.values);

        ChildAdoption adoption2 = new ChildAdoption("6", "12", "ET", 2009, this.values2);
        adoption2.setAge("6-12");

        assertNotEquals(adoption, adoption2);
    }

    @Test
    public void notEqualsOnBirthCountry() {
        ChildAdoption adoption = new ChildAdoption("6", "12", "ET", 2009, this.values);

        ChildAdoption adoption2 = new ChildAdoption("6", "12", "ET", 2009, this.values2);
        adoption2.setBirthCountry("VN");

        assertNotEquals(adoption, adoption2);
    }

    @Test
    public void notEqualsOnTime() {
        ChildAdoption adoption = new ChildAdoption("6", "12", "ET", 2009, this.values);

        ChildAdoption adoption2 = new ChildAdoption("6", "12", "ET", 2009, this.values2);
        adoption2.setTime(2014);

        assertNotEquals(adoption, adoption2);
    }

    @Test
    public void notEqualsOnValue() {
        ChildAdoption adoption = new ChildAdoption("6", "12", "ET", 2009, this.values);

        ChildAdoption adoption2 = new ChildAdoption("6", "12", "ET", 2009, this.values2);
        adoption2.setValue(this.testContentsCode, 15121);

        assertNotEquals(adoption, adoption2);
    }

    @Test
    public void equalsHashCode() {
        ChildAdoption adoption = new ChildAdoption("6", "12", "ET", 2009, this.values);
        ChildAdoption adoption2 = new ChildAdoption("6", "12", "ET", 2009, this.values2);

        assertEquals(adoption.hashCode(), adoption2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        ChildAdoption adoption = new ChildAdoption();
        ChildAdoption adoption2 = new ChildAdoption();

        assertEquals(adoption.hashCode(), adoption2.hashCode());
    }

    @Test
    public void convertToString() {
        ChildAdoption adoption = new ChildAdoption("6", "12", "ET", 2009, this.values);

        assertTrue(adoption.toString().contains("6"));
        assertTrue(adoption.toString().contains("12"));
        assertTrue(adoption.toString().contains("ET"));
        assertTrue(adoption.toString().contains("2009"));
    }

    @Test
    public void convertToStringNullValues() {
        ChildAdoption adoption = new ChildAdoption();

        assertNotNull(adoption.toString());
    }

}
