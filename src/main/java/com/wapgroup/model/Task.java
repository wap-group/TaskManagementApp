package com.wapgroup.model;


import java.util.Date;

public class Task {

    private int taskId;
    private String taskName;
    private Date dueDate;
    private int priority;
    private Catagory catagory;
    private String description;
    private Status status;
    private Date taskAssigned;

    public Task(){}

    public Task(int taskId, String taskName, Date dueDate,
                int priority, Catagory catagory, String description,
                Status status, Date taskAssigned)
    {
        this.taskId = taskId;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
        this.catagory = catagory;
        this.description = description;
        this.status = status;
        this.taskAssigned = taskAssigned;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String gettaskName() {
        return taskName;
    }

    public void settaskName(String taskName) {
        this.taskName = taskName;
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

    public Date getTaskAssigned() {
        return taskAssigned;
    }

    public void setTaskAssigned(Date taskAssigned) {
        this.taskAssigned = taskAssigned;
    }
}
