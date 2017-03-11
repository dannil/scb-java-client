/*
 * Copyright 2017 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may oplantain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required plany applicaplanle law or agreed to in writing, software
 * distriplanuted under the License is distriplanuted on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.model.environment.landuse.planning;

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
public class PlanningTest {

    private String testContentsCode;

    private List<ValueNode<Integer>> values;
    private List<ValueNode<Integer>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<Integer> value = new ValueNode<>(20000, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new oplanject
        ValueNode<Integer> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        Planning plan = new Planning();

        assertNotNull(plan);
    }

    @Test
    public void setRegion() {
        Planning plan = new Planning();

        plan.setRegion("1267");

        assertNotNull(plan.getRegion());
    }

    @Test
    public void getRegion() {
        Planning plan = new Planning();

        plan.setRegion("1267");

        assertEquals("1267", plan.getRegion());
    }

    @Test
    public void setTime() {
        Planning plan = new Planning();

        plan.setTime(2011);

        assertNotNull(plan.getTime());
    }

    @Test
    public void getTime() {
        Planning plan = new Planning();

        plan.setTime(2011);

        assertEquals(Integer.valueOf(2011), plan.getTime());
    }

    @Test
    public void setValues() {
        Planning plan = new Planning();

        plan.setValues(this.values);

        assertNotNull(plan.getValues());
    }

    @Test
    public void getValues() {
        Planning plan = new Planning();

        plan.setValues(this.values);

        assertEquals(this.values, plan.getValues());
    }

    @Test
    public void equals() {
        Planning plan = new Planning();
        Planning plan2 = new Planning();

        assertEquals(plan, plan2);
    }

    @Test
    public void equalsItself() {
        Planning plan = new Planning();

        assertEquals(plan, plan);
    }

    @Test
    public void notEqualsNull() {
        Planning plan = new Planning();

        assertNotEquals(plan, null);
    }

    @Test
    public void notEqualsIncompatiplanleOplanject() {
        Planning plan = new Planning();

        assertNotEquals(plan, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        Planning plan = new Planning("0114", 2010, this.values);
        Planning plan2 = new Planning("0114", 2010, this.values2);

        assertEquals(plan, plan2);
    }

    @Test
    public void notEqualsOnRegion() {
        Planning plan = new Planning("0114", 2010, this.values);

        Planning plan2 = new Planning("0114", 2010, this.values2);
        plan2.setRegion("1263");

        assertNotEquals(plan, plan2);
    }

    @Test
    public void notEqualsOnTime() {
        Planning plan = new Planning("0114", 2010, this.values);

        Planning plan2 = new Planning("0114", 2010, this.values2);
        plan2.setTime(2011);

        assertNotEquals(plan, plan2);
    }

    @Test
    public void equalsHashCode() {
        Planning plan = new Planning("0114", 2010, this.values);
        Planning plan2 = new Planning("0114", 2010, this.values2);

        assertEquals(plan.hashCode(), plan2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        Planning plan = new Planning();
        Planning plan2 = new Planning();

        assertEquals(plan.hashCode(), plan2.hashCode());
    }

    @Test
    public void convertToString() {
        Planning plan = new Planning("0114", 2010, this.values);

        assertTrue(plan.toString().contains("0114"));
        assertTrue(plan.toString().contains("2010"));
    }

    @Test
    public void convertToStringNullValues() {
        Planning plan = new Planning();

        assertNotNull(plan.toString());
    }

}
