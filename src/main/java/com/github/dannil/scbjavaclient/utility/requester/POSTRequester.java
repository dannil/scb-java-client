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
import java.nio.charset.Charset;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

import com.github.dannil.scbjavaclient.exception.SCBClientParsingException;

public class POSTRequester extends AbstractRequester {

	private String query;

	public POSTRequester() {
		super();
		super.requestProperties.put("Request-Method", "GET");
	}

	public POSTRequester(Charset charset) {
		this();
		super.charset = charset;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public String getResponse(String url) {
		if (this.query == null) {
			throw new IllegalStateException("Payload is null");
		}

		HttpPost request = new HttpPost(url);
		for (Entry<String, String> entry : super.requestProperties.entrySet()) {
			request.addHeader(entry.getKey(), entry.getValue());
		}

		HttpEntity entity;
		try {
			entity = new ByteArrayEntity(this.query.getBytes(this.charset.name()));
			request.setEntity(entity);
		} catch (IOException e) {
			throw new SCBClientParsingException(e);
		}

		HttpResponse response = super.getResponse(request);

		return super.getBody(response);
	}
}
