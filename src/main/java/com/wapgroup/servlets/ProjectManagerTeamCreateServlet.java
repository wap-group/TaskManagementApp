package com.wapgroup.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.wapgroup.service.ProjectManagerDataService;
import com.wapgroup.model.Team;
import java.util.List;

@WebServlet(name = "ProjectManagerTeamCreateServlet", urlPatterns = {"/pm-team-create"})
public class ProjectManagerTeamCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //send data to project manager data service to be saved the created team data to DB
        ProjectManagerDataService pmds = new ProjectManagerDataService();
        Team team = new Team();
        team.setTeamId(request.getParameter("teamId"));
        team.setName(request.getParameter("teamName"));
        boolean saved = pmds.saveTeam(team);
        Gson gson = new Gson();
        String json = gson.toJson(saved);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
