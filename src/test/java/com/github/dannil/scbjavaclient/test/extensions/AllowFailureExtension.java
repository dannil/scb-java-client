package com.github.dannil.scbjavaclient.test.extensions;

import java.lang.reflect.AnnotatedElement;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class AllowFailureExtension implements TestExecutionExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(AllowFailureExtension.class);

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        Optional<AnnotatedElement> opElement = context.getElement();
        AllowFailure a = opElement.get().getDeclaredAnnotation(AllowFailure.class);
        NoticeStrategy s = a.strategy();
        
        try {
            // Swallow exception to change test result
        } catch (Throwable t) {
            // Swallow exception to change test result
        } finally {
            if (Objects.equals(NoticeStrategy.TEMPORARY, s)) {
                String className = context.getRequiredTestClass().getSimpleName();
                String testName = context.getRequiredTestMethod().getName();
                LOGGER.warn("Test {}.{} failed but is marked with @AllowFailure", className, testName);
            }
        }
    }

}
