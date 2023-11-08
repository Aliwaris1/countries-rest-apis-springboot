# countries-rest-apis-springboot

A Spring Boot microservices project for fetching countries using external APIs. This project provides two main endpoints: one to get a list of all countries and another to get country details by name.

## Project Overview

This project is structured as follows:

- `src/main`: Contains the main application code.
- `src/test`: Contains integration tests using Cucumber.
- `src/test/JmeterTest`: Contains Jmeter script and test data `Countries Name - Sheet1.csv`, in order to run the script user should have Apache Jmeter install in the system 

## Prerequisites

Before running the project and its tests, ensure you have the following prerequisites:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) installed (version compatible with your Spring Boot version).
- [Maven](https://maven.apache.org/download.cgi) installed.
- Basic knowledge of Spring Boot and Cucumber.

## Running the Microservices

1. Clone this repository to your local machine:

   ```shell
   git clone https://github.com/yourusername/restcountries-calling-external-apis.git

2. Navigate to the project directory:

   ```shell
    cd restcountries-calling-external-apis

3. Build the project:

   ```shell
    mvn clean install

4. Run the application:

   ```shell
    mvn spring-boot:run


5. The microservices should now be running on http://localhost:8080 and provide the following endpoints:

    ```shell
    /api/countries - Get a list of all countries.
    /api/countryinfo?name={countryName} - Get country details by name.
    

## Running the Cucumber integration tests
```shell
mvn test
```

## Running Jmeter for performance Test

Extract the file from `src/test/JmeterTest` and open `.jmx file`  on Apache Jmeter
Note: Make sure to change the path of `csv file` in Apache Jmeter inside second script 
- Check the `GetCountryInfo script`
- Under `GetCountryInfo script` go to  `CSV Data Set Config`
- Inside `CSV Data Set Config` see the `Filename placholder`
- Click on `Browse`
- Change the path
