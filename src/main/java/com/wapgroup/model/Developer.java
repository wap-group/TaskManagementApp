package com.wapgroup.model;

import java.util.List;

public class Developer extends User {

    private List<Task> taskList;
    private Team team;

    public Developer(List<Task> taskList, Team team) {
        this.taskList = taskList;
        this.team = team;
    }

    public Developer(String fName, String lName, String empId,
                     String password, Address address, Role role,
                     List<Task> taskList, Team team)
    {
        super(fName, lName, empId, password, address, role);
        this.taskList = taskList;
        this.team = team;
    }
}
