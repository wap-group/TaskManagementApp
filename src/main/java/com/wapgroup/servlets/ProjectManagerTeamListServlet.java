package com.wapgroup.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.wapgroup.service.ProjectManagerDataService;
import com.wapgroup.model.Team;
import java.util.List;

@WebServlet(name = "ProjectManagerTeamListServlet" , urlPatterns = {"/pm-team-list"})
public class ProjectManagerTeamListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //retrieve task List from projectManagerDataService
        ProjectManagerDataService pmds = new ProjectManagerDataService();
        List<Team> teamList = pmds.getTeamList();

        Gson gson = new Gson();
        String json = gson.toJson(teamList);
        response.getWriter().write(json);
    }
}
