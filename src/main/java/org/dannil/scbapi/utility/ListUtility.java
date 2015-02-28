package org.dannil.scbapi.utility;

import java.util.ArrayList;
import java.util.List;

public class ListUtility<E> {

	public static final <E> List<E> toList(E value) {
		ArrayList<E> list = new ArrayList<E>(1);
		list.add(value);
		return list;
	}

	public static final <E> List<String> toString(List<E> list) {
		List<String> temp = new ArrayList<String>();
		for (E data : list) {
			temp.add(String.valueOf(data));
		}
		return temp;
	}
}
