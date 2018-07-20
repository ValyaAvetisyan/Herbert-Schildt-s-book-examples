package educationCenter.model;

import java.util.Date;

public class Message {
    private String from;
    private String to;
    private String text;
    private Date date;
    private boolean isRead;

    public Message(String from, String to, String text, Date date, boolean isRead) {
        this.from = from;
        this.to = to;
        this.text = text;
        this.date = date;
        this.isRead = isRead;
    }

    public String getFrom() {

        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", isRead=" + isRead +
                '}';
    }
}


