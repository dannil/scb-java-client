/*
 * Copyright 2014 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.model.environment.landandwaterarea;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.model.ValueNode;

@RunWith(JUnit4.class)
public class AreaTest {

	private String testContentsCode;

	private List<ValueNode<Double>> valueNodes;

	@Before
	public void setup() {
		this.testContentsCode = "TESTCONTENTSCODE";
		this.valueNodes = new ArrayList<ValueNode<Double>>();

		ValueNode<Double> value = new ValueNode<Double>(143d, "TESTCONTENTSCODE", "Test contents code");
		this.valueNodes.add(value);
	}

	@Test
	public void createWithDefaultConstructor() {
		Area area = new Area();

		assertNotNull(area);
	}

	@Test
	public void setRegion() {
		Area area = new Area();

		area.setRegion("1267");

		assertNotNull(area.getRegion());
	}

	@Test
	public void getRegion() {
		Area area = new Area();

		area.setRegion("1267");

		assertEquals("1267", area.getRegion());
	}

	@Test
	public void setType() {
		Area area = new Area();

		area.setType("01");

		assertNotNull(area.getType());
	}

	@Test
	public void getType() {
		Area area = new Area();

		area.setType("01");

		assertEquals("01", area.getType());
	}

	@Test
	public void setYear() {
		Area area = new Area();

		area.setYear(2011);

		assertNotNull(area.getYear());
	}

	@Test
	public void getYear() {
		Area area = new Area();

		area.setYear(2011);

		assertEquals(Integer.valueOf(2011), area.getYear());
	}

	@Test
	public void setValues() {
		Area area = new Area();

		area.setValues(this.valueNodes);

		assertNotNull(area.getValues());
	}

	@Test
	public void getValues() {
		Area area = new Area();

		area.setValues(this.valueNodes);

		assertEquals(this.valueNodes, area.getValues());
	}

	@Test
	public void getInputs() {
		assertNotNull(Area.getInputs());
	}

	@Test
	public void equals() {
		Area area = new Area();
		Area area2 = new Area();

		assertEquals(area, area2);
	}

	@Test
	public void equalsItself() {
		Area area = new Area();

		assertEquals(area, area);
	}

	@Test
	public void notEqualsNull() {
		Area area = new Area();

		assertNotEquals(area, null);
	}

	@Test
	public void notEqualsIncompatibleObject() {
		Area area = new Area();

		assertNotEquals(area, new Object());
	}

	@Test
	public void equalsItselfWithValues() {
		Area area = new Area("1267", "01", 2009, this.valueNodes);
		Area area2 = new Area("1267", "01", 2009, this.valueNodes);

		assertEquals(area, area2);
	}

	@Test
	public void notEqualsOnRegion() {
		Area area = new Area("1267", "01", 2009, this.valueNodes);

		Area area2 = new Area("1267", "01", 2009, this.valueNodes);
		area2.setRegion("1263");

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnType() {
		Area area = new Area("1267", "01", 2009, this.valueNodes);

		Area area2 = new Area("1267", "01", 2009, this.valueNodes);
		area2.setType("02");

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnYear() {
		Area area = new Area("1267", "01", 2009, this.valueNodes);

		Area area2 = new Area("1267", "01", 2009, this.valueNodes);
		area2.setYear(2011);

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnValue() {
		Area area = new Area("1267", "01", 2009, this.valueNodes);

		Area area2 = new Area("1267", "01", 2009, this.valueNodes);
		area2.setValue(this.testContentsCode, 300d);

		assertNotEquals(area, area2);
	}

	@Test
	public void equalsHashCode() {
		Area area = new Area("1267", "01", 2009, this.valueNodes);
		Area area2 = new Area("1267", "01", 2009, this.valueNodes);

		assertEquals(area.hashCode(), area2.hashCode());
	}

	@Test
	public void equalsHashCodeNullValues() {
		Area area = new Area();
		Area area2 = new Area();

		assertEquals(area.hashCode(), area2.hashCode());
	}

	@Test
	public void convertToString() {
		Area area = new Area("1267", "01", 2009, this.valueNodes);

		assertNotNull(area.toString());
	}

	@Test
	public void convertToStringNullValues() {
		Area area = new Area();

		assertNotNull(area.toString());
	}

}
