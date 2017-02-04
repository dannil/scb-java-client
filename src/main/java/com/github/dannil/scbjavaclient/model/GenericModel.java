/*
 * Copyright 2017 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;

public class GenericModel {

	private JsonCustomResponseFormat format;

	// TODO Add docs
	public GenericModel(String json) {
		this.format = new JsonCustomResponseFormat(json);
	}

	public Collection<Map<String, Object>> getEntries() {
		return this.format.getEntries();
	}

	public Collection<Map<String, Object>> getEntries(Map<String, Collection<String>> inputs) {
		Collection<Map<String, Object>> lst = new ArrayList<>();
		for (Map<String, Object> mp : this.format.getEntries()) {
			Set<String> mpKeys = mp.keySet();
			lst.add(mp);
			for (String key : inputs.keySet()) {
				if (!mpKeys.contains(key) || !inputs.get(key).contains(mp.get(key))) {
					lst.remove(mp);
					break;
				}
			}
		}
		return lst;
	}

	public Collection<Map<String, Object>> getEntries(String key, String value) {
		Map<String, Collection<String>> mp = new HashMap<>();

		Collection<String> lst = new ArrayList<>();
		lst.add(value);

		mp.put(key, lst);

		return getEntries(mp);
	}

	@Override
	public String toString() {
		return format.toString();
	}

}
