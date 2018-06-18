package com.github.dannil.scbjavaclient.test.extensions;

import java.lang.reflect.AnnotatedElement;
import java.util.Objects;
import java.util.Optional;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllowFailureExtension implements BeforeEachCallback, TestExecutionExceptionHandler, AfterEachCallback {

    private static final Namespace NAMESPACE = Namespace.create("com", "github", "dannil", "scbjavaclient");

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Store store = context.getStore(NAMESPACE);

        Optional<AnnotatedElement> opElement = context.getElement();
        opElement.map(e -> e.getAnnotation(AllowFailure.class)).ifPresent(a -> store.put("strategy", a.notice()));
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        try {
            // Swallow exception to change test result
        } catch (Throwable t) {
            // Swallow exception to change test result
        }
        Store store = context.getStore(NAMESPACE);
        store.put("failed", true);
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        Store store = context.getStore(NAMESPACE);
        Optional<Object> opFailed = Optional.ofNullable(store.get("failed"));

        boolean failed = (boolean) opFailed.orElse(false);
        NoticeStrategy strategy = (NoticeStrategy) store.get("strategy");
        String className = context.getRequiredTestClass().getSimpleName();
        String testName = context.getRequiredTestMethod().getName();

        if (Objects.equals(NoticeStrategy.NEVER, strategy)) {
            return;
        } else if (Objects.equals(strategy, NoticeStrategy.ALWAYS)
                || failed && Objects.equals(strategy, NoticeStrategy.ON_FAILURE)
                || !failed && Objects.equals(strategy, NoticeStrategy.ON_SUCCESS)) {
            logTest(failed, strategy, className, testName);
        }
    }

    private void logTest(boolean failed, NoticeStrategy strategy, String className, String testName) {
        String failedAsString = (failed ? "FAILED" : "PASSED");
        String strategyAsString = strategy.name();
        String result = "";

        if (failed) {
            result = ", changing result to PASSED";
        }

        Logger logger = LoggerFactory.getLogger(className);
        logger.warn("Test {} {} and is annotated with @AllowFailure(NoticeStrategy.{}){}", testName, failedAsString,
                strategyAsString, result);
    }

}
