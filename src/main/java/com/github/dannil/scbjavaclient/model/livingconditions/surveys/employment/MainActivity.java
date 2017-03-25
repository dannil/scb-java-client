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
 * <p>Model for main activity data.</p>
 *
 * @since 0.2.1
 */
public class MainActivity extends AbstractEmployment {

    @JsonProperty("HuvSyss")
    private String activity;

    /**
     * <p>Default constructor.</p>
     */
    public MainActivity() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param activity
     *            the activity
     * @param age
     *            the age
     * @param sex
     *            the sex
     * @param period
     *            the period
     * @param values
     *            the values
     */
    public MainActivity(String activity, String age, Integer sex, String period, List<ValueNode<Double>> values) {
        super(age, sex, period, values);
        this.activity = activity;
    }

    /**
     * <p>Getter for activity.</p>
     *
     * @return the activity
     */
    public String getActivity() {
        return this.activity;
    }

    /**
     * <p>Setter for activity.</p>
     *
     * @param activity
     *            the activity
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.activity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MainActivity)) {
            return false;
        }
        MainActivity other = (MainActivity) obj;
        return super.equals(obj) && Objects.equals(this.activity, other.activity);
    }

    @Override
    public String toString() {
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("activity", this.activity);
        return super.buildToString(variables);
    }

    /**
     * <p>Get the available codes and their respective values for the main activity data
     * from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("LE/LE0101/LE0101S/LE01012013S01");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
