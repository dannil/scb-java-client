package com.github.dannil.scbjavaclient.test.extensions;

import java.util.concurrent.TimeUnit;

import com.github.dannil.scbjavaclient.test.TestConstants;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class RemoteExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws InterruptedException {
        // Due to constraints set by the SCB API, we can only do 10 calls every 10
        // seconds, so we need an artificial timer which handles this.
        TimeUnit.MILLISECONDS.sleep(TestConstants.API_SLEEP_MS);
    }

}
