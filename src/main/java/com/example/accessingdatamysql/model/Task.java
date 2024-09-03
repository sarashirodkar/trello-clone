package com.example.accessingdatamysql.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity // This tells Hibernate to make a table out of this class
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String taskState;

    @ManyToOne
    @JoinColumn(referencedColumnName = "userid")
    private User assignedTo;
    private String description;

    @ElementCollection
    private List<String> comments = new ArrayList<String>();

    private Timestamp createtimestamp;

    public Task() {
    }


    public Task(Integer id, String taskState, User assignedTo, String description, List<String> comments, Timestamp createtimestamp) {
        this.id = id;
        this.taskState = taskState;
        this.assignedTo = assignedTo;
        this.description = description;
        this.comments = comments;
        this.createtimestamp = createtimestamp;
    }

    public Timestamp getCreatetimestamp() {
        return createtimestamp;
    }

    public void setCreatetimestamp(Timestamp createtimestamp) {
        this.createtimestamp = createtimestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String TaskState) {
        this.taskState = TaskState;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}