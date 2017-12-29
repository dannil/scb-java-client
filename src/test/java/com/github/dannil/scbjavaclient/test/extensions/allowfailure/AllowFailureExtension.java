package com.github.dannil.scbjavaclient.test.extensions.allowfailure;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Stack;

import com.github.dannil.scbjavaclient.test.extensions.NoticeStrategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.slf4j.MDC;

public class AllowFailureExtension implements BeforeEachCallback, TestExecutionExceptionHandler, AfterEachCallback {

    private static final Namespace NAMESPACE = Namespace.create("com", "github", "dannil", "scbjavaclient", "test",
            "extensions", "allowfailure");

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Optional<AnnotatedElement> opElement = context.getElement();
        AllowFailure allowFailure = opElement.get().getDeclaredAnnotation(AllowFailure.class);
        NoticeStrategy strategy = allowFailure.notice();

        Class<?> clazz = context.getRequiredTestClass();
        Method method = context.getRequiredTestMethod();

        // Map<String, Collection<String>> implementations =
        // getMethodsImplementations(clazz);
        // for (Entry<String, Collection<String>> entry : implementations.entrySet()) {
        // System.out.println(entry.getKey());
        // for (String s : entry.getValue()) {
        // System.out.println(s);
        // }
        // }

        Store store = context.getStore(NAMESPACE);
        if (store.get("implementations") == null) {
            Map<String, Collection<String>> implementations = getMethodsImplementations(clazz);
            store.put("implementations", implementations);
            // for (Entry<String, Collection<String>> entry : implementations.entrySet())
            // {
            // System.out.println(entry.getKey());
            // for (String s : entry.getValue()) {
            // System.out.println(s);
            // }
            // }
        }
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
        
        System.out.println("LINE FROM STORE: " + opFailed.toString());
        
        Optional<Object> opLineNumber = Optional.ofNullable(store.get("linenumber"));

        boolean failed = (boolean) opFailed.orElse(false);
        NoticeStrategy strategy = (NoticeStrategy) store.get("strategy");
        Class<?> clazz = (Class<?>) store.get("class");
        Method method = (Method) store.get("method");
        
        System.out.println(method.getName());

        Map<String, Collection<String>> implementations = (Map<String, Collection<String>>) store.get(
                "implementations");

        // System.out.println(implementations);

        Collection<String> imp = implementations.get(method.getName());
        System.out.println(imp);

        int lastAssertIndex = getLineNumberForLastAssert(imp);
        int lineNumber = (int) opLineNumber.orElse(lastAssertIndex);

        System.out.println("INDEX: " + lastAssertIndex);
        System.out.println("L: " + lineNumber);

        // if (lineNumber < 0) {
        // lineNumber = lastAssertIndex;
        // }
        
        System.out.println("MDC1: " + MDC.get("line"));

        CombinationHashMap<Boolean, NoticeStrategy> mappings = new CombinationHashMap<>();
        mappings.put(true, NoticeStrategy.ON_FAILURE);
        mappings.put(false, NoticeStrategy.ON_SUCCESS);
        if (strategy == NoticeStrategy.ALWAYS || mappings.containsCombination(failed, strategy)) {
            logResult(failed, strategy, clazz, method, lineNumber);
        }
    }

    private void logResult(boolean failed, NoticeStrategy strategy, Class<?> clazz, Method method, int lineNumber)
            throws IOException {
        String failedAsString = (failed ? "FAILED" : "PASSED");
        String strategyAsString = strategy.name();
        String result = "";

        if (failed) {
            result = ", changing result to PASSED";
        }

        Marker m = null;
        // if (lineNumber > 0) {
        String lineCtx = String.valueOf(lineNumber);
        MDC.put("line", lineCtx);

        System.out.println("LINECTX: " + lineCtx);

        System.out.println("MDCLINE: " + MDC.get("line"));

        // }
        m = MarkerManager.getMarker("ALLOW_FAILURE_EXTENSION");
        Logger logger = LogManager.getLogger(clazz);
        logger.warn(m, "Test {} {} and is annotated with @AllowFailure(NoticeStrategy.{}){}", method.getName(),
                failedAsString, strategyAsString, result);
        MDC.clear();
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

    private Map<String, Collection<String>> getMethodsImplementations(Class<?> clazz) throws IOException {
        Map<String, Collection<String>> implementations = new HashMap<>();

        String execPath = System.getProperty("user.dir");
        String path = execPath + "/src/test/java/" + clazz.getPackage().getName().replaceAll("\\.", "/");
        File sourceFile = new File(path, clazz.getSimpleName() + ".java");
        List<String> lines = java.nio.file.Files.readAllLines(sourceFile.toPath(), StandardCharsets.UTF_8);

        List<String> implementation = new ArrayList<>();

        Stack<Character> s = new Stack<Character>();
        boolean foundBeginning = false;
        int row = 0;
        for (String line : lines) {
            row++;
            String trimmedLine = line.trim();

            if (trimmedLine.contains("@Test")) {
                // Next line is (probably) the beginning of the test
                foundBeginning = true;
                continue;
            }

            if (foundBeginning && !trimmedLine.contains("@Test") && !trimmedLine.contains("@AllowFailure")) {
                implementation.add(row + ":" + trimmedLine);
                for (Character c : trimmedLine.toCharArray()) {
                    if (Objects.equals(c, '{')) {
                        s.push(c);
                    } else if (Objects.equals(c, '}')) {
                        s.pop();
                    }
                }
                if ("}".equals(trimmedLine) && s.size() == 0) {
                    String firstLine = implementation.get(0);

                    int parenthesis = firstLine.indexOf("(");
                    String methodName = firstLine.substring(0, parenthesis);
                    methodName = methodName.substring(methodName.lastIndexOf(" ") + 1);
                    implementation.set(0, firstLine);
                    implementations.put(methodName, implementation);

                    s = new Stack<Character>();
                    foundBeginning = false;
                    implementation = new ArrayList<>();
                }
            }
        }
        return implementations;
    }

    private int getLineNumberForLastAssert(Collection<String> implementation) {
        Iterator<String> it = implementation.iterator();
        int line = -1;
        int lastAssert = -1;
        while (it.hasNext()) {
            String s = it.next();
            String row = s.substring(0, s.indexOf(":"));
            int lineNumber = Integer.parseInt(row);
            line = lineNumber;

            String rowContent = s.substring(s.indexOf(":") + 1);
            if (rowContent.startsWith("assert")) {
                lastAssert = line;
            }
        }
        return Math.min(line, lastAssert);
    }

    private class CombinationHashMap<K, V> extends HashMap<K, V> {

        private static final long serialVersionUID = -7319716043109363600L;

        public boolean containsCombination(K key, V value) {
            return (containsKey(key) && Objects.equals(get(key), value));
        }

    }

}
