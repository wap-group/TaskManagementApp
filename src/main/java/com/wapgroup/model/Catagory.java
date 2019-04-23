package com.wapgroup.model;

public enum Catagory {
    PERSONAL("Personal"), WORK("Work");
    private String categoty;
    private Catagory(String taskCategory){
        this.categoty = taskCategory;
    }

    @Override
    public String toString() {
        return categoty;
    }
}
