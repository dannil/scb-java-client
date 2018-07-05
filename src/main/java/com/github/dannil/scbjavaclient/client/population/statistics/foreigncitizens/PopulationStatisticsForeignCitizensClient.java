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

package com.github.dannil.scbjavaclient.client.population.statistics.foreigncitizens;

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
 * <p>Client which handles population statistics foreign citizens data fetching.</p>
 *
 * @since 0.3.0
 */
public class PopulationStatisticsForeignCitizensClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PopulationStatisticsForeignCitizensClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PopulationStatisticsForeignCitizensClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all foreign citizens data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getForeignCitizens(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getForeignCitizens() {
        return getForeignCitizens(null, null, null, null);
    }

    /**
     * <p>Fetch all foreign citizens data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param ages
     *            the ages
     * @param sexes
     *            the sexes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getForeignCitizens(Collection<String> regions, Collection<String> ages,
            Collection<Integer> sexes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("UtlmedbTotNK", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("BE/BE0101/BE0101F/");
    }

}
