Feature: Login Page feature
  Scenario: Login Page title
    Given User is on Login Page
    When User gets Page title
    Then Page title should be "Account"

  Scenario: Forgot your password link
    Given User is on Login Page
    Then Forgot password link is displayed

  Scenario: Login with correct credentials
    Given User is on Login Page
    When User enters email "innajatsuk@i.ua"
    And User enters password "123fghQWE"
    And User clicks Sign in button
    Then User gets Page title
    And Page title should be "Account"