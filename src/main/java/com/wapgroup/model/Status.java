package com.wapgroup.model;

public enum Status {

    NOT_STARTED("Not started"), ON_PROGRESS("In progress"), COMPLETED("Completed");
    private String status;

    private Status(String taskStatus) {
        this.status = taskStatus;
    }

    @Override
    public String toString() {
        return status;
    }
    public static Status stringToStatus(String str){
        if(str.equals("Not started")) return Status.NOT_STARTED;
        if(str.equals("In progress")) return Status.ON_PROGRESS;
        if(str.equals("Completed")) return Status.COMPLETED;
        else return null;
    }
}
