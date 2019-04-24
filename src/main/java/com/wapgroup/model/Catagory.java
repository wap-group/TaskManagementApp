package com.wapgroup.model;

import java.util.Locale;

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

    public static Catagory StringToCategory(String strCat){
        if(strCat.equals("Personal")) return Catagory.PERSONAL;
        if(strCat.equals("Work")) return Catagory.WORK;
        else return null;
    }
}
