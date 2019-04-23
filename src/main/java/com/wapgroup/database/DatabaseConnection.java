package com.wapgroup.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    public static Connection con;

    public static synchronized DatabaseConnection getInstance(){
        if (instance == null) {
            instance = new DatabaseConnection();
            instance.connectDB();
        }

        return instance;
    }

    private void connectDB(){

        try{

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/taskmanagerdb","root","fwa2332"
            );

        }catch(ClassNotFoundException cnf){
            System.out.println(cnf);
            instance = null;
        }catch(SQLException se){
            System.out.println(se);
            instance = null;
        }

    }

}
