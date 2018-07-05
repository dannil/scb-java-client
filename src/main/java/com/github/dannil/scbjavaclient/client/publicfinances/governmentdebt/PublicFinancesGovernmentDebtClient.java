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

package com.github.dannil.scbjavaclient.client.publicfinances.governmentdebt;

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
 * <p>Client which handles public finances government debt data fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesGovernmentDebtClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PublicFinancesGovernmentDebtClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesGovernmentDebtClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all government debt data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getGovernmentDebt(Collection, Collection)
     */
    public List<ResponseModel> getGovernmentDebt() {
        return getGovernmentDebt(null, null);
    }

    /**
     * <p>Fetch all government debt data which match the input constraints.</p>
     *
     * @param items
     *            the items
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getGovernmentDebt(Collection<String> items, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.ITEM_CODE, items);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("Statsskuld", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/OE0202/");
    }

}
