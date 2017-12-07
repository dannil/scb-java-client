package com.github.dannil.scbjavaclient.test.extensions;

import java.lang.reflect.AnnotatedElement;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class AllowFailureExtension implements BeforeEachCallback, TestExecutionExceptionHandler, AfterEachCallback {

    private static final Namespace NAMESPACE = Namespace.create("com", "github", "dannil", "scbjavaclient");

    private static final Logger LOGGER = LogManager.getLogger(AllowFailureExtension.class);

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // System.out.println("in before each");

        System.out.println("------------");

        Optional<AnnotatedElement> opElement = context.getElement();
        AllowFailure allowFailure = opElement.get().getDeclaredAnnotation(AllowFailure.class);
        NoticeStrategy strategy = allowFailure.notice();

        Store store = context.getStore(NAMESPACE);
        store.put("strategy", strategy);
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        // System.out.println("in test execution exception extension");

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
        // System.out.println("in after each extension");

        // Optional<AnnotatedElement> opElement = context.getElement();
        // AllowFailure a = opElement.get().getDeclaredAnnotation(AllowFailure.class);
        // NoticeStrategy s = a.notice();

        Store store = context.getStore(NAMESPACE);
        Optional<Object> opFailed = Optional.ofNullable(store.get("failed"));
        // System.out.println("opFailed: " + opFailed.toString());

        boolean failed = (boolean) opFailed.orElse(false);
        NoticeStrategy strategy = (NoticeStrategy) store.get("strategy");
        String className = context.getRequiredTestClass().getSimpleName();
        String testName = context.getRequiredTestMethod().getName();

        if (Objects.equals(NoticeStrategy.NEVER, strategy)) {
            // System.out.println("------------");
            return;
        } else if (Objects.equals(strategy, NoticeStrategy.ALWAYS)
                || failed && Objects.equals(strategy, NoticeStrategy.ON_FAILURE)
                || !failed && Objects.equals(strategy, NoticeStrategy.ON_SUCCESS)) {
            logTest(failed, strategy, className, testName);
        }
        // System.out.println("------------");
    }

    public void logTest(boolean failed, NoticeStrategy strategy, String className, String testName) {
        String failedAsString = (failed ? "FAILED" : "PASSED");
        String strategyAsString = strategy.name();
        String result = "";

        if (failed) {
            result = "changing result of test to PASSED";
        } else {
            result = "consider removing the annotation or changing the notice strategy";
        }

        LOGGER.warn("Test {}.{} {} and is annotated with @AllowFailure(NoticeStrategy.{}), {}", className, testName,
                failedAsString, strategyAsString, result);
        // LOGGER.warn(result);

        // if (passed) {
        // switch (s) {
        // case ALWAYS:
        // LOGGER.warn("Test {}.{} PASSED and is annotated with
        // @AllowFailure(NoticeStrategy.ALWAYS)",
        // className, testName);
        // LOGGER.warn("Consider removing the annotation or changing the notice
        // strategy");
        // break;
        // case TEMPORARY:
        // LOGGER.warn("Test {}.{} PASSED and is annotated with
        // @AllowFailure(NoticeStrategy.TEMPORARY)",
        // className, testName);
        // LOGGER.warn("Consider removing the annotation or changing the notice
        // strategy");
        // break;
        // case NEVER:
        // break;
        // default:
        // break;
        // }
        // } else {
        // switch (s) {
        // case ALWAYS:
        // LOGGER.warn("Test {}.{} FAILED and is annotated with
        // @AllowFailure(NoticeStrategy.ALWAYS)",
        // className, testName);
        // LOGGER.warn("Changing result of test to PASSED");
        // break;
        // case TEMPORARY:
        // LOGGER.warn("Test {}.{} FAILED and is annotated with
        // @AllowFailure(NoticeStrategy.TEMPORARY)",
        // className, testName);
        // LOGGER.warn("Changing result of test to PASSED");
        // break;
        // case NEVER:
        // break;
        // default:
        // break;
        // }
        // }
    }

}
