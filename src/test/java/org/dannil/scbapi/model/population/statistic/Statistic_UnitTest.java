package org.dannil.scbapi.model.population.statistic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.dannil.scbapi.model.population.statistic.Statistic.Gender;
import org.dannil.scbapi.model.population.statistic.Statistic.RelationshipStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Statistic_UnitTest {

	@Test
	public final void createWithDefaultConstructor() {
		Statistic statistic = new Statistic();

		assertNotNull(statistic);
	}

	@Test
	public final void setRegion() {
		Statistic statistic = new Statistic();

		statistic.setRegion("1267");

		assertNotNull(statistic.getRegion());
	}

	@Test
	public final void getRegion() {
		Statistic statistic = new Statistic();

		statistic.setRegion("1267");

		assertEquals("1267", statistic.getRegion());
	}

	@Test
	public final void setRelationshipStatus() {
		Statistic statistic = new Statistic();

		statistic.setRelationshipStatus(RelationshipStatus.MARRIED);

		assertNotNull(statistic.getRelationshipStatus());
	}

	@Test
	public final void getRelationshipStatus() {
		Statistic statistic = new Statistic();

		statistic.setRelationshipStatus(RelationshipStatus.MARRIED);

		assertEquals(RelationshipStatus.MARRIED, statistic.getRelationshipStatus());
	}

	@Test
	public final void setAge() {
		Statistic statistic = new Statistic();

		statistic.setAge("20");

		assertNotNull(statistic.getAge());
	}

	@Test
	public final void getAge() {
		Statistic statistic = new Statistic();

		statistic.setAge("20");

		assertEquals("20", statistic.getAge());
	}

	@Test
	public final void setGender() {
		Statistic statistic = new Statistic();

		statistic.setGender(Gender.MAN);

		assertNotNull(statistic.getGender());
	}

	@Test
	public final void getGender() {
		Statistic statistic = new Statistic();

		statistic.setGender(Gender.MAN);

		assertEquals(Gender.MAN, statistic.getGender());
	}

	@Test
	public final void setYear() {
		Statistic statistic = new Statistic();

		statistic.setYear(2011);

		assertNotNull(statistic.getYear());
	}

	@Test
	public final void getYear() {
		Statistic statistic = new Statistic();

		statistic.setYear(2011);

		assertEquals(Integer.valueOf(2011), statistic.getYear());
	}

	@Test
	public final void setAmount() {
		Statistic statistic = new Statistic();

		statistic.setAmount(12345L);

		assertNotNull(statistic.getAmount());
	}

	@Test
	public final void getAmount() {
		Statistic statistic = new Statistic();

		statistic.setAmount(12345L);

		assertEquals(Long.valueOf(12345L), statistic.getAmount());
	}

	@Test
	public final void getCodes() {
		assertNotNull(Statistic.getCodes());
	}

	@Test
	public final void equals() {
		Statistic statistic = new Statistic();
		Statistic statistic2 = new Statistic();

		assertTrue(statistic.equals(statistic2));
	}

	@Test
	public final void equalsItself() {
		Statistic statistic = new Statistic();

		assertTrue(statistic.equals(statistic));
	}

	@Test
	public final void notEqualsNull() {
		Statistic statistic = new Statistic();

		assertFalse(statistic.equals(null));
	}

	@Test
	public final void notEqualsIncompatibleObject() {
		Statistic statistic = new Statistic();

		assertFalse(statistic.equals(new Object()));
	}

	@Test
	public final void equalsItselfWithValues() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertTrue(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnRegion() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setRegion("1452");

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnFirstNullRegion() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic.setRegion(null);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnSecondNullRegion() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setRegion(null);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnRelationshipStatus() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setRelationshipStatus(RelationshipStatus.DIVORCED);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnFirstNullRelationshipStatus() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic.setRelationshipStatus(null);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnSecondNullRelationshipStatus() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setRelationshipStatus(null);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnAge() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setAge("56");

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnFirstNullAge() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic.setAge(null);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnSecondNullAge() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setAge(null);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnGender() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setGender(Gender.WOMAN);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnFirstNullGender() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic.setGender(null);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnSecondNullGender() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setGender(null);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnYear() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setYear(1999);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnFirstNullYear() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic.setYear(null);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnSecondNullYear() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setYear(null);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnAmount() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setAmount(54321L);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnFirstNullAmount() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic.setAmount(null);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnSecondNullAmount() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setAmount(null);

		assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void equalsHashCode() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertEquals(statistic.hashCode(), statistic2.hashCode());
	}

	@Test
	public final void equalsHashCodeNullValues() {
		Statistic statistic = new Statistic();
		Statistic statistic2 = new Statistic();

		assertEquals(statistic.hashCode(), statistic2.hashCode());
	}

	@Test
	public final void convertToString() {
		Statistic statistic = new Statistic();

		assertNotNull(statistic.toString());
	}

	@Test
	public final void convertToStringNullValues() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertNotNull(statistic.toString());
	}

	@Test
	public final void relationshipStatusValues() {
		assertNotNull(RelationshipStatus.values());
	}

	@Test
	public final void genderValues() {
		assertNotNull(Gender.values());
	}

	@Test
	public final void relationshipStatusValueOf() {
		RelationshipStatus status = RelationshipStatus.valueOf("UNMARRIED");

		assertNotNull(status);
	}

	@Test
	public final void genderValueOf() {
		Gender gender = Gender.valueOf("MAN");

		assertNotNull(gender);
	}

	@Test
	public final void convertValueToRelationshipStatus() {
		RelationshipStatus status = RelationshipStatus.of("OG");

		assertNotNull(status);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void illegalArgumentForType() {
		RelationshipStatus.of("ABC");
	}

	@Test
	public final void convertValueToGender() {
		Gender gender = Gender.of(1);

		assertNotNull(gender);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void illegalArgumentForGender() {
		Gender.of(-1);
	}

}