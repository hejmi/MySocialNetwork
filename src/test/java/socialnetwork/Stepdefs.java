package socialnetwork;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Stepdefs {
    public List <TimeLine> theTimeLine = new ArrayList<>();
    private TimeLineH2Dao h2Conn;

    @Given("user {string} exists and posts one message")
    public void userExistsAndPostsMessage(String arg0) {
        h2Conn = new TimeLineH2Dao();
        h2Conn.checkIfUserExists(arg0);
    }

    @When("{string} posts {string}")
    public void posts(String arg0, String arg1) {
        //theTimeLine.add(new TimeLine(arg0, arg1));
        h2Conn.publish(new TimeLine(arg0, arg1));

    }

    @Then("the post should be published on {string}'s timeline")
    public void thePostShouldBePublishedOnPersonalTimeline(String arg0) {
        //assertEquals("Hello world", theTimeLine.get(0).postedmessage);
        //assertEquals("Alice", theTimeLine.get(0).username);
        assertEquals(List.of("Hello world"), h2Conn.showTimeLine(arg0));
    }

    @Given("posting two messages to personal timeline")
    public void postingTwoMessagesToPersonalTimeline() {
        //timeLine = new TimeLine();
    }

    @When("{string} posts {string} and {string}")
    public void postsAnd(String arg0, String arg1, String arg2) {
        theTimeLine.add(new TimeLine(arg0, arg1));
        theTimeLine.add(new TimeLine(arg0, arg2));
    }

    @Then("the posts should be published on personal timeline")
    public void thePostsShouldBePublishedOnPersonalTimeline() {
        assertEquals("Hello world", theTimeLine.get(0).postedmessage);
        assertEquals("I'm happy today", theTimeLine.get(1).postedmessage);
    }

    @Given("Bob wants to read Alice's timeline")
    public void bobWantsToReadAliceSTimeline() {
        theTimeLine.add(new TimeLine("Alice", "Hello world"));
        theTimeLine.add(new TimeLine("Alice", "I'm happy today"));
    }

    @When("{string} enters {string}'s timeline")
    public void entersSTimeline(String arg0, String arg1) {
    }

    @Then("he should see all the published messages")
    public void heShouldSeeAllThePublishedMessages() {
        assertEquals("Hello world", theTimeLine.get(0).postedmessage);
        assertEquals("I'm happy today", theTimeLine.get(1).postedmessage);
    }

    @Given("A user wants to follow another user")
    public void aUserWantsToFollowAnotherUser() {
        h2Conn = new TimeLineH2Dao();
    }

    @When("{string} subscribes to {string} and {string}")
    public void subscribesToAnd(String arg0, String arg1, String arg2) {
        h2Conn.subscribe(arg0, arg1);
        h2Conn.subscribe(arg0, arg2);
    }

    @Then("it will return an aggregated list of subscriptions for {string}")
    public void itWillReturnAnAggregatedListOfSubscriptions(String arg0) {
       assertEquals(List.of("Alice", "Bob"), h2Conn.following(arg0) );
    }

    @Given("Linking to another user")
    public void linkingToAnotherUser() {
        h2Conn = new TimeLineH2Dao();
    }

    @When("{string} posts a message containing @{string}")
    public void postsAMessageContaining(String arg0, String arg1) {
        h2Conn.publish(new TimeLine(arg0,"My best friend is @"+arg1));
    }

    @Then("{string}s post should include a link to {string}")
    public void thePostShouldIncludeALinkTo(String arg0, String arg1) {
        assertTrue(h2Conn.showTimeLine(arg0).toString().contains("@"+arg1));
    }

}
