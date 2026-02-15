Feature: API Health Check
  As a QA engineer
  I want to validate API availability
  So that I can trust downstream API tests

  Scenario: API returns 200 for health-like endpoint
    When user sends GET request to "/status/200"
    Then api response status code should be 200
