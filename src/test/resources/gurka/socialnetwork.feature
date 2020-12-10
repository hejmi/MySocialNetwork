Feature: Social Networking is fun

  Scenario: A user can post a message to personal timeline
    Given posting to personal timeline
    When "Alice" posts "Hello world"
    Then the post should be published on personal timeline

  Scenario: A user can post two messages to personal timeline
    Given posting two messages to personal timeline
    When "Alice" posts "Hello world" and "I'm happy today"
    Then the posts should be published on personal timeline

  Scenario: A user wants to read another users timeline
    Given Bob wants to read Alice's timeline
    When "Bob" enters "Alice"'s timeline
    Then he should see all the published messages

   Scenario: Following another user
     Given A user wants to follow another user
     When "Charlie" subscribes to "Alice" and "Bob"
     Then it will return an aggregated list of subscriptions for "Charlie"