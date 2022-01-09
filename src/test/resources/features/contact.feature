Feature: Contact
  As a user I should be able to fill out the contact form at the ProdigyLabs
#  Used Cucumber BDD framework structure to improve the reuse-ability of the test scenarios and
#  makes it accessible by both technical and non technical individuals.
  Background:
    Given user navigates to the homepage
    Then verify that Contact link is available on the page
    When user clicks the on Contact link

  Scenario: Check that user can see that contact email and address
    Then verify  contact email is "info@prodigylabs.net"
    Then verify  office address  is "80 Richmond St. West, Suite 1401 Toronto, ON"

  Scenario: User enters an invalid email then error message is displayed
    When user fills the form with random valid information
    And user enter invalid email address
    Then verify that error message "Email must be formatted correctly." is displayed

  Scenario: User enters all random valid information
    When user fills the form with random valid information
    And user enter valid email address
    And user selects Industry as "Banking" from the dropdown
    And user enters City as "Toronto"
    And user clicks submit the form


#  Following test scenario/case is structured the way it requested in the assignment document. Please uncomment and run.

#  Scenario: Check that user can fill out the contact form
#    Then verify  contact email is "info@prodigylabs.net"
#    Then verify  office address  is "80 Richmond St. West, Suite 1401 Toronto, ON"
#    When user fills the form with random valid information
#    And user enter invalid email address
#    Then verify that error message "Email must be formatted correctly." is displayed
#    And user enter valid email address
#    And user selects Industry as "Banking" from the dropdown
#    And user enters City as "Toronto"
#    And user clicks submit the form




