package org.dannil.scbapi.api.population.statistic;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.dannil.scbapi.api.AbstractAPI;
import org.dannil.scbapi.model.population.statistic.Statistic;
import org.dannil.scbapi.model.population.statistic.Statistic.Gender;
import org.dannil.scbapi.model.population.statistic.Statistic.RelationshipStatus;
import org.dannil.scbapi.utility.JsonUtility;
import org.dannil.scbapi.utility.QueryBuilder;
import org.dannil.scbapi.utility.RequestPoster;

import com.google.common.collect.ArrayListMultimap;

public final class StatisticAPI extends AbstractAPI implements StatisticOperations {

	private String url;

	public StatisticAPI() {
		this.locale = Locale.getDefault();

		buildUrl();
	}

	public StatisticAPI(Locale locale) {
		this();
		this.locale = locale;

		buildUrl();
	}

	@Override
	public final void setLocale(Locale locale) {
		this.locale = locale;

		buildUrl();
	}

	public final void buildUrl() {
		this.url = "http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy";
	}

	public final List<String> getRegions() {
		return super.getRegions(this.url);
	}

	public final List<Integer> getYears() {
		List<String> fetchedYears = super.getYears(this.url);

		List<Integer> years = new ArrayList<Integer>(fetchedYears.size());
		for (String fetchedYear : fetchedYears) {
			years.add(Integer.valueOf(fetchedYear));
		}

		return years;
	}

	@Override
	public final List<Statistic> getPopulation() {
		return this.getPopulation(null, null, null, null, null);
	}

	@Override
	public final List<Statistic> getPopulation(List<String> regions, List<RelationshipStatus> relationshipStatuses, List<String> ages, List<Gender> genders, List<Integer> years) {
		QueryBuilder<String, String> queryBuilder = new QueryBuilder<String, String>();

		ArrayListMultimap<String, String> map = ArrayListMultimap.create();
		map.put("ContentsCode", "BE0101N1");
		if (regions != null) {
			for (String region : regions) {
				if (region != null) {
					map.put("Region", region);
				}
			}
		}
		if (relationshipStatuses != null) {
			for (RelationshipStatus relationshipStatus : relationshipStatuses) {
				if (relationshipStatus != null) {
					map.put("Civilstand", relationshipStatus.toString());
				}
			}
		}
		if (ages != null) {
			for (String age : ages) {
				if (age != null) {
					map.put("Alder", age);
				}
			}
		}
		if (genders != null) {
			for (Gender gender : genders) {
				if (gender != null) {
					map.put("Kon", gender.toString());
				}
			}
		}
		if (years != null) {
			for (Integer year : years) {
				if (year != null) {
					map.put("Tid", year.toString());
				}
			}
		}

		String query = queryBuilder.build(map);
		String response = RequestPoster.doPost(this.url, query);
		return JsonUtility.parseStatistic(JsonUtility.getNode(response));
	}
}
