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

package com.github.dannil.scbjavaclient.utility;

import java.util.Locale;

import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.http.EndpointURL;

/**
 * <p>Utility class which handles URL operations.</p>
 *
 * @since 0.0.2
 */
public final class URLUtility {

    /**
     * <p>Private constructor to prevent instantiation.</p>
     */
    private URLUtility() {

    }

    /**
     * <p>Returns the root URL for the API.</p>
     *
     * @return the {@link com.github.dannil.scbjavaclient.constants.APIConstants#ROOT_URL
     *         ROOT_URL}
     */
    public static String getRootUrl() {
        return new EndpointURL(APIConstants.ROOT_URL).toString();
    }

    /**
     * <p>Returns the root URL for the API for a specific <code>Locale</code>.</p>
     *
     * @param locale
     *            the <code>Locale</code>
     * @return the {@link com.github.dannil.scbjavaclient.constants.APIConstants#ROOT_URL
     *         ROOT_URL} with a converted language tag segment matching the specified
     *         <code>Locale</code>
     */
    public static String getRootUrl(Locale locale) {
        return new EndpointURL(APIConstants.ROOT_URL).toURL(locale).toString();
    }

}
