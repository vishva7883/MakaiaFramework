Feature: Login for LeafTaps
Scenario: Login Positive
Given open the browser
And launch the url as http://leaftaps.com/opentaps
And set the timeouts
And maximize the browser
And enter the user name as DemoSalesManager
And enter the password as crmsfa
And click Login
And click crmsfa
And click Leads module
And click Create Lead
And enter Company Name as CTS
And enter First Name as vishnu
And enter Last Name as prabhu
When click Submit
Then lead should be created