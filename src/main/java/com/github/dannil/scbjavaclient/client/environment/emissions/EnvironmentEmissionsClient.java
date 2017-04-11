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

package com.github.dannil.scbjavaclient.client.environment.emissions;

import java.util.List;
import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles environment emissions data fetching.</p>
 *
 * @since 0.3.0
 */
public class EnvironmentEmissionsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public EnvironmentEmissionsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public EnvironmentEmissionsClient(Locale locale) {
        super(locale);
    }

    public List<ResponseModel> getTotalEmissions() {

    }

    public List<ResponseModel> getEmissionsFromOffroadVehiclesAndMachinery() {

    }

    public List<ResponseModel> getEmissionsFromWaste() {

    }

    public List<ResponseModel> getEmissionsFromElectricityAndHeating() {

    }

    public List<ResponseModel> getEmissionsFromIndustry() {

    }

    public List<ResponseModel> getEmissionsFromDomesticTransport() {

    }

    public List<ResponseModel> getEmissionsFromAgriculture() {

    }

    public List<ResponseModel> getEmissionsFromSolventUse() {

    }

    public List<ResponseModel> getEmissionsFromHeatingOfHousesAndBuildings() {

    }

    public List<ResponseModel> getEmissionsFromInternationalTransport() {

    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("MI/MI0108/");
    }

}
