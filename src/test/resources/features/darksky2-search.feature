@dregression @darksky-1 @net @web
Feature: Feature Final Project


  @darksky-1
  Scenario: Verify timline is displayed in correct format
    Given I am on Darksky home page
    Then I verify timeline is displayed with two hours incremented

    @darksky-2

      Scenario: Verify individual day temp timeline
      When I expand todays timeline
      Then I verify lowest and highest temp is displayed correctly