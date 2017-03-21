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

package com.github.dannil.scbjavaclient.model.publicfinances.governmentdebt;

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
public class GovernmentDebtTest {

    private String testContentsCode;

    private List<ValueNode<Double>> values;
    private List<ValueNode<Double>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<Double> value = new ValueNode<>(46321.56, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Double> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        GovernmentDebt debt = new GovernmentDebt();

        assertNotNull(debt);
    }
    
    @Test
    public void setItem() {
        GovernmentDebt debt = new GovernmentDebt();

        debt.setItem("K14100");

        assertNotNull(debt.getItem());
    }

    @Test
    public void getItem() {
        GovernmentDebt debt = new GovernmentDebt();

        debt.setItem("K14100");

        assertEquals("K14100", debt.getItem());
    }

    @Test
    public void setTime() {
        GovernmentDebt debt = new GovernmentDebt();

        debt.setTime("2016M03");

        assertNotNull(debt.getTime());
    }

    @Test
    public void getTime() {
        GovernmentDebt debt = new GovernmentDebt();

        debt.setTime("2016M03");

        assertEquals("2016M03", debt.getTime());
    }

    @Test
    public void setValues() {
        GovernmentDebt debt = new GovernmentDebt();

        debt.setValues(this.values);

        assertNotNull(debt.getValues());
    }

    @Test
    public void getValues() {
        GovernmentDebt debt = new GovernmentDebt();

        debt.setValues(this.values);

        assertEquals(this.values, debt.getValues());
    }

    @Test
    public void equals() {
        GovernmentDebt debt = new GovernmentDebt();
        GovernmentDebt debt2 = new GovernmentDebt();

        assertEquals(debt, debt2);
    }

    @Test
    public void equalsItself() {
        GovernmentDebt debt = new GovernmentDebt();

        assertEquals(debt, debt);
    }

    @Test
    public void notEqualsNull() {
        GovernmentDebt debt = new GovernmentDebt();

        assertNotEquals(debt, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        GovernmentDebt debt = new GovernmentDebt();

        assertNotEquals(debt, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        GovernmentDebt debt = new GovernmentDebt("RG210", "2003M03", this.values);
        GovernmentDebt debt2 = new GovernmentDebt("RG210", "2003M03", this.values2);

        assertEquals(debt, debt2);
    }

    @Test
    public void notEqualsOnItem() {
        GovernmentDebt debt = new GovernmentDebt("RG210", "2003M03", this.values);

        GovernmentDebt debt2 = new GovernmentDebt("RG210", "2003M03", this.values2);
        debt2.setItem("K12000");

        assertNotEquals(debt, debt2);
    }

    @Test
    public void notEqualsOnTime() {
        GovernmentDebt debt = new GovernmentDebt("RG210", "2003M03", this.values);

        GovernmentDebt debt2 = new GovernmentDebt("RG210", "2003M03", this.values2);
        debt2.setTime("2002M06");

        assertNotEquals(debt, debt2);
    }

    @Test
    public void notEqualsOnValue() {
        GovernmentDebt debt = new GovernmentDebt("RG210", "2003M03", this.values);

        GovernmentDebt debt2 = new GovernmentDebt("RG210", "2003M03", this.values2);
        debt2.setValue(this.testContentsCode, 99999.099);

        assertNotEquals(debt, debt2);
    }

    @Test
    public void equalsHashCode() {
        GovernmentDebt debt = new GovernmentDebt("RG210", "2003M03", this.values);
        GovernmentDebt debt2 = new GovernmentDebt("RG210", "2003M03", this.values2);

        assertEquals(debt.hashCode(), debt2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        GovernmentDebt debt = new GovernmentDebt();
        GovernmentDebt debt2 = new GovernmentDebt();

        assertEquals(debt.hashCode(), debt2.hashCode());
    }

    @Test
    public void convertToString() {
        GovernmentDebt debt = new GovernmentDebt("RG210", "2003M03", this.values);

        assertTrue(debt.toString().contains("RG210"));
        assertTrue(debt.toString().contains("2003M03"));
    }

    @Test
    public void convertToStringNullValues() {
        GovernmentDebt debt = new GovernmentDebt();

        assertNotNull(debt.toString());
    }

}
