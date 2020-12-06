Feature: Social Networking is fun

  Scenario: A user can post a message to personal timeline
    Given posting to personal timeline
    When "Alice" posts "Hello world"
    Then the post should be published on personal timeline