/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.model.population.demography;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.github.dannil.scbjavaclient.model.ValueNode;

import org.junit.Before;
import org.junit.Test;

public class MeanAgeFirstChildTest {

    private String testContentsCode;

    private List<ValueNode<Double>> values;
    private List<ValueNode<Double>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<ValueNode<Double>>();
        this.values2 = new ArrayList<ValueNode<Double>>();

        ValueNode<Double> value = new ValueNode<Double>(34.56d, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Double> value2 = new ValueNode<Double>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild();

        assertNotNull(mean);
    }

    @Test
    public void setRegion() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild();

        mean.setRegion("1263");

        assertEquals("1263", mean.getRegion());
    }

    @Test
    public void setGender() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild();

        mean.setGender(1);

        assertEquals(Integer.valueOf(1), mean.getGender());
    }

    @Test
    public void setTime() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild();

        mean.setTime(1996);

        assertEquals(Integer.valueOf(1996), mean.getTime());
    }

    @Test
    public void setValues() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild();

        mean.setValues(this.values);

        assertNotNull(mean.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(MeanAgeFirstChild.getInputs());
    }

    @Test
    public void equals() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild();
        MeanAgeFirstChild mean2 = new MeanAgeFirstChild();

        assertEquals(mean, mean2);
    }

    @Test
    public void equalsItself() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild();

        assertEquals(mean, mean);
    }

    @Test
    public void equalsItselfWithValues() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild("1263", 2, 1996, this.values);
        MeanAgeFirstChild mean2 = new MeanAgeFirstChild("1263", 2, 1996, this.values2);

        assertEquals(mean, mean2);
    }

    @Test
    public void notEqualsNull() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild();

        assertNotEquals(mean, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild();

        assertNotEquals(mean, new Object());
    }

    @Test
    public void notEqualsRegion() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild("1263", 2, 1996, this.values);
        MeanAgeFirstChild mean2 = new MeanAgeFirstChild("1267", 2, 1996, this.values2);

        assertNotEquals(mean, mean2);
    }

    @Test
    public void notEqualsGender() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild("1263", 2, 1996, this.values);
        MeanAgeFirstChild mean2 = new MeanAgeFirstChild("1263", 1, 1996, this.values2);

        assertNotEquals(mean, mean2);
    }

    @Test
    public void notEqualsTime() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild("1263", 2, 1996, this.values);
        MeanAgeFirstChild mean2 = new MeanAgeFirstChild("1263", 2, 2002, this.values2);

        assertNotEquals(mean, mean2);
    }

    @Test
    public void notEqualsValues() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild("1263", 2, 1996, this.values);
        MeanAgeFirstChild mean2 = new MeanAgeFirstChild("1263", 2, 1996, this.values2);
        mean2.setValue(this.testContentsCode, 65.43d);

        assertNotEquals(mean, mean2);
    }

    @Test
    public void equalsHashCode() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild("1263", 2, 1996, this.values);
        MeanAgeFirstChild mean2 = new MeanAgeFirstChild("1263", 2, 1996, this.values2);

        assertEquals(mean.hashCode(), mean2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild();
        MeanAgeFirstChild mean2 = new MeanAgeFirstChild();

        assertEquals(mean.hashCode(), mean2.hashCode());
    }

    @Test
    public void convertToStringNullValues() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild();

        assertNotNull(mean.toString());
    }

    @Test
    public void convertToString() {
        MeanAgeFirstChild mean = new MeanAgeFirstChild("1263", 2, 1996, this.values);

        assertTrue(mean.toString().contains("1263"));
        assertTrue(mean.toString().contains("2"));
        assertTrue(mean.toString().contains("1996"));
        assertTrue(mean.toString().contains("34.56"));
    }

}
