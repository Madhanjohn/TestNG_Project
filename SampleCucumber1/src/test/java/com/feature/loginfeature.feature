Feature: User Launch All Ecommerce website

Background: Welcome Message Print in Console
Given Print welcome msg in console

@amazon
Scenario Outline: Launch Amazon website  
When User Enter urlname in address bar "<urlname>"
When User Enter username and password
Then User Enter Flipcart homepage
Examples:
|urlname|
|https://www.amazon.in/|


@firstcry
Scenario Outline:Launch Firstcry application
When User enter urlname in address bar "<urlName>"
Then User enter the product in search option
Examples:
|urlName|
|https://www.firstcry.com/|

@lic
Scenario Outline:Launch lic application
When User enter urlname in address bar "<urlname>"
Then User enter the product in search option
Examples:
|urlname|
|https://licindia.in/|
