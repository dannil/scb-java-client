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

import java.util.ArrayList;
import java.util.List;

import com.github.dannil.scbjavaclient.model.ValueNode;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractEmploymentTest {

    private static class DummyEmployment extends AbstractEmployment {

        @Override
        public String toString() {
            return null;
        }

    }

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
        AbstractEmployment employment = new DummyEmployment();

        assertNotNull(employment);
    }

    @Test
    public void setAge() {
        AbstractEmployment employment = new DummyEmployment();

        employment.setAge("55-64");

        assertNotNull(employment.getAge());
    }

    @Test
    public void getAge() {
        AbstractEmployment employment = new DummyEmployment();

        employment.setAge("55-64");

        assertEquals("55-64", employment.getAge());
    }

    @Test
    public void setSex() {
        AbstractEmployment employment = new DummyEmployment();

        employment.setSex(1);

        assertNotNull(employment.getSex());
    }

    @Test
    public void getSex() {
        AbstractEmployment employment = new DummyEmployment();

        employment.setSex(1);

        assertEquals(Integer.valueOf(1), employment.getSex());
    }

    @Test
    public void setTime() {
        AbstractEmployment employment = new DummyEmployment();

        employment.setTime("2012-2013");

        assertNotNull(employment.getTime());
    }

    @Test
    public void getTime() {
        AbstractEmployment employment = new DummyEmployment();

        employment.setTime("2012-2013");

        assertEquals("2012-2013", employment.getTime());
    }

    @Test
    public void setValues() {
        AbstractEmployment employment = new DummyEmployment();

        employment.setValues(this.values);

        assertNotNull(employment.getValues());
    }

    @Test
    public void getValues() {
        AbstractEmployment employment = new DummyEmployment();

        employment.setValues(this.values);

        assertEquals(this.values, employment.getValues());
    }

    @Test
    public void equals() {
        AbstractEmployment employment = new DummyEmployment();
        AbstractEmployment employment2 = new DummyEmployment();

        assertEquals(employment, employment2);
    }

    @Test
    public void equalsItself() {
        AbstractEmployment employment = new DummyEmployment();

        assertEquals(employment, employment);
    }

    @Test
    public void notEqualsNull() {
        AbstractEmployment employment = new DummyEmployment();

        assertNotEquals(employment, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        AbstractEmployment employment = new DummyEmployment();

        assertNotEquals(employment, new Object());
    }

    @Test
    public void notEqualsOnAge() {
        AbstractEmployment employment = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);

        AbstractEmployment employment2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values2);
        employment2.setAge("45-54");

        assertNotEquals(employment, employment2);
    }

    @Test
    public void notEqualsOnSex() {
        AbstractEmployment employment = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);

        AbstractEmployment employment2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values2);
        employment2.setSex(1);

        assertNotEquals(employment, employment2);
    }

    @Test
    public void notEqualsOnTime() {
        AbstractEmployment employment = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);

        AbstractEmployment employment2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values2);
        employment2.setTime("2010-2011");

        assertNotEquals(employment, employment2);
    }

    @Test
    public void notEqualsOnValue() {
        AbstractEmployment employment = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);

        AbstractEmployment employment2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values2);
        employment2.setValue(this.testContentsCode, 65.65);

        assertNotEquals(employment, employment2);
    }

    @Test
    public void equalsHashCode() {
        AbstractEmployment employment = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values);
        AbstractEmployment employment2 = new GainfullyEmployedPersons("S240", "25-34", 2, "2008-2009", this.values2);

        assertEquals(employment.hashCode(), employment2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        AbstractEmployment employment = new GainfullyEmployedPersons();
        AbstractEmployment employment2 = new GainfullyEmployedPersons();

        assertEquals(employment.hashCode(), employment2.hashCode());
    }

}
