package socialnetwork;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Stepdefs {
    public List <TimeLine> theTimeLine = new ArrayList<>();
    private TimeLineH2Dao h2Conn = new TimeLineH2Dao();

    @Given("user {string} exists")
    public void userExistsAndPostsMessage(String arg0) {
        h2Conn.checkIfUserExists(arg0);
    }

    @When("{string} posts {string}")
    public void posts(String arg0, String arg1) {
        h2Conn.publish(new TimeLine(arg0, arg1));
    }

    @Then("the post should be published on {string}'s timeline")
    public void thePostShouldBePublishedOnPersonalTimeline(String arg0) {
        assertEquals(List.of("Hello world"), h2Conn.showTimeLine(arg0));
        System.out.println("\n- - - - - - - S C E N A R I O - 1 - - - - - - -");
        System.out.println(h2Conn.showTimeLine(arg0).get(0));
    }

    @When("{string} posts {string} and {string}")
    public void postsAnd(String arg0, String arg1, String arg2) {
        h2Conn.publish(new TimeLine(arg0, arg1));
        h2Conn.publish(new TimeLine(arg0, arg2));
    }

    @Then("the posts should be published on {string}'s timeline")
    public void thePostsShouldBePublishedOnPersonalTimeline(String arg0) {
        assertEquals(List.of("Hello world", "I'm happy today", "What are you doing?"), h2Conn.showTimeLine(arg0));
        System.out.println("\n- - - - - - - S C E N A R I O - 2 - - - - - - -");
        System.out.println(h2Conn.showTimeLine(arg0).get(0));
        System.out.println(h2Conn.showTimeLine(arg0).get(1));
    }

    @Given("user {string} and {string} exists")
    public void bobWantsToReadAliceSTimeline(String arg0, String arg1) {
        h2Conn.checkIfUserExists(arg0);
        h2Conn.checkIfUserExists(arg1);
    }

    @When("{string} enters {string}'s timeline")
    public void entersSTimeline(String arg0, String arg1) {
    }

    @Then("he should see all the published messages from {string}")
    public void heShouldSeeAllThePublishedMessages(String arg0) {
        assertEquals(List.of("Hello world", "I'm happy today", "What are you doing?"), h2Conn.showTimeLine(arg0));
        System.out.println("\n- - - - - - - S C E N A R I O - 3 - - - - - - -");
        System.out.println((arg0 + "'s Timeline ").toUpperCase());
        System.out.println(h2Conn.showTimeLine(arg0).get(0));
        System.out.println(h2Conn.showTimeLine(arg0).get(1));
        System.out.println(h2Conn.showTimeLine(arg0).get(2));
    }

    @Given("user {string}, {string} and {string} exists")
    public void checkThreeUsers(String arg0, String arg1, String arg2) {
        h2Conn = new TimeLineH2Dao();
        h2Conn.checkIfUserExists(arg0);
        h2Conn.checkIfUserExists(arg1);
        h2Conn.checkIfUserExists(arg2);
    }
    @When("{string} subscribes to the timelines for {string} and {string}")
    public void subscribesToAnd(String arg0, String arg1, String arg2) {
        h2Conn.subscribe(arg0, arg1);
        h2Conn.subscribe(arg0, arg2);
    }

    @Then("it will return an aggregated list of subscriptions for {string}")
    public void itWillReturnAnAggregatedListOfSubscriptions(String arg0) {
       assertEquals(List.of("Alice", "Bob"), h2Conn.following(arg0) );
       System.out.println("\n- - - - - - - S C E N A R I O - 4 - - - - - - -");
       System.out.print("You are following: ");
       System.out.println(h2Conn.following(arg0));
    }

    @When("{string} posts a message containing @{string}")
    public void postsAMessageContaining(String arg0, String arg1) {
        h2Conn.publish(new TimeLine(arg0,"My best friend is @"+arg1));
    }

    @Then("{string}s post should include a link to {string}")
    public void thePostShouldIncludeALinkTo(String arg0, String arg1) {
        assertTrue(h2Conn.showTimeLine(arg0).toString().contains("@"+arg1));
        System.out.println("\n- - - - - - - S C E N A R I O - 5 - - - - - - -");
        System.out.println(h2Conn.showTimeLine(arg0).get(0));
    }

}
