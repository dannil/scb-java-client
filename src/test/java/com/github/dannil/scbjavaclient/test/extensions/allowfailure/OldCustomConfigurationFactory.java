package com.github.dannil.scbjavaclient.test.extensions.allowfailure;

import java.net.URI;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.config.plugins.Plugin;

// @Plugin(name = "CustomConfigurationFactory", category = ConfigurationFactory.CATEGORY)
// @Order(50)
public class OldCustomConfigurationFactory extends ConfigurationFactory {

    public OldCustomConfigurationFactory() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Configuration getConfiguration(final LoggerContext loggerContext, final ConfigurationSource source) {
        return getConfiguration(loggerContext, source.toString(), null);
    }

    @Override
    public Configuration getConfiguration(final LoggerContext loggerContext, final String name,
            final URI configLocation) {
        ConfigurationBuilder<BuiltConfiguration> builder = newConfigurationBuilder();
        return createConfiguration(name, builder);
    }

    static Configuration createConfiguration(final String name, ConfigurationBuilder<BuiltConfiguration> builder) {
        //System.out.println(name);
        builder.setConfigurationName(name);
        builder.setStatusLevel(Level.WARN);
        builder.add(builder.newFilter("MarkerFilter", Filter.Result.ACCEPT, Filter.Result.DENY).addAttribute("marker",
                "ALLOW_FAILURE_EXTENSION"));

        AppenderComponentBuilder appenderBuilder = builder.newAppender("ALLOW_FAILURE", "CONSOLE").addAttribute(
                "target", ConsoleAppender.Target.SYSTEM_OUT);
        appenderBuilder.add(builder.newLayout("PatternLayout").addAttribute("pattern",
                "[%p] %d{yyyy-MM-dd HH:mm:ss zzz} %c{1}:HELLO - %m%n"));

        builder.add(appenderBuilder);
        builder.add(builder.newLogger("org.apache.logging.log4j", Level.DEBUG).add(
                builder.newAppenderRef("ALLOW_FAILURE")).addAttribute("additivity", false));
        // builder.add(builder.newRootLogger(Level.TRACE).add(builder.newAppenderRef("ALLOW_FAILURE")));
        return builder.build();
    }

    @Override
    protected String[] getSupportedTypes() {
        return new String[] { ".xml", "*" };
    }

}
