import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Modification {

    public static void deleteFilmsReleasedBeforeDate(Connection connection, int yearsAgo) throws SQLException {
        String sql = "DELETE FROM films WHERE release_date < date('now', '-? years')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, yearsAgo);
        statement.executeUpdate();
    }
}