package com.wapgroup.services;

import com.wapgroup.database.DatabaseConnection;
import com.wapgroup.model.Task;
import com.wapgroup.model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeveloperService {

    public static JSONArray getTaskJSON(){
        JSONArray jarray = new JSONArray();
        DatabaseConnection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try{
            connection = DatabaseConnection.getInstance();
            pst = connection.con.prepareStatement("SELECT * FROM task");
//            pst = connection.con.prepareStatement("SELECT taskId, taskName, dueDate, priority," +
//                    "category, taskDescription, taskStatus,devEmail, taskAssigned FROM task");
            rs = pst.executeQuery();
            JSONObject jsonobject = null;

            while (rs.next()) {

                ResultSetMetaData metaData = rs.getMetaData();
                jsonobject = new JSONObject();

                for(int i = 0; i < metaData.getColumnCount(); i++){
                    int column = i + 1;

                    if(column == 3 || column == 9){

                        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = null;

                        try{

                            date = sdf.parse(rs.getDate(column).toString());
                            jsonobject.put(metaData.getColumnLabel(column),
                                    new SimpleDateFormat("MM/dd/yyyy").format(date));

                        }catch(ParseException pe){
                            System.out.println("parse exception " + pe);
                        }
                    }else {
                        jsonobject.put(metaData.getColumnLabel(column), rs.getObject(column));
                    }

                }

                jarray.put(jsonobject);
            }

        }catch(SQLException se){
            System.out.println(se);
        }

        return jarray;
    }


    public static void insertTask(Task task){

        DatabaseConnection connection = null;
        PreparedStatement pst = null;


        try{
            connection = DatabaseConnection.getInstance();
            pst = connection.con.prepareStatement("INSERT into task (taskName, dueDate, priorty, category, " +
                    "taskDescription, taskStatus, devEmail, taskAssigned ) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, task.gettaskName());
            pst.setDate(2, new java.sql.Date(task.getDueDate().getTime()));
            pst.setInt(3,task.getPriority());
            pst.setString(4, task.getCatagory().toString());
            pst.setString(5,task.getDescription());
            pst.setString(6,task.getStatus().toString());
            pst.setString(7,task.getDevEmail());
            pst.setDate(8, new java.sql.Date(task.getTaskAssigned().getTime()));
            pst.executeUpdate();


        }catch(SQLException se){
            System.out.println(se);
        }

    }
}
