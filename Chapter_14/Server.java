import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private ServerSocket serverSocket;
    private List<ClientHandler> clients;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clients = new ArrayList<>();
    }

    public void start() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            clients.add(clientHandler);
            clientHandler.start();
        }
    }

    public void close() throws IOException {
        serverSocket.close();
        for (ClientHandler clientHandler : clients) {
            clientHandler.close();
        }
    }

    private class ClientHandler extends Thread {

        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = in.readLine();
                    if (message == null) {
                        break;
                    }

                    if (message.startsWith("GET_CLIENTS")) {
                        // Отправить список клиентов
                        StringBuilder clientList = new StringBuilder();
                        for (ClientHandler client : clients) {
                            clientList.append(client.getName()).append(",");
                        }
                        out.println(clientList.toString());
                    } else if (message.startsWith("SEND_MESSAGE")) {
                        // Отправить сообщение другому клиенту
                        String[] parts = message.split(" ");
                        String recipientName = parts[1];
                        String messageText = parts[2];

                        ClientHandler recipient = getClientByName(recipientName);
                        if (recipient != null) {
                            recipient.sendMessage(messageText);
                        } else {
                            out.println("Клиент не найден");
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public String getName() {
            return socket.getInetAddress().getHostAddress() + ":" + socket.getPort();
        }

        public void sendMessage(String message) throws IOException {
            out.println(message);
        }

        public void close() throws IOException {
            socket.close();
            out.close();
            in.close();
        }

        private ClientHandler getClientByName(String name) {
            for (ClientHandler client : clients) {
                if (client.getName().equals(name)) {
                    return client;
                }
            }

            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(12345);
        server.start();
    }
}
