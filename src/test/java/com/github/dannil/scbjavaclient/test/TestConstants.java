package com.github.dannil.scbjavaclient.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestConstants {

    /**
     * <p>An approximate time needed between each API call to not trigger a HTTP 403
     * error.</p>
     */
    public static final int API_SLEEP_MS = 400;

    // public static final Map<String, String> CODE_TRANSLATIONS;

    public static final Set<String> ALREADY_PLURALIZED;

    static {
        // CODE_TRANSLATIONS = new HashMap<>();
        // CODE_TRANSLATIONS.put("AmneMiljo", "substance");

        ALREADY_PLURALIZED = new HashSet<String>();
        ALREADY_PLURALIZED.add("assetsliabilities");
    }

}
