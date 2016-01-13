package com.github.dannil.scbapi.model.population;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RelationshipStatus_UnitTest {

	@Test
	public final void relationshipStatusValues() {
		assertNotNull(RelationshipStatus.values());
	}

	@Test
	public final void relationshipStatusValueOf() {
		RelationshipStatus status = RelationshipStatus.valueOf("UNMARRIED");

		assertEquals(RelationshipStatus.UNMARRIED, status);
	}

	@Test
	public final void convertValueToRelationshipStatus() {
		RelationshipStatus status = RelationshipStatus.of("OG");

		assertEquals(RelationshipStatus.UNMARRIED, status);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void illegalArgumentForType() {
		RelationshipStatus.of("ABC");
	}

}
