package lesson14.io.lesson15;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime date;




    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public Message(String sender, String text, LocalDateTime date) {
        this.sender = sender;
        this.text = text;
        this.date = date;
    }
}
