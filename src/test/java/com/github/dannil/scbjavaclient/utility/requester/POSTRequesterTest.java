/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.utility.requester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class POSTRequesterTest {

	@Test
	public void getCharset() {
		POSTRequester post = (POSTRequester) RequesterFactory.getRequester(RequestMethod.POST);

		assertEquals(StandardCharsets.UTF_8, post.getCharset());
	}

	@Test
	public void getPayload() {
		POSTRequester post = (POSTRequester) RequesterFactory.getRequester(RequestMethod.POST);
		post.setQuery("payload");

		assertEquals("payload", post.getQuery());
	}

	@Test(expected = IllegalStateException.class)
	public void doRequestIllegalStateNullPayload() throws IOException {
		POSTRequester post = (POSTRequester) RequesterFactory.getRequester(RequestMethod.POST);

		String response = post.getBodyAsString("http://api.scb.se/OV0104/v1/doris/en/ssd/BE/BE0701/MedelAlderNY");

		assertNull(response);
	}

}
