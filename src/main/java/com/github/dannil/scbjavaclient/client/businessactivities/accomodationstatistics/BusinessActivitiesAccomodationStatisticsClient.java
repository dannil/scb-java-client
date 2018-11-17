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

package com.github.dannil.scbjavaclient.client.businessactivities.accomodationstatistics;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.businessactivities.accomodationstatistics.month.BusinessActivitiesAccomodationStatisticsMonthClient;
import com.github.dannil.scbjavaclient.client.businessactivities.accomodationstatistics.year.BusinessActivitiesAccomodationStatisticsYearClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;

/**
 * <p>Client which handles business activities accomodation statistics data fetching.</p>
 *
 * @since 0.3.0
 */
public class BusinessActivitiesAccomodationStatisticsClient extends AbstractContainerClient {

    /**
     * <p>Default constructor. Initializes values and creates sub-clients.</p>
     */
    public BusinessActivitiesAccomodationStatisticsClient() {
        super();

        addClient("month", new BusinessActivitiesAccomodationStatisticsMonthClient());
        addClient("year", new BusinessActivitiesAccomodationStatisticsYearClient());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public BusinessActivitiesAccomodationStatisticsClient(Locale locale) {
        this();

        setLocale(locale);
    }

    /**
     * <p>Retrieve the client for interacting with business activities accomodation
     * statistics month data.</p>
     *
     * @return a client for business activities accomodation statistics month data
     */
    public BusinessActivitiesAccomodationStatisticsMonthClient month() {
        return (BusinessActivitiesAccomodationStatisticsMonthClient) getClient("month");
    }

    /**
     * <p>Retrieve the client for interacting with business activities accomodation
     * statistics year data.</p>
     *
     * @return a client for business activities accomodation statistics year data
     */
    public BusinessActivitiesAccomodationStatisticsYearClient year() {
        return (BusinessActivitiesAccomodationStatisticsYearClient) getClient("year");
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("NV/NV1701/");
    }

}
