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

package com.github.dannil.scbjavaclient.model.financialmarkets.institutions;

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
public class MonetaryAssetsTest {

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
        MonetaryAssets assets = new MonetaryAssets();

        assertNotNull(assets);
    }

    @Test
    public void setInstitution() {
        MonetaryAssets assets = new MonetaryAssets();

        assets.setInstitution("41249");

        assertNotNull(assets.getInstitution());
    }

    @Test
    public void getInstitution() {
        MonetaryAssets assets = new MonetaryAssets();

        assets.setInstitution("41249");

        assertEquals("41249", assets.getInstitution());
    }

    @Test
    public void setItem() {
        MonetaryAssets assets = new MonetaryAssets();

        assets.setItem("K14100");

        assertNotNull(assets.getItem());
    }

    @Test
    public void getItem() {
        MonetaryAssets assets = new MonetaryAssets();

        assets.setItem("K14100");

        assertEquals("K14100", assets.getItem());
    }

    @Test
    public void setCurrency() {
        MonetaryAssets assets = new MonetaryAssets();

        assets.setCurrency("v1");

        assertNotNull(assets.getCurrency());
    }

    @Test
    public void getCurrency() {
        MonetaryAssets assets = new MonetaryAssets();

        assets.setCurrency("v1");

        assertEquals("v1", assets.getCurrency());
    }

    @Test
    public void setTime() {
        MonetaryAssets assets = new MonetaryAssets();

        assets.setTime("2016M03");

        assertNotNull(assets.getTime());
    }

    @Test
    public void getTime() {
        MonetaryAssets assets = new MonetaryAssets();

        assets.setTime("2016M03");

        assertEquals("2016M03", assets.getTime());
    }

    @Test
    public void setValues() {
        MonetaryAssets assets = new MonetaryAssets();

        assets.setValues(this.values);

        assertNotNull(assets.getValues());
    }

    @Test
    public void getValues() {
        MonetaryAssets assets = new MonetaryAssets();

        assets.setValues(this.values);

        assertEquals(this.values, assets.getValues());
    }

    @Test
    public void equals() {
        MonetaryAssets assets = new MonetaryAssets();
        MonetaryAssets assets2 = new MonetaryAssets();

        assertEquals(assets, assets2);
    }

    @Test
    public void equalsItself() {
        MonetaryAssets assets = new MonetaryAssets();

        assertEquals(assets, assets);
    }

    @Test
    public void notEqualsNull() {
        MonetaryAssets assets = new MonetaryAssets();

        assertNotEquals(assets, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        MonetaryAssets assets = new MonetaryAssets();

        assertNotEquals(assets, new Object());
    }

    @Test
    public void equalsItselfWithValues() {
        MonetaryAssets assets = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values);
        MonetaryAssets assets2 = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values2);

        assertEquals(assets, assets2);
    }

    @Test
    public void notEqualsOnInstitution() {
        MonetaryAssets assets = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values);

        MonetaryAssets assets2 = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values2);
        assets2.setInstitution("32007");

        assertNotEquals(assets, assets2);
    }

    @Test
    public void notEqualsOnItem() {
        MonetaryAssets assets = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values);

        MonetaryAssets assets2 = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values2);
        assets2.setItem("K12000");

        assertNotEquals(assets, assets2);
    }

    @Test
    public void notEqualsOnCurrency() {
        MonetaryAssets assets = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values);

        MonetaryAssets assets2 = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values2);
        assets2.setCurrency("v0");

        assertNotEquals(assets, assets2);
    }

    @Test
    public void notEqualsOnTime() {
        MonetaryAssets assets = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values);

        MonetaryAssets assets2 = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values2);
        assets2.setTime("2002M06");

        assertNotEquals(assets, assets2);
    }

    @Test
    public void notEqualsOnValue() {
        MonetaryAssets assets = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values);

        MonetaryAssets assets2 = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values2);
        assets2.setValue(this.testContentsCode, "99999");

        assertNotEquals(assets, assets2);
    }

    @Test
    public void equalsHashCode() {
        MonetaryAssets assets = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values);
        MonetaryAssets assets2 = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values2);

        assertEquals(assets.hashCode(), assets2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        MonetaryAssets assets = new MonetaryAssets();
        MonetaryAssets assets2 = new MonetaryAssets();

        assertEquals(assets.hashCode(), assets2.hashCode());
    }

    @Test
    public void convertToString() {
        MonetaryAssets assets = new MonetaryAssets("11102", "K21600", "v2", "2003M03", this.values);

        assertTrue(assets.toString().contains("11102"));
        assertTrue(assets.toString().contains("K21600"));
        assertTrue(assets.toString().contains("v2"));
        assertTrue(assets.toString().contains("2003M03"));
    }

    @Test
    public void convertToStringNullValues() {
        MonetaryAssets assets = new MonetaryAssets();

        assertNotNull(assets.toString());
    }

}
