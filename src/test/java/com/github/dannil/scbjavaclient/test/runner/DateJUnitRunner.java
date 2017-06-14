package com.github.dannil.scbjavaclient.test.runner;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

        // Modify the calendar to represent the date if the day limit would've been added
        Calendar cutoffCalendar = Calendar.getInstance();
        cutoffCalendar.add(Calendar.DAY_OF_YEAR, -this.dayLimit);
        java.util.Date cutoffDate = cutoffCalendar.getTime();

        List<FrameworkMethod> children = new ArrayList<>();
        for (FrameworkMethod fm : getTestClass().getAnnotatedMethods(Test.class)) {
            Method m = fm.getMethod();
            if (!m.isAnnotationPresent(Date.class)) {
                throw new DateJUnitRunnerException("Tests run with DateJUnitRunner must be annotated with a date.");
            }

            Date d = m.getAnnotation(Date.class);
            String value = d.value();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date annotatedDate;
            try {
                annotatedDate = (Objects.equals(value, "now") ? cutoffDate : format.parse(value));
            } catch (ParseException e) {
                throw new DateJUnitRunnerException(e);
            }

            // If the cutoff date is equal to the annotated date OR the
            // cutoff date is before the annotated date (a point in time which
            // occurred before the annotated date), the test should be run; otherwise not
            if (Objects.equals(annotatedDate, cutoffDate) || cutoffDate.before(annotatedDate)) {
                children.add(fm);
            }
        }
        return children;
    }

    private class DateJUnitRunnerException extends RuntimeException {

        private static final long serialVersionUID = -273544118424218668L;

        public DateJUnitRunnerException(String message) {
            super(message);
        }

        public DateJUnitRunnerException(Throwable cause) {
            super(cause);
        }

    }

}
