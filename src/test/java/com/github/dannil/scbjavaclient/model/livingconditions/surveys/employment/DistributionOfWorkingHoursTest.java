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
public class DistributionOfWorkingHoursTest {

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
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        assertNotNull(distribution);
    }

    @Test
    public void setIndicator() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        distribution.setIndicator("A438");

        assertNotNull(distribution.getIndicator());
    }

    @Test
    public void getActivity() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        distribution.setIndicator("A438");

        assertEquals("A438", distribution.getIndicator());
    }

    @Test
    public void setAge() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        distribution.setAge("55-64");

        assertNotNull(distribution.getAge());
    }

    @Test
    public void getAge() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        distribution.setAge("55-64");

        assertEquals("55-64", distribution.getAge());
    }

    @Test
    public void setSex() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        distribution.setSex("1");

        assertNotNull(distribution.getSex());
    }

    @Test
    public void getSex() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        distribution.setSex("1");

        assertEquals("1", distribution.getSex());
    }

    @Test
    public void setTime() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        distribution.setTime("2012-2013");

        assertNotNull(distribution.getTime());
    }

    @Test
    public void getTime() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        distribution.setTime("2012-2013");

        assertEquals("2012-2013", distribution.getTime());
    }

    @Test
    public void setValues() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        distribution.setValues(this.values);

        assertNotNull(distribution.getValues());
    }

    @Test
    public void getValues() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        distribution.setValues(this.values);

        assertEquals(this.values, distribution.getValues());
    }

    @Test
    public void equals() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();
        DistributionOfWorkingHours distribution2 = new DistributionOfWorkingHours();

        assertEquals(distribution, distribution2);
    }

    @Test
    public void equalsItself() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        assertEquals(distribution, distribution);
    }

    @Test
    public void notEqualsNull() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        assertNotEquals(distribution, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        assertNotEquals(distribution, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values);
        DistributionOfWorkingHours distribution2 = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values2);

        assertEquals(distribution, distribution2);
    }

    @Test
    public void notEqualsOnIndicator() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values);

        DistributionOfWorkingHours distribution2 = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values2);
        distribution2.setIndicator("A440");

        assertNotEquals(distribution, distribution2);
    }

    @Test
    public void notEqualsOnAge() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values);

        DistributionOfWorkingHours distribution2 = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values2);
        distribution2.setAge("45-54");

        assertNotEquals(distribution, distribution2);
    }

    @Test
    public void notEqualsOnSex() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values);

        DistributionOfWorkingHours distribution2 = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values2);
        distribution2.setSex("1");

        assertNotEquals(distribution, distribution2);
    }

    @Test
    public void notEqualsOnTime() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values);

        DistributionOfWorkingHours distribution2 = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values2);
        distribution2.setTime("2010-2011");

        assertNotEquals(distribution, distribution2);
    }

    @Test
    public void notEqualsOnValue() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values);

        DistributionOfWorkingHours distribution2 = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values2);
        distribution2.setValue(this.testContentsCode, 65.65);

        assertNotEquals(distribution, distribution2);
    }

    @Test
    public void equalsHashCode() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values);
        DistributionOfWorkingHours distribution2 = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values2);

        assertEquals(distribution.hashCode(), distribution2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();
        DistributionOfWorkingHours distribution2 = new DistributionOfWorkingHours();

        assertEquals(distribution.hashCode(), distribution2.hashCode());
    }

    @Test
    public void convertToString() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours("A435", "25-34", "2", "2008-2009",
                this.values);

        assertTrue(distribution.toString().contains("A435"));
        assertTrue(distribution.toString().contains("25-34"));
        assertTrue(distribution.toString().contains("2"));
        assertTrue(distribution.toString().contains("2008-2009"));
    }

    @Test
    public void convertToStringNullValues() {
        DistributionOfWorkingHours distribution = new DistributionOfWorkingHours();

        assertNotNull(distribution.toString());
    }

}
