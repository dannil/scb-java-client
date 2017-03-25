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
public class MainActivityTest {

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
        MainActivity activity = new MainActivity();

        assertNotNull(activity);
    }

    @Test
    public void setActivity() {
        MainActivity activity = new MainActivity();

        activity.setActivity("S210");

        assertNotNull(activity.getActivity());
    }

    @Test
    public void getActivity() {
        MainActivity activity = new MainActivity();

        activity.setActivity("S210");

        assertEquals("S210", activity.getActivity());
    }

    @Test
    public void setAge() {
        MainActivity activity = new MainActivity();

        activity.setAge("55-64");

        assertNotNull(activity.getAge());
    }

    @Test
    public void getAge() {
        MainActivity activity = new MainActivity();

        activity.setAge("55-64");

        assertEquals("55-64", activity.getAge());
    }

    @Test
    public void setSex() {
        MainActivity activity = new MainActivity();

        activity.setSex("1");

        assertNotNull(activity.getSex());
    }

    @Test
    public void getSex() {
        MainActivity activity = new MainActivity();

        activity.setSex("1");

        assertEquals("1", activity.getSex());
    }

    @Test
    public void setTime() {
        MainActivity activity = new MainActivity();

        activity.setTime("2012-2013");

        assertNotNull(activity.getTime());
    }

    @Test
    public void getTime() {
        MainActivity activity = new MainActivity();

        activity.setTime("2012-2013");

        assertEquals("2012-2013", activity.getTime());
    }

    @Test
    public void setValues() {
        MainActivity activity = new MainActivity();

        activity.setValues(this.values);

        assertNotNull(activity.getValues());
    }

    @Test
    public void getValues() {
        MainActivity activity = new MainActivity();

        activity.setValues(this.values);

        assertEquals(this.values, activity.getValues());
    }

    @Test
    public void equals() {
        MainActivity activity = new MainActivity();
        MainActivity activity2 = new MainActivity();

        assertEquals(activity, activity2);
    }

    @Test
    public void equalsItself() {
        MainActivity activity = new MainActivity();

        assertEquals(activity, activity);
    }

    @Test
    public void notEqualsNull() {
        MainActivity activity = new MainActivity();

        assertNotEquals(activity, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        MainActivity activity = new MainActivity();

        assertNotEquals(activity, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        MainActivity activity = new MainActivity("S200", "25-34", "2", "2008-2009", this.values);
        MainActivity activity2 = new MainActivity("S200", "25-34", "2", "2008-2009", this.values2);

        assertEquals(activity, activity2);
    }

    @Test
    public void notEqualsOnActivity() {
        MainActivity activity = new MainActivity("S200", "25-34", "2", "2008-2009", this.values);

        MainActivity activity2 = new MainActivity("S200", "25-34", "2", "2008-2009", this.values2);
        activity2.setActivity("S335");

        assertNotEquals(activity, activity2);
    }

    @Test
    public void notEqualsOnAge() {
        MainActivity activity = new MainActivity("S200", "25-34", "2", "2008-2009", this.values);

        MainActivity activity2 = new MainActivity("S200", "25-34", "2", "2008-2009", this.values2);
        activity2.setAge("45-54");

        assertNotEquals(activity, activity2);
    }

    @Test
    public void notEqualsOnSex() {
        MainActivity activity = new MainActivity("S200", "25-34", "2", "2008-2009", this.values);

        MainActivity activity2 = new MainActivity("S200", "25-34", "2", "2008-2009", this.values2);
        activity2.setSex("1");

        assertNotEquals(activity, activity2);
    }

    @Test
    public void notEqualsOnTime() {
        MainActivity activity = new MainActivity("S200", "25-34", "2", "2008-2009", this.values);

        MainActivity activity2 = new MainActivity("S200", "25-34", "2", "2008-2009", this.values2);
        activity2.setTime("2010-2011");

        assertNotEquals(activity, activity2);
    }

    @Test
    public void notEqualsOnValue() {
        MainActivity activity = new MainActivity("S200", "25-34", "2", "2008-2009", this.values);

        MainActivity activity2 = new MainActivity("S200", "25-34", "2", "2008-2009", this.values2);
        activity2.setValue(this.testContentsCode, 65.65);

        assertNotEquals(activity, activity2);
    }

    @Test
    public void equalsHashCode() {
        MainActivity activity = new MainActivity("S200", "25-34", "2", "2008-2009", this.values);
        MainActivity activity2 = new MainActivity("S200", "25-34", "2", "2008-2009", this.values2);

        assertEquals(activity.hashCode(), activity2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        MainActivity activity = new MainActivity();
        MainActivity activity2 = new MainActivity();

        assertEquals(activity.hashCode(), activity2.hashCode());
    }

    @Test
    public void convertToString() {
        MainActivity activity = new MainActivity("S200", "25-34", "2", "2008-2009", this.values);

        assertTrue(activity.toString().contains("S200"));
        assertTrue(activity.toString().contains("25-34"));
        assertTrue(activity.toString().contains("2"));
        assertTrue(activity.toString().contains("2008-2009"));
    }

    @Test
    public void convertToStringNullValues() {
        MainActivity activity = new MainActivity();

        assertNotNull(activity.toString());
    }

}
