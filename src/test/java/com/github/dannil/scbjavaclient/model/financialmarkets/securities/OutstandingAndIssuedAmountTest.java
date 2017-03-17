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

package com.github.dannil.scbjavaclient.model.financialmarkets.securities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.github.dannil.scbjavaclient.model.ValueNode;
import com.github.dannil.scbjavaclient.model.financialmarkets.securities.OutstandingAndIssuedAmount;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OutstandingAndIssuedAmountTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<String> value = new ValueNode<>("46321", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount();

        assertNotNull(amount);
    }

    @Test
    public void setItem() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount();

        amount.setItem("K14100");

        assertNotNull(amount.getItem());
    }

    @Test
    public void getItem() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount();

        amount.setItem("K14100");

        assertEquals("K14100", amount.getItem());
    }

    @Test
    public void setValues() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount();

        amount.setValues(this.values);

        assertNotNull(amount.getValues());
    }

    @Test
    public void getValues() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount();

        amount.setValues(this.values);

        assertEquals(this.values, amount.getValues());
    }

    @Test
    public void equals() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount();
        OutstandingAndIssuedAmount amount2 = new OutstandingAndIssuedAmount();

        assertEquals(amount, amount2);
    }

    @Test
    public void equalsItself() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount();

        assertEquals(amount, amount);
    }

    @Test
    public void notEqualsNull() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount();

        assertNotEquals(amount, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount();

        assertNotEquals(amount, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount(970, "FMOBL", "v3", "2013M03", this.values);
        OutstandingAndIssuedAmount amount2 = new OutstandingAndIssuedAmount(970, "FMOBL", "v3", "2013M03",
                this.values2);

        assertEquals(amount, amount2);
    }

    @Test
    public void notEqualsOnItem() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount(970, "FMOBL", "v3", "2013M03", this.values);

        OutstandingAndIssuedAmount amount2 = new OutstandingAndIssuedAmount(970, "FMOBL", "v3", "2013M03",
                this.values2);
        amount2.setItem("K12000");

        assertNotEquals(amount, amount2);
    }

    @Test
    public void notEqualsOnValue() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount(970, "FMOBL", "v3", "2013M03", this.values);

        OutstandingAndIssuedAmount amount2 = new OutstandingAndIssuedAmount(970, "FMOBL", "v3", "2013M03",
                this.values2);
        amount2.setValue(this.testContentsCode, "99999");

        assertNotEquals(amount, amount2);
    }

    @Test
    public void equalsHashCode() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount(970, "FMOBL", "v3", "2013M03", this.values);
        OutstandingAndIssuedAmount amount2 = new OutstandingAndIssuedAmount(970, "FMOBL", "v3", "2013M03",
                this.values2);

        assertEquals(amount.hashCode(), amount2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount();
        OutstandingAndIssuedAmount amount2 = new OutstandingAndIssuedAmount();

        assertEquals(amount.hashCode(), amount2.hashCode());
    }

    @Test
    public void convertToString() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount(970, "FMOBL", "v3", "2013M03", this.values);

        assertTrue(amount.toString().contains("970"));
        assertTrue(amount.toString().contains("FMOBL"));
        assertTrue(amount.toString().contains("v3"));
        assertTrue(amount.toString().contains("2013M03"));
    }

    @Test
    public void convertToStringNullValues() {
        OutstandingAndIssuedAmount amount = new OutstandingAndIssuedAmount();

        assertNotNull(amount.toString());
    }

}
