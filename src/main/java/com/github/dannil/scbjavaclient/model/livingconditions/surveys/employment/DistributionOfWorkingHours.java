package com.github.dannil.scbjavaclient.model.livingconditions.surveys.employment;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for distribution of working hours data.</p>
 *
 * @since 0.2.1
 */
public class DistributionOfWorkingHours extends AbstractEmployment {

    @JsonProperty("Indikator")
    private String indicator;

    /**
     * <p>Default constructor.</p>
     */
    public DistributionOfWorkingHours() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param indicator
     *            the indicator
     * @param age
     *            the age
     * @param sex
     *            the sex
     * @param period
     *            the period
     * @param values
     *            the values
     */
    public DistributionOfWorkingHours(String indicator, String age, String sex, String period,
            List<ValueNode<Double>> values) {
        super(age, sex, period, values);
        this.indicator = indicator;
    }

    /**
     * <p>Getter for indicator.</p>
     *
     * @return the indicator
     */
    public String getIndicator() {
        return this.indicator;
    }

    /**
     * <p>Setter for indicator.</p>
     *
     * @param indicator
     *            the indicator
     */
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.indicator);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DistributionOfWorkingHours)) {
            return false;
        }
        DistributionOfWorkingHours other = (DistributionOfWorkingHours) obj;
        return super.equals(obj) && Objects.equals(this.indicator, other.indicator);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("indicator", this.indicator);
        return super.buildToString(variables);
    }

    /**
     * <p>Get the available codes and their respective values for the distribution of
     * working hours data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("LE/LE0101/LE0101S/LE01012013A19");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
