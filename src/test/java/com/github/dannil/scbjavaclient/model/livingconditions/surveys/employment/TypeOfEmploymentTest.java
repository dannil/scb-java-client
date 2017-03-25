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
public class TypeOfEmploymentTest {

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
        TypeOfEmployment type = new TypeOfEmployment();

        assertNotNull(type);
    }

    @Test
    public void setType() {
        TypeOfEmployment type = new TypeOfEmployment();

        type.setType("S265");

        assertNotNull(type.getType());
    }

    @Test
    public void getType() {
        TypeOfEmployment type = new TypeOfEmployment();

        type.setType("S265");

        assertEquals("S265", type.getType());
    }

    @Test
    public void setAge() {
        TypeOfEmployment type = new TypeOfEmployment();

        type.setAge("55-64");

        assertNotNull(type.getAge());
    }

    @Test
    public void getAge() {
        TypeOfEmployment type = new TypeOfEmployment();

        type.setAge("55-64");

        assertEquals("55-64", type.getAge());
    }

    @Test
    public void setSex() {
        TypeOfEmployment type = new TypeOfEmployment();

        type.setSex("1");

        assertNotNull(type.getSex());
    }

    @Test
    public void getSex() {
        TypeOfEmployment type = new TypeOfEmployment();

        type.setSex("1");

        assertEquals("1", type.getSex());
    }

    @Test
    public void setTime() {
        TypeOfEmployment type = new TypeOfEmployment();

        type.setTime("2012-2013");

        assertNotNull(type.getTime());
    }

    @Test
    public void getTime() {
        TypeOfEmployment type = new TypeOfEmployment();

        type.setTime("2012-2013");

        assertEquals("2012-2013", type.getTime());
    }

    @Test
    public void setValues() {
        TypeOfEmployment type = new TypeOfEmployment();

        type.setValues(this.values);

        assertNotNull(type.getValues());
    }

    @Test
    public void getValues() {
        TypeOfEmployment type = new TypeOfEmployment();

        type.setValues(this.values);

        assertEquals(this.values, type.getValues());
    }

    @Test
    public void equals() {
        TypeOfEmployment type = new TypeOfEmployment();
        TypeOfEmployment type2 = new TypeOfEmployment();

        assertEquals(type, type2);
    }

    @Test
    public void equalsItself() {
        TypeOfEmployment type = new TypeOfEmployment();

        assertEquals(type, type);
    }

    @Test
    public void notEqualsNull() {
        TypeOfEmployment type = new TypeOfEmployment();

        assertNotEquals(type, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        TypeOfEmployment type = new TypeOfEmployment();

        assertNotEquals(type, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        TypeOfEmployment type = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values);
        TypeOfEmployment type2 = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values2);

        assertEquals(type, type2);
    }

    @Test
    public void notEqualsOnType() {
        TypeOfEmployment type = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values);

        TypeOfEmployment type2 = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values2);
        type2.setType("S260");

        assertNotEquals(type, type2);
    }

    @Test
    public void notEqualsOnAge() {
        TypeOfEmployment type = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values);

        TypeOfEmployment type2 = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values2);
        type2.setAge("45-54");

        assertNotEquals(type, type2);
    }

    @Test
    public void notEqualsOnSex() {
        TypeOfEmployment type = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values);

        TypeOfEmployment type2 = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values2);
        type2.setSex("1");

        assertNotEquals(type, type2);
    }

    @Test
    public void notEqualsOnTime() {
        TypeOfEmployment type = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values);

        TypeOfEmployment type2 = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values2);
        type2.setTime("2010-2011");

        assertNotEquals(type, type2);
    }

    @Test
    public void notEqualsOnValue() {
        TypeOfEmployment type = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values);

        TypeOfEmployment type2 = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values2);
        type2.setValue(this.testContentsCode, 65.65);

        assertNotEquals(type, type2);
    }

    @Test
    public void equalsHashCode() {
        TypeOfEmployment type = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values);
        TypeOfEmployment type2 = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values2);

        assertEquals(type.hashCode(), type2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        TypeOfEmployment type = new TypeOfEmployment();
        TypeOfEmployment type2 = new TypeOfEmployment();

        assertEquals(type.hashCode(), type2.hashCode());
    }

    @Test
    public void convertToString() {
        TypeOfEmployment type = new TypeOfEmployment("S365", "25-34", "2", "2008-2009", this.values);

        assertTrue(type.toString().contains("S365"));
        assertTrue(type.toString().contains("25-34"));
        assertTrue(type.toString().contains("2"));
        assertTrue(type.toString().contains("2008-2009"));
    }

    @Test
    public void convertToStringNullValues() {
        TypeOfEmployment type = new TypeOfEmployment();

        assertNotNull(type.toString());
    }

}
