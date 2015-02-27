package org.dannil.scbapi.utility;

import java.util.ArrayList;

public class ListUtility<E> {

	public static final <E> ArrayList<E> toList(E value) {
		ArrayList<E> list = new ArrayList<E>(1);
		list.add(value);
		return list;
	}
}
