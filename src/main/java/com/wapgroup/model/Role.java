package com.wapgroup.model;

public enum Role {
    ADMIN, DEVELOPER, PROJECT_MANAGER;

    public String toString(){
        if(this.equals(Role.ADMIN)) return "admin";
        else if(this.equals(Role.DEVELOPER)) return "developer";
        else return "project manager";
    }
}
