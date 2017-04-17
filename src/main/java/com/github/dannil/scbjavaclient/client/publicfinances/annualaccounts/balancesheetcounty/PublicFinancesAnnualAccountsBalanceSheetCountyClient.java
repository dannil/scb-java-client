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

package com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetcounty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles public finances annual accounts balance sheet county data
 * fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesAnnualAccountsBalanceSheetCountyClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PublicFinancesAnnualAccountsBalanceSheetCountyClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesAnnualAccountsBalanceSheetCountyClient(Locale locale) {
        super(locale);
    }

    public List<ResponseModel> getContingentLiabilities() {
        return getContingentLiabilities(null, null, null);
    }

    public List<ResponseModel> getContingentLiabilities(Collection<String> regions,
            Collection<String> contingentLiabilities, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Ansvarsforbindelser", contingentLiabilities);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("AnsvarsforbL", mappings);
    }

    public List<ResponseModel> getRevenue() {
        return getRevenue(null, null, null);
    }

    public List<ResponseModel> getRevenue(Collection<String> regions, Collection<String> items,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Kontopost", items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("VerksIntLT", mappings);
    }

    public List<ResponseModel> getCosts() {
        return getCosts(null, null, null);
    }

    public List<ResponseModel> getCosts(Collection<String> regions, Collection<String> items,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Kontopost", items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("VerksKostnLT", mappings);
    }

    public List<ResponseModel> getIncomeStatements() {
        return getIncomeStatements(null, null, null);
    }

    public List<ResponseModel> getIncomeStatements(Collection<String> regions, Collection<String> incomeStatements,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Resultatraknposter", incomeStatements);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ResultLTing", mappings);
    }

    public List<ResponseModel> getBalanceSheet() {
        return getBalanceSheet(null, null, null);
    }

    public List<ResponseModel> getBalanceSheet(Collection<String> regions, Collection<String> balanceSheets,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Balansraknposter", balanceSheets);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BalansKnLTing", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/OE0107/OE0107C/");
    }

}
