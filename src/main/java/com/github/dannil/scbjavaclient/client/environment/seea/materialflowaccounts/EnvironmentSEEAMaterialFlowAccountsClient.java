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

package com.github.dannil.scbjavaclient.client.environment.seea.materialflowaccounts;

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
 * material flow accounts data fetching.</p>
 *
 * @since 0.4.0
 */
public class EnvironmentSEEAMaterialFlowAccountsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentSEEAMaterialFlowAccountsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentSEEAMaterialFlowAccountsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all material flows data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getMaterialFlows(Collection, Collection)
     */
    public List<ResponseModel> getMaterialFlows() {
        return getMaterialFlows(null, null);
    }

    /**
     * <p>Fetch all material flows data which match the input constraints.</p>
     *
     * @param categories
     *            the categories
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getMaterialFlows(Collection<String> categories, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("MatKat", categories);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI1301MFTA01N", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI1301/MI1301C/");
    }

}
