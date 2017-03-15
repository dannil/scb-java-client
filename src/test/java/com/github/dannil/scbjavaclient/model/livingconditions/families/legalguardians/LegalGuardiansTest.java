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

package com.github.dannil.scbjavaclient.model.livingconditions.families.legalguardians;

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
public class LegalGuardiansTest {

    private String testContentsCode;

    private List<ValueNode<Integer>> values;
    private List<ValueNode<Integer>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<Integer> value = new ValueNode<>(7171, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Integer> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        LegalGuardians guardians = new LegalGuardians();

        assertNotNull(guardians);
    }

    @Test
    public void setSex() {
        LegalGuardians guardians = new LegalGuardians();

        guardians.setSex("5");

        assertNotNull(guardians.getSex());
    }

    @Test
    public void getSex() {
        LegalGuardians guardians = new LegalGuardians();

        guardians.setSex("5");

        assertEquals("5", guardians.getSex());
    }

    @Test
    public void setCaregiver() {
        LegalGuardians guardians = new LegalGuardians();

        guardians.setCaregiver("UppgSakn");

        assertNotNull(guardians.getCaregiver());
    }

    @Test
    public void getLegalGuardiansType() {
        LegalGuardians guardians = new LegalGuardians();

        guardians.setCaregiver("UppgSakn");

        assertEquals("UppgSakn", guardians.getCaregiver());
    }

    @Test
    public void setFamilyType() {
        LegalGuardians guardians = new LegalGuardians();

        guardians.setFamilyType("Sambo6");

        assertNotNull(guardians.getFamilyType());
    }

    @Test
    public void getFamilyType() {
        LegalGuardians guardians = new LegalGuardians();

        guardians.setFamilyType("Sambo6");

        assertEquals("Sambo6", guardians.getFamilyType());
    }

    @Test
    public void setTime() {
        LegalGuardians guardians = new LegalGuardians();

        guardians.setTime(2015);

        assertNotNull(guardians.getTime());
    }

    @Test
    public void getTime() {
        LegalGuardians guardians = new LegalGuardians();

        guardians.setTime(2015);

        assertEquals(Integer.valueOf(2015), guardians.getTime());
    }

    @Test
    public void setValues() {
        LegalGuardians guardians = new LegalGuardians();

        guardians.setValues(this.values);

        assertNotNull(guardians.getValues());
    }

    @Test
    public void getValues() {
        LegalGuardians guardians = new LegalGuardians();

        guardians.setValues(this.values);

        assertEquals(this.values, guardians.getValues());
    }

    @Test
    public void equals() {
        LegalGuardians guardians = new LegalGuardians();
        LegalGuardians guardians2 = new LegalGuardians();

        assertEquals(guardians, guardians2);
    }

    @Test
    public void equalsItself() {
        LegalGuardians guardians = new LegalGuardians();

        assertEquals(guardians, guardians);
    }

    @Test
    public void notEqualsNull() {
        LegalGuardians guardians = new LegalGuardians();

        assertNotEquals(guardians, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        LegalGuardians guardians = new LegalGuardians();

        assertNotEquals(guardians, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        LegalGuardians guardians = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values);
        LegalGuardians guardians2 = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values2);

        assertEquals(guardians, guardians2);
    }

    @Test
    public void notEqualsOnSex() {
        LegalGuardians guardians = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values);

        LegalGuardians guardians2 = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values2);
        guardians2.setSex("6");

        assertNotEquals(guardians, guardians2);
    }

    @Test
    public void notEqualsOnCaregiver() {
        LegalGuardians guardians = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values);

        LegalGuardians guardians2 = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values2);
        guardians2.setCaregiver("UppgSakn");

        assertNotEquals(guardians, guardians2);
    }

    @Test
    public void notEqualsOnFamilyType() {
        LegalGuardians guardians = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values);

        LegalGuardians guardians2 = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values2);
        guardians2.setFamilyType("BorMedUF");

        assertNotEquals(guardians, guardians2);
    }

    @Test
    public void notEqualsOnTime() {
        LegalGuardians guardians = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values);

        LegalGuardians guardians2 = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values2);
        guardians2.setTime(2015);

        assertNotEquals(guardians, guardians2);
    }

    @Test
    public void notEqualsOnValue() {
        LegalGuardians guardians = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values);

        LegalGuardians guardians2 = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values2);
        guardians2.setValue(this.testContentsCode, 888);

        assertNotEquals(guardians, guardians2);
    }

    @Test
    public void equalsHashCode() {
        LegalGuardians guardians = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values);
        LegalGuardians guardians2 = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values2);

        assertEquals(guardians.hashCode(), guardians2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        LegalGuardians guardians = new LegalGuardians();
        LegalGuardians guardians2 = new LegalGuardians();

        assertEquals(guardians.hashCode(), guardians2.hashCode());
    }

    @Test
    public void convertToString() {
        LegalGuardians guardians = new LegalGuardians("5", "VardE2ny", "EnsamFar", 2014, this.values);

        assertTrue(guardians.toString().contains("5"));
        assertTrue(guardians.toString().contains("VardE2ny"));
        assertTrue(guardians.toString().contains("EnsamFar"));
        assertTrue(guardians.toString().contains("2014"));
    }

    @Test
    public void convertToStringNullValues() {
        LegalGuardians guardians = new LegalGuardians();

        assertNotNull(guardians.toString());
    }

}
