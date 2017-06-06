package com.github.dannil.scbjavaclient.test.runner;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class DateJUnitRunner extends BlockJUnit4ClassRunner {

    private int dayLimit;

    public DateJUnitRunner(Class<?> clazz) throws InitializationError {
        super(clazz);

        // 30 days cutoff time
        this.dayLimit = 30;
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
                annotatedDate = format.parse(m.getAnnotation(Date.class).value());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            // Get the difference in days
            long differenceInMillis = cutoffDate.getTime() - annotatedDate.getTime();
            long days = TimeUnit.DAYS.convert(differenceInMillis, TimeUnit.MILLISECONDS);

            // If the difference of days between the two dates are within the limit, the
            // test should be run; otherwise not
            if (days <= this.dayLimit) {
                children.add(fm);
            }
        }
        return children;
    }

}
