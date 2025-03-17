Feature: Login Validation

Scenario: Login with valid credentials
  #Step 1: Login with valid user, validate user is redirected to inventory page
  Given user navigates to the login page
  When on login page user enters valid credentials and clicks login
  Then user is redirected to the inventory page
