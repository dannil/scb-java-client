/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.communication;

import java.net.URL;
import java.util.Locale;
import java.util.Objects;

import com.github.dannil.scbjavaclient.constants.APIConstants;

/**
 * <p>Class which encapsulates the API URL, and enables relevant operations on this
 * URL.</p>
 *
 * @since 1.2.0
 */
public class URLEndpoint {

    private static final char TRAILING_SLASH = '/';

    private String url;

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param url
     *            the URL
     */
    public URLEndpoint(URL url) {
        this(url.toString());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param url
     *            the URL
     */
    public URLEndpoint(String url) {
        this.url = url;

        char[] chars = this.url.toCharArray();
        if (chars[chars.length - 1] != TRAILING_SLASH) {
            this.url = this.url + TRAILING_SLASH;
        }
    }

    /**
     * <p>Appends the given string to the URL.</p>
     *
     * @param str
     *            the string to append
     * @return a {@link URLEndpoint} with the given string appended
     */
    public URLEndpoint append(String str) {
        return new URLEndpoint(this.url + str);
    }

    /**
     * <p>Returns the table portion of this URL.</p>
     *
     * <p>Example: URL of
     * <b>https://api.scb.se/OV0104/v1/doris/sv/ssd/BE/BE0401/BE0401A/</b> is converted to
     * <b>BE/BE0401/BE0401A/</b>.</p>
     *
     * <p>Due to speed efficiency, this method does not perform any validity check on the
     * specified URL. Calling this method without a valid URL for the API may (and
     * probably will) result in undefined behavior.</p>
     *
     * @return the table portion of this URL
     */
    public String getTable() {
        String startSegment = "ssd";

        return this.url.substring(this.url.indexOf(startSegment) + startSegment.length() + 1);
    }

    /**
     * <p>Generates a new URL to the API using the specified <code>Locale</code>.</p>
     *
     * <p>See {@link #toURL(String)} for implementation details.</p>
     *
     * @param locale
     *            the <code>Locale</code> to use
     * @return an {@link URLEndpoint} representing the URL
     */
    public URLEndpoint toURL(Locale locale) {
        return toURL(locale.getLanguage());
    }

    /**
     * <p>Generates a new URL to the API by replacing the current language tag in the URL
     * with the specified language tag. The communication protocol used, such as HTTP or
     * HTTPS, is not modified.</p>
     *
     * @param language
     *            the language to use
     * @return an {@link URLEndpoint} representing the modified URL
     *
     * @see #toURL(String, CommunicationProtocol)
     */
    public URLEndpoint toURL(String language) {
        return toURL(language, null);
    }

    /**
     * <p>Generates a new URL to the API by replacing the current language tag and
     * communication protocol in the URL with the specified language tag and
     * {@link CommunicationProtocol}.</p>
     *
     * <p>The method performs two distinct operations, if needed: replacement of the
     * communication protocol and replacement of the language tag. The following steps are
     * performed to figure out what needs to be replaced:</p>
     *
     * <ol> <li>Replaces the <b>communication protocol</b> (such as "http") with the
     * specified protocol.</li>
     *
     * <li>Specifies the <b>start segment</b> as the segment preceding the <b>language tag
     * segment</b> in the URL.</li>
     *
     * <li>Finds the length of the <b>language tag segment</b> by finding the next forward
     * slash following the <b>start segment</b>, as this indicates that the segment has
     * ended.</li>
     *
     * <li>Replaces the content between the start and end of the segment (forward slashes
     * excluded) with the new language tag.</li> </ol>
     *
     * <p>Example: URL of <b>https://api.scb.se/OV0104/v1/doris/sv/ssd/</b> and language
     * input of <b>en</b> is converted to
     * <b>https://api.scb.se/OV0104/v1/doris/en/ssd/</b>.</p>
     *
     * <p>Due to speed efficiency, this method does not perform any validity check on the
     * specified URL. Calling this method without a valid URL for the API may (and
     * probably will) result in undefined behavior.</p>
     *
     * @param language
     *            the language to use
     * @param communicationProtocol
     *            the communication protocol to use
     * @return an {@link URLEndpoint} representing the modified URL
     */
    public URLEndpoint toURL(String language, CommunicationProtocol communicationProtocol) {
        StringBuilder builder = new StringBuilder(this.url);

        // Replace the communication protocol with the specified parameter. If the
        // parameter is null we don't change the protocol
        if (communicationProtocol != null) {
            String protocol = communicationProtocol.getProtocol();
            builder.replace(0, builder.toString().indexOf("://"), protocol);
        }

        // Specify the starting point. For this implementation, the starting
        // point is the segment preceding the language tag segment in the URL
        String startSegment = "doris";

        // Find the index where the language tag starts
        int start = builder.toString().indexOf(startSegment) + startSegment.length() + 1;
        // Find the index where the language tag ends
        int end = builder.toString().indexOf('/', start);

        // Replace the contents between the start and end index with our new
        // language tag
        builder.replace(start, end, language);

        return new URLEndpoint(builder.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.url);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof URLEndpoint)) {
            return false;
        }
        URLEndpoint other = (URLEndpoint) obj;
        return Objects.equals(this.url, other.url);
    }

    @Override
    public String toString() {
        return this.url;
    }

    /**
     * <p>Returns the root URL for the API.</p>
     *
     * @return an {@link URLEndpoint} representing the
     *         {@link com.github.dannil.scbjavaclient.constants.APIConstants#ROOT_URL
     *         ROOT_URL}
     */
    public static URLEndpoint getRootUrl() {
        return new URLEndpoint(APIConstants.ROOT_URL);
    }

    /**
     * <p>Returns the root URL for the API for a specific <code>Locale</code>.</p>
     *
     * @param locale
     *            the <code>Locale</code>
     * @return an {@link URLEndpoint} representing the
     *         {@link com.github.dannil.scbjavaclient.constants.APIConstants#ROOT_URL
     *         ROOT_URL} with a converted language tag segment matching the specified
     *         <code>Locale</code>
     */
    public static URLEndpoint getRootUrl(Locale locale) {
        return new URLEndpoint(APIConstants.ROOT_URL).toURL(locale);
    }

    /**
     * <p>Returns the root URL for the API for a specific <code>Locale</code> and
     * {@link CommunicationProtocol}.</p>
     *
     * @param locale
     *            the <code>Locale</code>
     * @param communicationProtocol
     *            the {@link CommunicationProtocol}
     * @return an {@link URLEndpoint} representing the
     *         {@link com.github.dannil.scbjavaclient.constants.APIConstants#ROOT_URL
     *         ROOT_URL} with a converted language tag segment matching the specified
     *         <code>Locale</code> and {@link CommunicationProtocol}
     */
    public static URLEndpoint getRootUrl(Locale locale, CommunicationProtocol communicationProtocol) {
        return new URLEndpoint(APIConstants.ROOT_URL).toURL(locale.getLanguage(), communicationProtocol);
    }

}
