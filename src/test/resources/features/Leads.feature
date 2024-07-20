Feature: Leads functionality

@test1
Scenario: Create new lead with all mandatory data TC01
Given user should be on login page
When user enters valid credentials
And click on Login button
When user click on new lead
And fill all mandatory data and click on Save button
Then lead should create sucessfully.

Scenario: Create new lead with all mandatory data TC02
Given user should be on login page
When user enters valid credentials
And click on Login button
When user click on new lead
And fill all mandatory data and click on Save button
Then lead should create sucessfully.


@multiple__lead
Scenario: Create multiple lead with all mandatory data
Given user should be on login page
When user enters valid credentials
And click on Login button
When user creates multiple lead with "<lastname>" and company "<company>" and verified
|lastname | company |
|Mali     | HDFC    |
|Rai      | IDBI    |
|Ghevare  | RBI     |

And Click on logout