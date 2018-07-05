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

package com.github.dannil.scbjavaclient.client.environment.seea.airemissionsaccounts;

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
 * air emissions accounts data fetching.</p>
 *
 * @since 0.4.0
 */
public class EnvironmentSEEAAirEmissionsAccountsClient extends AbstractClient {

    private static final String SUBSTANCE_CODE = "AmneMiljo";

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentSEEAAirEmissionsAccountsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentSEEAAirEmissionsAccountsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all air emissions by industry (SNI 2007) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAirEmissionsByIndustrySNI2007(Collection, Collection, Collection)
     */
    public List<ResponseModel> getAirEmissionsByIndustrySNI2007() {
        return getAirEmissionsByIndustrySNI2007(null, null, null);
    }

    /**
     * <p>Fetch all air emissions by industry (SNI 2007) data which match the input
     * constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param substances
     *            the substances
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAirEmissionsByIndustrySNI2007(Collection<String> industrialClassifications,
            Collection<String> substances, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(SUBSTANCE_CODE, substances);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MiljoUtslappAmneSNIb", mappings);
    }

    /**
     * <p>Fetch all air emissions by industry (SNI 92) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAirEmissionsByIndustrySNI92(Collection, Collection, Collection)
     */
    public List<ResponseModel> getAirEmissionsByIndustrySNI92() {
        return getAirEmissionsByIndustrySNI92(null, null, null);
    }

    /**
     * <p>Fetch all air emissions by industry (SNI 92) data which match the input
     * constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param substances
     *            the substances
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAirEmissionsByIndustrySNI92(Collection<String> industrialClassifications,
            Collection<String> substances, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI92_CODE, industrialClassifications);
        mappings.put(SUBSTANCE_CODE, substances);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MiljoUtslappAmneSNI", mappings);
    }

    /**
     * <p>Fetch all air emissions by industry and quarters (SNI 2007) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAirEmissionsByIndustryAndQuartersSNI2007(Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getAirEmissionsByIndustryAndQuartersSNI2007() {
        return getAirEmissionsByIndustrySNI2007(null, null, null);
    }

    /**
     * <p>Fetch all air emissions by industry and quarters (SNI 2007) data which match the
     * input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param substances
     *            the substances
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAirEmissionsByIndustryAndQuartersSNI2007(Collection<String> industrialClassifications,
            Collection<String> substances, Collection<String> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(SUBSTANCE_CODE, substances);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MiljoUtslappAmneSNIK", mappings);
    }

    /**
     * <p>Fetch all air emissions (municipality, LAU2) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAirEmissionsByMunicipalityLAU2(Collection, Collection, Collection)
     */
    public List<ResponseModel> getAirEmissionsByMunicipalityLAU2() {
        return getAirEmissionsByMunicipalityLAU2(null, null, null);
    }

    /**
     * <p>Fetch all air emissions (municipality, LAU2) data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param substances
     *            the substances
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAirEmissionsByMunicipalityLAU2(Collection<String> regions,
            Collection<String> substances, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(SUBSTANCE_CODE, substances);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("UtslappKommun", mappings);
    }

    /**
     * <p>Fetch all air emissions (NUTS 2) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAirEmissionsNUTS2(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getAirEmissionsNUTS2() {
        return getAirEmissionsNUTS2(null, null, null, null);
    }

    /**
     * <p>Fetch all air emissions (NUTS 2) data which match the input constraints.</p>
     *
     * @param regions
     *            the regions
     * @param industrialClassifications
     *            the industrial classifications
     * @param substances
     *            the substances
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAirEmissionsNUTS2(Collection<String> regions,
            Collection<String> industrialClassifications, Collection<String> substances, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(SUBSTANCE_CODE, substances);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("UtslappNUTS2", mappings);
    }

    /**
     * <p>Fetch all air emissions from transport (NUTS 2) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAirEmissionsFromTransportNUTS2(Collection, Collection, Collection,
     *      Collection)
     */
    public List<ResponseModel> getAirEmissionsFromTransportNUTS2() {
        return getAirEmissionsFromTransportNUTS2(null, null, null, null);
    }

    /**
     * <p>Fetch all air emissions from transport (NUTS 2) data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param industrialClassifications
     *            the industrial classifications
     * @param substances
     *            the substances
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAirEmissionsFromTransportNUTS2(Collection<String> regions,
            Collection<String> industrialClassifications, Collection<String> substances, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(SUBSTANCE_CODE, substances);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("UtslappTrspNUTS2", mappings);
    }

    /**
     * <p>Fetch all air emissions (county, NUTS3) data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getAirEmissionsByCountyNUTS3(Collection, Collection, Collection, Collection)
     */
    public List<ResponseModel> getAirEmissionsByCountyNUTS3() {
        return getAirEmissionsByCountyNUTS3(null, null, null, null);
    }

    /**
     * <p>Fetch all air emissions (county, NUTS3) data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param industrialClassifications
     *            the industrial classifications
     * @param substances
     *            the substances
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getAirEmissionsByCountyNUTS3(Collection<String> regions,
            Collection<String> industrialClassifications, Collection<String> substances, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(SUBSTANCE_CODE, substances);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("UtslappLan", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI1301/MI1301B/");
    }

}
