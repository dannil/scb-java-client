package com.github.dannil.scbjavaclient.model;

import java.util.Collection;
import java.util.Objects;

public class VariableNode {

	private String code;
	private String text;
	private Collection<String> values;
	private Collection<String> valueTexts;

	// public VariableNode() {
	// // TODO Auto-generated constructor stub
	// }

	public VariableNode(String code, String text, Collection<String> values, Collection<String> valueTexts) {
		this.code = code;
		this.text = text;
		this.values = values;
		this.valueTexts = valueTexts;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Collection<String> getValues() {
		return values;
	}

	public void setValues(Collection<String> values) {
		this.values = values;
	}

	public Collection<String> getValueTexts() {
		return valueTexts;
	}

	public void setValueTexts(Collection<String> valueTexts) {
		this.valueTexts = valueTexts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.code, this.text, this.values, this.valueTexts);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof VariableNode)) {
			return false;
		}

		VariableNode other = (VariableNode) obj;
		return Objects.equals(this.code, other.code) && Objects.equals(this.text, other.text)
				&& Objects.equals(this.values, other.values) && Objects.equals(this.valueTexts, other.valueTexts);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(128);
		builder.append("VariableNode [code=");
		builder.append(this.code);
		builder.append(", text=");
		builder.append(this.text);
		builder.append(", values=");
		builder.append(this.values);
		builder.append(", valueTexts=");
		builder.append(this.valueTexts);
		builder.append("]");
		return builder.toString();
	}

}
