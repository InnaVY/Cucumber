Feature: Account Page Feature
  Background:
    Given User is already logged in
    |username|password|
    |innajatsuk@i.ua|123fghQWE|

  Scenario: Account Page Title
    Given User is on Account Page
    When User gets Page title
    Then Page title should be "Account"

  Scenario: Categories count
    Given User is on Account Page
    Then User gets categories
    |New|
    |Coffee|
    |Subscriptions|
    |Locations|
    |Coffee Quiz|
    And Categories count should be 5

