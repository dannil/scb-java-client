package com.github.dannil.scbjavaclient.test.utility;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestProcessorTest {

    @Test
    public void isMissingParametersFalse() {
        List<String> apiParameters = Arrays.asList("property", "industrial classification", "waste category",
                "every other year");
        List<String> methodParameters = Arrays.asList("properties", "industrialClassification", "wasteCategories",
                "years");

        boolean isMissing = TestProcessor.isMissingParameters(methodParameters, apiParameters);
        assertFalse(isMissing);
    }

    @Test
    public void isMissingParametersTrue() {
        List<String> apiParameters = Arrays.asList("property", "industrial classification", "waste category",
                "every other year");
        List<String> methodParameters = Arrays.asList("industrialClassification", "wasteCategories", "years");

        boolean isMissing = TestProcessor.isMissingParameters(methodParameters, apiParameters);
        assertTrue(isMissing);
    }

    @Test
    public void isMissingParametersPluralize1() {
        List<String> apiParameters = Arrays.asList("country of citizenship", "sex", "year");
        List<String> methodParameters = Arrays.asList("countriesOfCitizenships", "sexes", "years");

        boolean isMissing = TestProcessor.isMissingParameters(methodParameters, apiParameters);
        assertFalse(isMissing);
    }

    @Test
    public void isMissingParametersPluralize2() {
        List<String> apiParameters = Arrays.asList("sex", "ages", "type of housing,", "family type",
                "foreign/Swedish background", "parents´ income level", "year");
        List<String> methodParameters = Arrays.asList("sexes", "ages", "typesOfHousings", "familyTypes",
                "foreignAndSwedishBackgrounds", "parentsIncomes", "years");

        boolean isMissing = TestProcessor.isMissingParameters(methodParameters, apiParameters);
        assertFalse(isMissing);
    }

    @Test
    public void isJumbledFalse() {
        List<String> apiParameters = Arrays.asList("property", "industrial classification", "waste category",
                "every other year");
        List<String> methodParameters = Arrays.asList("properties", "industrialClassification", "wasteCategories",
                "years");

        boolean isJumbled = TestProcessor.isJumbled(methodParameters, apiParameters);
        assertFalse(isJumbled);
    }

    @Test
    public void isJumbledTrue() {
        List<String> apiParameters = Arrays.asList("property", "industrial classification", "waste category",
                "every other year");
        List<String> methodParameters = Arrays.asList("industrialClassification", "wasteCategories", "years",
                "properties");

        boolean isJumbled = TestProcessor.isJumbled(methodParameters, apiParameters);
        assertTrue(isJumbled);
    }

}
