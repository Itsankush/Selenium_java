Feature: Login Action

@DDTExampleskeyword
Scenario Outline: Successful Login with Valid Credentials
	Given User is on Home Page
	When User enters "<input>"
	Then Message displayed Login Successfully
Examples:
    | input   |
    | 1234 |
    | 5678 |