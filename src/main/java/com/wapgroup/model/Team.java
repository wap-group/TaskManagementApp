package com.wapgroup.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String teamId;
    private String teamName;
    private List<Developer> developerList;

    public Team(String teamId, String name, List<Developer> developerList) {
        this.teamId = teamId;
        this.teamName = name;
        this.developerList = developerList;
    }

    public Team(){
        this.developerList = new ArrayList<>();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return teamName;
    }

    public void setName(String name) {
        this.teamName = name;
    }

    public List<Developer> getDeveloperList() {
        return developerList;
    }

    public void setDeveloperList(List<Developer> developerList) {
        this.developerList = developerList;
    }
}
