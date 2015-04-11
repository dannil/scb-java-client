package org.dannil.scbapi.api.environment.landandwaterarea;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.dannil.scbapi.api.AbstractAPI;
import org.dannil.scbapi.model.environment.landandwaterarea.Area;
import org.dannil.scbapi.model.environment.landandwaterarea.Area.Type;
import org.dannil.scbapi.utility.JsonUtility;
import org.dannil.scbapi.utility.QueryBuilder;
import org.dannil.scbapi.utility.RequestPoster;

import com.google.common.collect.ArrayListMultimap;

public final class LandAndWaterAreaAPI extends AbstractAPI implements AreaOperations {

	private String url;

	public LandAndWaterAreaAPI() {
		super.locale = Locale.getDefault();

		buildUrl();
	}

	public LandAndWaterAreaAPI(Locale locale) {
		this();
		super.locale = locale;

		buildUrl();
	}

	@Override
	public final void setLocale(Locale locale) {
		super.locale = locale;

		buildUrl();
	}

	public final void buildUrl() {
		this.url = "http://api.scb.se/OV0104/v1/doris/" + super.locale.getLanguage() + "/ssd/MI/MI0802/Areal2012";
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
	public final List<Area> getArea() {
		return this.getArea(null, null, null);
	}

	@Override
	public final List<Area> getArea(List<String> regions, List<Type> types, List<Integer> years) {
		QueryBuilder<String, String> queryBuilder = new QueryBuilder<String, String>();

		ArrayListMultimap<String, String> map = ArrayListMultimap.create();
		map.put("ContentsCode", "MI0802AA");
		if (regions != null) {
			for (String region : regions) {
				if (region != null) {
					map.put("Region", region);
				}
			}
		}
		if (types != null) {
			for (Type type : types) {
				if (type != null) {
					map.put("ArealTyp", type.toString());
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
		return JsonUtility.parseAreas(JsonUtility.getNode(response));
	}

}
