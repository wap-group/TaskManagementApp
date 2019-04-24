package com.wapgroup.servlets;

import com.wapgroup.model.Address;
import com.wapgroup.model.Role;
import com.wapgroup.model.User;
import com.wapgroup.services.UserServices;
import com.wapgroup.services.Utils;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/ManageUsersServlet")
public class ManageUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("******* Inside do post.");

        int empId = -1;
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String password = request.getParameter("pass_word");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        System.out.println("******* phone " + phone);
        String roles = request.getParameter("roles");
        System.out.println("******* roles " + roles);
        String zipcode = request.getParameter("zipcode");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");

        User user = new User(fName, lName, empId, password,
                             new Address(zipcode, street, city, state),
                             Role.stringToRole(roles), phone, email);

        System.out.println("------ " + empId + "  " + fName +
                            "  " + lName + "  " + password + "  " +
                            email + "  " + phone + "  " + roles);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        UserServices.insertUser(user);
        response.getWriter().write("");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONArray ar = UserServices.getUsersJSON();
        System.out.println("*** " + ar.toString());
        response.getWriter().write(ar.toString());

    }

    protected void doPut(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException
    {

        System.out.println("**** Inside doPut. hurrayyyyyyy");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Map<String, String> dataMap = Utils.reformatAdmin(Utils.getParameterMap(request));

        int empId = Integer.parseInt(dataMap.get("empId"));
        String fName = dataMap.get("fName");
        String lName = dataMap.get("lName");
        String pass_word = dataMap.get("pass_word");
        String email = dataMap.get("email");
        String phone = dataMap.get("phone");
        String roles = dataMap.get("roles");
        String zipcode = dataMap.get("zipcode");
        String street = dataMap.get("street");
        String city = dataMap.get("city");
        String state = dataMap.get("state");

        System.out.println("----- " + empId + " " + fName + " " + lName + " "
                                    + pass_word + " " + email + " " + phone + " "
                                    + roles + " " + zipcode + " " + street + " "
                                    + city + " " + state + " ");

        User user = new User(fName, lName, empId, pass_word,
                new Address(zipcode, street, city, state),
                Role.stringToRole(roles), phone, email);

        UserServices.updateUser(user);

    }

    protected void doDelete(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException
    {

        System.out.println("**** Inside doDelete. hurrayyyyyyy");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Map<String, String> dataMap = Utils.getParameterMap(request);
        int empId = Integer.parseInt(dataMap.get("empId"));

        UserServices.deleteUser(empId);
        response.getWriter().write("");
    }
}
