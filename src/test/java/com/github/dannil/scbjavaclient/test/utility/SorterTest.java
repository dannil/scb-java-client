package com.github.dannil.scbjavaclient.test.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.Test;

@Suite
public class SorterTest {

    @Test
    public void noElementOrderingMatches() {
        List<String> accordingTo = Arrays.asList("property", "industrial classification", "waste category",
                "every other year");
        List<String> toBeSorted = Arrays.asList("industrialClassification", "wasteCategories", "years", "properties");

        // Verify that elements are in the correct ordering
        assertNotEquals(accordingTo.indexOf("property"), toBeSorted.indexOf("properties"));
        assertNotEquals(accordingTo.indexOf("industrial classification"),
                toBeSorted.indexOf("industrialClassification"));
        assertNotEquals(accordingTo.indexOf("waste category"), toBeSorted.indexOf("wasteCategories"));
        assertNotEquals(accordingTo.indexOf("every other year"), toBeSorted.indexOf("years"));

        List<String> sorted = Sorter.sortAccordingTo(toBeSorted, accordingTo);

        // Verify that elements are in the correct ordering
        assertEquals(accordingTo.indexOf("property"), sorted.indexOf("properties"));
        assertEquals(accordingTo.indexOf("industrial classification"), sorted.indexOf("industrialClassification"));
        assertEquals(accordingTo.indexOf("waste category"), sorted.indexOf("wasteCategories"));
        assertEquals(accordingTo.indexOf("every other year"), sorted.indexOf("years"));
    }

    @Test
    public void firstAndLastElementOrderingMatches() {
        List<String> accordingTo = Arrays.asList("property", "industrial classification", "waste category",
                "every other year");
        List<String> toBeSorted = Arrays.asList("properties", "wasteCategories", "industrialClassification", "years");

        // Verify that elements are in the correct ordering
        assertEquals(accordingTo.indexOf("property"), toBeSorted.indexOf("properties"));
        assertNotEquals(accordingTo.indexOf("industrial classification"),
                toBeSorted.indexOf("industrialClassification"));
        assertNotEquals(accordingTo.indexOf("waste category"), toBeSorted.indexOf("wasteCategories"));
        assertEquals(accordingTo.indexOf("every other year"), toBeSorted.indexOf("years"));

        List<String> sorted = Sorter.sortAccordingTo(toBeSorted, accordingTo);

        // Verify that elements are in the correct ordering
        assertEquals(accordingTo.indexOf("property"), sorted.indexOf("properties"));
        assertEquals(accordingTo.indexOf("industrial classification"), sorted.indexOf("industrialClassification"));
        assertEquals(accordingTo.indexOf("waste category"), sorted.indexOf("wasteCategories"));
        assertEquals(accordingTo.indexOf("every other year"), sorted.indexOf("years"));
    }

    @Test
    public void allElementsOrderingMatches() {
        List<String> accordingTo = Arrays.asList("property", "industrial classification", "waste category",
                "every other year");
        List<String> toBeSorted = Arrays.asList("properties", "industrialClassification", "wasteCategories", "years");

        // Verify that elements are in the correct ordering
        assertEquals(accordingTo.indexOf("property"), toBeSorted.indexOf("properties"));
        assertEquals(accordingTo.indexOf("industrial classification"), toBeSorted.indexOf("industrialClassification"));
        assertEquals(accordingTo.indexOf("waste category"), toBeSorted.indexOf("wasteCategories"));
        assertEquals(accordingTo.indexOf("every other year"), toBeSorted.indexOf("years"));

        List<String> sorted = Sorter.sortAccordingTo(toBeSorted, accordingTo);

        // Verify that elements are in the correct ordering
        assertEquals(accordingTo.indexOf("property"), sorted.indexOf("properties"));
        assertEquals(accordingTo.indexOf("industrial classification"), sorted.indexOf("industrialClassification"));
        assertEquals(accordingTo.indexOf("waste category"), sorted.indexOf("wasteCategories"));
        assertEquals(accordingTo.indexOf("every other year"), sorted.indexOf("years"));
    }

    @Test
    public void elementIsSimilarToAnotherElement() {
        List<String> accordingTo = Arrays.asList("sex", "year of birth", "year");
        List<String> toBeSorted = Arrays.asList("sexes", "yearsOfBirths", "years");

        // Verify that elements are in the correct ordering
        assertEquals(accordingTo.indexOf("sex"), toBeSorted.indexOf("sexes"));
        assertEquals(accordingTo.indexOf("year of birth"), toBeSorted.indexOf("yearsOfBirths"));
        assertEquals(accordingTo.indexOf("year"), toBeSorted.indexOf("years"));

        List<String> sorted = Sorter.sortAccordingTo(toBeSorted, accordingTo);

        // Verify that elements are in the correct ordering
        assertEquals(accordingTo.indexOf("sex"), sorted.indexOf("sexes"));
        assertEquals(accordingTo.indexOf("year of birth"), sorted.indexOf("yearsOfBirths"));
        assertEquals(accordingTo.indexOf("year"), sorted.indexOf("years"));
    }

}
