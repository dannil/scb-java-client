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
public class GeneratedWasteTest {

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
        GeneratedWaste waste = new GeneratedWaste();

        assertNotNull(waste);
    }

    @Test
    public void setIndustrialClassification() {
        GeneratedWaste waste = new GeneratedWaste();

        waste.setIndustrialClassification("C16");

        assertNotNull(waste.getIndustrialClassification());
    }

    @Test
    public void getIndustrialClassification() {
        GeneratedWaste waste = new GeneratedWaste();

        waste.setIndustrialClassification("C16");

        assertEquals("C16", waste.getIndustrialClassification());
    }

    @Test
    public void setWasteCategory() {
        GeneratedWaste waste = new GeneratedWaste();

        waste.setWasteCategory("07.2");

        assertNotNull(waste.getWasteCategory());
    }

    @Test
    public void getWasteCategory() {
        GeneratedWaste waste = new GeneratedWaste();

        waste.setWasteCategory("07.2");

        assertEquals("07.2", waste.getWasteCategory());
    }

    @Test
    public void setTime() {
        GeneratedWaste waste = new GeneratedWaste();

        waste.setTime(2012);

        assertNotNull(waste.getTime());
    }

    @Test
    public void getTime() {
        GeneratedWaste waste = new GeneratedWaste();

        waste.setTime(2012);

        assertEquals(Integer.valueOf(2012), waste.getTime());
    }

    @Test
    public void setValues() {
        GeneratedWaste waste = new GeneratedWaste();

        waste.setValues(this.values);

        assertNotNull(waste.getValues());
    }

    @Test
    public void getValues() {
        GeneratedWaste waste = new GeneratedWaste();

        waste.setValues(this.values);

        assertEquals(this.values, waste.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(GeneratedWaste.getInputs());
    }

    @Test
    public void equals() {
        GeneratedWaste waste = new GeneratedWaste();
        GeneratedWaste waste2 = new GeneratedWaste();

        assertEquals(waste, waste2);
    }

    @Test
    public void equalsItself() {
        GeneratedWaste waste = new GeneratedWaste();

        assertEquals(waste, waste);
    }

    @Test
    public void notEqualsNull() {
        GeneratedWaste waste = new GeneratedWaste();

        assertNotEquals(waste, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        GeneratedWaste waste = new GeneratedWaste();

        assertNotEquals(waste, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        GeneratedWaste waste = new GeneratedWaste("C10-12", "05", 2014, this.values);
        GeneratedWaste waste2 = new GeneratedWaste("C10-12", "05", 2014, this.values2);

        assertEquals(waste, waste2);
    }

    @Test
    public void notEqualsOnIndustrialClassification() {
        GeneratedWaste waste = new GeneratedWaste("C10-12", "05", 2014, this.values);

        GeneratedWaste waste2 = new GeneratedWaste("C10-12", "05", 2014, this.values2);
        waste2.setIndustrialClassification("D35");

        assertNotEquals(waste, waste2);
    }

    @Test
    public void notEqualsOnWasteCategory() {
        GeneratedWaste waste = new GeneratedWaste("C10-12", "05", 2014, this.values);

        GeneratedWaste waste2 = new GeneratedWaste("C10-12", "05", 2014, this.values2);
        waste2.setWasteCategory("08.1");

        assertNotEquals(waste, waste2);
    }

    @Test
    public void notEqualsOnTime() {
        GeneratedWaste waste = new GeneratedWaste("C10-12", "05", 2014, this.values);

        GeneratedWaste waste2 = new GeneratedWaste("C10-12", "05", 2014, this.values2);
        waste2.setTime(2010);

        assertNotEquals(waste, waste2);
    }

    @Test
    public void notEqualsOnValue() {
        GeneratedWaste waste = new GeneratedWaste("C10-12", "05", 2014, this.values);

        GeneratedWaste waste2 = new GeneratedWaste("C10-12", "05", 2014, this.values2);
        waste2.setValue(this.testContentsCode, "15000");

        assertNotEquals(waste, waste2);
    }

    @Test
    public void equalsHashCode() {
        GeneratedWaste waste = new GeneratedWaste("C10-12", "05", 2014, this.values);
        GeneratedWaste waste2 = new GeneratedWaste("C10-12", "05", 2014, this.values2);

        assertEquals(waste.hashCode(), waste2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        GeneratedWaste waste = new GeneratedWaste();
        GeneratedWaste waste2 = new GeneratedWaste();

        assertEquals(waste.hashCode(), waste2.hashCode());
    }

    @Test
    public void convertToString() {
        GeneratedWaste waste = new GeneratedWaste("C10-12", "05", 2014, this.values);

        assertNotNull(waste.toString());
    }

    @Test
    public void convertToStringNullValues() {
        GeneratedWaste waste = new GeneratedWaste();

        assertNotNull(waste.toString());
    }

}
