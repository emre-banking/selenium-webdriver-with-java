Feature: Dynamic Loading
  As a user
  I want to wait for dynamic content
  So that I can verify loaded text

  Scenario: Content appears after loading is done
    Given user is on home page
    When user starts dynamic loading example 1
    Then loaded text should be "Hello World!"
