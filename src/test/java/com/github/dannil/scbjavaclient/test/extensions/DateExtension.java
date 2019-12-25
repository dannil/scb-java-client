package com.github.dannil.scbjavaclient.test.extensions;

import java.lang.reflect.AnnotatedElement;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class DateExtension implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        // Get the argument representing the number of cutoff days
        Optional<String> opDayLimitParameter = Optional.ofNullable(System.getProperty("testsDayLimit"));
        int dayLimit = Integer.valueOf(opDayLimitParameter.filter(s -> !s.isEmpty()).orElse("0"));

        // If day limit is less than 0, no tests should be run
        if (dayLimit < 0) {
            return ConditionEvaluationResult.disabled("Day limit is less than 0");
        }
        // Get the annotated date
        Optional<AnnotatedElement> opElement = context.getElement();
        Optional<Date> opDate = opElement.map(e -> e.getAnnotation(Date.class));
        if (!opDate.isPresent()) {
            return ConditionEvaluationResult.disabled("No annotation present");
        }
        String value = opDate.get().value();

        // Convert the annotated date to a LocalDate
        LocalDate date = getDate(value);

        // Check if the converted annotated date is equal to or after the current date
        // with the day limit subtracted from the current date
        if (hasDateOccured(date, dayLimit)) {
            return ConditionEvaluationResult.enabled("Date is within the day limit");
        }
        return ConditionEvaluationResult.disabled("Date is not within the day limit");
    }

    private boolean hasDateOccured(LocalDate date, int days) {
        // Create a new date which to represent the current date with the day limit
        // subtracted
        LocalDate cutoff = LocalDate.now().minusDays(days);

        // If the date is equal to the cutoff date OR the date is after the cutoff
        // date (a point in time which occurred after the cutoff date), the test
        // should be run, otherwise not
        if (date.equals(cutoff) || date.isAfter(cutoff)) {
            return true;
        }
        return false;
    }

    private LocalDate getDate(String value) {
        switch (value) {
            case "now":
                return LocalDate.now();
            default:
                return LocalDate.parse(value);
        }
    }

}
