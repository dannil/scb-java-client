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

package com.github.dannil.scbjavaclient.client.publicfinances.publiclyownedenterprises;

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
 * <p>Client which handles public finances publicly owned enterprises data fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesPubliclyOwnedEnterprisesClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PublicFinancesPubliclyOwnedEnterprisesClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesPubliclyOwnedEnterprisesClient(Locale locale) {
        super(locale);
    }

    public List<ResponseModel> getDataForMunicipalityOwnedEnterprises() {
        return getDataForMunicipalityOwnedEnterprises(null, null);
    }

    public List<ResponseModel> getDataForMunicipalityOwnedEnterprises(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("KomFtgK", mappings);
    }

    public List<ResponseModel> getEnterprises() {
        return getEnterprises(null, null);
    }

    public List<ResponseModel> getEnterprises(Collection<String> regions, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("KomFtgK100", mappings);
    }

    public List<ResponseModel> getCountyCouncilsEnterprises() {
        return getCountyCouncilsEnterprises(null, null, null);
    }

    public List<ResponseModel> getCountyCouncilsEnterprises(Collection<String> regions, Collection<String> sectors,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("LtFtgL", mappings);
    }

    public List<ResponseModel> getPubliclyOwnedEnterprises() {
        return getPubliclyOwnedEnterprises(null, null, null, null);
    }

    public List<ResponseModel> getPubliclyOwnedEnterprises(Collection<String> sectors,
            Collection<Integer> typesOfOwnerships, Collection<Integer> legalEntities, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Agarkategori", typesOfOwnerships);
        mappings.put("Juridiskform", legalEntities);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OffFtg", mappings);
    }

    public List<ResponseModel> getIncomeStatements() {
        return getIncomeStatements(null, null, null, null);
    }

    public List<ResponseModel> getIncomeStatements(Collection<String> sectors, Collection<Integer> typesOfOwnerships,
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Agarkategori", typesOfOwnerships);
        mappings.put("SNI2007", industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OffResultSektor", mappings);
    }

    public List<ResponseModel> getLiabilitiesAndEquity() {
        return getLiabilitiesAndEquity(null, null, null, null);
    }

    public List<ResponseModel> getLiabilitiesAndEquity(Collection<String> sectors,
            Collection<Integer> typesOfOwnerships, Collection<String> industrialClassifications,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Agarkategori", typesOfOwnerships);
        mappings.put("SNI2007", industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OffSkulderSektor", mappings);
    }

    public List<ResponseModel> getAssets() {
        return getAssets(null, null, null, null);
    }

    public List<ResponseModel> getAssets(Collection<String> sectors, Collection<Integer> typesOfOwnerships,
            Collection<String> industrialClassifications, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SECTOR_CODE, sectors);
        mappings.put("Agarkategori", typesOfOwnerships);
        mappings.put("SNI2007", industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("OffTillgSektor", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/OE0108/");
    }

}
