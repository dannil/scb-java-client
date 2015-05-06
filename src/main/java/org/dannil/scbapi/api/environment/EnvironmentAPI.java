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

package org.dannil.scbapi.api.environment;

import java.util.Locale;

import org.dannil.scbapi.api.AbstractContainerAPI;
import org.dannil.scbapi.api.environment.landandwaterarea.LandAndWaterAreaAPI;

public final class EnvironmentAPI extends AbstractContainerAPI {

	private LandAndWaterAreaAPI landAndWaterArea;

	public EnvironmentAPI() {
		this.landAndWaterArea = new LandAndWaterAreaAPI();
		super.apis.add(this.landAndWaterArea);
	}

	public EnvironmentAPI(Locale locale) {
		this();

		super.setLocale(locale);
	}

	public LandAndWaterAreaAPI landAndWaterArea() {
		return this.landAndWaterArea;
	}

}
