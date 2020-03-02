// Class originally retrieved from https://github.com/gpakosz/UnicodeBOMInputStream
// with modifications to ensure project formatting, Javadoc validness and SonarCloud rules
// test

// (‑●‑●)> released under the WTFPL v2 license, by Gregory Pakosz (@gpakosz)

package com.github.dannil.scbjavaclient.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/**
 * The <code>UnicodeBOMInputStream</code> class wraps any
 * <code>InputStream</code> and detects the presence of any Unicode BOM
 * (Byte Order Mark) at its beginning, as defined by
 * <a href="http://www.faqs.org/rfcs/rfc3629.html">RFC 3629 - UTF-8, a
 * transformation format of ISO 10646</a>.
 *
 * <p>The
 * <a href="http://www.unicode.org/unicode/faq/utf_bom.html">Unicode FAQ</a>
 * defines 5 types of BOMs:</p><ul>
 * <li>
 *
 * <pre>
 * 00 00 FE FF  = UTF-32, big-endian
 * </pre>
 *
 * </li>
 * <li>
 *
 * <pre>
 * FF FE 00 00  = UTF-32, little-endian
 * </pre>
 *
 * </li>
 * <li>
 *
 * <pre>
 * FE FF        = UTF-16, big-endian
 * </pre>
 *
 * </li>
 * <li>
 *
 * <pre>
 * FF FE        = UTF-16, little-endian
 * </pre>
 *
 * </li>
 * <li>
 *
 * <pre>
 * EF BB BF     = UTF-8
 * </pre>
 *
 * </li>
 * </ul>
 *
 * <p>Use the {@link #getBOM()} method to know whether a BOM has been detected
 * or not.
 * </p>
 * <p>Use the {@link #skipBOM()} method to remove the detected BOM from the
 * wrapped <code>InputStream</code> object.</p>
 *
 * @author Gregory Pakosz
 * @version 1.0
 */
public class UnicodeBOMInputStream extends InputStream {

    private final PushbackInputStream in;

    private BOM bom;

    private boolean skipped;

    /**
     * Constructs a new <code>UnicodeBOMInputStream</code> that wraps the
     * specified <code>InputStream</code>.
     *
     * @param inputStream
     *            an <code>InputStream</code>.
     * @throws IOException
     *             on reading from the specified <code>InputStream</code>
     *             when trying to detect the Unicode BOM.
     */
    public UnicodeBOMInputStream(final InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new NullPointerException("invalid input stream: null is not allowed");
        }

        int size = 4;
        in = new PushbackInputStream(inputStream, size);

        final byte[] bomRawBytes = new byte[4];
        final int read = in.read(bomRawBytes);

