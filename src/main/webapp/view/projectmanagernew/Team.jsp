<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/24/2019
  Time: 5:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Team</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <script src="../dev-page/scripts/jquery-2.0.3.js"></script>
    <script src="../dev-page/scripts/jquery-tmpl.js"></script>
    <script src="../dev-page/scripts/jquery.validate.js"></script>
    <script src="../dev-page/scripts/jquery-serialization.js"></script>
    <script src="../dev-page/scripts/dev-tasks-controller.js"></script>
    <script src="../dev-page/scripts/date.js"></script>
    <link type="text/css" rel="stylesheet" href="../../scripts/jsgrid/jsgrid.min.css" />
    <link type="text/css" rel="stylesheet" href="../../scripts/jsgrid/jsgrid-theme.min.css" />
    <link type="text/css" rel="stylesheet" href="../../styles/admin.css">

    <script type="text/javascript" src="../../scripts/jsgrid/jsgrid.min.js"></script>
    <script type="text/javascript" src="../../scripts/TeamList.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/pm-task-create">Task</a></li>
                <li><a href="/pm-task-assign">Task Assign</a></li>
                <li><a href="/pm-team-assign">Team Assign</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login.jsp"><span class="glyphicon glyphicon-log-out"></span> logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<div id="jsgrid">
</div>
</body>
</html>
