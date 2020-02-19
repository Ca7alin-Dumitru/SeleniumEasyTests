Feature: [Feature 2] Charts Demo page

Scenario Outline: [Scenario 1] Verification of the Charts Demo page on different browsers
Given I have <browsers> browser
When I open the Others menu
And The drop down displays me a Charts Demo button
Then I click on the Charts Demo button
And The url is changed with https://www.seleniumeasy.com/test/charts-mouse-hover-demo.html

Examples:
        | browsers  |
        | chrome    |
        | firefox   |

