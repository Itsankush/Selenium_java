Feature: Login Action

@DDTDataTable
Scenario: Successful Login with Valid Credentials
	Given User is on input Page
	When User enters input
	|a1000|
	|b2000|
	|c3000|
	Then Success
