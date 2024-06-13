/*
Унагаев Егор Б763-2
Вариант А
Создать на основе сокетов клиент/серверное приложение:
1. Клиент посылает через сервер сообщение другому клиенту, выбранному из
списка.
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
