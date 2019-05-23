package com.github.dannil.scbjavaclient.test.extensions.distributed;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistributedTestsExtensionHelper implements TestInstancePostProcessor {

    // private static final String DISTRIBUTED_ITS = "scb.distributedITs";
    private static final String DISTRIBUTED_ITS_MACHINE = "scb.distributedITs.machine";
    private static final String DISTRIBUTED_ITS_MACHINES = "scb.distributedITs.machines";

    private static final Namespace NAMESPACE = Namespace.create("com", "github", "dannil", "scbjavaclient", "test",
            "extensions", "distributed");

    private static final Logger LOGGER = LoggerFactory.getLogger(DistributedTestsExtensionHelper.class);

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        Store store = context.getRoot().getStore(NAMESPACE);
        int testNumber = (int) store.getOrComputeIfAbsent("testNumber", x -> 1);

        Optional<String> opMachinesParameter = Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINES));
        Optional<String> opMachineParameter = Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINE));

        if (opMachinesParameter.isPresent() && opMachineParameter.isPresent()) {
            // LOGGER.info("hello");
            Class<?> testClazz = context.getRequiredTestClass();
            String testClazzName = testClazz.getName();

            // LOGGER.debug("TCN: " + testClazzName);

            Object obj = store.get(testClazzName);
            if (obj == null) {
                store.put(testClazzName, testNumber);
                LOGGER.debug(testClazzName + "=" + testNumber);
                testNumber++;
                store.put("testNumber", testNumber);
            }
        }
    }

}
