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
    <title>PM-Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <!--script src="../../dev-page/scripts/jquery-2.0.3.js"></script>
    <script src="../../dev-page/scripts/jquery-tmpl.js"></script>
    <script src="../../dev-page/scripts/jquery.validate.js"></script>
    <script src="../../dev-page/scripts/jquery-serialization.js"></script>
    <script src="../../dev-page/scripts/dev-tasks-controller.js"></script>
    <script src="../../dev-page/scripts/date.js"></script-->
    <link type="text/css" rel="stylesheet" href="../../../scripts/jsgrid/jsgrid.min.css" />
    <link type="text/css" rel="stylesheet" href="../../../scripts/jsgrid/jsgrid-theme.min.css" />
    <link type="text/css" rel="stylesheet" href="../../../styles/admin.css">
    <link type="text/css" rel="stylesheet" href="jquery-ui-1.12.1/jquery-ui.min.css">

    <script type="text/javascript" src="jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../../../scripts/jsgrid/jsgrid.min.js"></script>
    <script type="text/javascript" src="pm.js"></script>
</head>
<body>

<!--%

    out.println("empId: " + request.getParameter("empid"));
    out.println("email: " + request.getParameter("email"));
    out.println("fname: " + request.getParameter("fname"));
    out.println("lname: " + request.getParameter("lname"));
%-->

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Projects</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> logout</a></li>
            </ul>
        </div>
    </div>

</nav>
<div class="content-area">
    <ul class="nav navbar-nav">
        <li class="active"><a href="#">Manage Tasks</a></li>
        <li><a href="#">Manage Teams </a></li>
        <li><a href="#">TBA</a></li>
    </ul>
</div>

<div id="task-grid">
</div>

</body>
</html>
