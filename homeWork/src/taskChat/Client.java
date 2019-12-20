package taskChat;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        boolean work = true;
        try (InputStream inputStream = Client.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            String server = properties.getProperty("server");//"127.0.0.1";
            int port = Integer.parseInt(properties.getProperty("port")); //8090

            System.out.println("Введите имя");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            String text;
            Connection connection = new Connection(new Socket(server, port));
            Thread read = new Thread(new ReadMessage(connection));
            read.start();

            while (work) {
                if (work) {
                    //двойная проверка. чтоб при завершении потока не запрашивал ещё одно сообщения.
                    //не обязательно, но показалось полн
                    System.out.println("Введите сообшение:");
                    text = scanner.nextLine();
                    Message message = new Message(text, name);
                    connection.sendMessage(message);
                }
            }
        } catch (IOException e) {
            // e.printStackTrace();
            work = false;
            //вот бы понять почему среда считает почему work не используется
            System.out.println("соединение с сервером потеряно");
        }
    }

    private static class ReadMessage implements Runnable {
        Connection connection;
        boolean work = true;

        public ReadMessage(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (work) {
                try {
                    if (work) {
                        System.out.println(connection.readMessage());
                    }
                } catch (IOException | ClassNotFoundException e) {
                    //  e.printStackTrace();
                    work = false;
                    System.out.println("соединение с сервером потеряно");

                }
            }
        }
    }
}
