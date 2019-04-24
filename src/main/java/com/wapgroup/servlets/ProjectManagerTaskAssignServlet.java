package com.wapgroup.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.wapgroup.service.ProjectManagerDataService;
import com.wapgroup.model.AssignTask;
import org.json.JSONArray;

@WebServlet(name = "ProjectManagerTaskAssignServlet", urlPatterns = {"/pm-task-assign"})
public class ProjectManagerTaskAssignServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //save assigned team to ProjectManagerdataService
        ProjectManagerDataService pmds = new ProjectManagerDataService();
        AssignTask assignTask = new AssignTask();
        assignTask.setTaskId(request.getParameter("taskAssign"));
        assignTask.setTeamId(request.getParameter("developerAssigned"));
        assignTask.setDeveloperId(request.getParameter("teamAssigned"));

        boolean saved = pmds.saveAssignTask(assignTask);
        Gson gson = new Gson();
        String json = gson.toJson(saved);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doPost(request, response);
        ProjectManagerDataService pmds = new ProjectManagerDataService();
        //List<Task> taskList = pmds.getTaskList();
        JSONArray taskList = pmds.getList("Select * from assigntask");
        /*Gson gson = new Gson();
        String json = gson.toJson(taskList);
        System.out.println("JSON " + json);*/
        System.out.println("JSONArray " + taskList.toString());
        request.getRequestDispatcher("view/projectmanagernew/TaskAssign.jsp").forward(request, response);
        response.getWriter().write(taskList.toString());
    }
}
