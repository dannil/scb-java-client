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

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
@Remote
public class PublicFinancesTaxAssessmentClientIT {

    private PublicFinancesTaxAssessmentClient client;

    @BeforeEach
    public void setup() {
        this.client = new PublicFinancesTaxAssessmentClient();
    }

    @Test
    @Date("2017-03-21")
    public void getAssessedAndTaxableEarnedIncome() {
        assertNotEquals(0, this.client.getAssessedAndTaxableEarnedIncome().size());
    }

    @Test
    @Date("2017-03-21")
    public void getAssessedAndTaxableEarnedIncomeWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAssessedAndTaxableEarnedIncome(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-03-21")
    public void getAssessedAndTaxableEarnedIncomeWithParameters() {
        List<String> regions = Arrays.asList("0182", "0305");
        List<Integer> years = Arrays.asList(2004, 2008);

        assertNotEquals(0, this.client.getAssessedAndTaxableEarnedIncome(regions, years).size());
    }

    @Test
    @Date("2017-03-21")
    public void getAssessmentForNationalCapitalIncomeTax() {
        assertNotEquals(0, this.client.getAssessmentForNationalCapitalIncomeTax().size());
    }

    @Test
    @Date("2017-03-21")
    public void getAssessmentForNationalCapitalIncomeTaxWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getAssessedAndTaxableEarnedIncome(Collections.<String>emptyList(),
                Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-03-21")
    public void getAssessmentForNationalCapitalIncomeTaxWithParameters() {
        List<String> regions = Arrays.asList("0182", "0305");
        List<Integer> years = Arrays.asList(2004, 2008);

        assertNotEquals(0, this.client.getAssessmentForNationalCapitalIncomeTax(regions, years).size());
    }

}
