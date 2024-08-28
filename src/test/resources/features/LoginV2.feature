Feature: User Login Verification

  Scenario: User logs in and verifies the dashboard text
    Given user sudah pernah login dan user dihalaman login
    When the user enters a valid password and clicks the "Login" button
    Then the user should see the dashboard with the text "Halo, Andhika Putra!"

  Scenario: User logs in with an invalid password
    Given user sudah pernah login dan user dihalaman login
    When the user enters an invalid password and clicks the "Login" button
    Then the user should see an error message "Password yang dimasukkan salah"
