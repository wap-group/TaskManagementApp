package com.wapgroup.servlets;

import com.wapgroup.model.*;
import com.wapgroup.services.DeveloperService;
import com.wapgroup.services.DeveloperService;
import com.wapgroup.services.UserServices;
import com.wapgroup.services.Utils;
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
import java.util.Map;

import static java.lang.Integer.parseInt;

@WebServlet("/DeveloperServlet")
public class DeveloperServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONArray ar = DeveloperService.getTaskJSON();
        System.out.println("*** " + ar.toString());
        response.getWriter().write(ar.toString());

    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        System.out.println("**** Inside doPut. hurrayyyyyyy");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Map<String, String> dataMap = Utils.reformatDeveloper(Utils.getParameterMap(request));

        int taskId = Integer.parseInt(dataMap.get("taskId"));

        String status = dataMap.get("taskStatus");

        System.out.println("----- " + taskId + " " + status + "-------");

        Task task = new Task();
        task.setTaskId(taskId);
        task.setStatus(Status.stringToStatus(status));

        DeveloperService.updateStatus(task);
        response.getWriter().write("");

    }
}