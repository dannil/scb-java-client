/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.model.population.partnership;

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
public class PartnershipTest {

    private String testContentsCode;

    private List<ValueNode<Integer>> values;
    private List<ValueNode<Integer>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<ValueNode<Integer>>();
        this.values2 = new ArrayList<ValueNode<Integer>>();

        ValueNode<Integer> value = new ValueNode<Integer>(144, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Integer> value2 = new ValueNode<Integer>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        Partnership partner = new Partnership();

        assertNotNull(partner);
    }

    @Test
    public void setRegion() {
        Partnership partner = new Partnership();

        partner.setRegion("1263");

        assertEquals("1263", partner.getRegion());
    }

    @Test
    public void setMaritalStatus() {
        Partnership partner = new Partnership();

        partner.setMaritalStatus("RP");

        assertEquals("RP", partner.getMaritalStatus());
    }

    @Test
    public void setSex() {
        Partnership partner = new Partnership();

        partner.setSex("2");

        assertEquals("2", partner.getSex());
    }

    @Test
    public void setTime() {
        Partnership partner = new Partnership();

        partner.setTime(2002);

        assertEquals(Integer.valueOf(2002), partner.getTime());
    }

    @Test
    public void setValues() {
        Partnership partner = new Partnership();

        partner.setValues(this.values);

        assertNotNull(partner.getValues());
    }

    @Test
    public void equals() {
        Partnership partner = new Partnership();
        Partnership partner2 = new Partnership();

        assertEquals(partner, partner2);
    }

    @Test
    public void equalsItself() {
        Partnership partner = new Partnership();

        assertEquals(partner, partner);
    }

    @Test
    public void equalsItselfWithValues() {
        Partnership partner = new Partnership("00", "RP", "2", 2002, this.values);
        Partnership partner2 = new Partnership("00", "RP", "2", 2002, this.values2);

        assertEquals(partner, partner2);
    }

    @Test
    public void notEqualsNull() {
        Partnership partner = new Partnership();

        assertNotEquals(partner, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        Partnership partner = new Partnership();

        assertNotEquals(partner, new Object());
    }

    @Test
    public void notEqualsRegion() {
        Partnership partner = new Partnership("00", "RP", "2", 2002, this.values);
        Partnership partner2 = new Partnership("02", "RP", "2", 2002, this.values);

        assertNotEquals(partner, partner2);
    }

    @Test
    public void notEqualsMaritalStatus() {
        Partnership partner = new Partnership("00", "RP", "2", 2002, this.values);
        Partnership partner2 = new Partnership("00", "SP", "2", 2002, this.values);

        assertNotEquals(partner, partner2);
    }

    @Test
    public void notEqualsSex() {
        Partnership partner = new Partnership("00", "RP", "2", 2002, this.values);
        Partnership partner2 = new Partnership("00", "RP", "1", 2002, this.values);

        assertNotEquals(partner, partner2);
    }

    @Test
    public void notEqualsTime() {
        Partnership partner = new Partnership("00", "RP", "2", 2002, this.values);
        Partnership partner2 = new Partnership("00", "RP", "2", 2004, this.values2);

        assertNotEquals(partner, partner2);
    }

    @Test
    public void notEqualsValues() {
        Partnership partner = new Partnership("00", "RP", "2", 2002, this.values);
        Partnership partner2 = new Partnership("00", "RP", "2", 2002, this.values2);
        partner2.setValue(this.testContentsCode, 99);

        assertNotEquals(partner, partner2);
    }

    @Test
    public void equalsHashCode() {
        Partnership partner = new Partnership("00", "RP", "2", 2002, this.values);
        Partnership partner2 = new Partnership("00", "RP", "2", 2002, this.values);

        assertEquals(partner.hashCode(), partner2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        Partnership partner = new Partnership();
        Partnership partner2 = new Partnership();

        assertEquals(partner.hashCode(), partner2.hashCode());
    }

    @Test
    public void convertToStringNullValues() {
        Partnership partner = new Partnership();

        assertNotNull(partner.toString());
    }

    @Test
    public void convertToString() {
        Partnership partner = new Partnership("00", "RP", "2", 2002, this.values);

        assertTrue(partner.toString().contains("00"));
        assertTrue(partner.toString().contains("RP"));
        assertTrue(partner.toString().contains("2"));
        assertTrue(partner.toString().contains("2002"));
        assertTrue(partner.toString().contains("144"));
    }

}
