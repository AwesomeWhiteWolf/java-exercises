/*
Унагаев Егор Б763-2
В каждом из заданий необходимо выполнить следующие действия:
• организацию соединения с базой данных вынести в отдельный класс, метод
которого возвращает соединение;
• создать БД. Привести таблицы к одной из нормальных форм;
• создать класс для выполнения запросов на извлечение информации из БД
с использованием компилированных запросов;
• создать класс на модификацию информации.
Видеотека. В БД хранится информация о домашней видеотеке: фильмы,
актеры, режиссеры.
Для фильмов необходимо хранить:
• название;
• имена актеров;
• дату выхода;
• страну, в которой выпущен фильм.
• Для актеров и режиссеров необходимо хранить:
• ФИО;
• дату рождения.
• Найти все фильмы, вышедшие на экран в текущем и прошлом году.
• Вывести информацию об актерах, снимавшихся в заданном фильме.
• Вывести информацию об актерах, снимавшихся как минимум в N фильмах.
• Вывести информацию об актерах, которые были режиссерами хотя бы одного из фильмов.
• Удалить все фильмы, дата выхода которых была более заданного числа лет
назад.
*/
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        // Find all films released in current and last year
        List<Film> films = Query.findFilmsReleasedInCurrentAndLastYear(connection);
        System.out.println("Films released in current and last year:");
        for (Film film : films) {
            System.out.println(film);
        }

        // Find all actors in a given film
        int filmId = 1;
        List<Actor> actors = Query.findActorsInFilm(connection, filmId);
        System.out.println("Actors in film with ID " + filmId + ":");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        // Find all actors who have been in at least N films
        int n = 2;
        List<Actor> actorsInAtLeastNFilms = Query.findActorsInAtLeastNFilms(connection, n);
        System.out.println("Actors who have been in at least " + n + " films:");
        for (Actor actor : actorsInAtLeastNFilms) {
            System.out.println(actor);
        }

        // Find all actors who are also directors
        List<Actor> actorsWhoAreAlsoDirectors = Query.findActorsWhoAreAlsoDirectors(connection);
        System.out.println("Actors who are also directors:");
        for (Actor actor : actorsWhoAreAlsoDirectors) {
            System.out.println(actor);
        }

        // Delete all films released more than a certain number of years ago
        int yearsAgo = 5;
        Modification.deleteFilmsReleasedBeforeDate(connection, yearsAgo);
        System.out.println("Deleted all films released more than " + yearsAgo + " years ago");

        connection.close();
    }
}