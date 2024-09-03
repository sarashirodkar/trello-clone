package com.example.accessingdatamysql.model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
public class TaskHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer taskhistoryid;
    private Timestamp creationtime;

    private  Timestamp updatetime;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Task task_id;
    private String state;
    //private User assigneduser;
    private String description;
    private String comments;

    public TaskHistory() {
    }

    public TaskHistory(Integer taskhistoryid, Timestamp creationtime, Timestamp updatetime, Task task_id, String state, String description, String comments) {
        this.taskhistoryid = taskhistoryid;
        this.creationtime = creationtime;
        this.updatetime = updatetime;
        this.task_id = task_id;
        this.state = state;
        this.description = description;
        this.comments = comments;
    }

    public Integer getTaskhistoryid() {
        return taskhistoryid;
    }

    public void setTaskhistoryid(Integer taskhistoryid) {
        this.taskhistoryid = taskhistoryid;
    }

    public Timestamp getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Timestamp creationtime) {
        this.creationtime = creationtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public Task getTask_id() {
        return task_id;
    }

    public void setTask_id(Task task_id) {
        this.task_id = task_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
