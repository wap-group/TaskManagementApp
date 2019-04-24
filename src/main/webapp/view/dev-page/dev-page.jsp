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
    <link type="text/css" rel="stylesheet" href="../../scripts/jsgrid/jsgrid.min.css" />
    <link type="text/css" rel="stylesheet" href="../../scripts/jsgrid/jsgrid-theme.min.css" />
    <link type="text/css" rel="stylesheet" href="../../styles/admin.css">
    <link type="text/css" rel="stylesheet" href="scripts/jquery-ui-1.12.1/jquery-ui.min.css">

    <script type="text/javascript" src="scripts/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../../scripts/jsgrid/jsgrid.min.js"></script>
    <script type="text/javascript" src="dev-page.js"></script>
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
                <li><a href="../../logout.jsp"><span class="glyphicon glyphicon-log-out"></span> logout</a></li>
            </ul>
        </div>
    </div>

</nav>
<div class="content-area">
    <ul class="nav navbar-nav">
        <li class="active"><a href="#">Manage Tasks</a></li>
        <li><a href="#">View Teams </a></li>
        <li><a href="#">TBA</a></li>
    </ul>
</div>

<div id="task-grid">
</div>

</body>
</html>
