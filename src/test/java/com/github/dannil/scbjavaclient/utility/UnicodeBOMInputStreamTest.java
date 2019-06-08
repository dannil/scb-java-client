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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class UnicodeBOMInputStreamTest {

    private String data;

    private InputStream stream;
    private UnicodeBOMInputStream bomInputStream;
    private BufferedReader reader;

    @BeforeEach
    public void setup() throws NullPointerException, IOException {
        byte[] utf8bom = { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF };
        this.data = new String(utf8bom, "UTF-8") + new String("abc abc abc");

        this.stream = new ByteArrayInputStream(this.data.getBytes());
        this.bomInputStream = new UnicodeBOMInputStream(this.stream);
        this.reader = new BufferedReader(new InputStreamReader(this.bomInputStream));
    }
    
    @Test
    public void nullInputStream() {
        assertThrows(NullPointerException.class, () -> new UnicodeBOMInputStream(null));
    }

    @Test
    public void getUTF8BOM() throws IOException {
        assertEquals("UTF-8", this.bomInputStream.getBOM().toString());
    }

    @Test
    public void keepUTF8BOM() throws IOException {
        assertEquals(this.data, this.reader.lines().collect(Collectors.joining()));
    }

    @Test
    public void skipUTF8BOM() throws IOException {
        this.bomInputStream.skipBOM();
        
        String data = this.reader.lines().collect(Collectors.joining());

        assertNotEquals(this.data, data);
        assertEquals("abc abc abc", data);
    }
    
    @Test
    public void skipUTF8BOMTwice() throws IOException {
        this.bomInputStream.skipBOM();
        this.bomInputStream.skipBOM();
        
        String data = this.reader.lines().collect(Collectors.joining());

        assertNotEquals(this.data, data);
        assertEquals("abc abc abc", data);
    }

}
