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

package com.github.dannil.scbjavaclient.model.environment.packagingandpackagingwaste;

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
public class PackagingAndPackagingWasteTest {

    private String testContentsCode;

    private List<ValueNode<Integer>> values;
    private List<ValueNode<Integer>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<ValueNode<Integer>>();
        this.values2 = new ArrayList<ValueNode<Integer>>();

        ValueNode<Integer> value = new ValueNode<Integer>(10000, this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<Integer> value2 = new ValueNode<Integer>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();

        assertNotNull(packaging);
    }

    @Test
    public void setType() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();

        packaging.setType(60);

        assertNotNull(packaging.getType());
    }

    @Test
    public void getType() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();

        packaging.setType(60);

        assertEquals(Integer.valueOf(60), packaging.getType());
    }

    @Test
    public void setTime() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();

        packaging.setTime(2014);

        assertNotNull(packaging.getTime());
    }

    @Test
    public void getTime() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();

        packaging.setTime(2014);

        assertEquals(Integer.valueOf(2014), packaging.getTime());
    }

    @Test
    public void setValues() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();

        packaging.setValues(this.values);

        assertNotNull(packaging.getValues());
    }

    @Test
    public void getValues() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();

        packaging.setValues(this.values);

        assertEquals(this.values, packaging.getValues());
    }

    @Test
    public void getInputs() {
        assertNotNull(PackagingAndPackagingWaste.getInputs());
    }

    @Test
    public void equals() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();
        PackagingAndPackagingWaste packaging2 = new PackagingAndPackagingWaste();

        assertEquals(packaging, packaging2);
    }

    @Test
    public void equalsItself() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();

        assertEquals(packaging, packaging);
    }

    @Test
    public void notEqualsNull() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();

        assertNotEquals(packaging, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();

        assertNotEquals(packaging, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste(10, 2015, this.values);
        PackagingAndPackagingWaste packaging2 = new PackagingAndPackagingWaste(10, 2015, this.values2);

        assertEquals(packaging, packaging2);
    }

    @Test
    public void notEqualsOnType() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste(10, 2015, this.values);

        PackagingAndPackagingWaste packaging2 = new PackagingAndPackagingWaste(10, 2015, this.values2);
        packaging2.setType(20);

        assertNotEquals(packaging, packaging2);
    }

    @Test
    public void notEqualsOnTime() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste(10, 2015, this.values);

        PackagingAndPackagingWaste packaging2 = new PackagingAndPackagingWaste(10, 2015, this.values2);
        packaging2.setTime(2013);

        assertNotEquals(packaging, packaging2);
    }

    @Test
    public void notEqualsOnValue() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste(10, 2015, this.values);

        PackagingAndPackagingWaste packaging2 = new PackagingAndPackagingWaste(10, 2015, this.values2);
        packaging2.setValue(this.testContentsCode, 20000);

        assertNotEquals(packaging, packaging2);
    }

    @Test
    public void equalsHashCode() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste(10, 2015, this.values);
        PackagingAndPackagingWaste packaging2 = new PackagingAndPackagingWaste(10, 2015, this.values2);

        assertEquals(packaging.hashCode(), packaging2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();
        PackagingAndPackagingWaste packaging2 = new PackagingAndPackagingWaste();

        assertEquals(packaging.hashCode(), packaging2.hashCode());
    }

    @Test
    public void convertToString() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste(10, 2015, this.values);

        assertNotNull(packaging.toString());
    }

    @Test
    public void convertToStringNullValues() {
        PackagingAndPackagingWaste packaging = new PackagingAndPackagingWaste();

        assertNotNull(packaging.toString());
    }

}
