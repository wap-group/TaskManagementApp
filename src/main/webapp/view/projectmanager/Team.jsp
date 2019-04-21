<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/20/2019
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>

<div class="hide" id="team">
    <div id="teamButtons">
        <button id="createTeam">Create Team</button>
        <button id="assignDeveloper">Assign Developer</button>
        <button id="listTeam">List Team</button>
        <button id="listDeveloper">List Developers</button>
        <button id="manageTask">Manage Task</button>
    </div>
    <div>
        <jsp:include page="TeamCreate.jsp" />
        <jsp:include page="TeamAssign.jsp" />
        <jsp:include page="TeamListDeveloper.jsp" />
        <jsp:include page="TeamListTeam.jsp" />
    </div>
</div>
