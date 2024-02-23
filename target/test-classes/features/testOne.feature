@Smoke
Feature: Verify blog
  @Smoke1
  Scenario: Post comment on blog
    Given Open website
    When Click on Blog
    Then Go to java-interview-questions blog and add comment
    Then take screenshot1
    Then close
  
  @Smoke2  
  Scenario: Post comment on blog
    Given Open website
    When Click on Blog
    Then Go to Appium tutorial - An Introduction blog and add comment
    Then take screenshot3
    Then close