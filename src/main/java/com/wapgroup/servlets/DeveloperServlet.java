package com.wapgroup.servlets;

import com.wapgroup.model.*;
import com.wapgroup.services.DeveloperService;
import com.wapgroup.services.DeveloperService;
import com.wapgroup.services.UserServices;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

@WebServlet("/DeveloperServlet")
public class DeveloperServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("******* Inside do post.");

        int taskId = -1;
        String taskName = request.getParameter("taskName");
        String date1 = request.getParameter("dueDate");
        Date dueDate = null;
        try{
            dueDate = new SimpleDateFormat("MM-DD-YYYY").parse(date1);
        }catch(ParseException e){
            e.printStackTrace();
        }
        int priority = parseInt(request.getParameter("priority"));

        String category = request.getParameter("category");
        //System.out.println("******* roles " + roles);
        String taskDescription = request.getParameter("taskDescription");
        String taskStatus = request.getParameter("taskStatus");
        String devEmail = request.getParameter("devEmail");
        String taskAssigned = request.getParameter("taskAssigned");
        Date dateAssigned = null;
        try{
            dateAssigned = new SimpleDateFormat("MM-DD-YYYY").parse(taskAssigned);
        } catch(ParseException e){
            e.printStackTrace();
        }

        Task task = new Task(taskId, taskName, dueDate, priority, Catagory.StringToCategory(category),taskDescription, Status.stringToStatus(taskStatus), devEmail, dateAssigned);


        System.out.println("------ " + taskId + "  " + taskName + "  " + dueDate + "  " + priority + "  " +
                category + "  " + taskDescription + "  " + devEmail + " " + dateAssigned);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        DeveloperService.insertTask(task);
        JSONArray ar = DeveloperService.getTaskJSON();
        response.getWriter().write(ar.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONArray ar = DeveloperService.getTaskJSON();
        System.out.println("*** " + ar.toString());
        response.getWriter().write(ar.toString());

    }
}