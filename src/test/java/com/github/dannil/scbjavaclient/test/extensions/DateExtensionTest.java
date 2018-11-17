package com.github.dannil.scbjavaclient.test.extensions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.AnnotatedElement;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExtensionContext;

public class DateExtensionTest {

    private DateExtension ex;

    @BeforeEach
    public void setup() {
        ex = new DateExtension();
    }

    @Test
    public void evaluateExecutionConditionNoAnnotatedElementPresent() {
        ExtensionContext context = mock(ExtensionContext.class);

        Optional<AnnotatedElement> opElement = Optional.empty();

        when(context.getElement()).thenReturn(opElement);

        ConditionEvaluationResult result = ex.evaluateExecutionCondition(context);
        assertTrue(result.isDisabled());
        assertEquals("No annotation present", result.getReason().get());
    }

    @Test
    public void evaluateExecutionConditionNoDateAnnotationPresent() {
        ExtensionContext context = mock(ExtensionContext.class);

        Optional<AnnotatedElement> opElement = Optional.ofNullable(Deprecated.class);

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
        Date date = mock(Date.class);
        when(date.value()).thenReturn("2099-12-31");

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
        Date date = mock(Date.class);
        when(date.value()).thenReturn("now");

        AnnotatedElement element = mock(AnnotatedElement.class);
        when(element.getAnnotation(Date.class)).thenReturn(date);

        Optional<AnnotatedElement> opElement = Optional.ofNullable(element);

        ExtensionContext context = mock(ExtensionContext.class);
        when(context.getElement()).thenReturn(opElement);

        // Backup testsDayLimit before modification
        String dayLimitBackup = System.getProperty("testsDayLimit");

        System.setProperty("testsDayLimit", "-1");

        ConditionEvaluationResult result = ex.evaluateExecutionCondition(context);
        assertTrue(result.isDisabled());
        assertEquals("Day limit is less than 0", result.getReason().get());
        
        if (dayLimitBackup == null) {
            System.setProperty("testsDayLimit", "");
        }
    }
    
    @Test
    public void evaluateExecutionConditionDateIsInThePresent() {
        Date date = mock(Date.class);
        when(date.value()).thenReturn("1970-01-01");

        AnnotatedElement element = mock(AnnotatedElement.class);
        when(element.getAnnotation(Date.class)).thenReturn(date);

        Optional<AnnotatedElement> opElement = Optional.ofNullable(element);

        ExtensionContext context = mock(ExtensionContext.class);
        when(context.getElement()).thenReturn(opElement);

        // Backup testsDayLimit before modification
        String dayLimitBackup = System.getProperty("testsDayLimit");

        System.setProperty("testsDayLimit", "7");

        ConditionEvaluationResult result = ex.evaluateExecutionCondition(context);
        assertTrue(result.isDisabled());
        assertEquals("Date is not within the day limit", result.getReason().get());
        
        if (dayLimitBackup == null) {
            System.setProperty("testsDayLimit", "");
        }
    }

}
