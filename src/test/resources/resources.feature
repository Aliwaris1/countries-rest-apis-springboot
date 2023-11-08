#Author: Ali.waris3755@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Fetch the countries

  @tag1
  Scenario Outline: Retrieve a list of all countries
    Given the Country Service is running
    When I request the list of countries
    Then I should receive a list of all countries
    Examples:
      | url        | http |  |
      | /countries | 200  |  |



  @tag2
  Scenario Outline: Retrieve Country information
    Given the Country Service is running
    When I request the country name "<countryName>"
    Then I should receive a country info successfully

    Examples:
      | countryName |  |
      | Pakistan    |  |
      | Finland     |  |
      | United      |  |
      | fin         |  |

