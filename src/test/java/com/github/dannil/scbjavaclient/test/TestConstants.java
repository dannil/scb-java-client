package com.github.dannil.scbjavaclient.test;

import java.util.HashSet;
import java.util.Set;

public class TestConstants {

    /**
     * <p>An approximate time needed between each API call to not trigger a HTTP 403
     * error.</p>
     */
    public static final int API_SLEEP_MS = 400;

    /**
     * <p>A set which holds strings which are already pluralized but which is hard to
     * check in the test cases.</p>
     */
    public static final Set<String> ALREADY_PLURALIZED;

    static {
        ALREADY_PLURALIZED = new HashSet<String>();
        ALREADY_PLURALIZED.add("numberofchildren");
        ALREADY_PLURALIZED.add("foreignandswedishbackgrounds");
        ALREADY_PLURALIZED.add("siblingslivingathomes");
        ALREADY_PLURALIZED.add("fullandparttimes");
    }

}
