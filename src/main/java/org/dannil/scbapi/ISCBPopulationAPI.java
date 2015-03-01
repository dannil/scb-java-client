package org.dannil.scbapi;

import java.util.List;

import org.dannil.scbapi.model.PopulationCollection;

public interface ISCBPopulationAPI {

	public PopulationCollection getPopulation();

	public PopulationCollection getPopulationForRegion(String region);

	public PopulationCollection getPopulationForRegion(String region, List<Integer> years);

	public PopulationCollection getPopulationForRegion(String region, Integer year);

	public PopulationCollection getPopulationForRegions(List<String> regions);

	public PopulationCollection getPopulationForRegions(List<String> regions, List<Integer> years);

	public PopulationCollection getPopulationForYear(int year);

	public PopulationCollection getPopulationBetweenYears(int startYear, int endYear);

	public PopulationCollection getPopulationForYears(List<Integer> years);

}
