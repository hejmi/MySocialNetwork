Feature: Social Networking is fun

  Scenario: A user can post a message to personal timeline
    Given posting to personal timeline
    When "Alice" posts "Hello world"
    Then the post should be published on personal timeline

  Scenario: A user can post two messages to personal timeline
    Given posting two messages to personal timeline
    When "Alice" posts "Hello world" and "I'm happy today"
    Then the posts should be published on personal timeline