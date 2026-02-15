Feature: JavaScript Alerts
  As a user
  I want to interact with JavaScript alerts
  So that I can validate alert behaviors

  Scenario: Accept JS Alert successfully
    Given user is on home page
    When user accepts javascript alert
    Then user should see alert result text "You successfully clicked an alert"

  Scenario: Dismiss JS Confirm and verify its text
    Given user is on home page
    When user dismisses javascript confirm with expected text "I am a JS Confirm"
    Then javascript confirm text should be verified

  Scenario: Accept JS Prompt with input
    Given user is on home page
    When user accepts javascript prompt with input "hello from cucumber"
    Then user should see alert result text "You entered: hello from cucumber"
