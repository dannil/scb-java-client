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

package com.github.dannil.scbjavaclient.model.livingconditions.families.siblings;

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
public class SiblingsTest {

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
        Siblings siblings = new Siblings();

        assertNotNull(siblings);
    }

    @Test
    public void setSex() {
        Siblings siblings = new Siblings();

        siblings.setSex("5");

        assertNotNull(siblings.getSex());
    }

    @Test
    public void getSex() {
        Siblings siblings = new Siblings();

        siblings.setSex("5");

        assertEquals("5", siblings.getSex());
    }

    @Test
    public void setAge() {
        Siblings siblings = new Siblings();

        siblings.setAge("18-21");

        assertNotNull(siblings.getAge());
    }

    @Test
    public void getAge() {
        Siblings siblings = new Siblings();

        siblings.setAge("18-21");

        assertEquals("18-21", siblings.getAge());
    }

    @Test
    public void setSiblingsLivingAtHome() {
        Siblings siblings = new Siblings();

        siblings.setSiblingsLivingAtHome(80);

        assertNotNull(siblings.getSiblingsLivingAtHome());
    }

    @Test
    public void getSiblingsLivingAtHome() {
        Siblings siblings = new Siblings();

        siblings.setSiblingsLivingAtHome(80);

        assertEquals(Integer.valueOf(80), siblings.getSiblingsLivingAtHome());
    }

    @Test
    public void setFamilyType() {
        Siblings siblings = new Siblings();

        siblings.setFamilyType("BR");

        assertNotNull(siblings.getFamilyType());
    }

    @Test
    public void getFamilyType() {
        Siblings siblings = new Siblings();

        siblings.setFamilyType("BR");

        assertEquals("BR", siblings.getFamilyType());
    }

    @Test
    public void setTime() {
        Siblings siblings = new Siblings();

        siblings.setTime(2015);

        assertNotNull(siblings.getTime());
    }

    @Test
    public void getTime() {
        Siblings siblings = new Siblings();

        siblings.setTime(2015);

        assertEquals(Integer.valueOf(2015), siblings.getTime());
    }

    @Test
    public void setValues() {
        Siblings siblings = new Siblings();

        siblings.setValues(this.values);

        assertNotNull(siblings.getValues());
    }

    @Test
    public void getValues() {
        Siblings siblings = new Siblings();

        siblings.setValues(this.values);

        assertEquals(this.values, siblings.getValues());
    }

    @Test
    public void equals() {
        Siblings siblings = new Siblings();
        Siblings siblings2 = new Siblings();

        assertEquals(siblings, siblings2);
    }

    @Test
    public void equalsItself() {
        Siblings siblings = new Siblings();

        assertEquals(siblings, siblings);
    }

    @Test
    public void notEqualsNull() {
        Siblings siblings = new Siblings();

        assertNotEquals(siblings, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        Siblings siblings = new Siblings();

        assertNotEquals(siblings, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        Siblings siblings = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values);
        Siblings siblings2 = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values2);

        assertEquals(siblings, siblings2);
    }

    @Test
    public void notEqualsOnSex() {
        Siblings siblings = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values);

        Siblings siblings2 = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values2);
        siblings2.setSex("6");

        assertNotEquals(siblings, siblings2);
    }

    @Test
    public void notEqualsOnAge() {
        Siblings siblings = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values);

        Siblings siblings2 = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values2);
        siblings2.setAge("6-12");

        assertNotEquals(siblings, siblings2);
    }

    @Test
    public void notEqualsOnSiblingsLivingAtHome() {
        Siblings siblings = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values);

        Siblings siblings2 = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values2);
        siblings2.setSiblingsLivingAtHome(20);

        assertNotEquals(siblings, siblings2);
    }

    @Test
    public void notEqualsOnFamilyType() {
        Siblings siblings = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values);

        Siblings siblings2 = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values2);
        siblings2.setFamilyType("BorMedUF");

        assertNotEquals(siblings, siblings2);
    }

    @Test
    public void notEqualsOnTime() {
        Siblings siblings = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values);

        Siblings siblings2 = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values2);
        siblings2.setTime(2014);

        assertNotEquals(siblings, siblings2);
    }

    @Test
    public void notEqualsOnValue() {
        Siblings siblings = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values);

        Siblings siblings2 = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values2);
        siblings2.setValue(this.testContentsCode, 15121);

        assertNotEquals(siblings, siblings2);
    }

    @Test
    public void equalsHashCode() {
        Siblings siblings = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values);
        Siblings siblings2 = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values2);

        assertEquals(siblings.hashCode(), siblings2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        Siblings siblings = new Siblings();
        Siblings siblings2 = new Siblings();

        assertEquals(siblings.hashCode(), siblings2.hashCode());
    }

    @Test
    public void convertToString() {
        Siblings siblings = new Siblings("5", "0-17", 40, "EnsamTot", 2015, this.values);

        assertTrue(siblings.toString().contains("5"));
        assertTrue(siblings.toString().contains("0-17"));
        assertTrue(siblings.toString().contains("40"));
        assertTrue(siblings.toString().contains("EnsamTot"));
        assertTrue(siblings.toString().contains("2015"));
    }

    @Test
    public void convertToStringNullValues() {
        Siblings siblings = new Siblings();

        assertNotNull(siblings.toString());
    }

}
