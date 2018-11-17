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

package com.github.dannil.scbjavaclient.client.financialmarkets.statistics.keyfigures;

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
 * <p>Client which handles financial markets statistics key figures data fetching.</p>
 *
 * @since 0.5.0
 */
public class FinancialMarketsStatisticsKeyFiguresClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsStatisticsKeyFiguresClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsStatisticsKeyFiguresClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all key figures data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getKeyFigures(Collection, Collection)
     */
    public List<ResponseModel> getKeyFigures() {
        return getKeyFigures(null, null);
    }

    /**
     * <p>Fetch all key figures data which match the input constraints.</p>
     *
     * @param keyFigures
     *            the key figures
     * @param months
     *            the months
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getKeyFigures(Collection<String> keyFigures, Collection<String> months) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("NyckeltalSCB", keyFigures);
        mappings.put(APIConstants.TIME_CODE, months);

        return getResponseModels("NTFM5001", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM5001/FM5001X/");
    }

}
