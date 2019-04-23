package com.wapgroup.servlets;
import java.sql.*;
import  java.util.List;
import java.util.ArrayList;
import com.wapgroup.database.DatabaseConnection;
import com.wapgroup.model.*;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/DevPage")
public class DevTaskController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = "dawit@gmail.com";
        //email = request.getParameter("email");

        List<Task> taskList = new ArrayList<>();
        request.getSession().setAttribute("tasks", taskList);

        DatabaseConnection dbCon = DatabaseConnection.getInstance();
        if(dbCon != null) {
            try {
                Statement stm = dbCon.con.createStatement();
                ResultSet result = stm.executeQuery("SELECT * FROM task WHERE devEmail = '" + email + "'");

                while (result.next()) {

                    Task task = new Task();

                    task.setTaskId(result.getInt("taskId"));
                    task.settaskName(result.getString("taskName"));
                    task.setDueDate(result.getDate("dueDate"));
                    task.setPriority(result.getInt("priority"));

                    String category = result.getString("category");
                    System.out.println(category);
                    if(category.equals(Catagory.PERSONAL.toString()))
                        task.setCatagory(Catagory.PERSONAL);
                    if(category.equals(Catagory.WORK.toString()))
                        task.setCatagory(Catagory.WORK);

                    String status = result.getString("taskStatus");
                    System.out.println(status);
                    if(status.equals(Status.NOT_STARTED.toString()))
                        task.setStatus(Status.NOT_STARTED);
                    if(status.equals(Status.ON_PROGRESS.toString()))
                        task.setStatus(Status.ON_PROGRESS);
                    if(status.equals(Status.COMPLETED.toString()))
                        task.setStatus(Status.COMPLETED);

                    task.setTaskAssigned(result.getDate("taskAssigned"));


                    taskList.add(task);
                    System.out.println(task);

                }

                ///response.sendRedirect("/view/dev-page/dev-tasks.jsp");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("http://localhost:8080/TaskManagementApp_war_exploded/view/dev-page/dev-tasks.jsp");
        //request.getRequestDispatcher("/view/dev-page/dev-tasks.jsp").forward(request, response);
        //String json = new Gson().toJson(users);
        //response.setContentType("application/json");
        //response.setCharacterEncoding("UTF-8");
        //response.getWriter().write(json);

    }
}
