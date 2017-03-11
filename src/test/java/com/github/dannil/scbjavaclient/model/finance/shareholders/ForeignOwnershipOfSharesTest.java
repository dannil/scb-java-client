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
public class ForeignOwnershipOfSharesTest {

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
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();

        assertNotNull(ownership);
    }

    @Test
    public void setCountry() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();

        ownership.setCountry("DE");

        assertNotNull(ownership.getCountry());
    }

    @Test
    public void getSector() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();

        ownership.setCountry("400");

        assertEquals("400", ownership.getCountry());
    }

    @Test
    public void setTime() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();

        ownership.setTime("2011M12");

        assertNotNull(ownership.getTime());
    }

    @Test
    public void getTime() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();

        ownership.setTime("2011M12");

        assertEquals("2011M12", ownership.getTime());
    }

    @Test
    public void setValues() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();

        ownership.setValues(this.values);

        assertNotNull(ownership.getValues());
    }

    @Test
    public void getValues() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();

        ownership.setValues(this.values);

        assertEquals(this.values, ownership.getValues());
    }

    @Test
    public void equals() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();
        ForeignOwnershipOfShares ownership2 = new ForeignOwnershipOfShares();

        assertEquals(ownership, ownership2);
    }

    @Test
    public void equalsItself() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();

        assertEquals(ownership, ownership);
    }

    @Test
    public void notEqualsNull() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();

        assertNotEquals(ownership, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();

        assertNotEquals(ownership, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares("DE", "2004M06", this.values);
        ForeignOwnershipOfShares ownership2 = new ForeignOwnershipOfShares("DE", "2004M06", this.values2);

        assertEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnCountry() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares("DE", "2004M06", this.values);

        ForeignOwnershipOfShares ownership2 = new ForeignOwnershipOfShares("DE", "2004M06", this.values2);
        ownership2.setCountry("DK");

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnTime() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares("DE", "2004M06", this.values);

        ForeignOwnershipOfShares ownership2 = new ForeignOwnershipOfShares("DE", "2004M06", this.values2);
        ownership2.setTime("2002M06");

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void notEqualsOnValue() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares("DE", "2004M06", this.values);

        ForeignOwnershipOfShares ownership2 = new ForeignOwnershipOfShares("DE", "2004M06", this.values2);
        ownership2.setValue(this.testContentsCode, 300d);

        assertNotEquals(ownership, ownership2);
    }

    @Test
    public void equalsHashCode() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares("DE", "2004M06", this.values);
        ForeignOwnershipOfShares ownership2 = new ForeignOwnershipOfShares("DE", "2004M06", this.values2);

        assertEquals(ownership.hashCode(), ownership2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();
        ForeignOwnershipOfShares ownership2 = new ForeignOwnershipOfShares();

        assertEquals(ownership.hashCode(), ownership2.hashCode());
    }

    @Test
    public void convertToString() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares("DE", "2004M06", this.values);

        assertTrue(ownership.toString().contains("DE"));
        assertTrue(ownership.toString().contains("2004M06"));
    }

    @Test
    public void convertToStringNullValues() {
        ForeignOwnershipOfShares ownership = new ForeignOwnershipOfShares();

        assertNotNull(ownership.toString());
    }

}
