Feature: [Feature 1] Input form with validations

Scenario: [Scenario 1] Verification of the form fields
Given I have chrome browser
When I am on the Input form with validations page
And I fill the form fields with some inputs
Then The fields contains the text inputted

Scenario: [Scenario 2] Verification of the Send button
Given I have chrome browser
When I am on the Input form with validations page
And I fill the form fields with some inputs
Then I click on the Send button

Scenario Outline: [Scenario 3] Verification of the Send button on different browsers
Given I have <browsers> browser
When I am on the Input form with validations page
And I fill the form fields with some inputs
Then I click on the Send button

Examples:
        | browsers  |
        | chrome    |
        | firefox   |