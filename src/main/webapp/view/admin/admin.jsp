<%--
  Created by IntelliJ IDEA.
  User: Hike
  Date: 4/22/2019
  Time: 1:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    out.println("empId: " + request.getParameter("empid"));
    out.println("email: " + request.getParameter("email"));
    out.println("fname: " + request.getParameter("fname"));
    out.println("lname: " + request.getParameter("lname"));
%>
</body>
</html>
