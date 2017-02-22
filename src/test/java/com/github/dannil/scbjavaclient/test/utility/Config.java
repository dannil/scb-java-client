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

package com.github.dannil.scbjavaclient.test.utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.format.json.JsonConverter;
import com.github.dannil.scbjavaclient.http.RequestMethod;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.RequesterFactory;
import com.github.dannil.scbjavaclient.utility.URLUtility;

public final class Config {

    private static int timeWindow;
    private static int maxCalls;

    static {
        try {
            AbstractRequester get = RequesterFactory.getRequester(RequestMethod.GET);
            String response = get.getBody(URLUtility.getRootUrl() + "?config");

            JsonConverter converter = new JsonConverter();
            JsonNode node = converter.toNode(response);

            maxCalls = node.get("maxCalls").asInt();
            timeWindow = node.get("timeWindow").asInt();
        } catch (SCBClientException e) {
            throw e;
        }
    }

    public static long getTimeBetweenCallsAsMilliSeconds() {
        // Time window as returned by the SCB API is specified in milliseconds. The
        // returned value is the time window divided by the number of allowed calls in a
        // time window
        double timeBetweenCalls = (double) timeWindow / maxCalls;
        return (long) (timeBetweenCalls * 1000);
    }
}
