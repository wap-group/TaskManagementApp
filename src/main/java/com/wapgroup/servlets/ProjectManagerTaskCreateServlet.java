package com.wapgroup.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.wapgroup.model.Catagory;
import com.wapgroup.model.Status;
import com.wapgroup.service.ProjectManagerDataService;
import com.wapgroup.model.Task;

@WebServlet(name = "ProjectManagerTaskCreateServlet", urlPatterns = {"/pm-task-create"})
public class ProjectManagerTaskCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //send data to project manager data service to be saved the created task data to DB
        ProjectManagerDataService pmds = new ProjectManagerDataService();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(request.getParameter("dueDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Task task = new Task();
        task.setTaskId(request.getParameter("taskId"));
        task.settaskName(request.getParameter("taskName"));
        task.setDueDate(date);
        task.setPriority(Integer.parseInt(request.getParameter("priority")));
        String category = request.getParameter("category");
        if(category.equals(Catagory.PERSONAL)) task.setCatagory(Catagory.PERSONAL);
        else if(category.equals(Catagory.WORK)) task.setCatagory(Catagory.WORK);
        task.setDescription(request.getParameter("description"));
        String status = request.getParameter("status");
        if(status.equals(Status.COMPLETED)) task.setStatus(Status.COMPLETED);
        else if(status.equals(Status.NOT_STARTED)) task.setStatus(Status.NOT_STARTED);
        else if(status.equals(Status.ON_PROGRESS)) task.setStatus(Status.ON_PROGRESS);
        Date taskAssigned=null;
        try {
            taskAssigned = formatter.parse(request.getParameter("taskAssigned"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //date = new Date(request.getParameter("taskAssigned"));
        task.setTaskAssigned(taskAssigned);

      //  System.out.println("Saved Info: " + pmds.getTaskList());
        /*for (Task t: pmds.getTaskList()){
            System.out.println(t.getTaskId() + " " + t.getDescription() + " " + t.gettaskName());
        }*/
        boolean saved = pmds.saveTask(task);
        Gson gson = new Gson();
        String json = gson.toJson(saved);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
