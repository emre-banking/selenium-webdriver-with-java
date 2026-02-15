Feature: Context Menu
  As a user
  I want to use context click on the context menu page
  So that I can see the expected browser alert

  Scenario: Alert text after right-click context menu
    Given user is on home page
    When user opens context menu area with right click
    Then user should see context menu alert text "You selected a context menu"
