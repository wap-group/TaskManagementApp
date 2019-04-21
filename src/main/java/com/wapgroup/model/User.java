package com.wapgroup.model;

public class User {

    protected String fName;
    protected String lName;
    protected int empId;
    protected String password;
    protected Address address;
    protected Role role;
    protected String phone;
    protected String email;

    public User(){}

    public User(String fName, String lName, int empId,
                String password, Address address, Role role,
                String phone, String email)
    {
        this.fName = fName;
        this.lName = lName;
        this.empId = empId;
        this.password = password;
        this.address = address;
        this.role = role;
        this.phone = phone;
        this.email = email;
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

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
