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

package com.github.dannil.scbjavaclient.client.labourmarket.shorttermemployment.population;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles labour market short-term employment population data
 * fetching.</p>
 *
 * @since 0.3.0
 */
public class LabourMarketShortTermEmploymentPopulationClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public LabourMarketShortTermEmploymentPopulationClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LabourMarketShortTermEmploymentPopulationClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all number of employees data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getNumberOfEmployees(Collection, Collection, Collection)
     */
    public List<ResponseModel> getNumberOfEmployees() {
        return getNumberOfEmployees(null, null, null);
    }

    /**
     * <p>Fetch all number of employees data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param sectors
     *            the sectors
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getNumberOfEmployees(Collection<String> regions, Collection<String> sectors,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("KS15Anstallda", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("AM/AM0201/AM0201A/");
    }

}
