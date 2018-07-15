Feature: Login for LeafTaps

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

