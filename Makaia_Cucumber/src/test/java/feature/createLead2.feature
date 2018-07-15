@smoke
Feature: Login for LeafTaps

Background:
Given open the browser
And launch the url as http://leaftaps.com/opentaps
And set the timeouts
And maximize the browser
And enter the user name as DemoSalesManager
And enter the password as crmsfa
And click Login
And click crmsfa

@sanity
Scenario Outline: Login Negative
Given click Leads module
And click Create Lead
And enter Company Name as <cname>
And enter First Name as <fname>
And enter Last Name as <lname>
When click Submit
But lead should NOT be created 

Examples:
|cname|fname|lname|
|CTS||prabhu|


@sanity
Scenario Outline: Login Positive
Given click Leads module
And click Create Lead
And enter Company Name as <cname>
And enter First Name as <fname>
And enter Last Name as <lname>
When click Submit
Then lead should be created

Examples:
|cname|fname|lname|
|CTS|vishnu|prabhu|
|Wipro|satya|moorty|

