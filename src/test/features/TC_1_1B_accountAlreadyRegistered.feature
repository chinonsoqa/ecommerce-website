Feature: Onboarding
  Scenario: Verify already registered account

    Given the user has completed the signup form
    When the user clicks on the submit button
    Then the user should get an error message