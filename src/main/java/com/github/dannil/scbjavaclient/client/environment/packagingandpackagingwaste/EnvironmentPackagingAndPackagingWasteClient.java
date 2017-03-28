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

package com.github.dannil.scbjavaclient.client.environment.packagingandpackagingwaste;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.environment.packagingandpackagingwaste.PackagingAndPackagingWaste;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles environment packaging and packaging waste data fetching.</p>
 *
 * @since 0.2.0
 */
public class EnvironmentPackagingAndPackagingWasteClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentPackagingAndPackagingWasteClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentPackagingAndPackagingWasteClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all packaging and packaging waste data.</p>
     *
     * @return the packaging and packaging waste data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.packagingandpackagingwaste.PackagingAndPackagingWaste
     *         PackagingAndPackagingWaste} objects
     *
     * @see #getPackagingAndPackagingWaste(Collection, Collection)
     */
    public List<PackagingAndPackagingWaste> getPackagingAndPackagingWaste() {
        return getPackagingAndPackagingWaste(null, null);
    }

    /**
     * <p>Fetch all packaging and packaging waste data which match the input
     * constraints.</p>
     *
     * @param types
     *            the types to fetch data for
     * @param years
     *            the years to fetch data for
     * @return the packaging and packaging waste data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.environment.packagingandpackagingwaste.PackagingAndPackagingWaste
     *         PackagingAndPackagingWaste} objects
     */
    public List<PackagingAndPackagingWaste> getPackagingAndPackagingWaste(Collection<Integer> types,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Forpackning", types);
        mappings.put(APIConstants.TIME_CODE, years);

        String response = doPostRequest(getUrl() + "MI0307T1", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(PackagingAndPackagingWaste.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "MI/MI0307/";
    }

}
