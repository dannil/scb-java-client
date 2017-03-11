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

public class PartnershipChangeTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<ValueNode<String>>();
        this.values2 = new ArrayList<ValueNode<String>>();

        ValueNode<String> value = new ValueNode<String>("199", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<String>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        PartnershipChange partner = new PartnershipChange();

        assertNotNull(partner);
    }

    @Test
    public void setRegion() {
        PartnershipChange partner = new PartnershipChange();

        partner.setRegion("1263");

        assertEquals("1263", partner.getRegion());
    }

    @Test
    public void setMaritalStatus() {
        PartnershipChange partner = new PartnershipChange();

        partner.setMaritalStatus("RP");

        assertEquals("RP", partner.getMaritalStatus());
    }

    @Test
    public void setSex() {
        PartnershipChange partner = new PartnershipChange();

        partner.setSex("2");

        assertEquals("2", partner.getSex());
    }

    @Test
    public void setTime() {
        PartnershipChange partner = new PartnershipChange();

        partner.setTime(2002);

        assertEquals(Integer.valueOf(2002), partner.getTime());
    }

    @Test
    public void setValues() {
        PartnershipChange partner = new PartnershipChange();

        partner.setValues(this.values);

        assertNotNull(partner.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(PartnershipChange.getInputs());
    }

    @Test
    public void equals() {
        PartnershipChange partner = new PartnershipChange();
        PartnershipChange partner2 = new PartnershipChange();

        assertEquals(partner, partner2);
    }

    @Test
    public void equalsItself() {
        PartnershipChange partner = new PartnershipChange();

        assertEquals(partner, partner);
    }

    @Test
    public void equalsItselfWithValues() {
        PartnershipChange partner = new PartnershipChange("00", "RP", "2", 2002, this.values);
        PartnershipChange partner2 = new PartnershipChange("00", "RP", "2", 2002, this.values2);

        assertEquals(partner, partner2);
    }

    @Test
    public void notEqualsNull() {
        PartnershipChange partner = new PartnershipChange();

        assertNotEquals(partner, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        PartnershipChange partner = new PartnershipChange();

        assertNotEquals(partner, new Object());
    }

    @Test
    public void notEqualsRegion() {
        PartnershipChange partner = new PartnershipChange("00", "RP", "2", 2002, this.values);
        PartnershipChange partner2 = new PartnershipChange("02", "RP", "2", 2002, this.values);

        assertNotEquals(partner, partner2);
    }

    @Test
    public void notEqualsMaritalStatus() {
        PartnershipChange partner = new PartnershipChange("00", "RP", "2", 2002, this.values);
        PartnershipChange partner2 = new PartnershipChange("00", "SP", "2", 2002, this.values);

        assertNotEquals(partner, partner2);
    }

    @Test
    public void notEqualsSex() {
        PartnershipChange partner = new PartnershipChange("00", "RP", "2", 2002, this.values);
        PartnershipChange partner2 = new PartnershipChange("00", "RP", "1", 2002, this.values);

        assertNotEquals(partner, partner2);
    }

    @Test
    public void notEqualsTime() {
        PartnershipChange partner = new PartnershipChange("00", "RP", "2", 2002, this.values);
        PartnershipChange partner2 = new PartnershipChange("00", "RP", "2", 2004, this.values2);

        assertNotEquals(partner, partner2);
    }

    @Test
    public void notEqualsValues() {
        PartnershipChange partner = new PartnershipChange("00", "RP", "2", 2002, this.values);
        PartnershipChange partner2 = new PartnershipChange("00", "RP", "2", 2002, this.values2);
        partner2.setValue(this.testContentsCode, "99");

        assertNotEquals(partner, partner2);
    }

    @Test
    public void equalsHashCode() {
        PartnershipChange partner = new PartnershipChange("00", "RP", "2", 2002, this.values);
        PartnershipChange partner2 = new PartnershipChange("00", "RP", "2", 2002, this.values);

        assertEquals(partner.hashCode(), partner2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        PartnershipChange partner = new PartnershipChange();
        PartnershipChange partner2 = new PartnershipChange();

        assertEquals(partner.hashCode(), partner2.hashCode());
    }

    @Test
    public void convertToStringNullValues() {
        PartnershipChange partner = new PartnershipChange();

        assertNotNull(partner.toString());
    }

    @Test
    public void convertToString() {
        PartnershipChange partner = new PartnershipChange("00", "RP", "2", 2002, this.values);

        assertTrue(partner.toString().contains("00"));
        assertTrue(partner.toString().contains("RP"));
        assertTrue(partner.toString().contains("2"));
        assertTrue(partner.toString().contains("2002"));
        assertTrue(partner.toString().contains("199"));
    }

}
