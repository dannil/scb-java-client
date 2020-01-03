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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.Test;

@Suite
public class StreamUtilityTest {

    @Test
    public void callPrivateConstructor()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = QueryBuilder.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        Object o = cons[0].newInstance();
        cons[0].setAccessible(false);

        assertNotNull(o);
    }

    @Test
    public void skipByteOrderMarkWithString() throws UnsupportedEncodingException {
        String byteOrderMarkText = "this is the tested byte order mark text";
        byte[] utf8bom = new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF };
        String textWithBOM = new String(utf8bom, "UTF-8") + byteOrderMarkText;
        String textWithoutBOM = byteOrderMarkText;

        assertEquals(textWithoutBOM, StreamUtility.skipUnicodeByteOrderMark(textWithBOM));
        assertEquals(textWithoutBOM, StreamUtility.skipUnicodeByteOrderMark(textWithoutBOM));
    }

    @Test
    public void skipByteOrderMarkWithInputStream() throws UnsupportedEncodingException {
        String byteOrderMarkText = "this is the tested byte order mark text";
        byte[] utf8bom = new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF };
        String textWithBOM = new String(utf8bom, "UTF-8") + byteOrderMarkText;
        String textWithoutBOM = byteOrderMarkText;

        ByteArrayInputStream baisNoBOM = new ByteArrayInputStream(textWithoutBOM.getBytes());
        assertEquals(textWithoutBOM, StreamUtility.skipUnicodeByteOrderMark(baisNoBOM));

        ByteArrayInputStream baisBOM = new ByteArrayInputStream(textWithBOM.getBytes());
        assertEquals(textWithoutBOM, StreamUtility.skipUnicodeByteOrderMark(baisBOM));
    }

}
