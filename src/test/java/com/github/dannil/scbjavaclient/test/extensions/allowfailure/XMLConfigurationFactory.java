package com.github.dannil.scbjavaclient.test.extensions.allowfailure;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.plugins.Plugin;

// @Plugin(name = "XMLConfigurationFactory", category = "ConfigurationFactory")
// @Order(10)
public class XMLConfigurationFactory extends ConfigurationFactory {

    /**
     * Valid file extensions for XML files.
     */
    public static final String[] SUFFIXES = new String[] { ".xml", "*" };

    /**
     * Return the Configuration.
     * 
     * @param source
     *            The InputSource.
     * @return The Configuration.
     */
    public Configuration getConfiguration(LoggerContext loggerContext, ConfigurationSource configSource) {
        return new XMLConfiguration(loggerContext, configSource);
    }

    /**
     * Returns the file suffixes for XML files.
     * 
     * @return An array of File extensions.
     */
    public String[] getSupportedTypes() {
        return SUFFIXES;
    }

}
