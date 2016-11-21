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
 * <p>Abstract class which specifies how methods by container clients (a client that has
 * sub-clients) should operate.</p>
 * 
 * @author Daniel Nilsson
 */
public abstract class AbstractContainerClient extends AbstractClient {

	protected Collection<AbstractClient> clients;

	/**
	 * <p>Default constructor.</p>
	 */
	protected AbstractContainerClient() {
		super();

		this.clients = new ArrayList<AbstractClient>();
	}

	/**
	 * <p>Set the locale for all sub-clients.</p>
	 */
	@Override
	public void setLocale(Locale locale) {
		super.setLocale(locale);

		for (AbstractClient client : this.clients) {
			client.setLocale(super.locale);
		}
	}

}
