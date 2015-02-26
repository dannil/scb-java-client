package org.dannil.scbapi.test;

import org.dannil.scbapi.SCBAPI;

public class Test {

	public static void main(String[] args) {

		SCBAPI api = new SCBAPI();

		api.test();

		api.getPopulationBetweenYears(2001, 2003);

	}

}
