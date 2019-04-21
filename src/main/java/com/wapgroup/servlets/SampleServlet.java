package com.wapgroup.servlets;

import com.wapgroup.database.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DatabaseConnection dbCon = DatabaseConnection.getInstance();

        if(dbCon != null){
            try{

                Statement stm = dbCon.con.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM users");

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<table><tr>");
                out.println("<th>id</th>" +
                            "<th>fName</th>" +
                            "<th>lName</th>" +
                            "<th>email</th>" +
                            "<th>phone</th>" +
                            "<th>roles</th></tr>");

                while(rs.next()){
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt(1) + "</td>");
                    out.println("<td>" + rs.getString(2) + "</td>");
                    out.println("<td>" + rs.getString(3) + "</td>");
                    out.println("<td>" + rs.getString(5) + "</td>");
                    out.println("<td>" + rs.getString(6) + "</td>");
                    out.println("<td>" + rs.getString(7) + "</td>");
                    out.println("<tr>");

                }
                out.println("</table></body></html>");

            }catch(SQLException se){
                System.out.println("SQLException inside doGet: " + se);
            }
        }

    }
}
