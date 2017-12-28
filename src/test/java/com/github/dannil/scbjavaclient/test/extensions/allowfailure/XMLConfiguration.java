package com.github.dannil.scbjavaclient.test.extensions.allowfailure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;
import org.apache.logging.log4j.core.config.xml.XmlConfiguration;
import org.apache.logging.log4j.core.layout.PatternLayout;

public class XMLConfiguration extends XmlConfiguration {

    public XMLConfiguration(LoggerContext loggerContext, ConfigurationSource configSource) {
        super(loggerContext, configSource);
    }

    @Override
    protected void doConfigure() {
        super.doConfigure();
        
        System.out.println("XMLConfiguration doConfigure()");

//        LayoutComponentBuilder layoutBuilder = builder.newLayout("PatternLayout").addAttribute("pattern",
//                "%d [%t] %-5level: %msg%n");

//        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
//        final Layout layout = PatternLayout.createLayout(PatternLayout.SIMPLE_CONVERSION_PATTERN, config, null, null,
//                null, null);
//        final Appender appender = FileAppender.createAppender("target/test.log", "false", "false", "File", "true",
//                "false", "false", "4000", layout, null, "false", null, config);
//        appender.start();
//        addAppender(appender);
//        LoggerConfig loggerConfig = LoggerConfig.createLogger("false", "info", "org.apache.logging.log4j", "true", refs,
//                null, config, null);
//        loggerConfig.addAppender(appender, null, null);
//        addLogger("org.apache.logging.log4j", loggerConfig);
    }
}
