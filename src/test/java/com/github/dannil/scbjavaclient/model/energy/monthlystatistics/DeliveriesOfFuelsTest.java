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

package com.github.dannil.scbjavaclient.model.energy.monthlystatistics;

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
public class DeliveriesOfFuelsTest {

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
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();

        assertNotNull(fuels);
    }

    @Test
    public void setCommodity() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();

        fuels.setCommodity(99);

        assertNotNull(fuels.getCommodity());
    }

    @Test
    public void getCommodity() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();

        fuels.setCommodity(99);

        assertEquals(Integer.valueOf(99), fuels.getCommodity());
    }

    @Test
    public void setUserCategory() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();

        fuels.setUserCategory("010");

        assertNotNull(fuels.getUserCategory());
    }

    @Test
    public void getUserCategory() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();

        fuels.setUserCategory("010");

        assertEquals("010", fuels.getUserCategory());
    }

    @Test
    public void setValues() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();

        fuels.setValues(this.values);

        assertNotNull(fuels.getValues());
    }

    @Test
    public void getValues() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();

        fuels.setValues(this.values);

        assertEquals(this.values, fuels.getValues());
    }

    @Test
    public void equals() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();
        DeliveriesOfFuels fuels2 = new DeliveriesOfFuels();

        assertEquals(fuels, fuels2);
    }

    @Test
    public void equalsItself() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();

        assertEquals(fuels, fuels);
    }

    @Test
    public void notEqualsNull() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();

        assertNotEquals(fuels, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();

        assertNotEquals(fuels, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels(10, "004", "2006M08", this.values);
        DeliveriesOfFuels fuels2 = new DeliveriesOfFuels(10, "004", "2006M08", this.values2);

        assertEquals(fuels, fuels2);
    }

    @Test
    public void notEqualsOnCommodity() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels(10, "004", "2006M08", this.values);

        DeliveriesOfFuels fuels2 = new DeliveriesOfFuels(10, "004", "2006M08", this.values2);
        fuels2.setCommodity(20);

        assertNotEquals(fuels, fuels2);
    }

    @Test
    public void notEqualsOnUserCategory() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels(10, "004", "2006M08", this.values);

        DeliveriesOfFuels fuels2 = new DeliveriesOfFuels(10, "004", "2006M08", this.values2);
        fuels2.setUserCategory("020");

        assertNotEquals(fuels, fuels2);
    }

    @Test
    public void notEqualsOnValue() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels(10, "004", "2006M08", this.values);

        DeliveriesOfFuels fuels2 = new DeliveriesOfFuels(10, "004", "2006M08", this.values2);
        fuels2.setValue(this.testContentsCode, "99999");

        assertNotEquals(fuels, fuels2);
    }

    @Test
    public void equalsHashCode() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels(10, "004", "2006M08", this.values);
        DeliveriesOfFuels fuels2 = new DeliveriesOfFuels(10, "004", "2006M08", this.values2);

        assertEquals(fuels.hashCode(), fuels2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();
        DeliveriesOfFuels fuels2 = new DeliveriesOfFuels();

        assertEquals(fuels.hashCode(), fuels2.hashCode());
    }

    @Test
    public void convertToString() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels(10, "004", "2006M08", this.values);

        assertTrue(fuels.toString().contains("10"));
        assertTrue(fuels.toString().contains("004"));
        assertTrue(fuels.toString().contains("2006M08"));
    }

    @Test
    public void convertToStringNullValues() {
        DeliveriesOfFuels fuels = new DeliveriesOfFuels();

        assertNotNull(fuels.toString());
    }

}
