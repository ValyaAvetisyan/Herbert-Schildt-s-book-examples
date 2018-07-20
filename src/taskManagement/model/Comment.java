package taskManagement.model;


import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{
    String text;
    User commentedUser;
    Task task;
    Date commentedDate;

    public Comment() {
    }

    public Comment(String text, User commentedUser, Task task, Date commentedDate) {
        this.text = text;
        this.commentedUser = commentedUser;
        this.task = task;
        this.commentedDate = commentedDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCommentedUser() {
        return commentedUser;
    }

    public void setCommentedUser(User commentedUser) {
        this.commentedUser = commentedUser;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Date getCommentedDate() {
        return commentedDate;
    }

    public void setCommentedDate(Date commentedDate) {
        this.commentedDate = commentedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
        if (commentedUser != null ? !commentedUser.equals(comment.commentedUser) : comment.commentedUser != null)
            return false;
        if (task != null ? !task.equals(comment.task) : comment.task != null) return false;
        return commentedDate != null ? commentedDate.equals(comment.commentedDate) : comment.commentedDate == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (commentedUser != null ? commentedUser.hashCode() : 0);
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (commentedDate != null ? commentedDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", commentedUser=" + commentedUser +
                ", task=" + task +
                ", commentedDate=" + commentedDate +
                '}';
    }
}

