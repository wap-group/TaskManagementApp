package com.wapgroup.service;

import com.wapgroup.database.ProjectManagerDatabaseConnection;
import com.wapgroup.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ProjectManagerDataService {
    /*private static final List<Task>  taskDommy = new ArrayList<>();
    private static  List<Team>  teamDommy = new ArrayList<>();*/
    private List<Task>  taskList;
    private List<Team>  teamList;
    private List<User>  developerList;
    private List<AssignLookup> assignLookup;
    private ProjectManagerDatabaseConnection connectionInstance;

    public ProjectManagerDataService(){
        taskList = new ArrayList<>();
        teamList = new ArrayList<>();
        developerList = new ArrayList<>();
        assignLookup = new ArrayList<>();
        connectionInstance = ProjectManagerDatabaseConnection.getInstance();
    }

    public boolean saveTask(Task t)  {
        String taskID = t.getTaskId();
        String taskNAMES = t.gettaskName();
        Date dueDATE = t.getDueDate();
        int priorityP = t.getPriority();
        Catagory cataeoryC = t.getCatagory();
        String taskDESCRIPTION = t.getDescription();
        Status taskSTATUS = t.getStatus();
        Date taskASSIGNED = t.getTaskAssigned();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String command = " INSERT INTO task "+
                "(taskId, taskName, dueDate, priority,category, taskDescription, taskStatus, taskAssigned)" +
                " VALUES("+taskID+", '"+taskNAMES+"','"+ formatter.format(dueDATE)+"',"+ priorityP+",'" +cataeoryC+"','" + taskDESCRIPTION +"','"+ taskSTATUS+"','"+ formatter.format(taskASSIGNED)+"')";


        return saveCommonMethod(command);
    }

    public boolean saveTeam(Team t) {
        String teamID = t.getTeamId();
        String teamNAME = t.getName();
        String command = "INSERT INTO team" +
                "(teamId, teamName)" +
                "VALUES(" + "'" + teamID + "','" + teamNAME + "'" + ")";

        return saveCommonMethod(command);
    }

    public boolean saveAssignTeam(AssignTeam t) {
        String teamID = t.getTeamId();
        String taskID = t.getTaskId();
        String developerID = t.getDeveloperId();
        String[] names = getCommonAssignName(teamID, taskID);
        String taskName = names[0];
        String teamName = names[1];
        String command = "INSERT INTO assigntask" +
                "(taskId, teamId, developerId)" +
                "VALUES(" + "'" + taskID + taskName + "','" + teamID + "','" + teamName + "','" + developerID + "'" + ")";

        return saveCommonMethod(command);
    }

    public boolean saveAssignTask(AssignTask t) {
        String teamID = t.getTeamId();
        String taskID = t.getTaskId();
        String developerID = t.getDeveloperId();
        String[] names = getCommonAssignName(teamID, taskID);
        String taskName = names[0];
        String teamName = names[1];
        String command = "INSERT INTO assigntask" +
                "(taskId,taskId , teamId, teamName, developerId)" +
                "VALUES(" + "'" + taskID + "','" + taskName + "','" + teamID + "','" + teamName + "','" + developerID + "'" + ")";

        return saveCommonMethod(command);
    }

    private String[] getCommonAssignName(String teamId, String taskId){
        String[] names = new String[2];
        String queryTask = "Select * from task WHERE taskId='" + taskId + "'";
        names[0] = getAssignQuesry(queryTask, taskId);
        String queryTeam = "Select * from team WHERE teamId='" + teamId + "'";
        names[1] = getAssignQuesry(queryTeam, teamId);

        return names;
    }

    private String getAssignQuesry(String query, String id) {
        ResultSet result = listCommonMethod(query);
        String name = null;
        while(true){
            try {
                if(!result.next()) break;
                name = result.getString(id);
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }

        return name;
    }

    private boolean saveCommonMethod(String command) {
        boolean sucess = false;
        try {
            Statement statement =  connectionInstance.getMyConnection().createStatement();
            statement.executeUpdate(command);
            sucess = true;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return sucess;
    }

    private ResultSet listCommonMethod(String query) {
        ResultSet result = null;
        try {
            Statement statement =  connectionInstance.getMyConnection().createStatement();
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  result;
    }
    public JSONArray getList(String query){ //getTaskList
        //String query = "Select * from task";
        ResultSet result = listCommonMethod(query);
        Task t;
        JSONObject jsonobject = null;
        JSONArray jarray = new JSONArray();

        while(true){
            try {
                if (!result.next()) break;
                ResultSetMetaData metaData = result.getMetaData();
                jsonobject = new JSONObject();

                for (int i = 0; i < metaData.getColumnCount(); i++) {

                    jsonobject.put(metaData.getColumnLabel(i + 1),result.getObject(i + 1));

                }

                jarray.put(jsonobject);
               /* t = new Task();

                t.setTaskId(result.getString("taskId"));
                t.settaskName(result.getString("taskName"));
                t.setDescription(result.getString("taskDescription"));
                t.setPriority(Integer.parseInt(result.getString("priority")));
                t.setTaskAssigned(result.getDate("taskAssigned"));
                t.setDueDate(result.getDate("dueDate"));
                String status = result.getString("taskStatus");
                if(status.equals("COMPLETED"))
                    t.setStatus(Status.COMPLETED);
                else if(status.equals("NOT_STARTED"))
                    t.setStatus(Status.NOT_STARTED);
                else if(status.equals("ON_PROGRESS"))
                    t.setStatus(Status.ON_PROGRESS);

                String category = result.getString("category");
                if(category.equals("WORK"))
                    t.setCatagory(Catagory.WORK);
                else if(category.equals("PERSONAL"))
                    t.setCatagory(Catagory.PERSONAL);

                taskList.add(t);*/

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return jarray;
        //return taskList;
    }

    public List<Team> getTeamList(){
        String query = "Select * from team";

        ResultSet result = listCommonMethod(query);
        Team t;
        while(true) {
            try {
                if (!result.next()) break;
                t = new Team();

                t.setTeamId(result.getString("teamId"));
                t.setName(result.getString("teamName"));
                teamList.add(t);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }return teamList;
    }
    public List<User> getDeveloperList(){
        String query = "Select * from users WHERE roles = 'developer'";

        ResultSet result = listCommonMethod(query);
        User d;
        while (true) {
            try {
                if (!result.next()) break;
                d = new Developer();
                d.setEmpId(Integer.parseInt(result.getString("empId")));
                d.setfName(result.getString("fName"));
                d.setlName(result.getString("lName"));
                d.setPassword(result.getString("pass_word"));
                d.setEmail(result.getString("email"));
                d.setPhone(result.getString("phone"));
                d.setRole(Role.DEVELOPER);
                developerList.add(d);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return developerList;
    }

    public List<AssignLookup> getAssignLookup(String type) {
        if(type.equals("task")){
            String query = "Select * from task";
            ResultSet result = listCommonMethod(query);
            return assignLookupCommon(result, type);
        }
        else if(type.equals("team")) {
            String query = "Select * from team";
            ResultSet result = listCommonMethod(query);
            return assignLookupCommon(result, type);
        }
        else if(type.equals("developer")){
            String query = "Select * from users";
            ResultSet result = listCommonMethod(query);
            return assignLookupCommon(result, "developer");
        }
        else
            return null;
    }

    private List<AssignLookup> assignLookupCommon(ResultSet result, String type) {

        while (true) {
            try {

                if(!result.next()) break;
                if(type.equals("task")){
                    AssignLookupTask lookup = new AssignLookupTask();
                    lookup.setTaskId(result.getString("taskId"));
                    lookup.setTaskName(result.getString("taskName"));
                    assignLookup.add(lookup);
                }
                else if(type.equals("team")) {
                    AssignLookupTeam lookup = new AssignLookupTeam();
                    lookup.setTeamId(result.getString("teamId"));
                    lookup.setTeamName(result.getString("teamName"));
                    assignLookup.add(lookup);
                }
                else if(type.equals("developer")){
                    AssignLookUpDeveloper lookup = new AssignLookUpDeveloper();
                    lookup.setDeveloperId(result.getString("empId"));
                    lookup.setDevFirstName(result.getString("fName"));
                    lookup.setDevLastName(result.getString("lName"));
                    assignLookup.add(lookup);
                }
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }

        return assignLookup;
    }
    //save created task data to DB
    //save assigned task to DB
    //retrieve task List from DB
    //save created team to DB
    //save assigned team to DB
    //retrieve team List from DB
    //retrieve developer List from DB
    //retrieve assignLookup
}
