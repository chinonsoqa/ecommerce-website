Feature: User Login
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid email and password
    And clicks the "Login" button
    Then the user should be redirected to the dashboard
    And should see a welcome message