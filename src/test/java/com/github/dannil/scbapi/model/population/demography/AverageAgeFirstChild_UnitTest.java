package com.github.dannil.scbapi.model.population.demography;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.dannil.scbapi.model.population.Gender;

public class AverageAgeFirstChild_UnitTest {

	@Test
	public final void createWithDefaultConstructor() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild();

		assertNotNull(avg);
	}

	@Test
	public void setRegion() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild();

		avg.setRegion("1263");

		assertEquals("1263", avg.getRegion());
	}

	@Test
	public void setGender() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild();

		avg.setGender(Gender.MAN);

		assertEquals(Gender.MAN, avg.getGender());
	}

	@Test
	public void setYear() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild();

		avg.setYear(1996);

		assertEquals(Integer.valueOf(1996), avg.getYear());
	}

	@Test
	public void setAverageAge() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild();

		avg.setAverageAge(34.56);

		assertEquals(Double.valueOf(34.56), avg.getAverageAge());
	}

	// Special cases (beginning with super) that tests the superclass
	// @Test
	// public void superEqualsItself() {
	// AbstractRegionAndYearModel<String, Integer> avg = new
	// AverageAgeFirstChild();
	//
	// assertEquals(avg, avg);
	// }
	//
	// @Test
	// public void superNotEqualsNull() {
	// AbstractRegionAndYearModel<String, Integer> avg = new
	// AverageAgeFirstChild();
	//
	// assertNotEquals(avg, null);
	// }
	//
	// @Test
	// public void superNotEqualsIncompatibleObject() {
	// AbstractRegionAndYearModel<String, Integer> avg = new
	// AverageAgeFirstChild();
	//
	// assertNotEquals(avg, new Object());
	// }

	@Test
	public void getCodes() {
		assertNotNull(AverageAgeFirstChild.getCodes());
	}

	@Test
	public void equals() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild();
		AverageAgeFirstChild avg2 = new AverageAgeFirstChild();

		assertEquals(avg, avg2);
	}

	@Test
	public void equalsItself() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild();

		assertEquals(avg, avg);
	}

	@Test
	public void equalsItselfWithValues() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild("1263", Gender.WOMAN, 1996, 34.56);
		AverageAgeFirstChild avg2 = new AverageAgeFirstChild("1263", Gender.WOMAN, 1996, 34.56);

		assertEquals(avg, avg2);
	}

	@Test
	public void notEqualsNull() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild();

		assertNotEquals(avg, null);
	}

	@Test
	public void notEqualsIncompatibleObject() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild();

		assertNotEquals(avg, new Object());
	}

	@Test
	public void notEqualsRegion() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild("1263", Gender.WOMAN, 1996, 34.56);
		AverageAgeFirstChild avg2 = new AverageAgeFirstChild("1267", Gender.WOMAN, 1996, 34.56);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsGender() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild("1263", Gender.WOMAN, 1996, 34.56);
		AverageAgeFirstChild avg2 = new AverageAgeFirstChild("1263", Gender.MAN, 1996, 34.56);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsYear() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild("1263", Gender.WOMAN, 1996, 34.56);
		AverageAgeFirstChild avg2 = new AverageAgeFirstChild("1263", Gender.WOMAN, 2002, 34.56);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsAverageAge() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild("1263", Gender.WOMAN, 1996, 34.56);
		AverageAgeFirstChild avg2 = new AverageAgeFirstChild("1263", Gender.WOMAN, 1996, 65.43);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void equalsHashCode() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild("1263", Gender.WOMAN, 1996, 34.56);
		AverageAgeFirstChild avg2 = new AverageAgeFirstChild("1263", Gender.WOMAN, 1996, 34.56);

		assertEquals(avg.hashCode(), avg2.hashCode());
	}

	@Test
	public void equalsHashCodeNullValues() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild();
		AverageAgeFirstChild avg2 = new AverageAgeFirstChild();

		assertEquals(avg.hashCode(), avg2.hashCode());
	}

	@Test
	public void convertToStringNullValues() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild();

		assertNotNull(avg.toString());
	}

	@Test
	public void convertToString() {
		AverageAgeFirstChild avg = new AverageAgeFirstChild("1263", Gender.WOMAN, 1996, 34.56);

		assertTrue(avg.toString().contains("1263"));
		assertTrue(avg.toString().contains("2"));
		assertTrue(avg.toString().contains("1996"));
		assertTrue(avg.toString().contains("34.56"));
	}

}
