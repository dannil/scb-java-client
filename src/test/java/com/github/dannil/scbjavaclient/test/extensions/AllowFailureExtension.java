package com.github.dannil.scbjavaclient.test.extensions;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
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

        Class<?> clazz = context.getRequiredTestClass();
        Method method = context.getRequiredTestMethod();

        Store store = context.getStore(NAMESPACE);
        store.put("class", clazz);
        store.put("method", method);
        store.put("strategy", strategy);
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

        Class<?> clazz = (Class<?>) store.get("class");
        Method method = (Method) store.get("method");
        String fullyQualifiedName = clazz.getName() + "." + method.getName();

        StackTraceElement[] elements = throwable.getStackTrace();
        StackTraceElement element = getStackTraceElement(elements, fullyQualifiedName);
        store.put("linenumber", element.getLineNumber());
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        Store store = context.getStore(NAMESPACE);
        Optional<Object> opFailed = Optional.ofNullable(store.get("failed"));
        Optional<Object> opLineNumber = Optional.ofNullable(store.get("linenumber"));

        boolean failed = (boolean) opFailed.orElse(false);
        NoticeStrategy strategy = (NoticeStrategy) store.get("strategy");
        Class<?> clazz = (Class<?>) store.get("class");
        Method method = (Method) store.get("method");
        int lineNumber = (int) opLineNumber.orElse(-1);

        CombinationHashMap<Boolean, NoticeStrategy> mappings = new CombinationHashMap<>();
        mappings.put(true, NoticeStrategy.ON_FAILURE);
        mappings.put(false, NoticeStrategy.ON_SUCCESS);
        if (strategy == NoticeStrategy.ALWAYS || mappings.containsCombination(failed, strategy)) {
            logResult(failed, strategy, clazz, method, lineNumber);
        }
    }

    private void logResult(boolean failed, NoticeStrategy strategy, Class<?> clazz, Method method, int lineNumber) {
        String failedAsString = (failed ? "FAILED" : "PASSED");
        String strategyAsString = strategy.name();
        String result = "";

        if (failed) {
            result = ", changing result to PASSED";
        }
        if (lineNumber > 0) {
            System.out.println(lineNumber);
        }

        Logger logger = LoggerFactory.getLogger(clazz);
        logger.warn("Test {} {} and is annotated with @AllowFailure(NoticeStrategy.{}){}", method.getName(),
                failedAsString, strategyAsString, result);
    }

    private StackTraceElement getStackTraceElement(StackTraceElement[] elements, String name) {
        for (int i = 0; i < elements.length; i++) {
            StackTraceElement element = elements[i];
            String elementClassAndMethod = element.getClassName() + "." + element.getMethodName();
            if (Objects.equals(name, elementClassAndMethod)) {
                return element;
            }
        }
        throw new IllegalArgumentException();
    }

    private class CombinationHashMap<K, V> extends HashMap<K, V> {

        private static final long serialVersionUID = -7319716043109363600L;

        public boolean containsCombination(K key, V value) {
            V fetchedValue = get(key);
            return (fetchedValue != null && Objects.equals(fetchedValue, value));
        }

    }

}
