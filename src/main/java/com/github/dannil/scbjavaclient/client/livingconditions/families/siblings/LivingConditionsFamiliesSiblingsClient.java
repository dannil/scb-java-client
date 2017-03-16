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

package com.github.dannil.scbjavaclient.client.livingconditions.families.siblings;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.livingconditions.families.siblings.Siblings;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles living conditions families siblings data fetching.</p>
 *
 * @since 0.2.0
 */
public class LivingConditionsFamiliesSiblingsClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public LivingConditionsFamiliesSiblingsClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public LivingConditionsFamiliesSiblingsClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all siblings data.</p>
     *
     * @return the siblings data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.families.siblings.Siblings
     *         Siblings} objects
     *
     * @see #getSiblings(Collection, Collection, Collection, Collection, Collection)
     */
    public List<Siblings> getSiblings() {
        return getSiblings(null, null, null, null, null);
    }

    /**
     * <p>Fetch all siblings data which match the input constraints.</p>
     *
     * @param sexes
     *            the sexes
     * @param ages
     *            the ages
     * @param siblingsLivingAtHome
     *            the siblings living at home
     * @param familyTypes
     *            the family types
     * @param years
     *            the years
     * @return the siblings data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.livingconditions.families.siblings.Siblings
     *         Siblings} objects
     */
    public List<Siblings> getSiblings(Collection<String> sexes, Collection<String> ages,
            Collection<Integer> siblingsLivingAtHome, Collection<String> familyTypes, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("ContentsCode", Arrays.asList("000000SV"));
        mappings.put("Kon", sexes);
        mappings.put("Alder", ages);
        mappings.put("SyskonHembo", siblingsLivingAtHome);
        mappings.put("Familjetyp", familyTypes);
        mappings.put("Tid", years);

        String response = doPostRequest(getUrl() + "LE0102T22", QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(Siblings.class);
    }

    @Override
    public String getUrl() {
        return getRootUrl() + "LE/LE0102/LE0102C/";
    }

}
