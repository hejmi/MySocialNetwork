package socialnetwork;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;


public class Stepdefs {
    public TimeLine timeLine;

    @Given("posting to personal timeline")
    public void postingToPersonalTimeline() {
        timeLine = new TimeLine();
    }

    @When("{string} posts {string}")
    public void posts(String arg0, String arg1) {
        timeLine.Post(arg0, arg1);

    }

    @Then("the post should be published on personal timeline")
    public void thePostShouldBePublishedOnPersonalTimeline() {
        assertEquals("Hello World", timeLine.getPost());
    }
}
