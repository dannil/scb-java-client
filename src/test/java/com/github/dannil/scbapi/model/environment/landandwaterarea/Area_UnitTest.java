/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package com.github.dannil.scbapi.model.environment.landandwaterarea;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbapi.model.environment.Type;

@RunWith(JUnit4.class)
public class Area_UnitTest {

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

		area.setType(Type.LANDAREA);

		assertNotNull(area.getType());
	}

	@Test
	public void getType() {
		Area area = new Area();

		area.setType(Type.LANDAREA);

		assertEquals(Type.LANDAREA, area.getType());
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
	public void setSquareKm() {
		Area area = new Area();

		area.setSquareKm(143d);

		assertNotNull(area.getSquareKm());
	}

	@Test
	public void getSquareKm() {
		Area area = new Area();

		area.setSquareKm(143d);

		assertEquals(Double.valueOf(143d), area.getSquareKm());
	}

	@Test
	public void getCodes() {
		assertNotNull(Area.getCodes());
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
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertEquals(area, area2);
	}

	@Test
	public void notEqualsOnRegion() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setRegion("1263");

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnFirstNullRegion() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setRegion(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnSecondNullRegion() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setRegion(null);

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnType() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setType(Type.SEAWATER);

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnFirstNullType() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setType(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnSecondNullType() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setType(null);

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnYear() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setYear(2011);

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnFirstNullYear() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setYear(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnSecondNullYear() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setYear(null);

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnSquareKm() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setSquareKm(300d);

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnFirstNullSquareKm() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setSquareKm(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertNotEquals(area, area2);
	}

	@Test
	public void notEqualsOnSecondNullSquareKm() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setSquareKm(null);

		assertNotEquals(area, area2);
	}

	@Test
	public void equalsHashCode() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

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
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertNotNull(area.toString());
	}

	@Test
	public void convertToStringNullValues() {
		Area area = new Area();

		assertNotNull(area.toString());
	}

}
