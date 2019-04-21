package com.wapgroup.model;

public class ProjectManager extends User {

    public ProjectManager() {
    }

    public ProjectManager(String fName, String lName, int empId,
                          String password, Address address, Role role,
                          String phone, String email) {
        super(fName, lName, empId, password, address, role, phone, email);
    }

}
