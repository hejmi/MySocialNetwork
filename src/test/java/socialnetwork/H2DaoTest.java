package socialnetwork;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class H2DaoTest {
    @Test
    void testingDbConnection() {
        TimeLineH2Dao h2Conn = new TimeLineH2Dao();
        h2Conn.publish(new TimeLine("Alice", "Hello World"));
        h2Conn.publish(new TimeLine("Alice", "I'm happy today"));
        assertEquals(List.of("Hello World", "I'm happy today"), h2Conn.showTimeLine("Alice"));
    }
}