        this.bom = getUtf32Bom(bomRawBytes);
        if (this.bom == null) {
            this.bom = getUtf8Bom(bomRawBytes);
        }
        if (this.bom == null) {
            this.bom = getUtf16Bom(bomRawBytes);
        }
        if (this.bom == null) {
            this.bom = BOM.NONE;
        }
        if (read > 0) {
            in.unread(bomRawBytes, 0, read);
        }
    }

    /**
     * Retrieves the UTF-32 <code>BOM</code> from the specified <code>byte</code> array.
     * 
     * @param bomRawBytes
     *            the bytes to read
     * @return an <code>BOM</code> (if any) present in the specified array
     */
    public final BOM getUtf32Bom(byte[] bomRawBytes) {
        if ((bomRawBytes[0] == (byte) 0xFF) && (bomRawBytes[1] == (byte) 0xFE) && (bomRawBytes[2] == (byte) 0x00)
                && (bomRawBytes[3] == (byte) 0x00)) {
            return BOM.UTF_32_LE;
        } else if ((bomRawBytes[0] == (byte) 0x00) && (bomRawBytes[1] == (byte) 0x00) && (bomRawBytes[2] == (byte) 0xFE)
                && (bomRawBytes[3] == (byte) 0xFF)) {
            return BOM.UTF_32_BE;
        }
        return null;
    }

    /**
     * Retrieves the UTF-8 <code>BOM</code> from the specified <code>byte</code> array.
     * 
     * @param bomRawBytes
     *            the bytes to read
     * @return an <code>BOM</code> (if any) present in the specified array
     */
    public final BOM getUtf8Bom(byte[] bomRawBytes) {
        if ((bomRawBytes[0] == (byte) 0xEF) && (bomRawBytes[1] == (byte) 0xBB) && (bomRawBytes[2] == (byte) 0xBF)) {
            return BOM.UTF_8;
        }
        return null;
    }

    /**
     * Retrieves the UTF-16 <code>BOM</code> from the specified <code>byte</code> array.
     * 
     * @param bomRawBytes
     *            the bytes to read
     * @return an <code>BOM</code> (if any) present in the specified array
     */
    public final BOM getUtf16Bom(byte[] bomRawBytes) {
        if ((bomRawBytes[0] == (byte) 0xFF) && (bomRawBytes[1] == (byte) 0xFE)) {
            return BOM.UTF_16_LE;
        } else if ((bomRawBytes[0] == (byte) 0xFE) && (bomRawBytes[1] == (byte) 0xFF)) {
            return BOM.UTF_16_BE;
        }
        return null;
    }

    /**
     * Returns the <code>BOM</code> that was detected in the wrapped
     * <code>InputStream</code> object.
     *
     * @return a <code>BOM</code> value.
     */
    public final BOM getBOM() {
        // BOM type is immutable.
        return bom;
    }

    /**
     * Skips the <code>BOM</code> that was found in the wrapped
     * <code>InputStream</code> object.
     *
     * @return this <code>UnicodeBOMInputStream</code>.
     *
     * @throws IOException
     *             when trying to skip the BOM from the wrapped
     *             <code>InputStream</code> object.
     */
    public final synchronized UnicodeBOMInputStream skipBOM() throws IOException {
        if (!skipped) {
            // Daniel 2019-06-15: added check to see that bytes actually were skipped
            long skippedBytes = in.skip(bom.bytes.length);
            if (skippedBytes > 0) {
                skipped = true;
            }
        }
        return this;
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }

    @Override
    public int read(final byte[] b) throws IOException {
        return in.read(b, 0, b.length);
    }

    @Override
    public int read(final byte[] b, final int off, final int len) throws IOException {
        return in.read(b, off, len);
    }

    @Override
    public long skip(final long n) throws IOException {
        return in.skip(n);
    }

    @Override
    public int available() throws IOException {
        return in.available();
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    @Override
    public synchronized void mark(final int readlimit) {
        in.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        in.reset();
    }

    @Override
    public boolean markSupported() {
        return in.markSupported();
    }

    /**
     * Type safe enumeration class that describes the different types of Unicode
     * BOMs.
     */
    public static final class BOM {

        /**
         * NONE.
         */
        public static final BOM NONE = new BOM(new byte[] {}, "NONE");

        /**
         * UTF-8 BOM (EF BB BF).
         */
        public static final BOM UTF_8 = new BOM(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF }, "UTF-8");

        /**
         * UTF-16, little-endian (FF FE).
         */
        public static final BOM UTF_16_LE = new BOM(new byte[] { (byte) 0xFF, (byte) 0xFE }, "UTF-16 little-endian");

        /**
         * UTF-16, big-endian (FE FF).
         */
        public static final BOM UTF_16_BE = new BOM(new byte[] { (byte) 0xFE, (byte) 0xFF }, "UTF-16 big-endian");

        /**
         * UTF-32, little-endian (FF FE 00 00).
         */
        public static final BOM UTF_32_LE = new BOM(new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0x00, (byte) 0x00 },
                "UTF-32 little-endian");

        /**
         * UTF-32, big-endian (00 00 FE FF).
         */
        public static final BOM UTF_32_BE = new BOM(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0xFE, (byte) 0xFF },
                "UTF-32 big-endian");

        private final byte[] bytes;

        private final String description;

        private BOM(final byte[] bom, final String description) {
            assert bom != null : "invalid BOM: null is not allowed";
            assert description != null : "invalid description: null is not allowed";
            assert description.length() != 0 : "invalid description: empty string is not allowed";

            this.bytes = bom;
            this.description = description;
        }

        /**
         * Returns a <code>String</code> representation of this <code>BOM</code>
         * value.
         *
         * @return a <code>String</code> representation of this <code>BOM</code> value.
         */
        public String toString() {
            return description;
        }

        /**
         * Returns the bytes corresponding to this <code>BOM</code> value.
         *
         * @return the bytes for this <code>BOM</code> value.
         */
        public byte[] getBytes() {
            final int length = bytes.length;
            final byte[] result = new byte[length];

            // make a defensive copy
            System.arraycopy(bytes, 0, result, 0, length);

            return result;
        }

    } // BOM

} // UnicodeBOMInputStream
