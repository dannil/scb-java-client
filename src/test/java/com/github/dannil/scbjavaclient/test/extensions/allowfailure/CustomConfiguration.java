package com.github.dannil.scbjavaclient.test.extensions.allowfailure;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter.Result;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.xml.XmlConfiguration;
import org.apache.logging.log4j.core.filter.MarkerFilter;
import org.apache.logging.log4j.core.layout.PatternLayout;

public class CustomConfiguration extends XmlConfiguration {

    public CustomConfiguration(LoggerContext context, ConfigurationSource configSource) {
        super(context, configSource);
    }

    @Override
    protected void doConfigure() {
        super.doConfigure();

        LoggerConfig rootLogger = getRootLogger();
        // final Map<String, Appender> appenderMap = rootLogger.getAppenders();

        MarkerFilter filter = MarkerFilter.createFilter("ALLOW_FAILURE_EXTENSION", Result.ACCEPT, Result.DENY);

        String pattern = "[%p] %d{yyyy-MM-dd HH:mm:ss zzz} %c{1}:HELLO - %m%n";
        Layout<String> layout = PatternLayout.newBuilder().withPattern(pattern).build();

        Appender appender = ConsoleAppender.newBuilder().withName("AllowFailure").withFilter(filter).withLayout(
                layout).build();
        appender.start();

        rootLogger.addAppender(appender, Level.WARN, null);
        System.out.println(rootLogger.getAppenders());
    }
}
