package com.wapgroup.model;

public class User {

    protected String fName;
    protected String lName;
    protected String empId;
    protected String password;
    protected Address address;
    protected Role role;

    public User(){}

    public User(String fName, String lName, String empId,
                String password, Address address, Role role)
    {
        this.fName = fName;
        this.lName = lName;
        this.empId = empId;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
