package com.wapgroup.model;

public class AssignLookupTeam extends AssignLookup{
    private String teamId;
    private String teamName;

    public String getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
