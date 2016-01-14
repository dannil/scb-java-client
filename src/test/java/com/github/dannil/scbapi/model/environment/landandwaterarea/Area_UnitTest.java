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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbapi.model.environment.Type;

@RunWith(JUnit4.class)
public class Area_UnitTest {

	@Test
	public final void createWithDefaultConstructor() {
		Area area = new Area();

		assertNotNull(area);
	}

	@Test
	public final void setRegion() {
		Area area = new Area();

		area.setRegion("1267");

		assertNotNull(area.getRegion());
	}

	@Test
	public final void getRegion() {
		Area area = new Area();

		area.setRegion("1267");

		assertEquals("1267", area.getRegion());
	}

	@Test
	public final void setType() {
		Area area = new Area();

		area.setType(Type.LANDAREA);

		assertNotNull(area.getType());
	}

	@Test
	public final void getType() {
		Area area = new Area();

		area.setType(Type.LANDAREA);

		assertEquals(Type.LANDAREA, area.getType());
	}

	@Test
	public final void setYear() {
		Area area = new Area();

		area.setYear(2011);

		assertNotNull(area.getYear());
	}

	@Test
	public final void getYear() {
		Area area = new Area();

		area.setYear(2011);

		assertEquals(Integer.valueOf(2011), area.getYear());
	}

	@Test
	public final void setSquareKm() {
		Area area = new Area();

		area.setSquareKm(143d);

		assertNotNull(area.getSquareKm());
	}

	@Test
	public final void getSquareKm() {
		Area area = new Area();

		area.setSquareKm(143d);

		assertEquals(Double.valueOf(143d), area.getSquareKm());
	}

	@Test
	public final void getCodes() {
		assertNotNull(Area.getCodes());
	}

	@Test
	public final void equals() {
		Area area = new Area();
		Area area2 = new Area();

		assertTrue(area.equals(area2));
	}

	@Test
	public final void equalsItself() {
		Area area = new Area();

		assertTrue(area.equals(area));
	}

	@Test
	public final void notEqualsNull() {
		Area area = new Area();

		assertThat(area, not(equalTo(null)));
	}

	@Test
	public final void notEqualsIncompatibleObject() {
		Area area = new Area();

		assertFalse(area.equals(new Object()));
	}

	@Test
	public final void equalsItselfWithValues() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertTrue(area.equals(area2));
	}

	@Test
	public final void notEqualsOnRegion() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setRegion("1263");

		assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnFirstNullRegion() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setRegion(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnSecondNullRegion() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setRegion(null);

		assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnType() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setType(Type.SEAWATER);

		assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnFirstNullType() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setType(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnSecondNullType() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setType(null);

		assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnYear() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setYear(2011);

		assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnFirstNullYear() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setYear(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnSecondNullYear() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setYear(null);

		assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnSquareKm() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setSquareKm(300d);

		assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnFirstNullSquareKm() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setSquareKm(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnSecondNullSquareKm() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setSquareKm(null);

		assertFalse(area.equals(area2));
	}

	@Test
	public final void equalsHashCode() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertEquals(area.hashCode(), area2.hashCode());
	}

	@Test
	public final void equalsHashCodeNullValues() {
		Area area = new Area();
		Area area2 = new Area();

		assertEquals(area.hashCode(), area2.hashCode());
	}

	@Test
	public final void convertToString() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		assertNotNull(area.toString());
	}

	@Test
	public final void convertToStringNullValues() {
		Area area = new Area();

		assertNotNull(area.toString());
	}

}
