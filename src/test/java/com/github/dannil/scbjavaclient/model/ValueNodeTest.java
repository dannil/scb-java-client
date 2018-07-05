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

package com.github.dannil.scbjavaclient.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class ValueNodeTest {

    @Test
    public void createWithDefaultConstructor() {
        ValueNode<Double> value = new ValueNode<Double>();

        assertNotNull(value);
    }

    @Test
    public void setValue() {
        ValueNode<Double> value = new ValueNode<Double>();

        value.setValue(11.22d);

        assertEquals(Double.valueOf(11.22d), value.getValue());
    }

    @Test
    public void setCode() {
        ValueNode<Double> value = new ValueNode<Double>();

        value.setCode("TESTCODE");

        assertEquals("TESTCODE", value.getCode());
    }

    @Test
    public void setText() {
        ValueNode<Double> value = new ValueNode<Double>();

        value.setText("TESTTEXT");

        assertEquals("TESTTEXT", value.getText());
    }

    @Test
    public void equals() {
        ValueNode<Double> value = new ValueNode<Double>();
        ValueNode<Double> value2 = new ValueNode<Double>();

        assertEquals(value, value2);
    }

    @Test
    public void equalsItself() {
        ValueNode<Double> value = new ValueNode<Double>();

        assertEquals(value, value);
    }

    @Test
    public void equalsItselfWithValues() {
        ValueNode<Double> value = new ValueNode<Double>(11.22d, "TESTCODE", "TESTTEXT");
        ValueNode<Double> value2 = new ValueNode<Double>(11.22d, "TESTCODE", "TESTTEXT");

        assertEquals(value, value2);
    }

    @Test
    public void notEqualsNull() {
        ValueNode<Double> value = new ValueNode<Double>();

        assertNotEquals(value, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        ValueNode<Double> value = new ValueNode<Double>();

        assertNotEquals(value, new Object());
    }

    @Test
    public void notEqualsValue() {
        ValueNode<Double> value = new ValueNode<Double>(11.22d, "TESTCODE", "TESTTEXT");
        ValueNode<Double> value2 = new ValueNode<Double>(55.66d, "TESTCODE", "TESTTEXT");

        assertNotEquals(value, value2);
    }

    @Test
    public void notEqualsCode() {
        ValueNode<Double> value = new ValueNode<Double>(11.22d, "TESTCODE", "TESTTEXT");
        ValueNode<Double> value2 = new ValueNode<Double>(11.22d, "ANOTHERTESTCODENOTEQUAL", "TESTTEXT");

        assertNotEquals(value, value2);
    }

    @Test
    public void notEqualsText() {
        ValueNode<Double> value = new ValueNode<Double>(11.22d, "TESTCODE", "TESTTEXT");
        ValueNode<Double> value2 = new ValueNode<Double>(11.22d, "TESTCODE", "ANOTHERTESTTEXTNOTEQUAL");

        assertNotEquals(value, value2);
    }

    @Test
    public void equalsHashCode() {
        ValueNode<Double> value = new ValueNode<Double>(11.22d, "TESTCODE", "TESTTEXT");
        ValueNode<Double> value2 = new ValueNode<Double>(11.22d, "TESTCODE", "TESTTEXT");

        assertEquals(value.hashCode(), value2.hashCode());
    }

    @Test
    public void equalsHashCodeNullValues() {
        ValueNode<Double> value = new ValueNode<Double>();
        ValueNode<Double> value2 = new ValueNode<Double>();

        assertEquals(value.hashCode(), value2.hashCode());
    }

    @Test
    public void convertToStringNullValues() {
        ValueNode<Double> value = new ValueNode<Double>();

        assertNotNull(value.toString());
    }

    @Test
    public void convertToString() {
        ValueNode<Double> value = new ValueNode<Double>(11.22d, "TESTCODE", "TESTTEXT");

        assertTrue(value.toString().contains("11.22"));
        assertTrue(value.toString().contains("TESTCODE"));
        assertTrue(value.toString().contains("TESTTEXT"));
    }

}
