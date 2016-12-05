/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/**
 * <p>Class which specifies how methods by container clients (a client that has
 * sub-clients) should operate.</p>
 * 
 * @author Daniel Nilsson
 */
public class ContainerClient extends Client {

	protected Collection<Client> clients;

	/**
	 * <p>Default constructor.</p>
	 */
	protected ContainerClient() {
		super();

		this.clients = new ArrayList<Client>();
	}

	/**
	 * <p>Overloaded constructor.</p>
	 * 
	 * @param locale
	 *            the <code>Locale</code> for this client
	 */
	protected ContainerClient(Locale locale) {
		this();

		this.setLocale(locale);
	}

	/**
	 * <p>Set the <code>Locale</code> for all sub-clients.</p>
	 */
	@Override
	public final void setLocale(Locale locale) {
		super.setLocale(locale);

		for (Client client : this.clients) {
			client.setLocale(this.locale);
		}
	}

}
