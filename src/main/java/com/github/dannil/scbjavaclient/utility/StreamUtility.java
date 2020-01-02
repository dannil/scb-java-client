/*
 * Copyright 2019 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.utility;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.stream.Collectors;

/**
 * <p>Class which defines various utility methods which operates principally around
 * various instances of <code>Stream</code>.</p>
 *
 * @since 3.0.0
 */
public final class StreamUtility {

    /**
     * <p>Private constructor to prevent instantiation.</p>
     */
    private StreamUtility() {

    }

    /**
     * <p>Removes any Unicode byte order marks from the specified string.</p>
     *
     * @param str
     *            the string to remove byte order marks from
     * @return a <code>String</code> having the contents of the specified string, without
     *         any byte order marks
     *
     * @see #skipUnicodeByteOrderMark(InputStream)
     */
    public static String skipUnicodeByteOrderMark(String str) {
        return skipUnicodeByteOrderMark(new ByteArrayInputStream(str.getBytes()));
    }

    /**
     * <p>Removes any Unicode byte order marks from the specified stream.</p>
     *
     * @param stream
     *            the stream to remove byte order marks from
     * @return a <code>String</code> having the contents of the specified stream, without
     *         any byte order marks
     */
    public static String skipUnicodeByteOrderMark(InputStream stream) {
        try (UnicodeBOMInputStream ubis = new UnicodeBOMInputStream(stream)) {
            ubis.skipBOM();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(ubis))) {
                return reader.lines().parallel().collect(Collectors.joining());
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
