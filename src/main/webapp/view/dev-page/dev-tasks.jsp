<%@ page import="java.util.Iterator" %>
<%@ page import="com.wapgroup.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wapgroup.model.Task" %>
<%@ page import="com.wapgroup.model.Catagory" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.wapgroup.model.Status" %>
<%@ page import="org.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Developer Tasks </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="scripts/jquery.validate.js"></script>
    <script src="scripts/dev-tasks.js"></script>
    <link rel="stylesheet" type="text/css" href="styles/dev-tasks.css" media="screen" />
    <script src="scripts/jquery-3.3.1.js"></script>
    <script src="scripts//jquery.dataTables.min.js"></script>
    <script src = "scripts/dataTables.bootstrap4.min.js"></script>
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
            <main  id="taskPage ">
                <div id = "selectStatus" style="display: none;">
                    <form id = "statusForm">
                        <label> Select Status <select id = "selector">
                            <option selected value = "None" va> None </option>
                            <option value = "Not started"> Not started </option>
                            <option value = "In progress">In progress </option>
                            <option value = "Completed"> Completed </option>
                        </select> </label>
                    </form>
                    <p>
                        <button id = "saveStatus" type = "buttom"> Save Status</button>
                    </p>
                </div>
                <section>
                    <div style = "display: inline;">
                        <button id = "sortTable" type = "buttom"> SortBy Priority</button>
                        <button id = "filterTable" type = "buttom"> Filter </button>
                    </div>
                    <table class = "sortable" id="userTasks">
                        <colgroup>
                            <col width="10%">
                            <col width="25%">
                            <col width="15%">
                            <col width="10%">
                            <col width="10%">
                            <col width="10%">
                            <col width="10%">
                            <col width="10%">

                        </colgroup>
                        <thead>
                        <tr>
                            <th style="text-align: center;">Task Id</th>
                            <th style="text-align: center;">Name</th>
                            <th style="text-align: center;">Category</th>
                            <th style="text-align: center;">Due Date</th>
                            <th style="text-align: center;"> Date Assigned</th>
                            <th style="text-align: center;">Priority</th>
                            <th style="text-align: center;">Status</th>
                            <th style="text-align: center;">Edit Status</th>

                        </tr>
                        </thead>

                        <tbody>

                            <c:forEach var = "task" items = "${tasks}">
                            <tr >
                                <td> ${task.getTaskId()} </td>
                                <td> ${task.gettaskName()} </td>
                                <td> ${task.getCatagory().toString()} </td>
                                <td> ${task.getDueDate()} </td>
                                <td> ${task.getTaskAssigned()} </td>
                                <td> ${task.getPriority()} </td>
                                <td class = "status" > ${task.getStatus().toString()} </td>
                                <td>
                                    <input type = "button" class = "editStatus" style = "width: 100%" value = "Edit"></td>
                            </tr>
                            </c:forEach>

                        </tbody>

                    <%--
                      <%List<Task> tasks = (List)session.getAttribute("tasks");
                        Iterator it = tasks.iterator();
                          while(it.hasNext()) {
                              Task task = (Task) it.next();
                              int taskId = task.getTaskId();
                              String name = task.gettaskName();
                              String category = task.getCatagory().toString();
                              Date dueDate = task.getDueDate();
                              Date dateAssigned = task.getTaskAssigned();
                              int priority  = task.getPriority();
                              String status = task.getStatus().toString();

                              JSONObject json = new JSONObject();
                              json.put("id", taskId);
                              json.put("name", name);
                              json.put("category", category);
                              json.put("dueDate", dueDate);
                              json.put("dateAssigned", dateAssigned);
                              json.put("priority", priority);
                              json.put("status", status);


                              //response.getWriter().print(json);
                              //response.getWriter().flush();
                              //response.getWriter().close();
                              %>

                        <tbody>
                           <tr >
                               <td> <%= taskId %> </td>
                               <td> <%= name %> </td>
                               <td> <%= category %> </td>
                               <td> <%= dueDate %> </td>
                               <td> <%= dateAssigned %> </td>
                               <td> <%= priority%> </td>
                               <td class = "status" > <%= status %> </td>
                               <td>
                                   <input type = "button" class = "editStatus" style = "width: 100%" value = "Edit"></td>
                            </tr>
                        </tbody>
                          <%} %>
                          --%>
                    </table>

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

</html>

