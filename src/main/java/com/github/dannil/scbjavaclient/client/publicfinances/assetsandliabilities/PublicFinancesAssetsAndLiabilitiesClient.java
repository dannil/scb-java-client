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

package com.github.dannil.scbjavaclient.client.publicfinances.assetsandliabilities;

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
 * <p>Client which handles public finances assets and liabilities data fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesAssetsAndLiabilitiesClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PublicFinancesAssetsAndLiabilitiesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesAssetsAndLiabilitiesClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all assets and liabilities data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAssetsAndLiabilities(Collection, Collection, Collection)
     */
    public List<ResponseModel> getAssetsAndLiabilities() {
        return getAssetsAndLiabilities(null, null, null);
    }

    /**
     * <p>Fetch all assets and liabilities data which match the input constraints.</p>
     *
     * @param items
     *            the items
     * @param sectors
     *            the sectors
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAssetsAndLiabilities(Collection<Integer> items, Collection<Integer> sectors,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("KTS", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/OE0106/");
    }

}
