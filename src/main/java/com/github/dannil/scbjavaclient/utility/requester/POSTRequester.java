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

import java.nio.charset.Charset;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

/**
 * HTTP requester for POST requests.
 * 
 * @author Daniel Nilsson
 */
public class POSTRequester extends AbstractRequester {

	private String query;

	/**
	 * Default constructor.
	 */
	public POSTRequester() {
		super();
		super.requestProperties.put("Request-Method", "GET");
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param charset
	 *            the charset
	 */
	public POSTRequester(Charset charset) {
		this();
		super.charset = charset;
	}

	/**
	 * Getter for query.
	 * 
	 * @return the query
	 */
	public String getQuery() {
		return this.query;
	}

	/**
	 * Setter for query.
	 * 
	 * @param query
	 *            the query
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public String getBody(String url) {
		if (this.query == null) {
			throw new IllegalStateException("Payload is null");
		}

		HttpPost request = new HttpPost(url);
		for (Entry<String, String> entry : super.requestProperties.entrySet()) {
			request.addHeader(entry.getKey(), entry.getValue());
		}

		HttpEntity entity = new ByteArrayEntity(this.query.getBytes(Charset.forName(this.charset.name())));
		request.setEntity(entity);

		// try {
		// HttpEntity entity = new ByteArrayEntity(this.query.getBytes(this.charset.name()));
		// request.setEntity(entity);
		// } catch (UnsupportedEncodingException e) {
		// throw new SCBClientParsingException(e);
		// }

		// HttpEntity entity;
		// try {
		// entity = new ByteArrayEntity(this.query.getBytes(this.charset.name()));
		// } catch (UnsupportedEncodingException e) {
		// System.out.println("unsupported");
		// entity = new ByteArrayEntity(this.query.getBytes(Charset.forName("UTF-8")));
		// // throw new SCBClientParsingException(e);
		// }
		// request.setEntity(entity);

		HttpResponse response = super.getResponse(request);

		return super.getBody(response);
	}
}
