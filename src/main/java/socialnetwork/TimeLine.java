package socialnetwork;

public class TimeLine {
    public String username, postedmessage;

    public TimeLine (String username, String postedmessage) {
        this.postedmessage = postedmessage;
        this.username = username;
    }

    public String getPost() {
        return "Hello World";
    }

    public String getUser() {
        return "Alice";
    }
}
