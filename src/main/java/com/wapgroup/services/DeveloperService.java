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
            //pst = connection.con.prepareStatement("SELECT * FROM task");
            pst = connection.con.prepareStatement("SELECT taskId, taskName, dueDate, priority," +
                    "category, taskDescription, taskStatus, taskAssigned FROM task");
            rs = pst.executeQuery();
            JSONObject jsonobject = null;

            while (rs.next()) {

                ResultSetMetaData metaData = rs.getMetaData();
                jsonobject = new JSONObject();

                for(int i = 0; i < metaData.getColumnCount(); i++){
                    int column = i + 1;

                    if(column == 3 || column == 8){

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


    public static void updateStatus(Task task){

        DatabaseConnection connection = null;
        PreparedStatement pst = null;


        try{
            connection = DatabaseConnection.getInstance();
            pst = connection.con.prepareStatement("UPDATE task " +
                    "Set taskStatus = ? WHERE taskId = ?");
            pst.setString(2,task.getStatus().toString());
            pst.setInt(1,task.getTaskId());
            pst.executeUpdate();
            System.out.println("Update status ...");
            System.out.println(task.getStatus());

        }catch(SQLException se){
            System.out.println(se);
        }

    }
}
