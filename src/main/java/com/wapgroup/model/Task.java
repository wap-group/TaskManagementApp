package com.wapgroup.model;


import java.util.Date;

public class Task {

    private String taskId;
    private String teamName;
    private Date dueDate;
    private int priority;
    private Catagory catagory;
    private String description;
    private Status status;

    public Task(){}

    public Task(String taskId, String teamName, Date dueDate,
                int priority, Catagory catagory, String description,
                Status status)
    {
        this.taskId = taskId;
        this.teamName = teamName;
        this.dueDate = dueDate;
        this.priority = priority;
        this.catagory = catagory;
        this.description = description;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
