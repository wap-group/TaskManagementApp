package com.wapgroup.servlets;

import com.wapgroup.Authorization.Authorization;
import com.wapgroup.model.Role;
import com.wapgroup.model.User;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("username");
        String password = request.getParameter("pass");

        System.out.println("Credentials are :" + email + " : " + password);

        User user = Authorization.checkAuthority(email, password);

        if(user != null){
            System.out.println("db successful");
            HttpSession session = request.getSession();
            session.setAttribute("empid", user.getEmpId());
            session.setAttribute("fname", user.getfName());
            session.setAttribute("lname", user.getlName());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("phone", user.getPhone());
            session.setAttribute("role", user.getRole().toString());

            System.out.println("User role: " + user.getRole());
            if(user.getRole().toString().equals("admin")) {

                  response.setContentType("text/html");
                  response.sendRedirect("/TaskManagementApp_war_exploded/view/admin/admin.jsp");

            }else if(user.getRole().toString().equals("developer")){

                response.setContentType("text/html");
                response.sendRedirect("/TaskManagementApp_war_exploded/view/dev-page/dev-page.jsp");
            }
        }else{
            response.sendRedirect("/TaskManagementApp_war_exploded/login.jsp?msg1=Incorrect&msg2=Credential&msg3=Inserted.");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
