Feature: edit an existing Lead

Scenario: Edit lead - Positive scenario

Given click Leads module
And click Find Leads link
And click Find Leads by Phone link
And enter Phone Number
And click Search Leads button
And click first lead id link from from the search result
And click first lead from the search result
And click Edit Lead button
And change Company Name 
When click Update button
Then Lead should be updated. 

