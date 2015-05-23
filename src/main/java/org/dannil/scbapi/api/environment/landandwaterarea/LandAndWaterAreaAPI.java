/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

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

public class LandAndWaterAreaAPI extends AbstractAPI implements AreaOperations {

	public LandAndWaterAreaAPI() {
		super.locale = Locale.getDefault();
	}

	public LandAndWaterAreaAPI(Locale locale) {
		this();
		super.locale = locale;
	}

	@Override
	public void setLocale(Locale locale) {
		super.locale = locale;
	}

	private String getUrl() {
		return "http://api.scb.se/OV0104/v1/doris/" + super.locale.getLanguage() + "/ssd/MI/MI0802/Areal2012";
	}

	public List<String> getRegions() {
		return super.getRegions(getUrl());
	}

	public List<Integer> getYears() {
		List<String> fetchedYears = super.getYears(getUrl());

		List<Integer> years = new ArrayList<Integer>(fetchedYears.size());
		for (String fetchedYear : fetchedYears) {
			years.add(Integer.valueOf(fetchedYear));
		}
		return years;
	}

	@Override
	public List<Area> getArea() {
		return this.getArea(null, null, null);
	}

	@Override
	public List<Area> getArea(List<String> regions, List<Type> types, List<Integer> years) {
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
		String response = RequestPoster.doPost(getUrl(), query);
		return JsonUtility.parseAreas(JsonUtility.getNode(response));
	}

}
