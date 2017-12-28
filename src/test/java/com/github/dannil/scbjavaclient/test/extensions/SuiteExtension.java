package com.github.dannil.scbjavaclient.test.extensions;

import com.github.dannil.scbjavaclient.test.extensions.allowfailure.CustomConfigurationFactory;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SuiteExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        //System.setProperty("log4j.configurationFactory", CustomConfigurationFactory.class.getName());
    }

}
