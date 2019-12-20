package taskChat;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable{

        private Socket socket;
        //не понял почему socket не используется. я же передаю его в конструкторе при запуске соединения
        private ObjectOutputStream out;
        private ObjectInputStream in;

        public Connection(Socket socket) throws IOException {
            this.socket = socket;
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        }

        public void sendMessage(Message message) throws IOException {
            out.writeObject(message);
            out.flush();
        }
        public Message readMessage() throws IOException, ClassNotFoundException {
            return (Message) in.readObject();
        }

        @Override
        public void close() throws Exception {
            in.close();
            out.close();
        }

    }

