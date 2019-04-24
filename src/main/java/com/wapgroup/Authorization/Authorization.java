package com.wapgroup.Authorization;

import com.wapgroup.database.DatabaseConnection;
import com.wapgroup.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authorization {

    public static User checkAuthority(String email, String pw){


        User user = null;
        DatabaseConnection connection;
        Statement stm = null;

        connection = DatabaseConnection.getInstance();

        if(connection != null) {
            try {

                stm = connection.con.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM users " +
                                                    "WHERE email = '" + email + "' " +
                                                    "AND pass_word = '" + pw + "'");
                if(rs.isBeforeFirst()){
                    System.out.println("record found.");
                    rs.next();
                    user = getUserType(rs.getString("roles"));
                    user.setEmpId(Integer.parseInt(rs.getString("empId")));
                    user.setfName(rs.getString("fName"));
                    user.setlName(rs.getString("lName"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone(rs.getString("phone"));

                }

            } catch (SQLException se) {
                System.out.println("SQLException inside Authorization class: " + se);
            }finally {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return user;
    }


    private static User getUserType(String role){

        User u = null;
        if(role.equals("admin")){
            u = new Admin();
            u.setRole(Role.ADMIN);
            return u;
        }

        else if(role.equals("project manager")){
            u = new ProjectManager();
            u.setRole(Role.PROJECT_MANAGER);
            return u;
        }

        else
            u = new Developer();
            u.setRole(Role.DEVELOPER);
            return u;


    }


}
