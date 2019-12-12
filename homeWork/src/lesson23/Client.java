package lesson23;
//в первом потоке сообщения отправляем, в другом принимаем
//main поток - формирование и отправка
//reader поток - формирование и чтение сообщений
/*start - запускает поток ридера, при старте просим имя, текст(в цикле),
рид месседж - другой поток, который будет получать потоки.*/


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private String server;
    private int port;
    private Scanner scanner;

    private Socket socket;
    private ObjectOutputStream out;


    public Client(String server, int port) {
        this.server = server;
        this.port = port;
    }

    public static void main(String[] args) throws IOException {

        try (InputStream inputStream = Client.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            String server = properties.getProperty("server");//"127.0.0.1";
            int port = Integer.parseInt(properties.getProperty("port")); //8090;
            System.out.println(server);


            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя");
            String name = scanner.nextLine();
            String messageText;

            while (true) {
                Message message;
                System.out.println("Введите сообщение");
                messageText = scanner.nextLine();
                try {

                    Client client = new Client(server, port);
                    client.start(new Socket(server, port));
                    client.sendMessage(new Message(name, messageText));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void start(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());

    }

    private void sendMessage(Message message) throws IOException {
        out.writeObject(message);
        out.flush();
    }
}


class ReadMessages implements Runnable {
    private Socket socket;
    private ObjectInputStream in;


    public ReadMessages(Socket socket) throws IOException {
        this.socket = socket;
        in = new ObjectInputStream(this.socket.getInputStream());
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = (Message) in.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
