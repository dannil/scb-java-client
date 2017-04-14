/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.format.json;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>Interface for JSON table format. All implementing classes should specify an instance
 * variable which contains the JSON which should be operated on by the methods.</p>
 *
 * @since 0.1.0
 *
 * @deprecated use {@link com.github.dannil.scbjavaclient.format.AbstractTableFormat
 *             AbstractTableFormat} instead
 */
@Deprecated
public interface IJsonTableFormat {

    /**
     * <p>Extracts the keys and their respective values from the JSON.</p>
     *
     * @return a <code>Map</code> of all keys and their respective values
     *
     * @deprecated use {@link com.github.dannil.scbjavaclient.format.AbstractTableFormat
     *             AbstractTableFormat} instead
     */
    @Deprecated
    Map<String, Collection<String>> getKeysAndValues();

    /**
     * <p>Extracts the values for a key from the JSON.</p>
     *
     * @param key
     *            the key
     * @return a <code>List</code> of values
     *
     * @deprecated use {@link com.github.dannil.scbjavaclient.format.AbstractTableFormat
     *             AbstractTableFormat} instead
     */
    @Deprecated
    List<String> getValues(String key);

    /**
     * <p>Extracts the codes from the JSON.</p>
     *
     * @return a <code>List</code> of keys
     *
     * @deprecated use {@link com.github.dannil.scbjavaclient.format.AbstractTableFormat
     *             AbstractTableFormat} instead
     */
    @Deprecated
    List<String> getKeys();

}
