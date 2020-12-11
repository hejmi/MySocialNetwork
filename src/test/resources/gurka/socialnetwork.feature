Feature: Social Networking is fun

  Scenario: A user can post a message to personal timeline
    Given user "Alice" exists
    When "Alice" posts "Hello world"
    Then the post should be published on "Alice"'s timeline

  Scenario: A user can post two messages to personal timeline
    Given user "Alice" exists
    When "Alice" posts "I'm happy today" and "What are you doing?"
    Then the posts should be published on "Alice"'s timeline

  Scenario: A user wants to read another users timeline
    Given user "Bob" and "Alice" exists
    When "Bob" enters "Alice"'s timeline
    Then he should see all the published messages from "Alice"

   Scenario: Following another user
     Given user "Charlie", "Alice" and "Bob" exists
     When "Charlie" subscribes to the timelines for "Alice" and "Bob"
     Then it will return an aggregated list of subscriptions for "Charlie"

   Scenario: Mentions of another user on personal timeline
     Given user "Bob" and "Charlie" exists
     When "Bob" posts a message containing @"Charlie"
     Then "Bob"s post should include a link to "Charlie"