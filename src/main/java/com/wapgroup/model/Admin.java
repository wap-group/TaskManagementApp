package com.wapgroup.model;

public class Admin extends User {

    public Admin() {
    }

    public Admin(String fName, String lName, String empId, String password, Address address, Role role) {
        super(fName, lName, empId, password, address, role);
    }
}
