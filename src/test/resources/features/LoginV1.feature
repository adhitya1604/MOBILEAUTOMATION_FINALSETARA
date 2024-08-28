Feature: LoginV1

  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And the user clicks the "Login" button
    Then the user should be logged in

  Scenario: User tries to log in with an invalid password
    Given the user is on the login page
    When the user enters a valid username and an invalid password
    And the user clicks the "Login" button
    Then the user should see an error message "Password yang dimasukkan salah"