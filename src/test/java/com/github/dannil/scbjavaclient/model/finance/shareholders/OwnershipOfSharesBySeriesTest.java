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
public class OwnershipOfSharesBySeriesTest {

    private String testContentsCode;

    private List<ValueNode<Double>> values;
    private List<ValueNode<Double>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<Double> value = new ValueNode<>(143d, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Double> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        assertNotNull(ownership);
    }

    @Test
    public void setSector() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        ownership.setSector("400");

        assertNotNull(ownership.getSector());
    }

    @Test
    public void getSector() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        ownership.setSector("400");

        assertEquals("400", ownership.getSector());
    }

    @Test
    public void setShareClass() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        ownership.setShareClass("Noterad");

        assertNotNull(ownership.getShareClass());
    }

    @Test
    public void getShareClass() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        ownership.setShareClass("Noterad");

        assertEquals("Noterad", ownership.getShareClass());
    }

    @Test
    public void setYear() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        ownership.setYear("2011M12");

        assertNotNull(ownership.getYear());
    }

    @Test
    public void getYear() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        ownership.setYear("2011M12");

        assertEquals("2011M12", ownership.getYear());
    }

    @Test
    public void setValues() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        ownership.setValues(this.values);

        assertNotNull(ownership.getValues());
    }

    @Test
    public void getValues() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        ownership.setValues(this.values);

        assertEquals(this.values, ownership.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(OwnershipOfSharesBySeries.getInputs());
    }

    @Test
    public void equals() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();
        OwnershipOfSharesBySeries ownership2 = new OwnershipOfSharesBySeries();

        assertEquals(ownership, ownership2);
    }

    @Test
    public void equalsItself() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        assertEquals(ownership, ownership);
    }

    @Test
    public void notEqualsNull() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        assertNotEquals(ownership, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        assertNotEquals(ownership, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries("200", "Noterad", "2004M06", this.values);
        OwnershipOfSharesBySeries ownership2 = new OwnershipOfSharesBySeries("200", "Noterad", "2004M06", this.values2);

        assertEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnSector() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries("200", "Noterad", "2004M06", this.values);

        OwnershipOfSharesBySeries ownership2 = new OwnershipOfSharesBySeries("200", "Noterad", "2004M06", this.values2);
        ownership2.setSector("700");

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnYear() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries("200", "Noterad", "2004M06", this.values);

        OwnershipOfSharesBySeries ownership2 = new OwnershipOfSharesBySeries("200", "Noterad", "2004M06", this.values2);
        ownership2.setYear("2002M06");

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnValue() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries("200", "Noterad", "2004M06", this.values);

        OwnershipOfSharesBySeries ownership2 = new OwnershipOfSharesBySeries("200", "Noterad", "2004M06", this.values2);
        ownership2.setValue(this.testContentsCode, 300d);

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void equalsHashCode() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries("200", "Noterad", "2004M06", this.values);
        OwnershipOfSharesBySeries ownership2 = new OwnershipOfSharesBySeries("200", "Noterad", "2004M06", this.values2);

        assertEquals(ownership.hashCode(), ownership2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();
        OwnershipOfSharesBySeries ownership2 = new OwnershipOfSharesBySeries();

        assertEquals(ownership.hashCode(), ownership2.hashCode());
    }

    @Test
    public void convertToString() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries("200", "Noterad", "2004M06", this.values);

        assertTrue(ownership.toString().contains("200"));
        assertTrue(ownership.toString().contains("Noterad"));
        assertTrue(ownership.toString().contains("2004M06"));
    }

    @Test
    public void convertToStringNullValues() {
        OwnershipOfSharesBySeries ownership = new OwnershipOfSharesBySeries();

        assertNotNull(ownership.toString());
    }

}
