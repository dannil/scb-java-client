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

package com.github.dannil.scbjavaclient.client.environment.seea.energyaccounts;

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
 * <p>Client which handles environment System of Environmental-Economic Accounting (SEEA)
 * energy accounts data fetching.</p>
 *
 * @since 0.4.0
 */
public class EnvironmentSEEAEnergyAccountsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentSEEAEnergyAccountsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentSEEAEnergyAccountsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all combustion of fuels data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCombustionOfFuels(Collection, Collection, Collection)
     */
    public List<ResponseModel> getCombustionOfFuels() {
        return getCombustionOfFuels(null, null, null);
    }

    /**
     * <p>Fetch all combustion of fuels data which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param typesOfFuels
     *            the types of fuels
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getCombustionOfFuels(Collection<String> industrialClassifications,
            Collection<String> typesOfFuels, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put("Bransle", typesOfFuels);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MiljoEnergiSNIbrslag", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI1301/MI1301A/");
    }

}
