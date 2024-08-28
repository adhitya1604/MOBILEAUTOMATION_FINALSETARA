Feature: info Saldo
Scenario: User logs in and validates dashboard
Given user is on the login page
When memasukkan username dan password valid
Then menampilkan text "Halo, Andhika Putra!"
And user sees the account number and saldo after clicking "Saldo"
