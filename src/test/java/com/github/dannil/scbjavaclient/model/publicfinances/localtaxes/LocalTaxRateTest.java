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

package com.github.dannil.scbjavaclient.model.publicfinances.localtaxes;

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
public class LocalTaxRateTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<String> value = new ValueNode<>("1234", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        LocalTaxRate tax = new LocalTaxRate();

        assertNotNull(tax);
    }

    @Test
    public void setRegion() {
        LocalTaxRate tax = new LocalTaxRate();

        tax.setRegion("05");

        assertNotNull(tax.getRegion());
    }

    @Test
    public void getRegion() {
        LocalTaxRate tax = new LocalTaxRate();

        tax.setRegion("05");

        assertEquals("05", tax.getRegion());
    }

    @Test
    public void setTime() {
        LocalTaxRate tax = new LocalTaxRate();

        tax.setTime(2015);

        assertNotNull(tax.getTime());
    }

    @Test
    public void getTime() {
        LocalTaxRate tax = new LocalTaxRate();

        tax.setTime(2015);

        assertEquals(Integer.valueOf(2015), tax.getTime());
    }

    @Test
    public void setValues() {
        LocalTaxRate tax = new LocalTaxRate();

        tax.setValues(this.values);

        assertNotNull(tax.getValues());
    }

    @Test
    public void getValues() {
        LocalTaxRate tax = new LocalTaxRate();

        tax.setValues(this.values);

        assertEquals(this.values, tax.getValues());
    }

    @Test
    public void equals() {
        LocalTaxRate tax = new LocalTaxRate();
        LocalTaxRate tax2 = new LocalTaxRate();

        assertEquals(tax, tax2);
    }

    @Test
    public void equalsItself() {
        LocalTaxRate tax = new LocalTaxRate();

        assertEquals(tax, tax);
    }

    @Test
    public void notEqualsNull() {
        LocalTaxRate tax = new LocalTaxRate();

        assertNotEquals(tax, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        LocalTaxRate tax = new LocalTaxRate();

        assertNotEquals(tax, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        LocalTaxRate tax = new LocalTaxRate("0140", 2010, this.values);
        LocalTaxRate tax2 = new LocalTaxRate("0140", 2010, this.values2);

        assertEquals(tax, tax2);
    }

    @Test
    public void notEqualsOnRegion() {
        LocalTaxRate tax = new LocalTaxRate("0140", 2010, this.values);

        LocalTaxRate tax2 = new LocalTaxRate("0140", 2010, this.values2);
        tax2.setRegion("1263");

        assertNotEquals(tax, tax2);
    }

    @Test
    public void notEqualsOnTime() {
        LocalTaxRate tax = new LocalTaxRate("0140", 2010, this.values);

        LocalTaxRate tax2 = new LocalTaxRate("0140", 2010, this.values2);
        tax2.setTime(2011);

        assertNotEquals(tax, tax2);
    }

    @Test
    public void notEqualsOnValue() {
        LocalTaxRate tax = new LocalTaxRate("0140", 2010, this.values);

        LocalTaxRate tax2 = new LocalTaxRate("0140", 2010, this.values2);
        tax2.setValue(this.testContentsCode, "800");

        assertNotEquals(tax, tax2);
    }

    @Test
    public void equalsHashCode() {
        LocalTaxRate tax = new LocalTaxRate("0140", 2010, this.values);
        LocalTaxRate tax2 = new LocalTaxRate("0140", 2010, this.values2);

        assertEquals(tax.hashCode(), tax2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        LocalTaxRate tax = new LocalTaxRate();
        LocalTaxRate tax2 = new LocalTaxRate();

        assertEquals(tax.hashCode(), tax2.hashCode());
    }

    @Test
    public void convertToString() {
        LocalTaxRate tax = new LocalTaxRate("0140", 2010, this.values);

        assertTrue(tax.toString().contains("0140"));
        assertTrue(tax.toString().contains("2010"));
    }

    @Test
    public void convertToStringNullValues() {
        LocalTaxRate tax = new LocalTaxRate();

        assertNotNull(tax.toString());
    }

}
