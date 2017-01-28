package com.github.dannil.scbjavaclient.model;

import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;

public class GenericModel extends AbstractValueModel<String> {

	private JsonCustomResponseFormat format;

	public GenericModel(String json) {
		this.format = new JsonCustomResponseFormat(json);
	}

	@Override
	public String toString() {
		return format.toString();
	}

}
