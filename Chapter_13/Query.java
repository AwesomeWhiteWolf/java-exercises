import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Query {

    public static List<Film> findFilmsReleasedInCurrentAndLastYear(Connection connection) throws SQLException {
        String sql = "SELECT * FROM films WHERE release_date >= date('now', '-1 year')";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        List<Film> films = new ArrayList<>();
        while (resultSet.next()) {
            films.add(new Film(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getDate("release_date"),
                    resultSet.getString("country")
            ));
        }

        return films;
    }

    public static List<Actor> findActorsInFilm(Connection connection, int filmId) throws SQLException {
        String sql = "SELECT a.* FROM actors a JOIN film_actors fa ON a.id = fa.actor_id WHERE fa.film_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, filmId);
        ResultSet resultSet = statement.executeQuery();

        List<Actor> actors = new ArrayList<>();
        while (resultSet.next()) {
            actors.add(new Actor(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("birthdate")
            ));
        }

        return actors;
    }

    public static List<Actor> findActorsInAtLeastNFilms(Connection connection, int n) throws SQLException {
        String sql = "SELECT a.* FROM actors a JOIN film_actors fa ON a.id = fa.actor_id GROUP BY a.id HAVING COUNT(*) >= ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, n);
        ResultSet resultSet = statement.executeQuery();

        List<Actor> actors = new ArrayList<>();
        while (resultSet.next()) {
            actors.add(new Actor(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("birthdate")
            ));
        }

        return actors;
    }

    public static List<Actor> findActorsWhoAreAlsoDirectors(Connection connection) throws SQLException {
        String sql = "SELECT a.* FROM actors a JOIN directors d ON a.name = d.name";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet res
        ultSet = statement.executeQuery();

        List<Actor> actors = new ArrayList<>();
        while (resultSet.next()) {
            actors.add(new Actor(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("birthdate")
            ));
        }

        return actors;
    }
}
