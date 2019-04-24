package com.wapgroup.model;

public class AssignLookupTask extends AssignLookup{
    private String taskId;
    private String taskName;

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
