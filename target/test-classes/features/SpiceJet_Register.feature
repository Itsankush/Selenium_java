@Register
Feature: Registration test
  Here I will check register functionality for my website.

  @Test1
  Scenario: Register user
    Given Open spicejet website
    When I click on signup
    Then I enter all details
    And click on submit
