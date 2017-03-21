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

package com.github.dannil.scbjavaclient.model.publicfinances.taxassessment;

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
public class IncomeTaxTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<ValueNode<String>>();
        this.values2 = new ArrayList<ValueNode<String>>();

        ValueNode<String> value = new ValueNode<String>("400", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<String>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        IncomeTax tax = new IncomeTax();

        assertNotNull(tax);
    }

    @Test
    public void setRegion() {
        IncomeTax tax = new IncomeTax();

        tax.setRegion("05");

        assertNotNull(tax.getRegion());
    }

    @Test
    public void getRegion() {
        IncomeTax tax = new IncomeTax();

        tax.setRegion("05");

        assertEquals("05", tax.getRegion());
    }

    @Test
    public void setTime() {
        IncomeTax tax = new IncomeTax();

        tax.setTime(2015);

        assertNotNull(tax.getTime());
    }

    @Test
    public void getTime() {
        IncomeTax tax = new IncomeTax();

        tax.setTime(2015);

        assertEquals(Integer.valueOf(2015), tax.getTime());
    }

    @Test
    public void setValues() {
        IncomeTax tax = new IncomeTax();

        tax.setValues(this.values);

        assertNotNull(tax.getValues());
    }

    @Test
    public void getValues() {
        IncomeTax tax = new IncomeTax();

        tax.setValues(this.values);

        assertEquals(this.values, tax.getValues());
    }

    @Test
    public void equals() {
        IncomeTax tax = new IncomeTax();
        IncomeTax tax2 = new IncomeTax();

        assertEquals(tax, tax2);
    }

    @Test
    public void equalsItself() {
        IncomeTax tax = new IncomeTax();

        assertEquals(tax, tax);
    }

    @Test
    public void notEqualsNull() {
        IncomeTax tax = new IncomeTax();

        assertNotEquals(tax, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        IncomeTax tax = new IncomeTax();

        assertNotEquals(tax, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        IncomeTax tax = new IncomeTax("0140", 2010, this.values);
        IncomeTax tax2 = new IncomeTax("0140", 2010, this.values2);

        assertEquals(tax, tax2);
    }

    @Test
    public void notEqualsOnRegion() {
        IncomeTax tax = new IncomeTax("0140", 2010, this.values);

        IncomeTax tax2 = new IncomeTax("0140", 2010, this.values2);
        tax2.setRegion("1263");

        assertNotEquals(tax, tax2);
    }

    @Test
    public void notEqualsOnTime() {
        IncomeTax tax = new IncomeTax("0140", 2010, this.values);

        IncomeTax tax2 = new IncomeTax("0140", 2010, this.values2);
        tax2.setTime(2011);

        assertNotEquals(tax, tax2);
    }

    @Test
    public void notEqualsOnValue() {
        IncomeTax tax = new IncomeTax("0140", 2010, this.values);

        IncomeTax tax2 = new IncomeTax("0140", 2010, this.values2);
        tax2.setValue(this.testContentsCode, "800");

        assertNotEquals(tax, tax2);
    }

    @Test
    public void equalsHashCode() {
        IncomeTax tax = new IncomeTax("0140", 2010, this.values);
        IncomeTax tax2 = new IncomeTax("0140", 2010, this.values2);

        assertEquals(tax.hashCode(), tax2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        IncomeTax tax = new IncomeTax();
        IncomeTax tax2 = new IncomeTax();

        assertEquals(tax.hashCode(), tax2.hashCode());
    }

    @Test
    public void convertToString() {
        IncomeTax tax = new IncomeTax("0140", 2010, this.values);

        assertTrue(tax.toString().contains("0140"));
        assertTrue(tax.toString().contains("2010"));
    }

    @Test
    public void convertToStringNullValues() {
        IncomeTax tax = new IncomeTax();

        assertNotNull(tax.toString());
    }

}
