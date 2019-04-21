<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/20/2019
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<!--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>-->
<div id="task">
    <div id="taskButtons">
        <button id="createTask">Create Task</button>
        <button id="assignTask">Assign Task</button>
        <button id="listTask">List Task</button>
        <button id="manageTeam">Manage Team</button>
    </div>
    <div>
        <jsp:include page="TaskCreate.jsp" />
        <jsp:include page="TaskAssign.jsp" />
        <jsp:include page="TaskList.jsp" />
    </div>
</div>

