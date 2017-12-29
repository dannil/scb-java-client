package com.github.dannil.scbjavaclient.test.extensions.allowfailure;

import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

public class TestLogger {

    private final Map context = ThreadContext.getContext();
    
    @BeforeEach
    public void setup() {
        System.setProperty("log4j2.isThreadContextMapInheritable", "true");
        
        //Map<String, String> map = MDC.getCopyOfContextMap();
        
        System.out.println("SETUP");
        Random r = new Random();
        int line = r.nextInt(10);
        System.out.println("LINE: " + line);
        //MDC.put("line", String.valueOf(line));
        
        context.put("line", String.valueOf(line));
        
//        map.put("line", String.valueOf(line));
//        MDC.setContextMap(map);
    }
    
    @AfterEach
    public void teardown() {
        //ThreadContext.clearMap();
        MDC.clear();
    }
    
    @Test
    public void test1() throws Exception {
        MDC.setContextMap(context);
        
        Marker m = MarkerManager.getMarker("ALLOW_FAILURE_EXTENSION");
        Logger logger = LogManager.getLogger(this.getClass());
        logger.warn(m, "Test1");
    }
    
    @Test
    public void test2() {
        //MDC.put("line", "T2");
        
        Marker m = MarkerManager.getMarker("ALLOW_FAILURE_EXTENSION");
        Logger logger = LogManager.getLogger(this.getClass());
        logger.warn(m, "Test2");
        
        Marker m1 = MarkerManager.getMarker("ALLOW_FAILURE_EXTENSION");
        Logger logger1 = LogManager.getLogger(this.getClass());
        logger1.warn(m1, "Test2");
    }
    
    @Test
    public void test3() throws Exception {
        Marker m = MarkerManager.getMarker("ALLOW_FAILURE_EXTENSION");
        Logger logger = LogManager.getLogger(this.getClass());
        logger.warn(m, "Test3");
    }
    
    @Nested
    public class TestClass {
        
        @Test
        public void insideTestClass() {
            Marker m = MarkerManager.getMarker("ALLOW_FAILURE_EXTENSION");
            Logger logger = LogManager.getLogger(this.getClass());
            logger.warn(m, "TestInsideTestClass");
        }
        
    }
    
}
