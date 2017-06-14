package com.github.dannil.scbjavaclient.test.runner;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class DateJUnitRunner extends BlockJUnit4ClassRunner {

    private int dayLimit;

    public DateJUnitRunner(Class<?> clazz) throws InitializationError {
        super(clazz);

        // Set the cutoff time
        String s = System.getProperty("testsDayLimit");
        if (s != null && s.length() != 0) {
            this.dayLimit = Integer.parseInt(s);
        }
    }

    @Override
    protected List<FrameworkMethod> getChildren() {
        // If day limit is less than 0, no tests should be run
        if (this.dayLimit < 0) {
            return Collections.emptyList();
        }

        // Modify the date to represent the date with the day limit subtracted
        LocalDate cutoff = LocalDate.now().minusDays(this.dayLimit);

        List<FrameworkMethod> children = new ArrayList<>();
        for (FrameworkMethod fm : getTestClass().getAnnotatedMethods(Test.class)) {
            Method m = fm.getMethod();
            if (!m.isAnnotationPresent(Date.class)) {
                throw new DateJUnitRunnerException("Tests run with DateJUnitRunner must be annotated with a date.");
            }

            String value = m.getAnnotation(Date.class).value();
            LocalDate date = getLocalDate(value);

            // If the date is equal to the cutoff date OR the date is after the cutoff
            // date (a point in time which occurred after the cutoff date), the test
            // should be run; otherwise not
            if (date.equals(cutoff) || date.isAfter(cutoff)) {
                children.add(fm);
            }
        }
        return children;
    }

    private LocalDate getLocalDate(String value) {
        switch (value) {
            case "now":
                return LocalDate.now();
            default:
                return LocalDate.parse(value);
        }
    }

    private class DateJUnitRunnerException extends RuntimeException {

        private static final long serialVersionUID = -273544118424218668L;

        public DateJUnitRunnerException(String message) {
            super(message);
        }

    }

}
