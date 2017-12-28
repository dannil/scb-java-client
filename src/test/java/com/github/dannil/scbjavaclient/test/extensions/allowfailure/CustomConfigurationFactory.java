package com.github.dannil.scbjavaclient.test.extensions.allowfailure;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.plugins.Plugin;

@Plugin(name = "XMLConfigurationFactory", category = ConfigurationFactory.CATEGORY)
@Order(1)
public class CustomConfigurationFactory extends ConfigurationFactory {

    /**
     * Valid file extensions for XML files.
     */
    private static final String[] SUFFIXES = new String[] { ".xml", "*" };

    /**
     * Return the Configuration.
     *
     * @param source
     *            The InputSource.
     * @return The Configuration.
     */
    @Override
    public Configuration getConfiguration(LoggerContext context, ConfigurationSource source) {
        System.out.println("in XMLConfigurationFactory getConfiguration()");
        return new CustomConfiguration(context, source);
    }

    /**
     * Returns the file suffixes for XML files.
     * 
     * @return An array of File extensions.
     */
    @Override
    public String[] getSupportedTypes() {
        return SUFFIXES;
    }

}
