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

package com.github.dannil.scbjavaclient.model.publicfinances.taxassessment;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.github.dannil.scbjavaclient.model.AbstractRegionTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for income tax data.</p>
 *
 * @since 0.2.1
 */
public class IncomeTax extends AbstractRegionTimeAndValueModel<String, Integer, String> {

    /**
     * <p>Default constructor.</p>
     */
    public IncomeTax() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param region
     *            the region
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public IncomeTax(String region, Integer year, List<ValueNode<String>> values) {
        super(region, year, values);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        return super.buildToString(variables);
    }

}
