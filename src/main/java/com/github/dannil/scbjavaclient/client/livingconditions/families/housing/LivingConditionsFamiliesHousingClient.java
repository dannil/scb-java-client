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

package com.github.dannil.scbjavaclient.client.livingconditions.families.housing;

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
 * <p>Client which handles living conditions families housing data fetching.</p>
 *
 * @since 0.2.0
 */
public class LivingConditionsFamiliesHousingClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public LivingConditionsFamiliesHousingClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LivingConditionsFamiliesHousingClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all housing data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getHousing(Collection, Collection, Collection, Collection, Collection,
     *      Collection, Collection)
     */
    public List<ResponseModel> getHousing() {
        return getHousing(null, null, null, null, null, null, null);
    }

    /**
     * <p>Fetch all housing data which match the input constraints.</p>
     *
     * @param sexes
     *            the sexes
     * @param ages
     *            the ages
     * @param housingTypes
     *            the housing types
     * @param familyTypes
     *            the family types
     * @param backgrounds
     *            the backgrounds
     * @param parentIncomes
     *            the parent incomes
     * @param years
     *            the years
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getHousing(Collection<String> sexes, Collection<String> ages,
            Collection<String> housingTypes, Collection<String> familyTypes, Collection<String> backgrounds,
            Collection<Integer> parentIncomes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.SEX_CODE, sexes);
        mappings.put(APIConstants.AGE_CODE, ages);
        mappings.put("Boendeform", housingTypes);
        mappings.put("Familjetyp", familyTypes);
        mappings.put("UtlBakgrund", backgrounds);
        mappings.put("Foraldrarinkniv", parentIncomes);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("LE0102T34", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("LE/LE0102/LE0102M/");
    }

}
