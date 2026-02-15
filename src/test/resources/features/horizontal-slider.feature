Feature: Horizontal Slider
  As a user
  I want to move horizontal slider
  So that expected value is displayed

  Scenario: Move slider to value 3
    Given user is on home page
    When user moves horizontal slider right by 6 steps
    Then horizontal slider value should be "3"
