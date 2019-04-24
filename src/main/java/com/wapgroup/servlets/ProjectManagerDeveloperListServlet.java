package com.wapgroup.servlets;

import com.google.gson.Gson;
import com.wapgroup.model.Developer;
import com.wapgroup.model.User;
import com.wapgroup.service.ProjectManagerDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProjectManagerDeveloperListServlet", urlPatterns = {"/pm-developer-list"})
public class ProjectManagerDeveloperListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //save assigned team to ProjectManagerdataService
        ProjectManagerDataService pmds = new ProjectManagerDataService();
        List<User> developerList = pmds.getDeveloperList();

        Gson gson = new Gson();
        String json = gson.toJson(developerList);
        response.getWriter().write(json);
    }
}
