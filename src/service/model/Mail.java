package service.model;


import java.io.Serializable;
import java.util.Date;

public class Mail implements Serializable {
    private String toEmail;
    private String fromEmail;
    private String message;
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mail mail = (Mail) o;

        if (toEmail != null ? !toEmail.equals(mail.toEmail) : mail.toEmail != null) return false;
        if (fromEmail != null ? !fromEmail.equals(mail.fromEmail) : mail.fromEmail != null) return false;
        if (message != null ? !message.equals(mail.message) : mail.message != null) return false;
        return date != null ? date.equals(mail.date) : mail.date == null;
    }

    @Override
    public int hashCode() {
        int result = toEmail != null ? toEmail.hashCode() : 0;
        result = 31 * result + (fromEmail != null ? fromEmail.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "toEmail='" + toEmail + '\'' +
                ", fromEmail='" + fromEmail + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Mail(String toEmail, String fromEmail, String message, Date date) {

        this.toEmail = toEmail;
        this.fromEmail = fromEmail;
        this.message = message;
        this.date = date;
    }

    public Mail() {

    }
}
