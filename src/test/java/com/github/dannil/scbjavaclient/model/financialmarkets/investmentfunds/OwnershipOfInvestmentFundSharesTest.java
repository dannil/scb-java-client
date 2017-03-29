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

package com.github.dannil.scbjavaclient.model.financialmarkets.investmentfunds;

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
public class OwnershipOfInvestmentFundSharesTest {

    private String testContentsCode;

    private List<ValueNode<Integer>> values;
    private List<ValueNode<Integer>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<Integer> value = new ValueNode<>(660, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Integer> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        assertNotNull(ownership);
    }

    @Test
    public void setType() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        ownership.setType("S12359");

        assertNotNull(ownership.getType());
    }

    @Test
    public void getType() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        ownership.setType("S12359");

        assertEquals("S12359", ownership.getType());
    }

    @Test
    public void setSector() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        ownership.setSector("400");

        assertNotNull(ownership.getSector());
    }

    @Test
    public void getSector() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        ownership.setSector("400");

        assertEquals("400", ownership.getSector());
    }

    @Test
    public void setTime() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        ownership.setTime("2011M12");

        assertNotNull(ownership.getTime());
    }

    @Test
    public void getTime() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        ownership.setTime("2011M12");

        assertEquals("2011M12", ownership.getTime());
    }

    @Test
    public void setValues() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        ownership.setValues(this.values);

        assertNotNull(ownership.getValues());
    }

    @Test
    public void getValues() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        ownership.setValues(this.values);

        assertEquals(this.values, ownership.getValues());
    }

    @Test
    public void equals() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();
        OwnershipOfInvestmentFundShares ownership2 = new OwnershipOfInvestmentFundShares();

        assertEquals(ownership, ownership2);
    }

    @Test
    public void equalsItself() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        assertEquals(ownership, ownership);
    }

    @Test
    public void notEqualsNull() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        assertNotEquals(ownership, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        assertNotEquals(ownership, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values);
        OwnershipOfInvestmentFundShares ownership2 = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values2);

        assertEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnType() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values);
        OwnershipOfInvestmentFundShares ownership2 = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values2);
        ownership2.setType("S12359");

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnSector() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values);

        OwnershipOfInvestmentFundShares ownership2 = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values2);
        ownership2.setSector("700");

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnTime() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values);

        OwnershipOfInvestmentFundShares ownership2 = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values2);
        ownership2.setTime("2002M06");

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnValue() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values);

        OwnershipOfInvestmentFundShares ownership2 = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values2);
        ownership2.setValue(this.testContentsCode, 9000);

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void equalsHashCode() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values);
        OwnershipOfInvestmentFundShares ownership2 = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values2);

        assertEquals(ownership.hashCode(), ownership2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();
        OwnershipOfInvestmentFundShares ownership2 = new OwnershipOfInvestmentFundShares();

        assertEquals(ownership.hashCode(), ownership2.hashCode());
    }

    @Test
    public void convertToString() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares("S12354", "S19", "2004K1",
                this.values);

        assertTrue(ownership.toString().contains("S12354"));
        assertTrue(ownership.toString().contains("S19"));
        assertTrue(ownership.toString().contains("2004K1"));
    }

    @Test
    public void convertToStringNullValues() {
        OwnershipOfInvestmentFundShares ownership = new OwnershipOfInvestmentFundShares();

        assertNotNull(ownership.toString());
    }

}
