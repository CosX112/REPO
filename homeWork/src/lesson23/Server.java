package lesson23;
//пишуший поток - отправка сообщений клиентам
//читающий поток - читает сообщения от клиента - на каждое соединение свой поток


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;

public class Server {
    private int port;
    private ReadMessage readMessage;
    private WriteMessage writeMessage;


    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException, InterruptedException {
        /*два потока. здесь слушаем сообщения, здесь в цикле соединения принимаем, поток чтения один, будет смотреть в очередь
         * коллекцию,  */
        Thread read = new Thread(readMessage);
        Thread write = new Thread(writeMessage);
        read.join();
        write.join();
        read.start();
        write.start();
    }


    public static void main(String[] args) {
        int port = 8090;

        Server server = new Server(port);
        try {
            server.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printMessage(Message message) {
        System.out.println("получено сообщение: " + message);
    }

}

class WriteMessage implements Runnable {
    private Socket socket;
    private ObjectOutputStream out;
    LinkedBlockingDeque<Message> messages;


    public WriteMessage(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(this.socket.getOutputStream());
    }

    public void sendMessage(Message message) throws IOException {
        out.writeObject(message);
        out.flush();
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(8090)) {
            System.out.println("Server started...");
            while (true) {
                Socket socket = serverSocket.accept();
                WriteMessage writeMessage = new WriteMessage(socket);
                writeMessage.sendMessage(new Message("server", "сообщение получено"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadMessage implements Runnable {
    private Socket socket;
    private ObjectInputStream in;
    LinkedBlockingDeque<Message> messages;

    public ReadMessage(Socket socket) throws IOException {
        this.socket = socket;
        in = new ObjectInputStream(this.socket.getInputStream());
    }


    public Message readMessage() throws IOException, ClassNotFoundException {
        return (Message) in.readObject();
    }

    @Override
    public void run() {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(8090)) {
                Socket socket = serverSocket.accept();  //вот тут запускаем поток ридер
                ReadMessage message = new ReadMessage(socket);
                messages.put(message.readMessage());
                // а это другой поток. один ридер, много врайтеров
            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}