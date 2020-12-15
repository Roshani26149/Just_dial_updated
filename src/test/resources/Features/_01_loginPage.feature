# Auther: Roshani Mendhe
#Institute: Vision IT
#Batch-09
#Feature: Login Related Functionality


Feature: Just Dial Application User stories Journeys

  Background: 
    Given User navigates to the application url

  Scenario: User is able to Sign up in the application
    When User clicks on Sign up link at the top right corner of the application
    And User enters name as "Roshani" and Phone number as "9511824982" and clicks on Submit Button
    Then User is displayed with the message as "OTP is sent on number"

  #Negative Scenario, to check error messages thrown by application
  Scenario Outline: User receives an error message when tries to enter incorrect mobile number in the Login pop up
    When User clicks on Login-in link at the top right corner of the application
    And User enters name as "<Name>" and Phone number "<Mobile>" and clicks on Submit Button
    Then User gets error message

    Examples: 
      | Name    | Mobile     |
      | Roshani | 1234567890 |
      |         |            |

 
  Scenario: 4. User is able to enter only 10 digits in the Mobile Text box
    When User clicks on Login-in link at the top right corner of the application
    Then User is able to enter only "10" digits in the Mobile text field
