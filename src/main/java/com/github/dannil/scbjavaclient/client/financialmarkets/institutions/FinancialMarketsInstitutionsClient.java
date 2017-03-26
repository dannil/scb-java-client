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

package com.github.dannil.scbjavaclient.client.financialmarkets.institutions;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.ResponseModel;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles financial markets institutions data fetching.</p>
 *
 * @since 0.2.0
 */
public class FinancialMarketsInstitutionsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsInstitutionsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsInstitutionsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all institution assets data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAssets(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getAssets() {
        return getAssets(null, null, null, null);
    }

    /**
     * <p>Fetch all institution assets data which match the input constraints.</p>
     *
     * @param institutions
     *            the institutions to fetch data for
     * @param items
     *            the items to fetch data for
     * @param currencies
     *            the currencies to fetch data for
     * @param months
     *            the months to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAssets(Collection<String> institutions, Collection<String> items,
            Collection<String> currencies, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.CONTENTSCODE_CODE, Arrays.asList("FM0401XX"));
        mappings.put("Institut", institutions);
        mappings.put("Kontopost", items);
        mappings.put("Valuta", currencies);
        mappings.put(APIConstants.TIME_CODE, months);

        String response = doPostRequest(getUrl() + "MFIM1", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(ResponseModel.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "FM/FM0401/";
    }

}
