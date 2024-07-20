Feature: login functionality

Background: 
Given user should be on login page

Scenario: Valid login

When user enters valid credentials
And click on Login button
Then user should be navigated to home page
And user can click logout link

Scenario Outline: Invalid login

When user enters userid as "<userid>" and password as "<password >" credentials
And click on Login button
Then validate error message on login page
Examples:
|userid | password |
|admin1 | pwd1     |
|admin2 | pwd2     |
|admin3 | pwd3     |
