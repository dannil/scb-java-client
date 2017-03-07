package com.github.dannil.scbjavaclient.model.environment.waste;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WasteTest {

    private static class DummyWaste extends AbstractWaste {

        @Override
        public String toString() {
            return null;
        }

    }

    @Test
    public void equals() {
        AbstractWaste waste = new DummyWaste();
        AbstractWaste waste2 = new DummyWaste();

        assertEquals(waste, waste2);
    }

    @Test
    public void equalsItself() {
        AbstractWaste waste = new DummyWaste();

        assertEquals(waste, waste);
    }

    @Test
    public void notEqualsNull() {
        AbstractWaste waste = new DummyWaste();

        assertNotEquals(waste, null);
    }

    @Test
    public void notEqualsIncompatibleObject() {
        AbstractWaste waste = new DummyWaste();

        assertNotEquals(waste, new Object());
    }

}
