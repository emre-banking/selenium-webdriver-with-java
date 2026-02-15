Feature: Hover
  As a user
  I want to hover over figures
  So that I can verify user captions

  Scenario: Verify user1 caption on hover
    Given user is on home page
    When user hovers over figure 1
    Then hovered figure caption should be:
      | title      | linkText     | linkEnding |
      | name: user1| View profile | /users/1   |
