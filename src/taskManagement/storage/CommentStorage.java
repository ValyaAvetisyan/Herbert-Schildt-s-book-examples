package taskManagement.storage;

import taskManagement.model.Comment;
import taskManagement.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentStorage {
    Map<Task, List<Comment>> comments = new HashMap<>();

    public void add(Comment comment) {

        if (comments.get(comment.getTask()) == null) {
            List<Comment> commentList = new ArrayList<>();
            commentList.add(comment);
            comments.put(comment.getTask(), commentList);
        } else {
            comments.get(comment.getTask()).add(comment);
        }
    }
    public void printComments(){
        for (List<Comment> commentList : comments.values()) {
            System.out.println(commentList);
        }
    }
}
