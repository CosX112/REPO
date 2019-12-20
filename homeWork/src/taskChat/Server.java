package taskChat;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Server {


    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();  //пул. просто потому что так удобнее запускать потоки.
        LinkedBlockingDeque<taskChat.Message> messages = new LinkedBlockingDeque<>();
        //коллекция для хранения сообщений
        LinkedBlockingDeque<Connection> connections = new LinkedBlockingDeque<>();
        //коллекция для хранения соединений

        try (InputStream inputStream = Server.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            int port = Integer.parseInt(properties.getProperty("port"));
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Cокет открыт");
            pool.execute(new WriteMessage(connections, messages));
            //серверный сокет открывается один раз. Запускаем поток рассылки сообщений.

            while (true) {
                Socket socket = serverSocket.accept();
                //ждём соединения с серверным сокетом. как только он создан - отдаём соединение в класс соединений.
                //заодно закидываем это соединение в коллекцию(для рассылки сообщений)
                Connection connection = new Connection(socket);
                connections.put(connection);
                //  System.out.println(connection);
                pool.execute(new ReadMessage(connection, messages));
                //и так как это цикл - создаём новый поток для чтения с конкретного соединения клиента
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static class ReadMessage implements Runnable {
        Connection connection;
        LinkedBlockingDeque<taskChat.Message> messages;
        boolean work = true;

        public ReadMessage(Connection connection, LinkedBlockingDeque<taskChat.Message> messages) {
            this.connection = connection;
            this.messages = messages;
        }

        @Override
        public void run() {
            while (work) {
                try {
                    taskChat.Message message = connection.readMessage();
                    System.out.println(message);
                    message.setId(connection.toString());
                    messages.put(message);
                } catch (IOException | ClassNotFoundException | InterruptedException e) {
                    //  e.printStackTrace();
                    //закоментил чтоб не сыпало мусор в консоль. но меняю флаг работы для завершения этого потока
                    //при отключении потока
                    work = false;
                    // System.out.println("соедиение " + connection + " закрыто");

                }
            }
        }
    }

    private static class WriteMessage implements Runnable {
        LinkedBlockingDeque<Connection> connections;
        LinkedBlockingDeque<Message> messages;
        boolean work = true;


        public WriteMessage(LinkedBlockingDeque<Connection> connections, LinkedBlockingDeque<Message> messages) {
            this.connections = connections;
            this.messages = messages;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Message message = messages.take();
                    //забираем сообщение из коллекции сообщений
                    for (Connection c : connections) {
                        //перебираем коллекцию сообщений чтоб отправить сообщение всем
                        if (!c.toString().equals(message.getId())) {
                            //сравниваем ID из сообщения(я добавил ещё одно поле в сообщение, и сделал дополнительный
                            // геттер и сеттер)
                            c.sendMessage(message);
                            //рассылаем сообщение всем
                        }
                    }
                }
            } catch (InterruptedException | IOException e) {
                // e.printStackTrace();
                work = false;
            }


        }
    }

}
