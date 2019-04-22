<%@ page import="java.util.Iterator" %>
<%@ page import="com.wapgroup.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Fisseha
  Date: 4/20/2019
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Developer Tasks </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="styles/dev-tasks.css" media="screen" />
    <script src="scripts/jquery-2.0.3.js"></script>
    <script src="scripts/jquery-tmpl.js"></script>
    <script src="scripts/jquery.validate.js"></script>
    <script src="scripts/jquery-serialization.js"></script>
    <script src="scripts/dev-tasks-controller.js"></script>
    <script src="scripts/date.js"></script>
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
                <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-1 sidenav">
        </div>
        <div class="col-sm-10 text-left">
            <header>
                <span>Task list</span>
            </header>
            <hr>
            <main  id="taskPage">

                <section>
                    <form action = "DevPage" method = "GET" >
                    <p>
                        <button id = "viewBtn" type = "submit"> View Task</button>
                    </p>

                    <table id="userTasks">
                        <colgroup>
                            <col width="10%">
                            <col width="40%">
                            <col width="10%">
                            <col width="15%">
                            <col width="10%">
                            <col width="15%">
                        </colgroup>
                        <tr>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Due</th>
                            <th>Category</th>
                            <th>Priority</th>
                            <th>Status</th>
                        </tr>
                        <tr>

                            <c:forEach items = "${users}" var = "user">
                            <td> ${user.getfName()}</td> <td> ${user.getlName()}</td>
                                <td> ${user.getEmpId()}</td> <td> ${user.getEmail()}</td>
                                <td> ${user.getPhone()}</td>  <td> Edit Status</td>
                                </c:forEach>

                        </tr>
                    </table>
                    </form>
                </section>
            </main>

            <section class = "foot">
                <p>You have <span id="taskCount"></span> tasks</p>
            </section>
        </div>
        <div class="col-sm-1 sidenav">
        </div>
    </div>
</div>

</body>
<!--
<script>
    $(document).ready(function () {
        $("#viewBtn").click(function () {
            console.log("connecting to servlet ...");
            $.get("DevPage", {"tasks": "data"}).done(function (data) {
                console.log(data);
                $.each(data, function (index, value) {
                    $("#userTable").append("<tr data-id="+value.id+">" +
                        "<td>"+value.id+"</td>" +
                        "<td>"+value.username+"</td>" +
                        "<td>"+value.email+"</td>" +
                        "</tr>");
                });
                $("#userTable").show();
            }).fail(function (err) {
                console.error(err);
            });
        });

        $("#userTable").on('click', 'tr', function(){
            var self = $(this);
            var userId=self.attr("data-id");
            console.log(userId);
            $.get("http://jsonplaceholder.typicode.com/posts?userId="+userId)
                .done(function(data){

                    var tableStr = '<tr><td colspan="3"><table><tr><th>ID</th><th>Title</th><th>Body</th></tr>';

                    $.each(data, function (index, value) {
                        tableStr += '<tr data-id="+value.id+"><td>"+value.id+"</td><td>"+value.title+"</td><td>"+value.body+"</td></tr>';
                    });
                    tableStr +='</table></td></tr>';
                    self.append(tableStr);
                }).fail(function () {

            });
        });


    });
</script> -->
</html>

