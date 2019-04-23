package com.wapgroup.model;

public enum Role {
    ADMIN, DEVELOPER, PROJECT_MANAGER;

    public String toString(){
        if(this.equals(Role.ADMIN)) return "admin";
        else if(this.equals(Role.DEVELOPER)) return "developer";
        else return "project manager";
    }

    public static Role stringToRole(String role){
        if(role.equals("developer")) return Role.DEVELOPER;
        if(role.equals("admin")) return Role.ADMIN;
        if(role.equals("project manager")) return Role.PROJECT_MANAGER;

        else return null;
    }
}
