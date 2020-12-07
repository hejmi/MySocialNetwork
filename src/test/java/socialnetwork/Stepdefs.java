package socialnetwork;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class Stepdefs {
    public List <TimeLine> theTimeLine = new ArrayList<>();

    @Given("posting to personal timeline")
    public void postingToPersonalTimeline() {
        //timeLine = new TimeLine();
    }

    @When("{string} posts {string}")
    public void posts(String arg0, String arg1) {
        theTimeLine.add(new TimeLine(arg0, arg1));

    }

    @Then("the post should be published on personal timeline")
    public void thePostShouldBePublishedOnPersonalTimeline() {
        assertEquals("Hello world", theTimeLine.get(0).postedmessage);
        assertEquals("Alice", theTimeLine.get(0).username);
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
}
