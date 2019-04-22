<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/20/2019
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Team And Task</title>
    <script src="../../scripts/jquery-3.2.1.min.js"></script>
    <link href="../../styles/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../styles/style.css" rel="stylesheet" type="text/css">
    <link href="../../styles/Display.css" rel="stylesheet" type="text/css">
    <link href="../../styles/table.css" rel="stylesheet" type="text/css">
    <script src="../../ourscript/ProjectManagerDashbord.js"></script>

</head>
<body>
<div>
    <!-- <link href="../../styles/style2.css" rel="stylesheet" type="text/css">
    <link href="../../styles/style3.css" rel="stylesheet" type="text/css">
    <link href="../../styles/style4.css" rel="stylesheet" type="text/css">
    <link href="../../styles/style5.css" rel="stylesheet" type="text/css">-->
    <!-- <i class="fa fa-sign-out fa_custom fa-2x"></i>-->
    <div class="top15"><jsp:include page="Task.jsp" /></div>
    <div class="top15"><jsp:include page="Team.jsp" /></div>
</div>
</body>
</html>
