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

package com.github.dannil.scbjavaclient.client.businessactivities.industrialcapacityutilization.industrialcapacityutilization;

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
 * <p>Client which handles business activities industrial capacity utilization industrial
 * capacity utilization data fetching.</p>
 *
 * @since 0.7.0
 */
public class BusinessActivitiesIndustrialCapacityUtilizationIndustrialCapacityUtilizationClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public BusinessActivitiesIndustrialCapacityUtilizationIndustrialCapacityUtilizationClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesIndustrialCapacityUtilizationIndustrialCapacityUtilizationClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all industrial capacity utilisation SNI2007 data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIndustrialCapacityUtilisationSNI2007(Collection, Collection)
     */
    public List<ResponseModel> getIndustrialCapacityUtilisationSNI2007() {
        return getIndustrialCapacityUtilisationSNI2007(null, null);
    }

    /**
     * <p>Fetch all industrial capacity utilisation SNI2007 data which match the input
     * constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIndustrialCapacityUtilisationSNI2007(Collection<String> industrialClassifications,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("IndKaputnSNI07Kv", mappings);
    }

    /**
     * <p>Fetch all industrial capacity utilisation SNI92 data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIndustrialCapacityUtilisationSNI92(Collection, Collection)
     */
    public List<ResponseModel> getIndustrialCapacityUtilisationSNI92() {
        return getIndustrialCapacityUtilisationSNI92(null, null);
    }

    /**
     * <p>Fetch all industrial capacity utilisation SNI92 data which match the input
     * constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIndustrialCapacityUtilisationSNI92(Collection<String> industrialClassifications,
            Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI92_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("IndKaputnFaktKv", mappings);
    }

    /**
     * <p>Fetch all industrial capacity utilisation SNI2007 historical time series
     * data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getIndustrialCapacityUtilisationSNI2007HistoricalTimeSeries(Collection,
     *      Collection)
     */
    public List<ResponseModel> getIndustrialCapacityUtilisationSNI2007HistoricalTimeSeries() {
        return getIndustrialCapacityUtilisationSNI2007HistoricalTimeSeries(null, null);
    }

    /**
     * <p>Fetch all industrial capacity utilisation SNI2007 historical time series data
     * which match the input constraints.</p>
     *
     * @param industrialClassifications
     *            the industrial classifications
     * @param quarters
     *            the quarters
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getIndustrialCapacityUtilisationSNI2007HistoricalTimeSeries(
            Collection<String> industrialClassifications, Collection<String> quarters) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SNI2007_CODE, industrialClassifications);
        mappings.put(APIConstants.TIME_CODE, quarters);

        return getResponseModels("IndKaputnSNI07KvHis", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV0701/NV0701A/");
    }

}
