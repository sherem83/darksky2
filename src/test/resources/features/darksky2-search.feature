@dregression @darksky-1 @net @web
Feature: Feature Final Project

  Background:
    Given I am on Darksky home page

  @darksky-1

   Scenario: Verify timline is displayed in correct format
   Then I verify timeline is displayed with two hours incremented

  @darksky-2
   Scenario: Verify individual day temp timeline
   When I expand todays timeline
   Then I verify lowest and highest temp is displayed correctly

  @darksky-3

    Scenario: Verify Time Machine Calendar
    When I click on Time Machine
    Then I verify date is selected to todays date