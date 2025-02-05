Feature: Onboarding
  Scenario: Register

    Given the user is on the home page
    When the user clicks on the accounts link
    * the user enters a username
    * the user enters an email address
    * the user enters a password
    * the user clicks on the register button
    Then the user should be registered and navigated to the dashboard