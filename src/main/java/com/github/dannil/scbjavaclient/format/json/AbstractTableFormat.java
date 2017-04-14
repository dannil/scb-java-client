package com.github.dannil.scbjavaclient.format.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class AbstractTableFormat implements IJsonTableFormat {

    @Override
    public abstract Map<String, Collection<String>> getKeysAndValues();

    @Override
    public List<String> getKeys() {
        return new ArrayList<>(getKeysAndValues().keySet());
    }

    @Override
    public List<String> getValues(String key) {
        Map<String, Collection<String>> fetchedInputs = getKeysAndValues();
        if (fetchedInputs.containsKey(key)) {
            return new ArrayList<>(fetchedInputs.get(key));
        }
        return Collections.emptyList();
    }

}
