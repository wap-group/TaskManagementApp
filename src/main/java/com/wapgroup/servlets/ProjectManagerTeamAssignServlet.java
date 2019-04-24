package com.wapgroup.servlets;

import com.google.gson.Gson;
import com.wapgroup.service.ProjectManagerDataService;
import com.wapgroup.model.AssignTeam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProjectManagerTeamAssignServlet", urlPatterns = {"/pm-team-assign"})
public class ProjectManagerTeamAssignServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //save assigned team to ProjectManagerdataService
        ProjectManagerDataService pmds = new ProjectManagerDataService();
        AssignTeam assignTeam = new AssignTeam();
        assignTeam.setTaskId(request.getParameter("taskAssign"));
        assignTeam.setTeamId(request.getParameter("developerAssigned"));
        assignTeam.setDeveloperId(request.getParameter("teamAssigned"));

        boolean saved = pmds.saveAssignTeam(assignTeam);
        Gson gson = new Gson();
        String json = gson.toJson(saved);

        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
