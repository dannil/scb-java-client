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

package com.github.dannil.scbjavaclient.model.livingconditions.families.housing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.github.dannil.scbjavaclient.model.ValueNode;
import com.github.dannil.scbjavaclient.model.livingconditons.housing.Housing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HousingTest {

    private String testContentsCode;

    private List<ValueNode<String>> values;
    private List<ValueNode<String>> values2;

    @Before
    public void setup() {
        this.testContentsCode = "TESTCONTENTSCODE";

        this.values = new ArrayList<>();
        this.values2 = new ArrayList<>();

        ValueNode<String> value = new ValueNode<>("4141414", this.testContentsCode, "Test contents code");
        this.values.add(value);

        // Copy previous value node into new object
        ValueNode<String> value2 = new ValueNode<>(value.getValue(), value.getCode(), value.getText());
        this.values2.add(value2);
    }

    @Test
    public void createWithDefaultConstructor() {
        Housing housing = new Housing();

        assertNotNull(housing);
    }

    @Test
    public void setSex() {
        Housing housing = new Housing();

        housing.setSex("5");

        assertNotNull(housing.getSex());
    }

    @Test
    public void getSex() {
        Housing housing = new Housing();

        housing.setSex("5");

        assertEquals("5", housing.getSex());
    }

    @Test
    public void setAge() {
        Housing housing = new Housing();

        housing.setAge("18-21");

        assertNotNull(housing.getAge());
    }

    @Test
    public void getAge() {
        Housing housing = new Housing();

        housing.setSex("18-21");

        assertEquals("18-21", housing.getSex());
    }

    @Test
    public void setHousingType() {
        Housing housing = new Housing();

        housing.setHousingType("BR");

        assertNotNull(housing.getHousingType());
    }

    @Test
    public void getHousingType() {
        Housing housing = new Housing();

        housing.setHousingType("BR");

        assertEquals("BR", housing.getHousingType());
    }

    @Test
    public void setFamilyType() {
        Housing housing = new Housing();

        housing.setFamilyType("BR");

        assertNotNull(housing.getFamilyType());
    }

    @Test
    public void getFamilyType() {
        Housing housing = new Housing();

        housing.setFamilyType("BR");

        assertEquals("BR", housing.getFamilyType());
    }

    @Test
    public void setBackground() {
        Housing housing = new Housing();

        housing.setBackground("2");

        assertNotNull(housing.getBackground());
    }

    @Test
    public void getBackgrund() {
        Housing housing = new Housing();

        housing.setBackground("2");

        assertEquals("2", housing.getBackground());
    }

    @Test
    public void setParentIncome() {
        Housing housing = new Housing();

        housing.setParentIncome(40);

        assertNotNull(housing.getParentIncome());
    }

    @Test
    public void getParentIncome() {
        Housing housing = new Housing();

        housing.setParentIncome(40);

        assertEquals(Integer.valueOf(40), housing.getParentIncome());
    }

    @Test
    public void setTime() {
        Housing housing = new Housing();

        housing.setTime(2015);

        assertNotNull(housing.getTime());
    }

    @Test
    public void getTime() {
        Housing housing = new Housing();

        housing.setTime(2015);

        assertEquals(Integer.valueOf(2015), housing.getTime());
    }

    @Test
    public void setValues() {
        Housing housing = new Housing();

        housing.setValues(this.values);

        assertNotNull(housing.getValues());
    }

    @Test
    public void getValues() {
        Housing housing = new Housing();

        housing.setValues(this.values);

        assertEquals(this.values, housing.getValues());
    }

    @Test
    public void equals() {
        Housing housing = new Housing();
        Housing housing2 = new Housing();

        assertEquals(housing, housing2);
    }

    @Test
    public void equalsItself() {
        Housing housing = new Housing();

        assertEquals(housing, housing);
    }

    @Test
    public void notEqualsNull() {
        Housing housing = new Housing();

        assertNotEquals(housing, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        Housing housing = new Housing();

        assertNotEquals(housing, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        Housing housing = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values);
        Housing housing2 = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values2);

        assertEquals(housing, housing2);
    }

    @Test
    public void notEqualsOnSex() {
        Housing housing = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values);

        Housing housing2 = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values2);
        housing2.setSex("6");

        assertNotEquals(housing, housing2);
    }

    @Test
    public void notEqualsOnAge() {
        Housing housing = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values);

        Housing housing2 = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values2);
        housing2.setAge("6-12");

        assertNotEquals(housing, housing2);
    }

    @Test
    public void notEqualsOnHousingType() {
        Housing housing = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values);

        Housing housing2 = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values2);
        housing2.setHousingType("Tot");

        assertNotEquals(housing, housing2);
    }

    @Test
    public void notEqualsOnFamilyType() {
        Housing housing = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values);

        Housing housing2 = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values2);
        housing2.setFamilyType("BorMedUF");

        assertNotEquals(housing, housing2);
    }

    @Test
    public void notEqualsOnBackground() {
        Housing housing = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values);

        Housing housing2 = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values2);
        housing2.setBackground("1");

        assertNotEquals(housing, housing2);
    }

    @Test
    public void notEqualsOnParentIncome() {
        Housing housing = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values);

        Housing housing2 = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values2);
        housing2.setParentIncome(20);

        assertNotEquals(housing, housing2);
    }

    @Test
    public void notEqualsOnTime() {
        Housing housing = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values);

        Housing housing2 = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values2);
        housing2.setTime(2015);

        assertNotEquals(housing, housing2);
    }

    @Test
    public void notEqualsOnValue() {
        Housing housing = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values);

        Housing housing2 = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values2);
        housing2.setValue(this.testContentsCode, "99999");

        assertNotEquals(housing, housing2);
    }

    @Test
    public void equalsHashCode() {
        Housing housing = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values);
        Housing housing2 = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values2);

        assertEquals(housing.hashCode(), housing2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        Housing housing = new Housing();
        Housing housing2 = new Housing();

        assertEquals(housing.hashCode(), housing2.hashCode());
    }

    @Test
    public void convertToString() {
        Housing housing = new Housing("5", "18-21", "BR", "Annan", "TotalC", 30, 2014, this.values);

        assertTrue(housing.toString().contains("5"));
        assertTrue(housing.toString().contains("18-21"));
        assertTrue(housing.toString().contains("BR"));
        assertTrue(housing.toString().contains("Annan"));
        assertTrue(housing.toString().contains("TotalC"));
        assertTrue(housing.toString().contains("30"));
        assertTrue(housing.toString().contains("2014"));
    }

    @Test
    public void convertToStringNullValues() {
        Housing housing = new Housing();

        assertNotNull(housing.toString());
    }

}
