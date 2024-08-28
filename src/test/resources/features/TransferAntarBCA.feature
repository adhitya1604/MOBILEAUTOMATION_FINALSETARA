Feature: transferBCA
Scenario: User logs in and makes a transfer
Given user logs in with "ADTP604T" and "andika12345"
Then user sees the dashboard and checks saldo
When user transfers "1000" to "3344556677"
Then user confirms the details and enters PIN "120951"
Then the transfer is successful
