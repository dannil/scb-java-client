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

import java.util.ArrayList;
import java.util.List;

import com.github.dannil.scbjavaclient.model.ValueNode;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractSecurityTest {

    private static class DummySecurity extends AbstractSecurity<Integer> {

        @Override
        public String toString() {
            return null;
        }

    }

    private String testContentsCode;

    private List<ValueNode<Integer>> values;
    private List<ValueNode<Integer>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<Integer> value = new ValueNode<>(66121, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Integer> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        AbstractSecurity<Integer> security = new DummySecurity();

        assertNotNull(security);
    }

    @Test
    public void setSector() {
        AbstractSecurity<Integer> security = new DummySecurity();

        security.setSector(400);

        assertNotNull(security.getSector());
    }

    @Test
    public void getSector() {
        AbstractSecurity<Integer> security = new DummySecurity();

        security.setSector(400);

        assertEquals(Integer.valueOf(400), security.getSector());
    }

    @Test
    public void setCurrency() {
        AbstractSecurity<Integer> security = new DummySecurity();

        security.setCurrency("v2");

        assertNotNull(security.getCurrency());
    }

    @Test
    public void getCurrency() {
        AbstractSecurity<Integer> security = new DummySecurity();

        security.setCurrency("v2");

        assertEquals("v2", security.getCurrency());
    }

    @Test
    public void equals() {
        AbstractSecurity<Integer> security = new DummySecurity();
        AbstractSecurity<Integer> security2 = new DummySecurity();

        assertEquals(security, security2);
    }

    @Test
    public void equalsItself() {
        AbstractSecurity<Integer> security = new DummySecurity();

        assertEquals(security, security);
    }

    @Test
    public void notEqualsNull() {
        AbstractSecurity<Integer> security = new DummySecurity();

        assertNotEquals(security, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        AbstractSecurity<Integer> security = new DummySecurity();

        assertNotEquals(security, new Object());
    }

    @Test
    public void notEqualsOnSector() {
        AbstractSecurity<Integer> security = new MaturityStructure(400, "24", "v0", "2005M05", this.values);

        AbstractSecurity<Integer> security2 = new MaturityStructure(400, "24", "v0", "2005M05", this.values2);
        security2.setSector(130);

        assertNotEquals(security, security2);
    }

    @Test
    public void notEqualsOnCurrency() {
        AbstractSecurity<Integer> security = new MaturityStructure(400, "24", "v0", "2005M05", this.values);

        AbstractSecurity<Integer> security2 = new MaturityStructure(400, "24", "v0", "2005M05", this.values2);
        security2.setCurrency("v2");

        assertNotEquals(security, security2);
    }

    @Test
    public void notEqualsOnTime() {
        AbstractSecurity<Integer> security = new MaturityStructure(400, "24", "v0", "2005M05", this.values);

        AbstractSecurity<Integer> security2 = new MaturityStructure(400, "24", "v0", "2005M05", this.values2);
        security2.setTime("2002M06");

        assertNotEquals(security, security2);
    }

}
