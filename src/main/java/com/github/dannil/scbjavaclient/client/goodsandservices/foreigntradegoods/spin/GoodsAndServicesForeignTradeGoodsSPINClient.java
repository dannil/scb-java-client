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

package com.github.dannil.scbjavaclient.client.goodsandservices.foreigntradegoods.spin;

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
 * <p>Client which handles goods and services foreign trade goods SPIN (Swedish Standard
 * Classification of Products by Activity) data fetching.</p>
 *
 * @since 0.7.0
 */
public class GoodsAndServicesForeignTradeGoodsSPINClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public GoodsAndServicesForeignTradeGoodsSPINClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public GoodsAndServicesForeignTradeGoodsSPINClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all imports and exports of goods data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getImportsAndExportsOfGoods(Collection, Collection)
     */
    public List<ResponseModel> getImportsAndExportsOfGoods() {
        return getImportsAndExportsOfGoods(null, null);
    }

    /**
     * <p>Fetch all imports and exports of goods data which match the input
     * constraints.</p>
     *
     * @param spin2007
     *            the SPIN 2007
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getImportsAndExportsOfGoods(Collection<String> spin2007, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("SPIN2007Original", spin2007);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ImpExpSPIN2007TotAr", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("HA/HA0201/HA0201E/");
    }

}
