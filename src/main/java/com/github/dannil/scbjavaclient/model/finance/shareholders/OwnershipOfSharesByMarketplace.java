package com.github.dannil.scbjavaclient.model.finance.shareholders;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.ValueNode;

public class OwnershipOfSharesByMarketplace extends OwnershipOfShares {

    @JsonProperty("Marknadsplats")
    private String marketplace;

    /**
     * <p>Default constructor.</p>
     */
    public OwnershipOfSharesByMarketplace() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param sector
     *            the sector
     * @param marketplace
     *            the marketplace
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public OwnershipOfSharesByMarketplace(String sector, String marketplace, String year,
            List<ValueNode<Double>> values) {
        super(sector, year, values);
        this.marketplace = marketplace;
    }

    /**
     * <p>Getter for marketplace.</p>
     *
     * @return the marketplace
     */
    public String getMarketplace() {
        return this.marketplace;
    }

    /**
     * <p>Setter for marketplace.</p>
     *
     * @param marketplace
     *            the marketplace
     */
    public void setMarketplace(String marketplace) {
        this.marketplace = marketplace;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.marketplace);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof OwnershipOfSharesByMarketplace)) {
            return false;
        }

        OwnershipOfSharesByMarketplace other = (OwnershipOfSharesByMarketplace) obj;
        return super.equals(obj) && Objects.equals(this.marketplace, other.marketplace);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [sector=");
        builder.append(getSector());
        builder.append(", marketplace=");
        builder.append(this.marketplace);
        builder.append(", year=");
        builder.append(getYear());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the ownership of shares
     * by marketplace data from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("FM/FM0201/AktieAgarMarknad");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
