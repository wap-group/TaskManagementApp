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
    <title>Bootstrap Example</title>
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
        <div class="col-sm-2 sidenav">
            <p><a href="#">Manage Teams</a></p>
            <p><a href="#">Manage Tasks</a></p>
            <p><a href="#">View Tasks</a></p>
        </div>
        <div class="col-sm-8 text-left">
            <header>
                <span>Task list</span>
            </header>
            <hr>
            <main  id="taskPage">
                <section id="taskCreation" class="not">
                    <form id="taskForm">
                        <input type="hidden" name="id"/>
                        <div>
                            <label>Task</label> <input type="text" required="required"
                                                       name="task" class="large" placeholder="Breakfast at Tiffanys" maxlength="200"  />
                        </div>
                        <div>
                            <label>Required by</label> <input type="date" required="required"
                                                              name="requiredBy" />
                        </div>
                        <div>
                            <label>Category</label> <select name="category">
                            <option value="Personal">Personal</option>
                            <option value="Work">Work</option>
                        </select>
                        </div>
                        <nav>
                            <a href="#" id="saveTask">Save task</a>
                            <a href="#" id="clearTask">Clear task</a>
                        </nav>
                    </form>
                </section>
                <section>
                    <table id="tblTasks">
                        <colgroup>
                            <col width="40%">
                            <col width="15%">
                            <col width="15%">
                            <col width="30%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Due</th>
                            <th>Category</th>
                            <th>Status</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <!--
                    <nav>
                        <a href="#" id="btnAddTask">Add task</a>
                    </nav>
                    -->
                </section>

            </main>

            <section class = "foot">
                <p>You have <span id="taskCount"></span> tasks</p>
            </section>
        </div>
        <div class="col-sm-2 sidenav">
            <div class="well">
                <p>ADS</p>
            </div>
            <div class="well">
                <p>ADS</p>
            </div>
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
	<td {{if complete == true}}class="taskCompleted"{{/if}}>${task}</td>
	<td {{if complete == true}}class="taskCompleted"{{/if}}><time datetime="${requiredBy}">${requiredBy}</time></td>
	<td {{if complete == true}}class="taskCompleted"{{/if}}>${category}</td>
	<td>
		<Select name = "status">
		    <option value="notStarted"></option>
		    <option value="completed"></option>
		    <option value="In Progress"></option>
		</Select>
	<!--
	<nav>
			{{if complete != true}}
				<a href="#" class="editRow" data-task-id="${id}">Edit</a>
				<a href="#" class="completeRow" data-task-id="${id}">Complete</a>
			{{/if}}
			<a href="#" class="deleteRow" data-task-id="${id}">Delete</a>
		</nav>
		-->
	</td>

</tr>

</script>
</html>

