package com.wapgroup.model;

public class ProjectManager extends User {

    public ProjectManager() {
    }

    public ProjectManager(String fName, String lName, String empId, String password, Address address, Role role) {
        super(fName, lName, empId, password, address, role);
    }

}
