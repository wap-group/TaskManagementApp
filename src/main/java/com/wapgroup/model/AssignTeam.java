package com.wapgroup.model;

public class AssignTeam {

    private String taskId;
    private String teamId;
    private String developerId;

    public String getTaskId(){
        return taskId;
    }

    public String getTeamId(){
        return teamId;
    }

    public String getDeveloperId(){
        return developerId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }
}
