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

package com.github.dannil.scbjavaclient.model.livingconditions.surveys.health;

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
public class HealthTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<String> value = new ValueNode<>("55", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        Health health = new Health();

        assertNotNull(health);
    }

    @Test
    public void setIndicator() {
        Health health = new Health();

        health.setIndicator("A438");

        assertNotNull(health.getIndicator());
    }

    @Test
    public void getIndicator() {
        Health health = new Health();

        health.setIndicator("A438");

        assertEquals("A438", health.getIndicator());
    }

    @Test
    public void setAge() {
        Health health = new Health();

        health.setAge("55-64");

        assertNotNull(health.getAge());
    }

    @Test
    public void getAge() {
        Health health = new Health();

        health.setAge("55-64");

        assertEquals("55-64", health.getAge());
    }

    @Test
    public void setSex() {
        Health health = new Health();

        health.setSex(1);

        assertNotNull(health.getSex());
    }

    @Test
    public void getSex() {
        Health health = new Health();

        health.setSex(1);

        assertEquals(Integer.valueOf(1), health.getSex());
    }

    @Test
    public void setTime() {
        Health health = new Health();

        health.setTime("2012-2013");

        assertNotNull(health.getTime());
    }

    @Test
    public void getTime() {
        Health health = new Health();

        health.setTime("2012-2013");

        assertEquals("2012-2013", health.getTime());
    }

    @Test
    public void setValues() {
        Health health = new Health();

        health.setValues(this.values);

        assertNotNull(health.getValues());
    }

    @Test
    public void getValues() {
        Health health = new Health();

        health.setValues(this.values);

        assertEquals(this.values, health.getValues());
    }

    @Test
    public void equals() {
        Health health = new Health();
        Health health2 = new Health();

        assertEquals(health, health2);
    }

    @Test
    public void equalsItself() {
        Health health = new Health();

        assertEquals(health, health);
    }

    @Test
    public void notEqualsNull() {
        Health health = new Health();

        assertNotEquals(health, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        Health health = new Health();

        assertNotEquals(health, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        Health health = new Health("A435", "25-34", 2, "2008-2009", this.values);
        Health health2 = new Health("A435", "25-34", 2, "2008-2009", this.values2);

        assertEquals(health, health2);
    }

    @Test
    public void notEqualsOnIndicator() {
        Health health = new Health("A435", "25-34", 2, "2008-2009", this.values);

        Health health2 = new Health("A435", "25-34", 2, "2008-2009", this.values2);
        health2.setIndicator("A440");

        assertNotEquals(health, health2);
    }

    @Test
    public void notEqualsOnAge() {
        Health health = new Health("A435", "25-34", 2, "2008-2009", this.values);

        Health health2 = new Health("A435", "25-34", 2, "2008-2009", this.values2);
        health2.setAge("45-54");

        assertNotEquals(health, health2);
    }

    @Test
    public void notEqualsOnSex() {
        Health health = new Health("A435", "25-34", 2, "2008-2009", this.values);

        Health health2 = new Health("A435", "25-34", 2, "2008-2009", this.values2);
        health2.setSex(1);

        assertNotEquals(health, health2);
    }

    @Test
    public void notEqualsOnTime() {
        Health health = new Health("A435", "25-34", 2, "2008-2009", this.values);

        Health health2 = new Health("A435", "25-34", 2, "2008-2009", this.values2);
        health2.setTime("2010-2011");

        assertNotEquals(health, health2);
    }

    @Test
    public void notEqualsOnValue() {
        Health health = new Health("A435", "25-34", 2, "2008-2009", this.values);

        Health health2 = new Health("A435", "25-34", 2, "2008-2009", this.values2);
        health2.setValue(this.testContentsCode, "65.65");

        assertNotEquals(health, health2);
    }

    @Test
    public void equalsHashCode() {
        Health health = new Health("A435", "25-34", 2, "2008-2009", this.values);
        Health health2 = new Health("A435", "25-34", 2, "2008-2009", this.values2);

        assertEquals(health.hashCode(), health2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        Health health = new Health();
        Health health2 = new Health();

        assertEquals(health.hashCode(), health2.hashCode());
    }

    @Test
    public void convertToString() {
        Health health = new Health("A435", "25-34", 2, "2008-2009", this.values);

        assertTrue(health.toString().contains("A435"));
        assertTrue(health.toString().contains("25-34"));
        assertTrue(health.toString().contains("2"));
        assertTrue(health.toString().contains("2008-2009"));
    }

    @Test
    public void convertToStringNullValues() {
        Health health = new Health();

        assertNotNull(health.toString());
    }

}
