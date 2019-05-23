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

public class DistributedTestsExtension implements TestInstancePostProcessor {

    // private static final String DISTRIBUTED_ITS = "scb.distributedITs";
    private static final String DISTRIBUTED_ITS_MACHINE = "scb.distributedITs.machine";
    private static final String DISTRIBUTED_ITS_MACHINES = "scb.distributedITs.machines";

    private static final Namespace NAMESPACE = Namespace.create("com", "github", "dannil", "scbjavaclient", "test",
            "extensions", "distributed");

    private static final Logger LOGGER = LoggerFactory.getLogger(DistributedTestsExtension.class);

    private static int testNumber = 1;

    // @Override
    // public void beforeAll(ExtensionContext context) throws Exception {
    // LOGGER.info("beforeAll");
    //
    // Store store = context.getStore(NAMESPACE);
    //
    // Optional<String> opMachinesParameter =
    // Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINES));
    // Optional<String> opMachineParameter =
    // Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINE));
    // // System.out.println("OPM: " + opMachinesParameter.get());
    //
    // Map<String, Integer> testMappings = new HashMap<>();
    //
    // if (opMachinesParameter.isPresent() && opMachineParameter.isPresent()) {
    // LOGGER.info("hello");
    // Class<?> testClazz = context.getRequiredTestClass();
    //
    // testMappings.put(testClazz.getName(), testNumber);
    //
    // // store.put(testClazz.getName(), testNumber);
    // testNumber++;
    // }
    //
    // LOGGER.info(testMappings.toString());
    //
    // for (Entry<String, Integer> entry : testMappings.entrySet()) {
    // store.put(entry.getKey(), entry.getValue());
    // }
    //
    // // Store store = context.getStore(NAMESPACE);
    // // Optional<String> opMachinesParameter =
    // // Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINES));
    // // Optional<String> opMachineParameter =
    // // Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINE));
    // //
    // // if (opMachinesParameter.isPresent() && opMachineParameter.isPresent()) {
    // // int numberOfMachines = Integer.valueOf(opMachinesParameter.get());
    // // int thisMachineNumber = Integer.valueOf(opMachineParameter.get());
    // //
    // // Class<?> testClazz = context.getRequiredTestClass();
    // // int testNumber = (int) store.get(testClazz.getName());
    // //
    // //// LOGGER.debug("Machine {} should run test ({}) {}", (testNumber %
    // // numberOfMachines), testNumber,
    // //// testClazz.getName());
    // //
    // // System.out.println(testClazz);
    // // System.out.println("T: " + testNumber);
    // //
    // // boolean assignedToThisMachine = testNumber % (numberOfMachines +
    // // thisMachineNumber) == 0;
    // // System.out.println("ATTM: " + assignedToThisMachine);
    // //
    // // if (testNumber == thisMachineNumber || assignedToThisMachine) {
    // // LOGGER.debug("Running test!");
    // // } else {
    // // LOGGER.debug("NOT running test!");
    // // }
    // // System.out.println("");
    // //
    // // // store.put(DISTRIBUTED_ITS, true);
    // // // store.put(DISTRIBUTED_ITS_MACHINES, numberOfMachines);
    // // // store.put(DISTRIBUTED_ITS_MACHINE, thisMachineNumber);
    // // }
    // }
    //
    // @Override
    // public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext
    // context) {
    // LOGGER.debug("evaluateExecutionCondition");
    //
    // Store store = context.getStore(NAMESPACE);
    // Optional<String> opMachinesParameter =
    // Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINES));
    // Optional<String> opMachineParameter =
    // Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINE));
    //
    // if (opMachinesParameter.isPresent() && opMachineParameter.isPresent()) {
    // int numberOfMachines = Integer.valueOf(opMachinesParameter.get());
    // int thisMachineNumber = Integer.valueOf(opMachineParameter.get());
    //
    // Class<?> testClazz = context.getRequiredTestClass();
    // LOGGER.debug("TESTCLAZZ: " + testClazz.getName());
    //
    // int testNumber = (int) store.get(testClazz.getName());
    //
    // // LOGGER.debug("Machine {} should run test ({}) {}", (testNumber %
    // // numberOfMachines), testNumber,
    // // testClazz.getName());
    //
    // System.out.println(testClazz);
    // System.out.println("T: " + testNumber);
    //
    // boolean assignedToThisMachine = testNumber % (numberOfMachines + thisMachineNumber)
    // == 0;
    // System.out.println("ATTM: " + assignedToThisMachine);
    //
    // if (testNumber == thisMachineNumber || assignedToThisMachine) {
    // LOGGER.debug("Running test!");
    // return ConditionEvaluationResult.enabled("Running test!");
    // } else {
    // LOGGER.debug("NOT running test!");
    // return ConditionEvaluationResult.disabled("NOT running test!");
    // }
    // }
    // return ConditionEvaluationResult.enabled("Missing distributed IT parameters");
    // }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        LOGGER.info("TI: " + testInstance);

        Thread.sleep(100);

        LOGGER.info("beforeAll");

        Store store = context.getStore(NAMESPACE);

        Optional<String> opMachinesParameter = Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINES));
        Optional<String> opMachineParameter = Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINE));
        // System.out.println("OPM: " + opMachinesParameter.get());

        Map<String, Integer> testMappings = new HashMap<>();

        if (opMachinesParameter.isPresent() && opMachineParameter.isPresent()) {
            LOGGER.info("hello");
            Class<?> testClazz = context.getRequiredTestClass();

            testMappings.put(testClazz.getName(), testNumber);

            // store.put(testClazz.getName(), testNumber);
            testNumber++;
        }

        LOGGER.info(testMappings.toString());

        for (Entry<String, Integer> entry : testMappings.entrySet()) {
            store.put(entry.getKey(), entry.getValue());
        }
    }

    // @Override
    // public void beforeEach(ExtensionContext context) throws Exception {
    // LOGGER.debug("BeforeEach");
    //
    // Store store = context.getStore(NAMESPACE);
    // Optional<Object> opDistributedITsParameter =
    // Optional.ofNullable(store.get(DISTRIBUTED_ITS));
    // boolean runDistributedITs = (boolean) opDistributedITsParameter.orElse(false);
    //
    // }

}
