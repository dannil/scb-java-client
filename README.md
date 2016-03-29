# scb-java-client

[![Build Status](https://travis-ci.org/dannil/scb-java-client.svg?branch=dev)](https://travis-ci.org/dannil/scb-java-client)
[![Codacy Grade Badge](https://api.codacy.com/project/badge/grade/af5b976ee2f94fd4b25ef1ae991d7993)](https://www.codacy.com/app/dannil/scb-java-client)
[![Codacy Coverage Badge](https://api.codacy.com/project/badge/coverage/af5b976ee2f94fd4b25ef1ae991d7993)](https://www.codacy.com/app/dannil/scb-java-client)
[![Dependency Status](https://www.versioneye.com/user/projects/56d19801157a69002ea956d6/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56d19801157a69002ea956d6)

Java client for the SCB (Statistiska centralbyrån) API.

If you have an improvement, feel free to make a pull request or start an issue if you'd like feedback.

## Installation

### Maven

```xml
<dependency>
  <groupId>com.github.dannil</groupId>
  <artifactId>scb-java-client</artifactId>
  <version>0.0.2</version>
</dependency>
```

### Gradle
```xml
'com.github.dannil:scb-java-client:0.0.2'
```

### SBT
```xml
libraryDependencies += "com.github.dannil" % "scb-java-client" % "0.0.2"
```

## Usage

This demonstrates the typical usage of the client.

```java
// Create the client
SCBClient baseClient = new SCBClient();

// Retrieve all population statistics
List<Population> population = baseClient.population().statistic().getPopulation();

// Perform operations with the PopulationDemographyClient
PopulationDemographyClient populationDemographyClient = baseClient.population().demography();

// Retrieve all mean age for first child birth statistics 
// using the PopulationDemographyClient
List<MeanAgeFirstChild> firstChild = populationDemographyClient.getMeanAgeFirstChild();
```

The client also supports selecting specific values directly from the SCB API.

```java
// Specify the criterion for the information we want to retrieve
List<String> regions = Arrays.asList("00", "01", "0114");
List<String> types = Arrays.asList("01", "02");

// Defining an input as null means that we want to retrieve all information
// for this input. 
// 
// Example: if the information from the API specifies that it has information 
// for the years 2011 through 2015 (for a specific table), the inputs underneath 
// this row would result in an equivalent response from the API.
//
// List<Integer> years = Arrays.asList(2011, 2012, 2013, 2014, 2015);
// List<Integer> years = null;
// 
// This makes it easy to be selective when we have a case where we 
// want to retrieve all information for one input and at the same time 
// restrict the input for another (for example the years 2012 and 2014).
List<Integer> years = null;

// Retrieve all area statistics using the selected values
List<Area> areas = baseClient.environment().landAndWaterArea().getArea(regions, types, years);
```

If you know the required inputs and you're only interested in the JSON data, you may use the 
method getRawData() to specify the table and the inputs. The required inputs can be viewed in 
plaintext from the URL endpoint of the table.
```java
// Specifies the criterion for the information we want to retrieve, in this case:
// 		The contents code (so the API know what information we want for the response)
//		The regions 00, 01 and 0114
//		The relationship statuses OG (unmarried) and G (married)
//		The ages 45 and 50
//		The genders are null; we want to retrieve information for all genders
//		The years 2011 and 2012
Map<String, Collection<?>> inputs = new HashMap<String, Collection<?>>();
inputs.put("ContentsCode", Arrays.asList("BE0101N1"));
inputs.put("Region", Arrays.asList("00", "01", "0114"));
inputs.put("Civilstand", Arrays.asList("OG", "G"));
inputs.put("Alder", Arrays.asList(45, 50));
inputs.put("Kon", null);
inputs.put("Tid", Arrays.asList(2011, 2012));

// Specify the table to retrieve from and our inputs to this table. The response will be a JSON
// string containing the information that matched our criterion.
String json = baseClient.getRawData("BE/BE0101/BE0101A/BefolkningNy", inputs);