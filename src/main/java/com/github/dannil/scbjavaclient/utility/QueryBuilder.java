/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * <p>Class which is responsible for constructing the query which should be sent to the SCB API.</p>
 * 
 * @author Daniel Nilsson
 *
 */
public final class QueryBuilder {

	/**
	 * <p>Private constructor to prevent instantiation.</p>
	 */
	private QueryBuilder() {

	}

	/**
	 * <p>Filter out the specified value from the input collection.</p>
	 * 
	 * @param collection
	 *            the <code>Collection</code> to filter
	 * @param value
	 *            the value to remove from the <code>Collection</code>
	 * @return a <code>Collection</code> with the specified value removed
	 */
	private static List<?> filterValue(Collection<?> collection, Object value) {
		List<Object> filteredValues = new ArrayList<Object>();
		for (Object o : collection) {
			if (!Objects.equals(o, value)) {
				filteredValues.add(o);
			}
		}
		return filteredValues;
	}

	/**
	 * <p>Constructs a query which matches the format the SCB API expects. This method performs two
	 * distinct steps:</p>
	 * 
	 * <h1>1. Filter out the null keys</h1>
	 * 
	 * <p>If a key (such as region or year) is defined and all of this key's values are defined as
	 * null it means that all data for this key should be fetched (such as fetching the data for all
	 * available years). By not sending this key at all to the SCB API it recognizes that it should
	 * respond with all data corresponding to this key.</p>
	 * 
	 * <h1>2. Construct the query</h1>
	 * 
	 * <p>For every key in the input map, it creates an entry for this key. It then writes all of
	 * the values corresponding with this key (defined somewhere by using the put-method on the
	 * input map) into this entry. For example, if the input for the key Tid (Swedish for year)
	 * contains the years (values) 2011 and 2012, the resulting entry looks like this:</p>
	 * 
	 * <p>{ "code": "Tid", "selection": { "filter": "item", "values": [ "2011", "2012" ] } }</p>
	 * 
	 * <p>The method works on the principle of pasting all these blocks together in an orderly
	 * fashion to conform to the SCB API specification.</p>
	 * 
	 * @param inputMap
	 *            the input map which contains the keys and the values for every key
	 * @return a string which can be sent as the payload to the SCB API
	 */
	public static String build(Map<String, Collection<?>> inputMap) {
		// 1: Filter out null values
		Map<String, List<?>> filteredMap = new HashMap<String, List<?>>();

		for (Entry<String, Collection<?>> entry : inputMap.entrySet()) {
			if (entry.getValue() != null) {
				// if (new ArrayList<Object>(entry.getValue()).get(0) != null) {
				// filteredMap.put(entry.getKey(), filterValue(entry.getValue(),
				// null));
				// }
				filteredMap.put(entry.getKey(), filterValue(entry.getValue(), null));
			}
		}

		// Approximate a good initial capacity for the string builder
		int size = Math.max(44 + (80 * filteredMap.size()), 256);
		StringBuilder builder = new StringBuilder(size);

		// 2: Construct the query
		builder.append("{\"query\": [");
		int i = 0;
		for (Entry<String, List<?>> entry : filteredMap.entrySet()) {
			builder.append("{\"code\": \"" + entry.getKey() + "\", \"selection\": {\"filter\": \"item\", \"values\": [");
			List<?> values = entry.getValue();
			for (int j = 0; j < values.size(); j++) {
				builder.append("\"" + values.get(j) + "\"");
				if (j != values.size() - 1) {
					builder.append(',');
				}
			}
			builder.append("]}}");
			if (i != filteredMap.size() - 1) {
				builder.append(',');
			}
			i++;
		}
		builder.append("],\"response\": {\"format\": \"json\"}}");

		return builder.toString();
	}
}
