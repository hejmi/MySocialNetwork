package socialnetwork;

import java.util.List;

public interface TimeLineDao {
    List<TimeLine> allPosts();

    void publish(TimeLine post);

    List<String> showTimeLine(String username);

    void close();
}
