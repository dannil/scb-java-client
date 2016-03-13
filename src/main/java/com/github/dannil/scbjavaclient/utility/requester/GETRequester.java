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

import java.io.IOException;
import java.net.HttpURLConnection;

public class GETRequester extends AbstractRequester {

	@Override
	public String doRequest(String address) throws IOException {
		HttpURLConnection httpUrlConnection = super.prepareConnection(address);

		httpUrlConnection.setDoInput(true);
		httpUrlConnection.setRequestMethod("GET");

		String response = super.getResponse(httpUrlConnection);
		return response;
	}

}
