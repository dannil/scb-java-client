package org.dannil.scbapi.api.environment;

import java.util.List;

import org.dannil.scbapi.api.AbstractAPI;
import org.dannil.scbapi.model.AreaCollection;
import org.dannil.scbapi.utility.JsonUtility;
import org.dannil.scbapi.utility.QueryBuilder;
import org.dannil.scbapi.utility.RequestPoster;

import com.google.common.collect.ArrayListMultimap;

public final class LandAndWaterAreasAPI extends AbstractAPI implements AreaOperations {

	@Override
	public final AreaCollection getArea() {
		return this.getArea(null, null, null);
	}

	@Override
	public final AreaCollection getArea(List<String> regions, List<String> types, List<Integer> years) {
		QueryBuilder<String, String> queryBuilder = new QueryBuilder<String, String>();

		ArrayListMultimap<String, String> map = ArrayListMultimap.create();
		map.put("ContentsCode", "MI0802AA");
		if (regions != null) {
			for (String region : regions) {
				map.put("Region", region);
			}
		}
		if (types != null) {
			for (String type : types) {
				map.put("ArealTyp", type);
			}
		}
		if (years != null) {
			for (Integer year : years) {
				map.put("Tid", year.toString());
			}
		}

		String query = queryBuilder.build(map);
		String response = RequestPoster.doPost("http://api.scb.se/OV0104/v1/doris/" + super.locale.getLanguage() + "/ssd/MI/MI0802/Areal2012", query);
		return new AreaCollection(JsonUtility.getNode(response));
	}

}
