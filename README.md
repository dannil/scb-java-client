# scb-java-client

[![Build Status](https://travis-ci.org/dannil/scb-java-client.svg?branch=dev)](https://travis-ci.org/dannil/scb-java-client)
[![Codacy Grade Badge](https://api.codacy.com/project/badge/grade/af5b976ee2f94fd4b25ef1ae991d7993)](https://www.codacy.com/app/dannil/scb-java-client)
[![Codacy Coverage Badge](https://api.codacy.com/project/badge/coverage/af5b976ee2f94fd4b25ef1ae991d7993)](https://www.codacy.com/app/dannil/scb-java-client)
[![Dependency Status](https://www.versioneye.com/user/projects/56d19801157a69002ea956d6/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56d19801157a69002ea956d6)

Java client for the SCB (Statistiska centralbyrån) API.

## Installation

### Maven

Add the dependency to your project's POM.

```xml
<dependency>
  <groupId>com.github.dannil</groupId>
  <artifactId>scb-java-client</artifactId>
  <version>0.0.1</version>
</dependency>
```

## Usage

This demonstarates the typical usage of the client.

```java
// Create the client
SCBClient baseClient = new SCBClient();

// Retrieve all population statistics
List<Population> population = baseClient.population().statistic().getPopulation();

// Perform operations with the DemographyClient
DemographyClient demographyClient = baseClient.population().demography();

// Retrieve all mean age for first child birth statistics 
// using the DemographyClient
List<MeanAgeFirstChild> firstChild = demographyClient.getMeanAgeFirstChild();
```

The client also supports selecting specific values directly from the SCB API.

```java
// Specify the criterion for the information we want to receive
List<String> regions = Arrays.asList("00", "01", "0114");
List<String> types = Arrays.asList("01", "02");
List<Integer> years = Arrays.asList(2012, 2014);

// Retrieve all area statistics using the selected values
List<Area> areas = baseClient.environment().landAndWaterArea().getArea(regions, types, years);
```