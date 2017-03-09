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

package com.github.dannil.scbjavaclient.model.finance.institutions;

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
public class InstitutionTest {

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
        Institution insti = new Institution();

        assertNotNull(insti);
    }

    @Test
    public void setInstitution() {
        Institution insti = new Institution();

        insti.setInstitution("41249");

        assertNotNull(insti.getInstitution());
    }

    @Test
    public void getSector() {
        Institution insti = new Institution();

        insti.setInstitution("41249");

        assertEquals("41249", insti.getInstitution());
    }

    @Test
    public void setItem() {
        Institution insti = new Institution();

        insti.setItem("K14100");

        assertNotNull(insti.getItem());
    }

    @Test
    public void getItem() {
        Institution insti = new Institution();

        insti.setItem("K14100");

        assertEquals("K14100", insti.getItem());
    }

    @Test
    public void setCurrency() {
        Institution insti = new Institution();

        insti.setCurrency("v1");

        assertNotNull(insti.getCurrency());
    }

    @Test
    public void getCurrency() {
        Institution insti = new Institution();

        insti.setCurrency("v1");

        assertEquals("v1", insti.getCurrency());
    }

    @Test
    public void setTime() {
        Institution insti = new Institution();

        insti.setTime("2016M03");

        assertNotNull(insti.getTime());
    }

    @Test
    public void getTime() {
        Institution insti = new Institution();

        insti.setTime("2016M03");

        assertEquals("2016M03", insti.getTime());
    }

    @Test
    public void setValues() {
        Institution insti = new Institution();

        insti.setValues(this.values);

        assertNotNull(insti.getValues());
    }

    @Test
    public void getValues() {
        Institution insti = new Institution();

        insti.setValues(this.values);

        assertEquals(this.values, insti.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(Institution.getInputs());
    }

    @Test
    public void equals() {
        Institution insti = new Institution();
        Institution insti2 = new Institution();

        assertEquals(insti, insti2);
    }

    @Test
    public void equalsItself() {
        Institution insti = new Institution();

        assertEquals(insti, insti);
    }

    @Test
    public void notEqualsNull() {
        Institution insti = new Institution();

        assertNotEquals(insti, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        Institution insti = new Institution();

        assertNotEquals(insti, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        Institution insti = new Institution("11102", "K21600", "v2", "2003M03", this.values);
        Institution insti2 = new Institution("11102", "K21600", "v2", "2003M03", this.values2);

        assertEquals(insti, insti2);
    }

    @Test
    public void notEqualsOnInstitution() {
        Institution insti = new Institution("11102", "K21600", "v2", "2003M03", this.values);

        Institution insti2 = new Institution("11102", "K21600", "v2", "2003M03", this.values2);
        insti2.setInstitution("32007");

        assertNotEquals(insti, insti2);
    }

    @Test
    public void notEqualsOnItem() {
        Institution insti = new Institution("11102", "K21600", "v2", "2003M03", this.values);

        Institution insti2 = new Institution("11102", "K21600", "v2", "2003M03", this.values2);
        insti2.setItem("K12000");

        assertNotEquals(insti, insti2);
    }

    @Test
    public void notEqualsOnCurrency() {
        Institution insti = new Institution("11102", "K21600", "v2", "2003M03", this.values);

        Institution insti2 = new Institution("11102", "K21600", "v2", "2003M03", this.values2);
        insti2.setCurrency("v0");

        assertNotEquals(insti, insti2);
    }

    @Test
    public void notEqualsOnTime() {
        Institution insti = new Institution("11102", "K21600", "v2", "2003M03", this.values);

        Institution insti2 = new Institution("11102", "K21600", "v2", "2003M03", this.values2);
        insti2.setTime("2002M06");

        assertNotEquals(insti, insti2);
    }

    @Test
    public void notEqualsOnValue() {
        Institution insti = new Institution("11102", "K21600", "v2", "2003M03", this.values);

        Institution insti2 = new Institution("11102", "K21600", "v2", "2003M03", this.values2);
        insti2.setValue(this.testContentsCode, "99999");

        assertNotEquals(insti, insti2);
    }

    @Test
    public void equalsHashCode() {
        Institution insti = new Institution("11102", "K21600", "v2", "2003M03", this.values);
        Institution insti2 = new Institution("11102", "K21600", "v2", "2003M03", this.values2);

        assertEquals(insti.hashCode(), insti2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        Institution insti = new Institution();
        Institution insti2 = new Institution();

        assertEquals(insti.hashCode(), insti2.hashCode());
    }

    @Test
    public void convertToString() {
        Institution insti = new Institution("11102", "K21600", "v2", "2003M03", this.values);

        assertTrue(insti.toString().contains("11102"));
        assertTrue(insti.toString().contains("K21600"));
        assertTrue(insti.toString().contains("v2"));
        assertTrue(insti.toString().contains("2003M03"));
    }

    @Test
    public void convertToStringNullValues() {
        Institution insti = new Institution();

        assertNotNull(insti.toString());
    }

}
