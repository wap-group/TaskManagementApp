package com.wapgroup.services;

import com.wapgroup.database.DatabaseConnection;
import com.wapgroup.model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;

public class UserServices {




    public static JSONArray getUsersJSON(){
        JSONArray jarray = new JSONArray();
        DatabaseConnection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try{
            connection = DatabaseConnection.getInstance();
            pst = connection.con.prepareStatement("SELECT users.empId, fName, lName, pass_word, email, " +
                    "phone, roles, zipcode, street, city, state FROM users INNER JOIN " +
                    "address ON users.empId = address.empId");
            rs = pst.executeQuery();
            JSONObject jsonobject = null;
            //jarray = SimpleJsonUtils.toJSON(rs);

            while (rs.next()) {

                ResultSetMetaData metaData = rs.getMetaData();
                jsonobject = new JSONObject();

                for (int i = 0; i < metaData.getColumnCount(); i++) {

                    jsonobject.put(metaData.getColumnLabel(i + 1),rs.getObject(i + 1));

                }

                jarray.put(jsonobject);
            }

        }catch(SQLException se){
            System.out.println(se);
        }

        return jarray;
    }


    public static void insertUser(User user){

        DatabaseConnection connection = null;
        PreparedStatement pst = null;


        try{
            connection = DatabaseConnection.getInstance();
            pst = connection.con.prepareStatement("INSERT into users (fName, lName, pass_word, email, phone, roles) "
                                                        + "VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1,user.getfName());
            pst.setString(2,user.getlName());
            pst.setString(3,user.getPassword());
            pst.setString(4,user.getEmail());
            pst.setString(5,user.getPhone());
            pst.setString(6,user.getRole().toString());
            pst.executeUpdate();

            pst = connection.con.prepareStatement("SELECT MAX(empId) AS recent FROM users");
            ResultSet rs = pst.executeQuery();

            rs.next();
            user.setEmpId(rs.getInt("recent"));
            System.out.println(user.getEmpId());

            pst = connection.con.prepareStatement("INSERT INTO address (empId, zipcode, street, city, state) "
                                                        + "VALUES (?, ?, ?, ?, ?)");
            pst.setInt(1,user.getEmpId());
            pst.setString(2,user.getAddress().getZipcode());
            pst.setString(3,user.getAddress().getStreet());
            pst.setString(4,user.getAddress().getCity());
            pst.setString(5,user.getAddress().getState());
            pst.executeUpdate();


        }catch(SQLException se){
            System.out.println(se);
        }finally {
            try{
                pst.close();
            }catch(SQLException se){
                System.out.println(se);
            }
        }

    }


    public static void deleteUser(){

    }
}
