Feature: Login
  As a valid user
  I want to login to the secure area
  So that I can access protected pages

  Scenario: Successful login with valid credentials
    Given user is on home page
    When user logs in with valid credentials
    Then user should see secure area success message
