package com.wapgroup.model;

import java.util.ArrayList;
import java.util.List;

public class Developer extends User {

    private List<Task> taskList;
    private Team team;

    public Developer(){
        taskList = new ArrayList<>();
        team = new Team();
    }

    public Developer(List<Task> taskList, Team team) {
        this.taskList = taskList;
        this.team = team;
    }

    public Developer(String fName, String lName, int empId,
                     String password, Address address, Role role,
                     List<Task> taskList, Team team, String phone, String email)
    {
        super(fName, lName, empId, password,
                address, role, phone, email);
        this.taskList = taskList;
        this.team = team;
    }

    public void setTaskList(List<Task> tasks) {
        this.taskList = tasks;
    }
    public void setTeam(Team team){
        this.team = team;
    }

    public List<Task> getTaskList(){
        return taskList;
    }

    public Team getTeam(){
        return team;
    }
}
