<%--
  Created by IntelliJ IDEA.
  User: Fisseha
  Date: 4/20/2019
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
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
                    <table id="tblTasks">
                        <colgroup>
                            <col width="10%">
                            <col width="40%">
                            <col width="10%">
                            <col width="15%">
                            <col width="10%">
                            <col width="15%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Due</th>
                            <th>Category</th>
                            <th>Priority</th>
                            <th>Status</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
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
<script>
    function initScreen() {
        $(document).ready(function() {
            tasksController.init($('#taskPage'), function() {
                tasksController.loadTasks();
            });
        });
    }
    if (window.indexedDB) {
        $.getScript( "scripts/dev-tasks-indexeddb.js" )
            .done(function( script, textStatus ) {
                initScreen();
            })
            .fail(function( jqxhr, settings, exception ) {
                console.log( 'Failed to load indexed db script' );
            });
    } else if (window.localStorage) {
        $.getScript( "scripts/dev-tasks-webstorage.js" )
            .done(function( script, textStatus ) {
                initScreen();
            })
            .fail(function( jqxhr, settings, exception ) {
                console.log( 'Failed to load web storage script' );
            });
    }
</script>

<script id="taskRow" type="text/x-jQuery-tmpl">
<tr>
	<td {{if complete == true}}class="taskCompleted"{{/if}}>${taskId}</td>
	<td {{if complete == true}}class="taskCompleted"{{/if}}>${task}</td>
	<td {{if complete == true}}class="taskCompleted"{{/if}}><time datetime="${requiredBy}">${requiredBy}</time></td>
	<td {{if complete == true}}class="taskCompleted"{{/if}}>${category}</td>
	<td {{if complete == true}}class="taskCompleted"{{/if}}>${priority}</td>


	<td>
		<Select name = "status" id = "status" onchange = "changeStatus()">
		    <option value="notStarted"> No Started </option>
		    <option value="completed"> In Progress </option>
		    <option value="In Progress"> Completed </option>
		</Select>

    <!--
	<td>
	<nav>
			{{if complete != true}}
				<a href="#" class="editRow" data-task-id="${id}">Edit</a>
				<a href="#" class="completeRow" data-task-id="${id}">Complete</a>
			{{/if}}
			<a href="#" class="deleteRow" data-task-id="${id}">Delete</a>
		</nav>
	</td>
	-->

</tr>

</script>
</html>

