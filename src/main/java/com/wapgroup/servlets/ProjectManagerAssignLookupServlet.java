package com.wapgroup.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.wapgroup.service.ProjectManagerDataService;
import com.wapgroup.model.AssignLookup;
import java.util.List;

@WebServlet(name = "ProjectManagerAssignLookupServlet", urlPatterns = {"/PM-assign-lookup"})
public class ProjectManagerAssignLookupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get look up data
        ProjectManagerDataService pmds = new ProjectManagerDataService();
        Gson gson = new Gson(); //type
        List<AssignLookup> lookup = null;
        if(request.getParameter("type").equals("Assign Task"))
            lookup = pmds.getAssignLookup("task");
        else if(request.getParameter("type").equals("Assign Team"))
            lookup = pmds.getAssignLookup("team");

        else if(request.getParameter("type").equals("Assign Team"))
            lookup = pmds.getAssignLookup("team");

        String json = gson.toJson(lookup);
        System.out.println("JSON  " + json);
        response.getWriter().write(json);
    }
}
