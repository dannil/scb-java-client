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

package com.github.dannil.scbjavaclient.model.environment.waste;

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
public class TreatedWasteTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<ValueNode<String>>();
        this.values2 = new ArrayList<ValueNode<String>>();

        ValueNode<String> value = new ValueNode<String>("5000", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<String>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        TreatedWaste waste = new TreatedWaste();

        assertNotNull(waste);
    }

    @Test
    public void setTreatmentCategory() {
        TreatedWaste waste = new TreatedWaste();

        waste.setTreatmentCategory(20);

        assertNotNull(waste.getTreatmentCategory());
    }

    @Test
    public void getTreatmentCategory() {
        TreatedWaste waste = new TreatedWaste();

        waste.setTreatmentCategory(20);

        assertEquals(Integer.valueOf(20), waste.getTreatmentCategory());
    }

    @Test
    public void setWasteCategory() {
        TreatedWaste waste = new TreatedWaste();

        waste.setWasteCategory("07.2");

        assertNotNull(waste.getWasteCategory());
    }

    @Test
    public void getWasteCategory() {
        TreatedWaste waste = new TreatedWaste();

        waste.setWasteCategory("07.2");

        assertEquals("07.2", waste.getWasteCategory());
    }

    @Test
    public void setTime() {
        TreatedWaste waste = new TreatedWaste();

        waste.setTime(2012);

        assertNotNull(waste.getTime());
    }

    @Test
    public void getTime() {
        TreatedWaste waste = new TreatedWaste();

        waste.setTime(2012);

        assertEquals(Integer.valueOf(2012), waste.getTime());
    }

    @Test
    public void setValues() {
        TreatedWaste waste = new TreatedWaste();

        waste.setValues(this.values);

        assertNotNull(waste.getValues());
    }

    @Test
    public void getValues() {
        TreatedWaste waste = new TreatedWaste();

        waste.setValues(this.values);

        assertEquals(this.values, waste.getValues());
    }

    @Test
    public void equals() {
        TreatedWaste waste = new TreatedWaste();
        TreatedWaste waste2 = new TreatedWaste();

        assertEquals(waste, waste2);
    }

    @Test
    public void equalsItself() {
        TreatedWaste waste = new TreatedWaste();

        assertEquals(waste, waste);
    }

    @Test
    public void notEqualsNull() {
        TreatedWaste waste = new TreatedWaste();

        assertNotEquals(waste, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        TreatedWaste waste = new TreatedWaste();

        assertNotEquals(waste, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        TreatedWaste waste = new TreatedWaste(40, "05", 2014, this.values);
        TreatedWaste waste2 = new TreatedWaste(40, "05", 2014, this.values2);

        assertEquals(waste, waste2);
    }

    @Test
    public void notEqualsOnTreatmentCategory() {
        TreatedWaste waste = new TreatedWaste(40, "05", 2014, this.values);

        TreatedWaste waste2 = new TreatedWaste(40, "05", 2014, this.values2);
        waste2.setTreatmentCategory(50);

        assertNotEquals(waste, waste2);
    }

    @Test
    public void notEqualsOnWasteCategory() {
        TreatedWaste waste = new TreatedWaste(40, "05", 2014, this.values);

        TreatedWaste waste2 = new TreatedWaste(40, "05", 2014, this.values2);
        waste2.setWasteCategory("08.1");

        assertNotEquals(waste, waste2);
    }

    @Test
    public void notEqualsOnTime() {
        TreatedWaste waste = new TreatedWaste(40, "05", 2014, this.values);

        TreatedWaste waste2 = new TreatedWaste(40, "05", 2014, this.values2);
        waste2.setTime(2010);

        assertNotEquals(waste, waste2);
    }

    @Test
    public void notEqualsOnValue() {
        TreatedWaste waste = new TreatedWaste(40, "05", 2014, this.values);

        TreatedWaste waste2 = new TreatedWaste(40, "05", 2014, this.values2);
        waste2.setValue(this.testContentsCode, "15000");

        assertNotEquals(waste, waste2);
    }

    @Test
    public void equalsHashCode() {
        TreatedWaste waste = new TreatedWaste(40, "05", 2014, this.values);
        TreatedWaste waste2 = new TreatedWaste(40, "05", 2014, this.values2);

        assertEquals(waste.hashCode(), waste2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        TreatedWaste waste = new TreatedWaste();
        TreatedWaste waste2 = new TreatedWaste();

        assertEquals(waste.hashCode(), waste2.hashCode());
    }

    @Test
    public void convertToString() {
        TreatedWaste waste = new TreatedWaste(40, "05", 2014, this.values);

        assertNotNull(waste.toString());
    }

    @Test
    public void convertToStringNullValues() {
        TreatedWaste waste = new TreatedWaste();

        assertNotNull(waste.toString());
    }

}
