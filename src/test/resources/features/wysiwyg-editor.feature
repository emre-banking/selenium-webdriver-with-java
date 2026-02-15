Feature: WYSIWYG Editor
  As a user
  I want to edit text in WYSIWYG editor
  So that I can validate editor interactions

  Scenario: Edit text in WYSIWYG editor
    Given user is on home page
    When user updates wysiwyg editor text to "TAU rocks!"
    Then wysiwyg editor should show text "TAU rocks!"
