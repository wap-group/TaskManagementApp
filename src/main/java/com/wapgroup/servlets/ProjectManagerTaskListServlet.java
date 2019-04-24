package com.wapgroup.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.wapgroup.service.ProjectManagerDataService;
import com.wapgroup.model.Task;
import com.google.gson.Gson;
import org.json.JSONArray;

import java.util.List;


@WebServlet(name = "ProjectManagerTaskListServlet", urlPatterns = {"/pm-task-list"})
public class ProjectManagerTaskListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //retrieve task List from projectManagerDataService
        ProjectManagerDataService pmds = new ProjectManagerDataService();
        //List<Task> taskList = pmds.getTaskList();
        JSONArray taskList = pmds.getList("Select * from task");
        /*Gson gson = new Gson();
        String json = gson.toJson(taskList);
        System.out.println("JSON " + json);*/
        System.out.println("JSONArray " + taskList.toString());
        response.getWriter().write(taskList.toString());
    }
}
