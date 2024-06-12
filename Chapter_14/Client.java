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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Client {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendMessage(String message) throws IOException {
        out.println(message);
    }

    public String receiveMessage() throws IOException {
        return in.readLine();
    }

    public void close() throws IOException {
        socket.close();
        out.close();
        in.close();
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 12345);

        // Получить список клиентов
        client.sendMessage("GET_CLIENTS");
        String clients = client.receiveMessage();
        List<String> clientList = List.of(clients.split(","));

        // Выбрать клиента из списка
        System.out.println("Список клиентов:");
        for (int i = 0; i < clientList.size(); i++) {
            System.out.println((i + 1) + ". " + clientList.get(i));
        }
        int choice = Integer.parseInt(client.receiveMessage()) - 1;

        // Отправить сообщение выбранному клиенту
        System.out.println("Введите сообщение для отправки:");
        String message = client.receiveMessage();
        client.sendMessage("SEND_MESSAGE " + clientList.get(choice) + " " + message);

        // Получить ответ
        String response = client.receiveMessage();
        System.out.println("Ответ от клиента: " + response);

        client.close();
    }
}