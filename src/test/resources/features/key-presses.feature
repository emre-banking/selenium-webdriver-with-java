Feature: Key Presses
  As a user
  I want to press keys in input field
  So that key press result can be validated

  Scenario: Backspace key press is captured
    Given user is on home page
    When user enters backspace key sequence in key presses input
    Then key press result should be "You entered: BACK_SPACE"
