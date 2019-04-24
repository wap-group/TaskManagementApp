package com.wapgroup.model;

public class AssignLookUpDeveloper extends AssignLookup{

    private String developerId;
    private String devFirstName;
    private String devLastName;

    public String getDeveloperId() {
        return developerId;
    }

    public String getDevFirstName() {
        return devFirstName;
    }

    public String getDevLastName() {
        return devLastName;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public void setDevFirstName(String devFirstName) {
        this.devFirstName = devFirstName;
    }

    public void setDevLastName(String devLastName) {
        this.devLastName = devLastName;
    }
}
