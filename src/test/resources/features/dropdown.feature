Feature: Dropdown
  As a user
  I want to select an option from dropdown
  So that the selected value is reflected correctly

  Scenario Outline: Select option from dropdown
    Given user is on home page
    When user selects dropdown option "<option>"
    Then only one dropdown option should be selected
    And selected dropdown option should be "<option>"

    Examples:
      | option   |
      | Option 1 |
      | Option 2 |
