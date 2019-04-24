package com.wapgroup.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProjectManagerDatabaseConnection {
    private static ProjectManagerDatabaseConnection instance = null;
    private String url;
    private String user;
    private String password;
    private static Connection myConnection;

    private ProjectManagerDatabaseConnection(){
        url = "jdbc:mysql://localhost:3307/taskmanagerdb";
        user= "root";
        password = "root";
    }
    public static synchronized ProjectManagerDatabaseConnection getInstance(){
        if (instance == null) {
            instance = new ProjectManagerDatabaseConnection();
            instance.connectToDatabase();
        }

        return instance;
    }

    private void connectToDatabase(){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection(url, user, password);

        }catch(ClassNotFoundException classNotFound){
            System.out.println(classNotFound);
            instance = null;
        }catch(SQLException sqlException){
            System.out.println(sqlException);
            instance = null;
        }
    }

    public Connection getMyConnection() {
        return myConnection;
    }
}
