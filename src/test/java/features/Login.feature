Feature: Login functionality

@reg
Scenario: user login wit correct user name and passward

When user enter userName
And user enter passWard
And user click login button
Then Validate Success Login
