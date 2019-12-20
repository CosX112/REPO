package taskChat;

import java.io.Serializable;

public class Message implements Serializable {
    String text;
    String name;
    String id;

    @Override
    public String toString() {
        return "U: '" + name + '\'' + " " + "W: " + text;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Message(String text, String name) {
        this.text = text;
        this.name = name;
    }
}
