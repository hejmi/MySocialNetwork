package socialnetwork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimeLineH2Dao implements TimeLineDao{

    private static Connection conn;

    public TimeLineH2Dao() {
        try {
            if (conn!=null) return;
            conn = DriverManager.getConnection("jdbc:h2:mem:mymemdb.db", "SA", "");
            conn.prepareStatement("CREATE TABLE timelines (user varchar(40), post varchar(255))").execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TimeLine> allPosts() {
        return null;
    }

    @Override
    public void publish(TimeLine post) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO timelines (user, post) values (?,?)");
            ps.setString(1, post.getUser());
            ps.setString(2, post.getPost());

            ps.execute();

            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> showTimeLine(String username) {
        List<String>result = new ArrayList<>();
        try {
            String query = "SELECT * FROM timelines WHERE user = '"+username+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString("post"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void close() {

    }
}
