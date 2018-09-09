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

package com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountsmunicipality;

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
 * <p>Client which handles public finances annual accounts statement accounts municipality
 * data fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient extends AbstractClient {

    private static final String ACTIVITY_CODE = "Verksomrkom";

    /**
     * <p>Default constructor.</p>
     */
    public PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all costs and incomes data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCostsAndIncomes(Collection, Collection, Collection)
     */
    public List<ResponseModel> getCostsAndIncomes() {
        return getCostsAndIncomes(null, null, null);
    }

    /**
     * <p>Fetch all costs and incomes data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getCostsAndIncomes(Collection<String> regions, Collection<Integer> activities,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(ACTIVITY_CODE, activities);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("KostnDR", mappings);
    }

    /**
     * <p>Fetch all purchase of main activities data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getPurchaseOfMainActivities(Collection, Collection, Collection)
     */
    public List<ResponseModel> getPurchaseOfMainActivities() {
        return getPurchaseOfMainActivities(null, null, null);
    }

    /**
     * <p>Fetch all purchase of main activities data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getPurchaseOfMainActivities(Collection<String> regions, Collection<Integer> activities,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(ACTIVITY_CODE, activities);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("KopDr", mappings);
    }

    /**
     * <p>Fetch all costs of individual and family care data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getCostsOfIndividualAndFamilyCare(Collection, Collection, Collection)
     */
    public List<ResponseModel> getCostsOfIndividualAndFamilyCare() {
        return getCostsOfIndividualAndFamilyCare(null, null, null);
    }

    /**
     * <p>Fetch all costs of individual and family care data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param cares
     *            the cares
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getCostsOfIndividualAndFamilyCare(Collection<String> regions, Collection<Integer> cares,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Omsorg", cares);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("IndFamTkrRN", mappings);
    }

    /**
     * <p>Fetch all grants data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getGrants(Collection, Collection, Collection)
     */
    public List<ResponseModel> getGrants() {
        return getGrants(null, null, null);
    }

    /**
     * <p>Fetch all grants data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getGrants(Collection<String> regions, Collection<Integer> activities,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(ACTIVITY_CODE, activities);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Lamnadebidrag", mappings);
    }

    /**
     * <p>Fetch all some incomes data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getSomeIncomes(Collection, Collection, Collection)
     */
    public List<ResponseModel> getSomeIncomes() {
        return getSomeIncomes(null, null, null);
    }

    /**
     * <p>Fetch all some incomes data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param activities
     *            the activities
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getSomeIncomes(Collection<String> regions, Collection<Integer> activities,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(ACTIVITY_CODE, activities);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("Vissaintakter", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/OE0107/OE0107B/");
    }

}
