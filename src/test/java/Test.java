import java.util.Date;
import java.util.Locale;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.utility.Localization;

public class Test {

	public static void main(String[] args) {
		// Locale locale = Locale.getDefault();
		Locale locale = new Locale("en", "US");

		// SCBClient c = new SCBClient(locale);

		// List<Population> pops = c.population().statistics()
		// .getPopulation(Arrays.asList("1263", "00"), null, null, null, Arrays.asList(1999, 2000));

		// System.out.println(c.getRegions("NR/NR0105/NR0105A"));

		Locale locale2 = new Locale("fr", "CA");
		Locale locale3 = Locale.getDefault();

		System.out.println(SCBClient.isSupportedLocale(locale2));

		// boolean res = c1.isSupportedLocale(locale1);
		// System.out.println(res);

		Localization loc = new Localization(locale2);
		System.out.println(loc.getString("hello", new Date()));
	}

}
