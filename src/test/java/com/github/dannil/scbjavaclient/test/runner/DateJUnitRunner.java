package com.github.dannil.scbjavaclient.test.runner;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        // Modify the calendar to represent the date if the day limit would've been added
        Calendar cutoffCalendar = Calendar.getInstance();
        cutoffCalendar.add(Calendar.DAY_OF_YEAR, -this.dayLimit);
        java.util.Date cutoffDate = cutoffCalendar.getTime();

        List<FrameworkMethod> children = new ArrayList<>();
        for (FrameworkMethod fm : getTestClass().getAnnotatedMethods(Test.class)) {
            Method m = fm.getMethod();
            if (!m.isAnnotationPresent(Date.class)) {
                throw new IllegalStateException(
                        "Tests run with " + this.getClass().getSimpleName() + " must be annotated with a date.");
            }

            java.util.Date annotatedDate;
            try {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date d = m.getAnnotation(Date.class);
                String value = d.value();
                annotatedDate = (Objects.equals(value, "now") ? cutoffDate : format.parse(value));
            } catch (ParseException e) {
                throw new RuntimeException(e);
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

}
