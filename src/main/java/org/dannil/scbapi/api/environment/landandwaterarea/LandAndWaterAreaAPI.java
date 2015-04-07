package org.dannil.scbapi.api.environment.landandwaterarea;

import java.util.List;

import org.dannil.scbapi.api.AbstractAPI;
import org.dannil.scbapi.model.environment.landandwaterarea.Area;
import org.dannil.scbapi.model.environment.landandwaterarea.Area.Type;
import org.dannil.scbapi.utility.JsonUtility;
import org.dannil.scbapi.utility.QueryBuilder;
import org.dannil.scbapi.utility.RequestPoster;

import com.google.common.collect.ArrayListMultimap;

public final class LandAndWaterAreaAPI extends AbstractAPI implements AreaOperations {

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
				map.put("Region", region);
			}
		}
		if (types != null) {
			for (Type type : types) {
				map.put("ArealTyp", type.toString());
			}
		}
		if (years != null) {
			for (Integer year : years) {
				map.put("Tid", year.toString());
			}
		}

		String query = queryBuilder.build(map);
		String response = RequestPoster.doPost("http://api.scb.se/OV0104/v1/doris/" + super.locale.getLanguage() + "/ssd/MI/MI0802/Areal2012", query);
		return JsonUtility.parseAreas(JsonUtility.getNode(response));
	}

}
