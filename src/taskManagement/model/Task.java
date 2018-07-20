package taskManagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Task implements Comparable<Task>, Serializable {
    String title;
    String description;
    long estimate;
    String assignTo;
    Date createdDate;
    String status;
    Project project;

    public Task(String title, String description, long estimate, String assignTo, Date createdDate, String status, Project project) {
        this.title = title;
        this.description = description;
        this.estimate = estimate;
        this.assignTo = assignTo;
        this.createdDate = createdDate;
        this.status = status;
        this.project = project;
    }

    public Task() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getEstimate() {
        return estimate;
    }

    public void setEstimate(long estimate) {
        this.estimate = estimate;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (estimate != task.estimate) return false;
        if (title != null ? !title.equals(task.title) : task.title != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (assignTo != null ? !assignTo.equals(task.assignTo) : task.assignTo != null) return false;
        if (createdDate != null ? !createdDate.equals(task.createdDate) : task.createdDate != null) return false;
        return status != null ? status.equals(task.status) : task.status == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (estimate ^ (estimate >>> 32));
        result = 31 * result + (assignTo != null ? assignTo.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", estimate=" + estimate +
                ", assignTo='" + assignTo + '\'' +
                ", createdDate=" + createdDate +
                ", status='" + status + '\'' +
                ", project=" + project +
                '}';
    }

    @Override
    /**
     * this method compares task's titles'
     * and next will be printed by the order of task's title
     */
    public int compareTo(Task o) {
        return title.compareTo(o.getTitle());
    }

}
