package com.github.dannil.scbjavaclient.test;

import java.util.HashMap;
import java.util.Map;

public class TestConstants {

    /**
     * <p>An approximate time needed between each API call to not trigger a HTTP 403
     * error.</p>
     */
    public static final int API_SLEEP_MS = 400;
    
    public static final Map<String, String> CODE_TRANSLATIONS;
    
    static {
        CODE_TRANSLATIONS = new HashMap<>();
        CODE_TRANSLATIONS.put("AmneMiljo", "substance");
    }
    
    

}
