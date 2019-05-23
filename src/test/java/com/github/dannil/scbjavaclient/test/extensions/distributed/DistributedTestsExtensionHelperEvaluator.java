package com.github.dannil.scbjavaclient.test.extensions.distributed;

import java.util.Optional;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistributedTestsExtensionHelperEvaluator implements ExecutionCondition {

    private static final String DISTRIBUTED_ITS_MACHINE = "scb.distributedITs.machine";
    private static final String DISTRIBUTED_ITS_MACHINES = "scb.distributedITs.machines";

    private static final Namespace NAMESPACE = Namespace.create("com", "github", "dannil", "scbjavaclient", "test",
            "extensions", "distributed");

    private static final Logger LOGGER = LoggerFactory.getLogger(DistributedTestsExtensionHelperEvaluator.class);
    
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        //LOGGER.debug("evaluateExecutionCondition");

        Optional<String> opMachinesParameter = Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINES));
        Optional<String> opMachineParameter = Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINE));

        if (opMachinesParameter.isPresent() && opMachineParameter.isPresent()) {
            Store store = context.getRoot().getStore(NAMESPACE);
            
            int numberOfMachines = Integer.valueOf(opMachinesParameter.get());
            int thisMachineNumber = Integer.valueOf(opMachineParameter.get());

            Class<?> testClazz = context.getRequiredTestClass();
            String testClazzName = testClazz.getName();
            int testNumber = (int) store.get(testClazzName);

            // LOGGER.debug("Machine {} should run test ({}) {}", (testNumber %
            // numberOfMachines), testNumber,
            // testClazz.getName());

//            System.out.println(testClazz);
//            System.out.println("T: " + testNumber);

            boolean assignedToThisMachine = testNumber % (numberOfMachines + thisMachineNumber) == 0;
            System.out.println("ATTM: " + assignedToThisMachine);

            if (testNumber == thisMachineNumber || assignedToThisMachine) {
                LOGGER.debug("Running test!");
                return ConditionEvaluationResult.enabled("Running test!");
            } else {
                LOGGER.debug("NOT running test!");
                return ConditionEvaluationResult.disabled("NOT running test!");
            }
        }
        return ConditionEvaluationResult.enabled("Missing distributed IT parameters");
    }
    
}
