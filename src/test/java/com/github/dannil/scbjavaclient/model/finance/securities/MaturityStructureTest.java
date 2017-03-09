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

package com.github.dannil.scbjavaclient.model.finance.securities;

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
public class MaturityStructureTest {

    private String testContentsCode;

    private List<ValueNode<Integer>> values;
    private List<ValueNode<Integer>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<Integer> value = new ValueNode<>(66121, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Integer> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        MaturityStructure maturity = new MaturityStructure();

        assertNotNull(maturity);
    }

    @Test
    public void setSector() {
        MaturityStructure maturity = new MaturityStructure();

        maturity.setSector(400);

        assertNotNull(maturity.getSector());
    }

    @Test
    public void getSector() {
        MaturityStructure maturity = new MaturityStructure();

        maturity.setSector(400);

        assertEquals(Integer.valueOf(400), maturity.getSector());
    }

    @Test
    public void setMaturity() {
        MaturityStructure maturity = new MaturityStructure();

        maturity.setMaturity("41249");

        assertNotNull(maturity.getMaturity());
    }

    @Test
    public void getMaturity() {
        MaturityStructure maturity = new MaturityStructure();

        maturity.setMaturity("41249");

        assertEquals("41249", maturity.getMaturity());
    }

    @Test
    public void setCurrency() {
        MaturityStructure maturity = new MaturityStructure();

        maturity.setCurrency("v2");

        assertNotNull(maturity.getCurrency());
    }

    @Test
    public void getCurrency() {
        MaturityStructure maturity = new MaturityStructure();

        maturity.setCurrency("v2");

        assertEquals("v2", maturity.getCurrency());
    }

    @Test
    public void setTime() {
        MaturityStructure maturity = new MaturityStructure();

        maturity.setTime("2016M03");

        assertNotNull(maturity.getTime());
    }

    @Test
    public void getTime() {
        MaturityStructure maturity = new MaturityStructure();

        maturity.setTime("2016M03");

        assertEquals("2016M03", maturity.getTime());
    }

    @Test
    public void setValues() {
        MaturityStructure maturity = new MaturityStructure();

        maturity.setValues(this.values);

        assertNotNull(maturity.getValues());
    }

    @Test
    public void getValues() {
        MaturityStructure maturity = new MaturityStructure();

        maturity.setValues(this.values);

        assertEquals(this.values, maturity.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(MaturityStructure.getInputs());
    }

    @Test
    public void equals() {
        MaturityStructure maturity = new MaturityStructure();
        MaturityStructure maturity2 = new MaturityStructure();

        assertEquals(maturity, maturity2);
    }

    @Test
    public void equalsItself() {
        MaturityStructure maturity = new MaturityStructure();

        assertEquals(maturity, maturity);
    }

    @Test
    public void notEqualsNull() {
        MaturityStructure maturity = new MaturityStructure();

        assertNotEquals(maturity, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        MaturityStructure maturity = new MaturityStructure();

        assertNotEquals(maturity, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        MaturityStructure maturity = new MaturityStructure(400, "24", "v0", "2005M05", this.values);
        MaturityStructure maturity2 = new MaturityStructure(400, "24", "v0", "2005M05", this.values2);

        assertEquals(maturity, maturity2);
    }

    @Test
    public void notEqualsOnSector() {
        MaturityStructure maturity = new MaturityStructure(400, "24", "v0", "2005M05", this.values);

        MaturityStructure maturity2 = new MaturityStructure(400, "24", "v0", "2005M05", this.values2);
        maturity2.setSector(130);

        assertNotEquals(maturity, maturity2);
    }

    @Test
    public void notEqualsOnMaturity() {
        MaturityStructure maturity = new MaturityStructure(400, "24", "v0", "2005M05", this.values);

        MaturityStructure maturity2 = new MaturityStructure(400, "24", "v0", "2005M05", this.values2);
        maturity2.setMaturity("32007");

        assertNotEquals(maturity, maturity2);
    }
    //
    // @Test
    // public void notEqualsOnCurrency() {
    // MaturityStructure maturity = new MaturityStructure(400, "24", "v0", "2005M05",
    // this.values);
    //
    // MaturityStructure maturity2 = new MaturityStructure(400, "24", "v0", "2005M05",
    // this.values2);
    // maturity2.setCurrency("v0");
    //
    // assertNotEquals(maturity, maturity2);
    // }

    @Test
    public void notEqualsOnTime() {
        MaturityStructure maturity = new MaturityStructure(400, "24", "v0", "2005M05", this.values);

        MaturityStructure maturity2 = new MaturityStructure(400, "24", "v0", "2005M05", this.values2);
        maturity2.setTime("2002M06");

        assertNotEquals(maturity, maturity2);
    }

    @Test
    public void notEqualsOnValue() {
        MaturityStructure maturity = new MaturityStructure(400, "24", "v0", "2005M05", this.values);

        MaturityStructure maturity2 = new MaturityStructure(400, "24", "v0", "2005M05", this.values2);
        maturity2.setValue(this.testContentsCode, 99421);

        assertNotEquals(maturity, maturity2);
    }

    @Test
    public void equalsHashCode() {
        MaturityStructure maturity = new MaturityStructure(400, "24", "v0", "2005M05", this.values);
        MaturityStructure maturity2 = new MaturityStructure(400, "24", "v0", "2005M05", this.values2);

        assertEquals(maturity.hashCode(), maturity2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        MaturityStructure maturity = new MaturityStructure();
        MaturityStructure maturity2 = new MaturityStructure();

        assertEquals(maturity.hashCode(), maturity2.hashCode());
    }

    @Test
    public void convertToString() {
        MaturityStructure maturity = new MaturityStructure(400, "24", "v0", "2005M05", this.values);

        assertTrue(maturity.toString().contains("400"));
        assertTrue(maturity.toString().contains("24"));
        assertTrue(maturity.toString().contains("v0"));
        assertTrue(maturity.toString().contains("2005M05"));
    }

    @Test
    public void convertToStringNullValues() {
        MaturityStructure maturity = new MaturityStructure();

        assertNotNull(maturity.toString());
    }

}
