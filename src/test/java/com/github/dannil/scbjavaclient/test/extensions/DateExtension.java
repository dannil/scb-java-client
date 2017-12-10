package com.github.dannil.scbjavaclient.test.extensions;

import java.lang.reflect.AnnotatedElement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class DateExtension implements ExecutionCondition {

    // private static final Logger LOGGER = LogManager.getLogger(DateExtension.class);

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        int dayLimit = 0;

        // Set the number of cutoff days
        Optional<String> opDayLimitParameter = Optional.ofNullable(System.getProperty("testsDayLimit"));
        String dayLimitParameter = opDayLimitParameter.orElse("0");
        if (!dayLimitParameter.isEmpty()) {
            dayLimit = Integer.valueOf(dayLimitParameter);
        }

        // If day limit is less than 0, no tests should be run
        if (dayLimit < 0) {
            return ConditionEvaluationResult.disabled("Day limit is less than 0");
        }

        // Retrieve the annotated date
        Optional<AnnotatedElement> opElement = context.getElement();
        if (!opElement.isPresent()) {
            return ConditionEvaluationResult.disabled("No annotated element present");
        }
        AnnotatedElement element = opElement.get();
        Optional<Date> opDate = Optional.ofNullable(element.getAnnotation(Date.class));
        if (!opDate.isPresent()) {
            return ConditionEvaluationResult.disabled("No Date annotation present");
        }
        String value = opDate.get().value();

        // Create a new date which to represent the current date with the day limit
        // subtracted
        LocalDateTime cutoff = LocalDateTime.now().minusDays(dayLimit);

        // Convert the annotation date to a LocalDateTime
        LocalDateTime date = getDate(value);

        // If the date is equal to the cutoff date OR the date is after the cutoff
        // date (a point in time which occurred after the cutoff date), the test
        // should be run; otherwise not
        if (date.equals(cutoff) || date.isAfter(cutoff)) {
            return ConditionEvaluationResult.enabled("Date is within the day limit");
        }
        return ConditionEvaluationResult.disabled("Date is not within the day limit");
    }

    private LocalDateTime getDate(String value) {
        switch (value) {
            case "now":
                return LocalDateTime.now();
            default:
                return LocalDateTime.of(LocalDate.parse(value), LocalTime.MIDNIGHT);
        }
    }

}
