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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.AllowFailure;
import com.github.dannil.scbjavaclient.test.extensions.Suite;
import com.github.dannil.scbjavaclient.utility.UnicodeBOMInputStream.BOM;

@Suite
public class UnicodeBOMInputStreamTest {

    private byte[] utf8bom;
    private byte[] utf16lebom;
    private byte[] utf16bebom;
    private byte[] utf32lebom;
    private byte[] utf32bebom;

    private String utf8data;
    private String utf16ledata;
    private String utf16bedata;
    private String utf32ledata;
    private String utf32bedata;

    private InputStream stream;
    private UnicodeBOMInputStream bomInputStream;
    private BufferedReader reader;

    @BeforeEach
    public void setup() throws IOException {
        this.utf8bom = new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF };
        this.utf8data = new String(this.utf8bom, "UTF-8") + new String("abc abc abc");

        this.utf16lebom = new byte[] { (byte) 0xFF, (byte) 0xFE };
        this.utf16ledata = new String(this.utf16lebom, "UTF-16LE") + new String("abc abc abc");

        this.utf16bebom = new byte[] { (byte) 0xFE, (byte) 0xFF };
        this.utf16bedata = new String(this.utf16bebom, "UTF-16") + new String("abc abc abc");

        this.utf32lebom = new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0x00, (byte) 0x00 };
        this.utf32ledata = new String(this.utf32lebom, "UTF-32LE") + new String("abc abc abc");

        this.utf32bebom = new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0xFE, (byte) 0xFF };
        this.utf32bedata = new String(this.utf32bebom, "UTF-32") + new String("abc abc abc");
    }

    private void createStreams(String data, String encoding) throws IOException {
        this.stream = new ByteArrayInputStream(data.getBytes(Charset.forName(encoding)));
        this.bomInputStream = new UnicodeBOMInputStream(this.stream);
        this.reader = new BufferedReader(new InputStreamReader(this.bomInputStream));
    }

    public String createRandomCode(int codeLength, String id) {
        List<Character> temp = id.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        Collections.shuffle(temp, new SecureRandom());
        return temp.stream().map(Object::toString).limit(codeLength).collect(Collectors.joining());
    }

    @Test
    public void nullInputStream() {
        assertThrows(NullPointerException.class, () -> new UnicodeBOMInputStream(null));
    }

    @Test
    public void getUTF8BOM() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        assertEquals("UTF-8", this.bomInputStream.getBOM().toString());
    }

    @Test
    public void getUTF8BOMBytes() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        assertTrue(Arrays.equals(this.utf8bom, this.bomInputStream.getBOM().getBytes()));
    }

    @Test
    public void keepUTF8BOM() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        assertEquals(this.utf8data, this.reader.lines().collect(Collectors.joining()));
    }

    @Test
    public void skipUTF8BOM() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        this.bomInputStream.skipBOM();

        String data = this.reader.lines().collect(Collectors.joining());

        assertNotEquals(this.utf8data, data);
        assertEquals("abc abc abc", data);
    }

    @Test
    public void skipUTF8BOMTwice() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        this.bomInputStream.skipBOM();
        this.bomInputStream.skipBOM();

        String data = this.reader.lines().collect(Collectors.joining());

        assertNotEquals(this.utf8data, data);
        assertEquals("abc abc abc", data);
    }

    @Test
    public void getUTF16LEBOM() throws IOException {
        createStreams(this.utf16ledata, "UTF-16LE");

        assertEquals("UTF-16 little-endian", this.bomInputStream.getBOM().toString());
    }

    @Test
    public void getUTF16BEBOM() throws IOException {
        createStreams(this.utf16bedata, "UTF-16");

        assertEquals("UTF-16 big-endian", this.bomInputStream.getBOM().toString());
    }

    // Daniel 2019-06-15: Try to fix test in the future
    @Test
    @AllowFailure
    public void getUTF32LEBOM() throws IOException {
        createStreams(this.utf32ledata, "UTF-32LE");

        assertEquals("UTF-32 little-endian", this.bomInputStream.getBOM().toString());
    }

    // Daniel 2019-06-15: Try to fix test in the future
    @Test
    @AllowFailure
    public void getUTF32BEBOM() throws IOException {
        createStreams(this.utf32bedata, "UTF-32");

        assertEquals("UTF-32 big-endian", this.bomInputStream.getBOM().toString());
    }

    @Test
    public void read() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        for (int i = 0; i < this.utf8bom.length; i++) {
            int read = (byte) this.bomInputStream.read();
            assertEquals(this.utf8bom[i], read);
        }
    }

    @Test
    public void readArray() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        byte[] bufferArray = new byte[3];
        this.bomInputStream.read(bufferArray);

        for (int i = 0; i < bufferArray.length; i++) {
            assertEquals(this.utf8bom[i], bufferArray[i]);
        }
    }

    @Test
    public void readArrayOffLen() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        byte[] bufferArray = new byte[2];
        int bytesRead = this.bomInputStream.read(bufferArray, 0, 2);
        assertEquals(2, bytesRead);

        for (int i = 0; i < bytesRead; i++) {
            assertEquals(this.utf8bom[i], bufferArray[i]);
        }
    }

    @Test
    public void skip() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        this.bomInputStream.skip(1);

        for (int i = 1; i < 3; i++) {
            assertEquals(this.utf8bom[i], (byte) this.bomInputStream.read());
        }
    }

    @Test
    public void available() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        int available = this.bomInputStream.available();

        assertEquals(this.utf8data.getBytes().length, available);
    }

    @Test
    public void close() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        this.bomInputStream.close();

        assertThrows(IOException.class, () -> this.bomInputStream.read());

        try {
            this.bomInputStream.read();
        } catch (IOException e) {
            assertTrue(e.getMessage().contains("Stream closed"));
        }
    }

    @Test
    public void mark() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        this.bomInputStream.mark(4);

        assertEquals(this.utf8data, this.reader.lines().collect(Collectors.joining()));
    }

    @Test
    public void reset() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        assertThrows(IOException.class, () -> this.bomInputStream.reset());
    }

    @Test
    public void markSupported() throws IOException {
        createStreams(this.utf8data, "UTF-8");

        boolean markSupported = this.bomInputStream.markSupported();

        assertFalse(markSupported);
    }

    @Test
    public void callPrivateBOMConstructorNullBOM()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = BOM.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        try {
            cons[0].newInstance(null, "");
        } catch (InvocationTargetException | AssertionError e) {

            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);

            String stackTrace = writer.toString();

            assertTrue(stackTrace.contains("java.lang.AssertionError"));
            assertTrue(stackTrace.contains("invalid BOM: null is not allowed"));
        }
        cons[0].setAccessible(false);
    }

    @Test
    public void callPrivateBOMConstructorNullDescription()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = BOM.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        try {
            cons[0].newInstance(new byte[] {}, null);
        } catch (InvocationTargetException | AssertionError e) {

            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);

            String stackTrace = writer.toString();

            assertTrue(stackTrace.contains("java.lang.AssertionError"));
            assertTrue(stackTrace.contains("invalid description: null is not allowed"));
        }
        cons[0].setAccessible(false);
    }

    @Test
    public void callPrivateBOMConstructorEmptyDescription()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = BOM.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        try {
            cons[0].newInstance(new byte[] {}, "");
        } catch (InvocationTargetException | AssertionError e) {

            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);

            String stackTrace = writer.toString();

            assertTrue(stackTrace.contains("java.lang.AssertionError"));
            assertTrue(stackTrace.contains("invalid description: empty string is not allowed"));
        }
        cons[0].setAccessible(false);
    }

}
