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

package org.dannil.scbapi.deprecated;

//public final class AreaCollection implements AreaOperations {
//
// private List<Area> areas;
//
// private AreaCollection() {
// this.areas = new ArrayList<Area>();
// }
//
// public AreaCollection(JsonNode node) {
// this();
//
// JsonNode data = node.get("data");
//
// List<JsonNode> keys = data.findValues("key");
// List<JsonNode> values = data.findValues("values");
//
// for (int i = 0; i < keys.size(); i++) {
// String region = null;
// String type = null;
// Integer year = null;
//
// JsonNode keyAtPosition = keys.get(i);
// if (keyAtPosition.size() < 3) {
// region = keyAtPosition.get(0).asText();
// year = keyAtPosition.get(1).asInt();
// } else {
// region = keyAtPosition.get(0).asText();
// type = keyAtPosition.get(1).asText();
// year = keyAtPosition.get(2).asInt();
// }
//
// JsonNode valueAtPosition = values.get(i);
// final Double squareKm = valueAtPosition.get(0).asDouble();
//
// Area a = new Area(region, type, year, squareKm);
// this.areas.add(a);
// }
// }
//
// @Override
// public AreaCollection getArea() {
// return this;
// }
//
// @Override
// public AreaCollection getArea(List<String> regions, List<String> types,
// List<Integer> years) {
// final AreaCollection c = new AreaCollection();
// for (Area a : c.getAreas()) {
// if (regions == null && types == null && years == null) {
// return this;
// } else if (regions == null && types == null) {
// for (Integer year : years) {
// if (a.getYear().equals(year)) {
// c.add(a);
// }
// }
// } else if (regions == null && years == null) {
// for (String type : types) {
// if (a.getType() == type) {
// c.add(a);
// }
// }
// } else if (types == null && years == null) {
// for (String region : regions) {
// if (a.getRegion().equals(region)) {
// c.add(a);
// }
// }
// } else if (regions == null) {
// for (String type : types) {
// for (Integer year : years) {
// if (a.getType() == type && a.getYear().equals(year)) {
// c.add(a);
// }
// }
// }
// } else if (types == null) {
// for (String region : regions) {
// for (Integer year : years) {
// if (a.getRegion().equals(region) && a.getYear().equals(year)) {
// c.add(a);
// }
// }
// }
// } else if (years == null) {
// for (String region : regions) {
// for (String type : types) {
// if (a.getRegion().equals(region) && a.getType() == type) {
// c.add(a);
// }
// }
// }
// } else {
// for (String region : regions) {
// for (String type : types) {
// for (Integer year : years) {
// if (a.getRegion().equals(region) && a.getType() == type &&
// a.getYear().equals(year)) {
// c.add(a);
// }
// }
// }
// }
// }
// }
// return c;
// }
//
// public void add(Area a) {
// this.areas.add(a);
// }
//
// public List<Area> getAreas() {
// return this.areas;
// }

// }
