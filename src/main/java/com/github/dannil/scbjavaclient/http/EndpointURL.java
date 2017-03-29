package com.github.dannil.scbjavaclient.http;

import java.net.URL;
import java.util.Locale;
import java.util.Objects;

public class EndpointURL {

    private String url;

    public EndpointURL(URL url) {
        this(url.toString());
    }

    public EndpointURL(String url) {
        this.url = url;

        char[] chars = this.url.toCharArray();
        if (chars[chars.length - 1] != '/') {
            this.url = this.url + '/';
        }
    }

    public EndpointURL append(String str) {
        return new EndpointURL(this.url + str);
    }

    /**
     * <p>Generates a new URL to the API using the specified <code>Locale</code>.</p>
     *
     * <p>See {@link #toURL(String)} for implementation
     * details.</p>
     *
     * @param locale
     *            the <code>Locale</code> to use
     * @return the modified URL
     */
    public EndpointURL toURL(Locale locale) {
        return toURL(locale.getLanguage());
    }
    
    /**
     * <p>Generates a new URL to the API by replacing the current language tag in the URL
     * with the specified language tag.</p>
     *
     * <p>This method performs these steps to figure out what needs to be replaced:</p>
     *
     * <ol> <li>Specifies the <b>start segment</b> as the segment preceding the
     * <b>language tag segment</b> in the URL.</li>
     *
     * <li>Finds the length of the <b>language tag segment</b> by finding the next forward
     * slash following the <b>start segment</b>, as this indicates that the segment has
     * ended.</li>
     *
     * <li>Replaces the content between the start and end of the segment (forward slashes
     * excluded) with the new language tag.</li> </ol>
     *
     * <p>Example: URL of <b>https://api.scb.se/OV0104/v1/doris/sv/ssd/</b> and
     * language input of <b>en</b> is converted to
     * <b>https://api.scb.se/OV0104/v1/doris/en/ssd/</b>.</p>
     *
     * <p>Due to speed efficiency, this method does not perform any validity check on the
     * specified URL. Calling this method without a valid URL for the API may (and
     * probably will) result in undefined behavior.</p>
     *
     * @param url
     *            the URL to edit
     * @param language
     *            the language to use
     * @return the modified URL
     */
    public EndpointURL toURL(String language) {
        // Specify the starting point. For this implementation, the starting
        // point is the segment preceding the language tag segment in the URL
        String startSegment = "doris";

        // Find the index where the language tag starts
        int start = this.url.indexOf(startSegment) + startSegment.length() + 1;
        // Find the index where the language tag ends
        int end = start + this.url.substring(start).indexOf('/');

        // Replace the contents between the start and end index with our new
        // language tag
        StringBuilder builder = new StringBuilder(this.url);
        builder.replace(start, end, language);

        return new EndpointURL(builder.toString());
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
        if (!(obj instanceof EndpointURL)) {
            return false;
        }
        EndpointURL other = (EndpointURL) obj;
        return Objects.equals(this.url, other.url);
    }

    @Override
    public String toString() {
        return this.url;
    }

}
