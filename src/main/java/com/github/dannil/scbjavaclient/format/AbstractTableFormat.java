/*
 * Copyright 2017 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.format;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>Abstract class for API table format. All implementing classes should specify an
 * instance variable which contains the data which should be operated on by the
 * methods.</p>
 *
 * @since 0.3.0
 */
public abstract class AbstractTableFormat {

    /**
     * <p>Extracts the keys and their respective values from the data.</p>
     *
     * @return a <code>Map</code> of all keys and their respective values
     */
    public abstract Map<String, Collection<String>> getKeysAndValues();

    /**
     * <p>Extracts the values for a key from the data.</p>
     *
     * @return a <code>List</code> of values
     */
    public List<String> getKeys() {
        return new ArrayList<>(getKeysAndValues().keySet());
    }

    /**
     * <p>Extracts the codes from the data.</p>
     *
     * @param key
     *            the key
     * @return a <code>List</code> of keys
     */
    public List<String> getValues(String key) {
        Map<String, Collection<String>> fetchedInputs = getKeysAndValues();
        if (fetchedInputs.containsKey(key)) {
            return new ArrayList<>(fetchedInputs.get(key));
        }
        return Collections.emptyList();
    }

}
