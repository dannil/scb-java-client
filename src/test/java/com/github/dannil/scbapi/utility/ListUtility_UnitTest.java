/*
Copyright 2016 Daniel Nilsson

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

package com.github.dannil.scbapi.utility;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ListUtility_UnitTest {

	@Test
	public void toList() {
		String test = "helloworld";

		List<String> list1 = ListUtility.toList(test);

		List<String> list2 = new ArrayList<String>();
		list2.add(test);

		assertEquals(list1, list2);
	}

	@Test
	public void toStringWithValues() {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(42);

		List<String> list2 = new ArrayList<String>();
		list2.add("42");

		assertEquals(list2, ListUtility.toString(list1));
	}

	@Test
	public void toStringNoValues() {
		List<Integer> list1 = new ArrayList<Integer>();
		List<String> list2 = new ArrayList<String>();

		assertEquals(list2, ListUtility.toString(list1));
	}

}
