package com.github.dannil.scbjavaclient.test.extensions.allowfailure;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

import com.github.dannil.scbjavaclient.test.extensions.NoticeStrategy;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.appender.OutputStreamAppender;
import org.apache.logging.log4j.core.config.AbstractConfiguration;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

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

    private void logResult(boolean failed, NoticeStrategy strategy, Class<?> clazz, Method method, int lineNumber)
            throws IOException {
        String failedAsString = (failed ? "FAILED" : "PASSED");
        String strategyAsString = strategy.name();
        String result = "";

        if (failed) {
            result = ", changing result to PASSED";
        }
        if (lineNumber > 0) {
            System.out.println(lineNumber);
        }

        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
        
        // Read the Appenders
        System.out.println("Appenders declared in .xml :" + loggerConfig.getAppenderRefs());
        System.out.println("Appenders used in Logger :" + loggerConfig.getAppenders());
        
        ConfigurationFactory custom2 = new CustomConfigurationFactory();
        //
        // Configuration configuration = custom.getConfiguration(ctx,
        // oldConf.getConfigurationSource().resetInputStream());
        // Configuration configuration2 = custom2.getConfiguration(ctx,
        // oldConf.getConfigurationSource().resetInputStream());

        // ConfigurationBuilder<BuiltConfiguration> builder =
        // ConfigurationBuilderFactory.newConfigurationBuilder();
        // builder.setStatusLevel(Level.DEBUG);
        // builder.setConfigurationName("BuilderTest");
        // builder.add(builder.newFilter("ThresholdFilter", Filter.Result.ACCEPT,
        // Filter.Result.NEUTRAL).addAttribute(
        // "level", Level.DEBUG));
        //
        // AppenderComponentBuilder appenderBuilder = builder.newAppender("Stdout",
        // "CONSOLE").addAttribute("target",
        // ConsoleAppender.Target.SYSTEM_OUT);
        // appenderBuilder.add(builder.newLayout("PatternLayout").addAttribute("pattern",
        // "%d Thread:[%t] %-5level: MSG: %msg%n%throwable"));
        // appenderBuilder.add(builder.newFilter("MarkerFilter", Filter.Result.DENY,
        // Filter.Result.NEUTRAL).addAttribute(
        // "marker", "FLOW"));
        //
        // builder.add(appenderBuilder);
        // builder.add(builder.newLogger("org.apache.logging.log4j", Level.DEBUG).add(
        // builder.newAppenderRef("Stdout")).addAttribute("additivity", false));
        // builder.add(builder.newRootLogger(Level.DEBUG).add(builder.newAppenderRef("Stdout")));

        Configurator.initialize(custom2.getConfiguration(null, "", null));
        //
        // Configurator.initialize(configuration);
        // ctx = (LoggerContext) LogManager.getContext(false);
        //
        // ctx.updateLoggers(configuration);

        // Configuration newConf = custom.getConfiguration(ctx, null,
        // ctx.getConfigLocation());

        // System.out.println(ctx.getLoggers());

        // ConfigurationFactory.setConfigurationFactory(custom);
        // ctx.updateLoggers();

        // System.out.println("C: " + configuration2.getLoggers());

        // LoggerContext ctx = Configurator.intitialize(builder.build());

        Logger logger = LogManager.getLogger(clazz);

        Marker m = MarkerManager.getMarker("ALLOW_FAILURE_EXTENSION");
        logger.warn(m, "Test {} {} and is annotated with @AllowFailure(NoticeStrategy.{}){}", method.getName(),
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
            return (containsKey(key) && Objects.equals(get(key), value));
        }

    }

}
