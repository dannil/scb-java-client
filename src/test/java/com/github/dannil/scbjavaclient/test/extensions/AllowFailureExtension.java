package com.github.dannil.scbjavaclient.test.extensions;

import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
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
        Optional<AnnotatedElement> opElement = context.getElement();
        AllowFailure allowFailure = opElement.get().getDeclaredAnnotation(AllowFailure.class);
        NoticeStrategy strategy = allowFailure.notice();

        Store store = context.getStore(NAMESPACE);
        store.put("strategy", strategy);
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        throwable.printStackTrace();
        
        try {
            // Swallow exception to change test result
        } catch (Throwable t) {
            // Swallow exception to change test result
        }
        Store store = context.getStore(NAMESPACE);
        store.put("failed", true);
        
        Class<?> clazz = context.getRequiredTestClass();
        String testName = context.getRequiredTestMethod().getName();
        
        String testClassAndTestName = clazz.getName() + "." + testName;
        System.out.println(testClassAndTestName);
        
        StackTraceElement[] elements = throwable.getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            StackTraceElement element = elements[i];
            String elementClassAndTestName = element.getClassName() + "." + element.getMethodName();
            System.out.println(elementClassAndTestName);
            
            if (Objects.equals(testClassAndTestName, elementClassAndTestName)) {
                store.put("linenumber", element.getLineNumber());
                break;
            }
        }
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        Store store = context.getStore(NAMESPACE);
        Optional<Object> opFailed = Optional.ofNullable(store.get("failed"));

        boolean failed = (boolean) opFailed.orElse(false);
        NoticeStrategy strategy = (NoticeStrategy) store.get("strategy");
        String className = context.getRequiredTestClass().getSimpleName();
        String testName = context.getRequiredTestMethod().getName();
        int lineNumber = (int) store.get("linenumber");

        CombinationHashMap<Boolean, NoticeStrategy> mappings = new CombinationHashMap<>();
        mappings.put(true, NoticeStrategy.ON_FAILURE);
        mappings.put(false, NoticeStrategy.ON_SUCCESS);
        if (strategy == NoticeStrategy.ALWAYS || mappings.containsCombination(failed, strategy)) {
            logResult(failed, strategy, className, testName, lineNumber);
        }
    }

    private void logResult(boolean failed, NoticeStrategy strategy, String className, String testName, int lineNumber) {
        String failedAsString = (failed ? "FAILED" : "PASSED");
        String strategyAsString = strategy.name();
        String result = "";

        if (failed) {
            result = ", changing result to PASSED";
        }

        Logger logger = LoggerFactory.getLogger(className);
        logger.warn("Test {} {} and is annotated with @AllowFailure(NoticeStrategy.{}){}, {}", testName, failedAsString,
                strategyAsString, result, lineNumber);
    }

    private class CombinationHashMap<K, V> extends HashMap<K, V> {

        private static final long serialVersionUID = -7319716043109363600L;

        public boolean containsCombination(K key, V value) {
            V fetchedValue = get(key);
            return (fetchedValue != null && Objects.equals(fetchedValue, value));
        }

    }

}
