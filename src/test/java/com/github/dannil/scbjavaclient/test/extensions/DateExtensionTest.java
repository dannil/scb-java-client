package com.github.dannil.scbjavaclient.test.extensions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.AnnotatedElement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExtensionContext;

public class DateExtensionTest {

    private final int defaultTestsDayLimit = 7;

    private int actualTestsDayLimit;

    private DateExtension ex;

    @BeforeEach
    public void setup() {
        ex = new DateExtension();

        // Assume testsDayLimit is the default for all tests unless we make a call to the
        // method and specify our own limit
        modifyTestsDayLimit(defaultTestsDayLimit);
    }

    @AfterEach
    public void teardown() {
        String systemPropertyDayLimit = System.getProperty("testsDayLimit");
        if (systemPropertyDayLimit == null) {
            throw new UnsupportedOperationException("testsDayLimit can't be null");
        }
        System.setProperty("testsDayLimit", String.valueOf(actualTestsDayLimit));
    }

    @Test
    public void evaluateExecutionConditionNoAnnotationPresent() {
        Optional<AnnotatedElement> opElement = Optional.empty();

        ExtensionContext context = mock(ExtensionContext.class);
        when(context.getElement()).thenReturn(opElement);

        ConditionEvaluationResult result = ex.evaluateExecutionCondition(context);
        assertTrue(result.isDisabled());
        assertEquals("No annotation present", result.getReason().get());
    }

    @Test
    public void evaluateExecutionConditionDateIsNow() {
        Date date = mock(Date.class);
        when(date.value()).thenReturn("now");

        AnnotatedElement element = mock(AnnotatedElement.class);
        when(element.getAnnotation(Date.class)).thenReturn(date);

        Optional<AnnotatedElement> opElement = Optional.ofNullable(element);

        ExtensionContext context = mock(ExtensionContext.class);
        when(context.getElement()).thenReturn(opElement);

        ConditionEvaluationResult result = ex.evaluateExecutionCondition(context);
        assertFalse(result.isDisabled());
        assertEquals("Date is within the day limit", result.getReason().get());
    }

    @Test
    public void evaluateExecutionConditionDateIsInTheFuture() {
        LocalDate now = LocalDate.now();

        Date date = mock(Date.class);
        when(date.value()).thenReturn(now.plusYears(1).toString());

        AnnotatedElement element = mock(AnnotatedElement.class);
        when(element.getAnnotation(Date.class)).thenReturn(date);

        Optional<AnnotatedElement> opElement = Optional.ofNullable(element);

        ExtensionContext context = mock(ExtensionContext.class);
        when(context.getElement()).thenReturn(opElement);

        ConditionEvaluationResult result = ex.evaluateExecutionCondition(context);
        assertFalse(result.isDisabled());
        assertEquals("Date is within the day limit", result.getReason().get());
    }

    @Test
    public void evaluateExecutionConditionDaysAreLessThanZero() {
        modifyTestsDayLimit(-1L);

        Date date = mock(Date.class);
        when(date.value()).thenReturn("now");

        AnnotatedElement element = mock(AnnotatedElement.class);
        when(element.getAnnotation(Date.class)).thenReturn(date);

        Optional<AnnotatedElement> opElement = Optional.ofNullable(element);

        ExtensionContext context = mock(ExtensionContext.class);
        when(context.getElement()).thenReturn(opElement);

        ConditionEvaluationResult result = ex.evaluateExecutionCondition(context);
        assertTrue(result.isDisabled());
        assertEquals("Day limit is less than 0", result.getReason().get());
    }

    @Test
    public void evaluateExecutionConditionDateIsInThePast() {
        LocalDate now = LocalDate.now();

        Date date = mock(Date.class);
        when(date.value()).thenReturn(now.minusYears(1).toString());

        AnnotatedElement element = mock(AnnotatedElement.class);
        when(element.getAnnotation(Date.class)).thenReturn(date);

        Optional<AnnotatedElement> opElement = Optional.ofNullable(element);

        ExtensionContext context = mock(ExtensionContext.class);
        when(context.getElement()).thenReturn(opElement);

        ConditionEvaluationResult result = ex.evaluateExecutionCondition(context);
        assertTrue(result.isDisabled());
        assertEquals("Date is not within the day limit", result.getReason().get());
    }

    @Test
    public void evaluateExecutionConditionDateIsInsideCutoff() {
        // This test should always be inside the cutoff, so let's do this calculation
        // dynamically so the test won't begin to fail in the future
        LocalDate now = LocalDate.now();
        LocalDate oneYearAgo = now.minusYears(1);

        long daysBetween = ChronoUnit.DAYS.between(oneYearAgo, now);
        LocalDate dateBetween = oneYearAgo.plusDays(daysBetween / 2);

        modifyTestsDayLimit(daysBetween);

        Date date = mock(Date.class);
        when(date.value()).thenReturn(dateBetween.toString());

        AnnotatedElement element = mock(AnnotatedElement.class);
        when(element.getAnnotation(Date.class)).thenReturn(date);

        Optional<AnnotatedElement> opElement = Optional.ofNullable(element);

        ExtensionContext context = mock(ExtensionContext.class);
        when(context.getElement()).thenReturn(opElement);

        ConditionEvaluationResult result = ex.evaluateExecutionCondition(context);
        assertFalse(result.isDisabled());
        assertEquals("Date is within the day limit", result.getReason().get());
    }

    @Test
    public void evaluateExecutionConditionDateEqualsCutoff() {
        // This test should always be equal to the cutoff, so let's do this calculation
        // dynamically so the test won't begin to fail in the future
        LocalDate now = LocalDate.now();
        LocalDate oneWeekAgo = now.minusWeeks(1);

        long daysBetween = ChronoUnit.DAYS.between(oneWeekAgo, now);

        modifyTestsDayLimit(daysBetween);

        Date date = mock(Date.class);
        when(date.value()).thenReturn(oneWeekAgo.toString());

        AnnotatedElement element = mock(AnnotatedElement.class);
        when(element.getAnnotation(Date.class)).thenReturn(date);

        Optional<AnnotatedElement> opElement = Optional.ofNullable(element);

        ExtensionContext context = mock(ExtensionContext.class);
        when(context.getElement()).thenReturn(opElement);

        ConditionEvaluationResult result = ex.evaluateExecutionCondition(context);
        assertFalse(result.isDisabled());
        assertEquals("Date is within the day limit", result.getReason().get());
    }

    public void modifyTestsDayLimit(long newValue) {
        String systemPropertyDayLimit = System.getProperty("testsDayLimit");
        if (systemPropertyDayLimit == null) {
            actualTestsDayLimit = defaultTestsDayLimit;
        }
        System.setProperty("testsDayLimit", String.valueOf(newValue));
    }

}
