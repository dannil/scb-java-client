package com.github.dannil.scbjavaclient.model.environment.waste;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractYearAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Abstract model for waste data. Holds data which are common for all classes located
 * in this package.</p>
 *
 * @since 0.2.0
 */
public abstract class Waste extends AbstractYearAndValueModel<Integer, String> {

    @JsonProperty("avfallsslag")
    private String wasteCategory;

    /**
     * <p>Default constructor.</p>
     */
    public Waste() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param wasteCategory
     *            the waste category
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public Waste(String wasteCategory, Integer year, List<ValueNode<String>> values) {
        super(year, values);
        this.wasteCategory = wasteCategory;
    }

    /**
     * <p>Getter for waste category.</p>
     *
     * @return the waste category
     */
    public String getWasteCategory() {
        return this.wasteCategory;
    }

    /**
     * <p>Setter for waste category.</p>
     *
     * @param wasteCategory
     *            the waste category
     */
    public void setWasteCategory(String wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.wasteCategory);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Waste)) {
            return false;
        }

        Waste other = (Waste) obj;
        return super.equals(obj) && Objects.equals(this.wasteCategory, other.wasteCategory);
    }

}
