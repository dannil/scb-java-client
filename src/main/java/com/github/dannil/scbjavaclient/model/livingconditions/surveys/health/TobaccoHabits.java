package com.github.dannil.scbjavaclient.model.livingconditions.surveys.health;

import java.util.Collection;
import java.util.Map;

import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;

public class TobaccoHabits extends Health {

    /**
     * <p>Default constructor.</p>
     */
    public TobaccoHabits() {
        super();
    }

    /**
     * <p>Get the available codes and their respective values for the tobacco habits data
     * from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("LE/LE0101/LE0101H/LE0101H25");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
