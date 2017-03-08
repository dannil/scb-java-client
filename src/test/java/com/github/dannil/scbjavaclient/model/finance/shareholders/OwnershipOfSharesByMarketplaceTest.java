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

package com.github.dannil.scbjavaclient.model.finance.shareholders;

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
public class OwnershipOfSharesByMarketplaceTest {

    private String testContentsCode;

    private List<ValueNode<Double>> values;
    private List<ValueNode<Double>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<Double> value = new ValueNode<>(4512.44, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Double> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        assertNotNull(ownership);
    }

    @Test
    public void setSector() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        ownership.setSector("400");

        assertNotNull(ownership.getSector());
    }

    @Test
    public void getSector() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        ownership.setSector("400");

        assertEquals("400", ownership.getSector());
    }

    @Test
    public void setMarketplace() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        ownership.setMarketplace("BORSOMA");

        assertNotNull(ownership.getMarketplace());
    }

    @Test
    public void getMarketplace() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        ownership.setMarketplace("BORSOMA");

        assertEquals("BORSOMA", ownership.getMarketplace());
    }

    @Test
    public void setYear() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        ownership.setYear("2011M12");

        assertNotNull(ownership.getYear());
    }

    @Test
    public void getYear() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        ownership.setYear("2011M12");

        assertEquals("2011M12", ownership.getYear());
    }

    @Test
    public void setValues() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        ownership.setValues(this.values);

        assertNotNull(ownership.getValues());
    }

    @Test
    public void getValues() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        ownership.setValues(this.values);

        assertEquals(this.values, ownership.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(OwnershipOfSharesByMarketplace.getInputs());
    }

    @Test
    public void equals() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();
        OwnershipOfSharesByMarketplace ownership2 = new OwnershipOfSharesByMarketplace();

        assertEquals(ownership, ownership2);
    }

    @Test
    public void equalsItself() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        assertEquals(ownership, ownership);
    }

    @Test
    public void notEqualsNull() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        assertNotEquals(ownership, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        assertNotEquals(ownership, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace("230", "BORSOMA", "2004M06",
                this.values);
        OwnershipOfSharesByMarketplace ownership2 = new OwnershipOfSharesByMarketplace("230", "BORSOMA", "2004M06",
                this.values2);

        assertEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnSector() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace("230", "BORSOMA", "2004M06",
                this.values);

        OwnershipOfSharesByMarketplace ownership2 = new OwnershipOfSharesByMarketplace("230", "BORSOMA", "2004M06",
                this.values2);
        ownership2.setSector("700");

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnYear() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace("230", "BORSOMA", "2004M06",
                this.values);

        OwnershipOfSharesByMarketplace ownership2 = new OwnershipOfSharesByMarketplace("230", "BORSOMA", "2004M06",
                this.values2);
        ownership2.setYear("2002M06");

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnValue() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace("230", "BORSOMA", "2004M06",
                this.values);

        OwnershipOfSharesByMarketplace ownership2 = new OwnershipOfSharesByMarketplace("230", "BORSOMA", "2004M06",
                this.values2);
        ownership2.setValue(this.testContentsCode, 300d);

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void equalsHashCode() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace("230", "BORSOMA", "2004M06",
                this.values);
        OwnershipOfSharesByMarketplace ownership2 = new OwnershipOfSharesByMarketplace("230", "BORSOMA", "2004M06",
                this.values2);

        assertEquals(ownership.hashCode(), ownership2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();
        OwnershipOfSharesByMarketplace ownership2 = new OwnershipOfSharesByMarketplace();

        assertEquals(ownership.hashCode(), ownership2.hashCode());
    }

    @Test
    public void convertToString() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace("230", "BORSOMA", "2004M06",
                this.values);

        assertTrue(ownership.toString().contains("200"));
        assertTrue(ownership.toString().contains("BORSOMA"));
        assertTrue(ownership.toString().contains("2004M06"));
    }

    @Test
    public void convertToStringNullValues() {
        OwnershipOfSharesByMarketplace ownership = new OwnershipOfSharesByMarketplace();

        assertNotNull(ownership.toString());
    }

}
