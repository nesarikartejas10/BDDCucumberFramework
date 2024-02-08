Feature: Login Functionality for OpenCart E-commerce website

As a user of OpenCart website
I want to be able to login with my account
So that I can access my account related features and manage my orders

Background:
Given I am on the OpenCart login page

Scenario: Successful login with valid credentials
When I have entered valid username and password  
And I click on the login button
Then I should be able to logged in successfuly

Scenario Outline: Unsuccessful login with invalid and empty credentials
When I have entered invalid "<username>" and "<password>"  
And I click on the login button
Then I should see an error message indicating "<error_message>"
 
Examples:
|       username      |  password  |                    error_message                       |
| abc@gmail.com       | abc@123    |  Warning: No match for E-Mail Address and/or Password. |
| xyz@gmail.com       | tejas@1795 |  Warning: No match for E-Mail Address and/or Password. |
| soham.xyz@gmail.com | xyz@2407   |  Warning: No match for E-Mail Address and/or Password. |

Scenario: Navigating to the forgotten password page
When I click on the forgotten password link
Then I should be redirected to the password reset page
