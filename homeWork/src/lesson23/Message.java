package lesson23;

/*
сообщения передаются между клиентом и сервером.
клиент создаёт сообщение в консоли, просим имя и текст, и передаём на сервер
сервер получает, и рассылает всем клиентам, исключая отправителя
сервер держит соединения пока клиент есть, клиент отключается - удаляем соединение.

*/


public class Message {
    private String name;
    private String text;

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }
}
