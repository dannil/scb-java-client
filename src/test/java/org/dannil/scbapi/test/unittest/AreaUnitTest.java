package org.dannil.scbapi.test.unittest;

import org.dannil.scbapi.model.environment.landandwaterarea.Area;
import org.dannil.scbapi.model.environment.landandwaterarea.Area.Type;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AreaUnitTest {

	@Test
	public final void createWithDefaultConstructor() {
		Area area = new Area();

		Assert.assertNotNull(area);
	}

	@Test
	public final void setRegion() {
		Area area = new Area();

		area.setRegion("1267");

		Assert.assertNotNull(area.getRegion());
	}

	@Test
	public final void getRegion() {
		Area area = new Area();

		area.setRegion("1267");

		Assert.assertEquals("1267", area.getRegion());
	}

	@Test
	public final void setType() {
		Area area = new Area();

		area.setType(Type.LANDAREA);

		Assert.assertNotNull(area.getType());
	}

	@Test
	public final void getType() {
		Area area = new Area();

		area.setType(Type.LANDAREA);

		Assert.assertEquals(Type.LANDAREA, area.getType());
	}

	@Test
	public final void setYear() {
		Area area = new Area();

		area.setYear(2011);

		Assert.assertNotNull(area.getYear());
	}

	@Test
	public final void getYear() {
		Area area = new Area();

		area.setYear(2011);

		Assert.assertEquals(Integer.valueOf(2011), area.getYear());
	}

	@Test
	public final void setSquareKm() {
		Area area = new Area();

		area.setSquareKm(143d);

		Assert.assertNotNull(area.getSquareKm());
	}

	@Test
	public final void getSquareKm() {
		Area area = new Area();

		area.setSquareKm(143d);

		Assert.assertEquals(Double.valueOf(143d), area.getSquareKm());
	}

	@Test
	public final void getCodes() {
		Assert.assertNotNull(Area.getCodes());
	}

	@Test
	public final void equals() {
		Area area = new Area();
		Area area2 = new Area();

		Assert.assertTrue(area.equals(area2));
	}

	@Test
	public final void equalsItself() {
		Area area = new Area();

		Assert.assertTrue(area.equals(area));
	}

	@Test
	public final void notEqualsNull() {
		Area area = new Area();

		Assert.assertFalse(area.equals(null));
	}

	@Test
	public final void notEqualsIncompatibleObject() {
		Area area = new Area();

		Assert.assertFalse(area.equals(new Object()));
	}

	@Test
	public final void equalsItselfWithValues() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		Assert.assertTrue(area.equals(area2));
	}

	@Test
	public final void notEqualsOnRegion() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setRegion("1263");

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnFirstNullRegion() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setRegion(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnSecondNullRegion() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setRegion(null);

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnType() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setType(Type.SEAWATER);

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnFirstNullType() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setType(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnSecondNullType() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setType(null);

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnYear() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setYear(2011);

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnFirstNullYear() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setYear(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnSecondNullYear() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setYear(null);

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnSquareKm() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setSquareKm(300d);

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnFirstNullSquareKm() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		area.setSquareKm(null);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void notEqualsOnSecondNullSquareKm() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);
		area2.setSquareKm(null);

		Assert.assertFalse(area.equals(area2));
	}

	@Test
	public final void equalsHashCode() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);
		Area area2 = new Area("1267", Type.LANDAREA, 2009, 200d);

		Assert.assertEquals(area.hashCode(), area2.hashCode());
	}

	@Test
	public final void equalsHashCodeNullValues() {
		Area area = new Area();
		Area area2 = new Area();

		Assert.assertEquals(area.hashCode(), area2.hashCode());
	}

	@Test
	public final void convertToString() {
		Area area = new Area("1267", Type.LANDAREA, 2009, 200d);

		Assert.assertNotNull(area.toString());
	}

	@Test
	public final void convertToStringNullValues() {
		Area area = new Area();

		Assert.assertNotNull(area.toString());
	}

	@Test
	public final void convertValueToType() {
		Type type = Type.of("01");

		Assert.assertNotNull(type);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void illegalArgumentForType() {
		Type.of(null);
	}

	//
	// @Test
	// public final void test() {
	// throw new NotImplementedYetException();
	// }
	//
	// @Test
	// public final void test() {
	// throw new NotImplementedYetException();
	// }
	//
	// @Test
	// public final void test() {
	// throw new NotImplementedYetException();
	// }
	//
	// @Test
	// public final void test() {
	// throw new NotImplementedYetException();
	// }
	//
	// @Test
	// public final void test() {
	// throw new NotImplementedYetException();
	// }
	//
	// @Test
	// public final void test() {
	// throw new NotImplementedYetException();
	// }
	//
	// @Test
	// public final void test() {
	// throw new NotImplementedYetException();
	// }

}
