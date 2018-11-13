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
        List<String> methodParameters = Arrays.asList("properties", "industrialClassifications", "wasteCategories",
                "years");

        boolean isMissing = TestProcessor.isMissingParameters(methodParameters, apiParameters);
        assertFalse(isMissing);
    }

    @Test
    public void isMissingParametersTrue1() {
        List<String> apiParameters = Arrays.asList("property", "industrial classification", "waste category",
                "every other year");
        List<String> methodParameters = Arrays.asList("industrialClassifications", "wasteCategories", "years");

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
                "foreignAndSwedishBackgrounds", "parentsIncomeLevels", "years");

        boolean isMissing = TestProcessor.isMissingParameters(methodParameters, apiParameters);
        assertFalse(isMissing);
    }

    @Test
    public void isMissingParametersPluralize3() {
        List<String> apiParameters = Arrays.asList("greenhouse gas", "fuel type", "year");
        List<String> methodParameters = Arrays.asList("greenhouseGases", "fuelTypes", "years");

        boolean isMissing = TestProcessor.isMissingParameters(methodParameters, apiParameters);
        assertFalse(isMissing);
    }

    @Test
    public void isMissingParametersPluralize4() {
        List<String> apiParameters = Arrays.asList("industrialclassificationnacerev");
        List<String> methodParameters = Arrays.asList("industrialClassifications");

        boolean isMissing = TestProcessor.isMissingParameters(methodParameters, apiParameters);
        assertFalse(isMissing);
    }

    @Test
    public void isMissingParametersPluralize5() {
        List<String> apiParameters = Arrays.asList("assets/liabilities", "item", "quarter");
        List<String> methodParameters = Arrays.asList("assetsAndLiabilities", "items", "quarters");

        boolean isMissing = TestProcessor.isMissingParameters(methodParameters, apiParameters);
        assertFalse(isMissing);
    }

    @Test
    public void isMissingParametersNotPluralized() {
        List<String> apiParameters = Arrays.asList("greenhouse gas", "fuel type", "year");
        List<String> methodParameters = Arrays.asList("greenhouseGas", "fuelType", "year");

        boolean isMissing = TestProcessor.isMissingParameters(methodParameters, apiParameters);
        assertTrue(isMissing);
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

    @Test
    public void isParametersPluralizedFalse() {
        // year is not pluralized
        List<String> methodParameters = Arrays.asList("greenhouseGases", "fuelTypes", "year");

        boolean isPluralized = TestProcessor.isParametersPluralized(methodParameters);
        assertFalse(isPluralized);
    }

    @Test
    public void isParametersPluralizedTrue1() {
        List<String> methodParameters = Arrays.asList("greenhouseGases", "fuelTypes", "years");

        boolean isPluralized = TestProcessor.isParametersPluralized(methodParameters);
        assertTrue(isPluralized);
    }
    
    @Test
    public void isParametersPluralizedTrue2() {
        List<String> methodParameters = Arrays.asList("icnpos", "transactionItems", "years");

        boolean isPluralized = TestProcessor.isParametersPluralized(methodParameters);
        assertTrue(isPluralized);
    }

}
