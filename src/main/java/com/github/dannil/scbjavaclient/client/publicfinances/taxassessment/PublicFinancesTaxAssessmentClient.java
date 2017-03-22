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

package com.github.dannil.scbjavaclient.client.publicfinances.taxassessment;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.publicfinances.taxassessment.CapitalIncomeTax;
import com.github.dannil.scbjavaclient.model.publicfinances.taxassessment.EarnedIncomeTax;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles public finances tax assessment data fetching.</p>
 *
 * @since 0.2.1
 */
public class PublicFinancesTaxAssessmentClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PublicFinancesTaxAssessmentClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesTaxAssessmentClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all assessed and taxable earned income data.</p>
     *
     * @return the assessed and taxable earned income data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.publicfinances.taxassessment.EarnedIncomeTax
     *         EarnedIncomeTax} objects
     *
     * @see #getAssessedAndTaxableEarnedIncome(Collection, Collection)
     */
    public List<EarnedIncomeTax> getAssessedAndTaxableEarnedIncome() {
        return getAssessedAndTaxableEarnedIncome(null, null);
    }

    /**
     * <p>Fetch all assessed and taxable earned income data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the assessed and taxable earned income data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.publicfinances.taxassessment.EarnedIncomeTax
     *         EarnedIncomeTax} objects
     */
    public List<EarnedIncomeTax> getAssessedAndTaxableEarnedIncome(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("OE0701AA", "OE0701AB", "OE0701AC", "OE0701AD", "OE0701AE"));
        mappings.put("Region", regions);
        mappings.put("Tid", years);

        String response = doPostRequest(getUrl() + "ForvInkomsterA", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(EarnedIncomeTax.class);
    }

    /**
     * <p>Fetch all assessment for national capital income tax data.</p>
     *
     * @return the assessment for national capital income tax data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.publicfinances.taxassessment.CapitalIncomeTax
     *         CapitalIncomeTax} objects
     *
     * @see #getAssessmentForNationalCapitalIncomeTax(Collection, Collection)
     */
    public List<CapitalIncomeTax> getAssessmentForNationalCapitalIncomeTax() {
        return getAssessmentForNationalCapitalIncomeTax(null, null);
    }

    /**
     * <p>Fetch all assessment for national capital income tax data which match the input
     * constraints.</p>
     *
     * @param regions
     *            the regions
     * @param years
     *            the years
     * @return the assessment for national capital income tax data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.publicfinances.taxassessment.CapitalIncomeTax
     *         CapitalIncomeTax} objects
     */
    public List<CapitalIncomeTax> getAssessmentForNationalCapitalIncomeTax(Collection<String> regions,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode",
                Arrays.asList("OE0701CA", "OE0701CB", "OE0701CC", "OE0701CD", "OE0701CE", "OE0701CF"));
        mappings.put("Region", regions);
        mappings.put("Tid", years);

        String response = doPostRequest(getUrl() + "KapInkomsterA", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(CapitalIncomeTax.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "OE/OE0701/";
    }

}
