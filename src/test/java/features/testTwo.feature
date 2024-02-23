@Sanity
Feature: Verify Contact

Scenario Outline: Contact Us
    Given Open website
    When Click on Contact
    Then add <name> <email> <subject> & other details
    Then take screenshot2
    
Examples:
|name|email|subject|
|user1|user1@gmail.com|user1|
|user2|user2@gmail.com|user2|