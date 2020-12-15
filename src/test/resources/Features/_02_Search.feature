# Auther: Roshani Mendhe
#Institute: Vision IT
#Batch-09
#Feature: Login Related Functionality

Feature: Search Functionality

  Background: 
    Given User navigates to the application url

  Scenario: 5. User is able to search the Application
    When User enters "restaurants" in search text box
    And User clicks search button
    Then User is able to see search result related to "restaurants"

  # Hint: Use Fluent Wait to wait in the Then Step to wait for drop down to appear
  Scenario: 6. User is able to see the drop down when he keys in the text in the search box
    When User enters a "resta" in search text box
    Then User is able to see the drop down under search text box with all the items with text "resta"
