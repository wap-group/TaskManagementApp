package com.wapgroup.servlets;
import java.awt.print.Book;
import java.sql.*;
import java.util.LinkedHashMap;
import  java.util.List;
import java.util.ArrayList;
import com.wapgroup.database.DatabaseConnection;
import com.wapgroup.model.Role;
import com.wapgroup.model.User;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/DevPage")
public class DevTaskController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<User> users = new ArrayList<>();
        session.setAttribute("users", users);

        DatabaseConnection dbCon = DatabaseConnection.getInstance();
        if(dbCon != null) {
            try {
                Statement stm = dbCon.con.createStatement();
                ResultSet rows = stm.executeQuery("SELECT * FROM users");
                while (rows.next()) {
                    User user = new User();

                    user.setfName(rows.getString("fName"));
                    user.setlName(rows.getString("lName"));
                    user.setEmpId(rows.getInt("empId"));
                    user.setEmail(rows.getString("email"));
                    user.setPhone(rows.getString("phone"));

                    String role = rows.getString("role");
                    if (role.equals(Role.ADMIN))
                        user.setRole(Role.ADMIN);
                    else if (role.equals(Role.PROJECT_MANAGER))
                        user.setRole(Role.PROJECT_MANAGER);
                    if (role.equals(Role.DEVELOPER))
                        user.setRole(Role.DEVELOPER);

                    users.add(user);
                }

                ///response.sendRedirect("/view/dev-page/dev-tasks.jsp");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //String json = new Gson().toJson(users);
        //response.setContentType("application/json");
        //response.setCharacterEncoding("UTF-8");
        //response.getWriter().write(json);

    }
}
