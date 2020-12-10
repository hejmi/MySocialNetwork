Feature: Social Networking is fun

  Scenario: A user can post a message to personal timeline
    Given user "Alice" exists and posts one message
    When "Alice" posts "Hello world"
    Then the post should be published on "Alice"'s timeline

  Scenario: A user can post two messages to personal timeline
    Given posting two messages to personal timeline
    Given user "Alice" exists and posts 2 messages
    When "Alice" posts "Hello world" and "I'm happy today"
    Then the posts should be published on personal timeline

  Scenario: A user wants to read another users timeline
    Given Bob wants to read Alice's timeline
    Given user "Bob" exists and reads "Alice"s timeline
    When "Bob" enters "Alice"'s timeline
    Then he should see all the published messages from "Alice"

   Scenario: Following another user
     Given A user wants to follow another user
     Given user "Charlie" is following "Alice" and "Bob"
     When "Charlie" subscribes to the timelines for "Alice" and "Bob"
     Then it will return an aggregated list of subscriptions for "Charlie"

   Scenario: Mentions of another user on personal timeline
     Given user "Bob" links to "Charlie" in a post
     When "Bob" posts a message containing @"Charlie"
     Then "Bob"s post should include a link to "Charlie"