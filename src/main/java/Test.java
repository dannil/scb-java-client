import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.utility.JsonUtility;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> contentsCodes = Arrays.asList("BE0101N1", "BE0101N2");
		List<String> regions = Arrays.asList("01");
		List<String> ages = Arrays.asList("30");

		Map<String, Collection<?>> query = new HashMap<String, Collection<?>>();
		query.put("ContentsCode", contentsCodes);
		query.put("Region", regions);
		query.put("Alder", ages);

		SCBClient c = new SCBClient(new Locale("en", "US"));
		String json = c.getRawData("BE/BE0101/BE0101A/BefolkningNy", query);

		JsonNode formatted = JsonUtility.toConventionalJson(json);
		System.out.println(formatted.toString());

		for (Object o : c.population().demography().getFertilityRate()) {
			System.out.println(o);
		}

	}
}
