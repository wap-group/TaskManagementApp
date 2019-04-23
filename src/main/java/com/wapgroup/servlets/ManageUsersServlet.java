package com.wapgroup.servlets;

import com.wapgroup.model.Address;
import com.wapgroup.model.Role;
import com.wapgroup.model.User;
import com.wapgroup.services.UserServices;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        JSONArray ar = UserServices.getUsersJSON();
        response.getWriter().write(ar.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONArray ar = UserServices.getUsersJSON();
        System.out.println("*** " + ar.toString());
        response.getWriter().write(ar.toString());

    }
}
