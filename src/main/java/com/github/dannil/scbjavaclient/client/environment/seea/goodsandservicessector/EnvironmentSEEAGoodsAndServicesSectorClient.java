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

package com.github.dannil.scbjavaclient.client.environment.seea.goodsandservicessector;

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
 * goods and services sector data fetching.</p>
 *
 * @since 0.4.0
 */
public class EnvironmentSEEAGoodsAndServicesSectorClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentSEEAGoodsAndServicesSectorClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentSEEAGoodsAndServicesSectorClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all environmental sector by environmental area data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnvironmentalSectorByEnvironmentalArea(Collection, Collection)
     */
    public List<ResponseModel> getEnvironmentalSectorByEnvironmentalArea() {
        return getEnvironmentalSectorByEnvironmentalArea(null, null);
    }

    /**
     * <p>Fetch all environmental sector by environmental area data which match the input
     * constraints.</p>
     *
     * @param environmentalAreas
     *            the environmental areas
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnvironmentalSectorByEnvironmentalArea(Collection<Integer> environmentalAreas,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Miljoomrade", environmentalAreas);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI1301T05", mappings);
    }

    /**
     * <p>Fetch all environmental sector by county data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnvironmentalSectorByCounty(Collection, Collection)
     */
    public List<ResponseModel> getEnvironmentalSectorByCounty() {
        return getEnvironmentalSectorByCounty(null, null);
    }

    /**
     * <p>Fetch all environmental sector by county data which match the input
     * constraints.</p>
     *
     * @param counties
     *            the counties
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnvironmentalSectorByCounty(Collection<String> counties, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Lan", counties);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("MI1301T04", mappings);
    }

    /**
     * <p>Fetch all environmental sector net turnover by industrial classification
     * data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnvironmentalSectorNetTurnoverByIndustrialClassification(Collection,
     *      Collection)
     */
    public List<ResponseModel> getEnvironmentalSectorNetTurnoverByIndustrialClassification() {
        return getEnvironmentalSectorNetTurnoverByIndustrialClassification(null, null);
    }

    /**
     * <p>Fetch all environmental sector net turnover by industrial classification data
     * which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnvironmentalSectorNetTurnoverByIndustrialClassification(
            Collection<String> industrialClassifications, Collection<Integer> years) {
        return generateEnvironmentalSectorByIndustrialClassification(industrialClassifications, years, "MI1301T01");
    }

    /**
     * <p>Fetch all environmental sector value added by industrial classification
     * data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnvironmentalSectorValueAddedByIndustrialClassification(Collection,
     *      Collection)
     */
    public List<ResponseModel> getEnvironmentalSectorValueAddedByIndustrialClassification() {
        return getEnvironmentalSectorValueAddedByIndustrialClassification(null, null);
    }

    /**
     * <p>Fetch all environmental sector value added by industrial classification data
     * which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnvironmentalSectorValueAddedByIndustrialClassification(
            Collection<String> industrialClassifications, Collection<Integer> years) {
        return generateEnvironmentalSectorByIndustrialClassification(industrialClassifications, years, "MI1301T02");
    }

    /**
     * <p>Fetch all environmental sector export by industrial classification data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getEnvironmentalSectorExportByIndustrialClassification(Collection,
     *      Collection)
     */
    public List<ResponseModel> getEnvironmentalSectorExportByIndustrialClassification() {
        return getEnvironmentalSectorExportByIndustrialClassification(null, null);
    }

    /**
     * <p>Fetch all environmental sector export by industrial classification data which
     * match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getEnvironmentalSectorExportByIndustrialClassification(
            Collection<String> industrialClassifications, Collection<Integer> years) {
        return generateEnvironmentalSectorByIndustrialClassification(industrialClassifications, years, "MI1301T03");
    }

    /**
     * <p>Common generator method for methods handling environmental sector by industrial
     * classification data.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param years
     *            the years
     * @param table
     *            the table
     * @return a <code>List</code> of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     */
    private List<ResponseModel> generateEnvironmentalSectorByIndustrialClassification(
            Collection<String> industrialClassifications, Collection<Integer> years, String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels(table, mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI1301/MI1301D/");
    }

}
