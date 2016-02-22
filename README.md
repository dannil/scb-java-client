[![Build Status](https://travis-ci.org/dannil/scb-api.svg?branch=dev)](https://travis-ci.org/dannil/scb-api)
[![Codacy Grade Badge](https://api.codacy.com/project/badge/grade/af5b976ee2f94fd4b25ef1ae991d7993)](https://www.codacy.com/app/dannil/scb-api)
[![Codacy Coverage Badge](https://api.codacy.com/project/badge/coverage/af5b976ee2f94fd4b25ef1ae991d7993)](https://www.codacy.com/app/dannil/scb-api)
[![Dependency Status](https://www.versioneye.com/user/projects/56a60ed01b78fd0035000109/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56a60ed01b78fd0035000109)

# scb-api

Java wrapper client implementation for the SCB (Statistiska centralbyrån) API.

## Getting Started



## Usage

This demonstarates the typical usage of the client API.

```java
// Create the client API
SCBAPI baseApi = new SCBAPI();

// Retrieve all population statistics
List<Population> population = baseApi.population().statistic().getPopulation();

// Perform operations with the DemographyAPI
DemographyAPI demographyApi = baseApi.population().demography();

// Retrieve all mean age for first child birth statistics 
// using the DemographyAPI
List<MeanAgeFirstChild> firstChild = demographyApi.getMeanAgeFirstChild();
```

The client API also supports selecting specific values directly from the SCB API.

```java
// Specify the criterion for the information we want to receive
List<String> regions = Arrays.asList("00", "01", "0114");
List<String> types = Arrays.asList("01", "02");
List<Integer> years = Arrays.asList(2012, 2014);

// Retrieve all area statistics using the selected values
List<Area> areas = baseApi.environment().landAndWaterArea().getArea(regions, types, years);
```