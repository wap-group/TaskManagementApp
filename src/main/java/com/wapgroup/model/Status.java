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
}
