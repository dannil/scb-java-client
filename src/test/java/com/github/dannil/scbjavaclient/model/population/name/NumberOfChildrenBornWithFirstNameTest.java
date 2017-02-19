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

package com.github.dannil.scbjavaclient.model.population.name;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.github.dannil.scbjavaclient.model.ValueNode;

import org.junit.Before;
import org.junit.Test;

public class NumberOfChildrenBornWithFirstNameTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<ValueNode<String>>();
        this.values2 = new ArrayList<ValueNode<String>>();

        ValueNode<String> value = new ValueNode<String>("15", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<String>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

        assertNotNull(nbrChildren);
    }

    @Test
    public void setFirstname() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

        nbrChildren.setFirstname("Adrian");

        assertEquals("Adrian", nbrChildren.getFirstname());
    }

    @Test
    public void setYear() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

        nbrChildren.setYear(2010);

        assertEquals(Integer.valueOf(2010), nbrChildren.getYear());
    }

    @Test
    public void setValues() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

        nbrChildren.setValues(this.values);

        assertNotNull(nbrChildren.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(NumberOfChildrenBornWithFirstName.getInputs());
    }

    @Test
    public void equals() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();
        NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName();

        assertEquals(nbrChildren, nbrChildren2);
    }

    @Test
    public void equalsItself() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

        assertEquals(nbrChildren, nbrChildren);
    }

    @Test
    public void equalsItselfWithValues() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010,
                this.values);
        NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName("Adrian", 2010,
                this.values2);

        assertEquals(nbrChildren, nbrChildren2);
    }

    @Test
    public void notEqualsNull() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

        assertNotEquals(nbrChildren, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

        assertNotEquals(nbrChildren, new Object());
    }

    @Test
    public void notEqualsFirstname() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010,
                this.values);
        NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName("Bob", 2010,
                this.values2);

        assertNotEquals(nbrChildren, nbrChildren2);
    }

    @Test
    public void notEqualsYear() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010,
                this.values);
        NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName("Adrian", 2005,
                this.values2);

        assertNotEquals(nbrChildren, nbrChildren2);
    }

    @Test
    public void notEqualsValues() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010,
                this.values);
        NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName("Adrian", 2010,
                this.values2);
        nbrChildren2.setValue(this.testContentsCode, "30");

        assertNotEquals(nbrChildren, nbrChildren2);
    }

    @Test
    public void equalsHashCode() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010,
                this.values);
        NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName("Adrian", 2010,
                this.values2);

        assertEquals(nbrChildren.hashCode(), nbrChildren2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();
        NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName();

        assertEquals(nbrChildren.hashCode(), nbrChildren2.hashCode());
    }

    @Test
    public void convertToStringNullValues() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

        assertNotNull(nbrChildren.toString());
    }

    @Test
    public void convertToString() {
        NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010,
                this.values);

        assertTrue(nbrChildren.toString().contains("Adrian"));
        assertTrue(nbrChildren.toString().contains("2010"));
        assertTrue(nbrChildren.toString().contains("15"));
    }

}
