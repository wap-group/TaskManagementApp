<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/20/2019
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>

<div class="hide" id="team">
    <div id="teamButtons" class="container">
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>Manage Team</h3>
            </div>

            <ul class="list-unstyled components">
                <li class="top5" id="createTeam">
                    Create Team
                </li>
                <li class="top5" id="assignDeveloper">
                    Assign Developer
                </li>
                <li class="top5" id="listTeam">
                    List Team
                </li>
                <li class="top5" id="listDeveloper">
                    List Developers
                </li>
                <li class="top5" id="manageTask">
                    Manage Task
                </li>
            </ul>
        </nav>
        <!--<button id="createTeam">Create Team</button>
        <button id="assignDeveloper">Assign Developer</button>
        <button id="listTeam">List Team</button>
        <button id="listDeveloper">List Developers</button>
        <button id="manageTask">Manage Task</button>-->
    </div>

    <div class="wrapper top5" id="contentTeam">
        <div>
            <jsp:include page="TeamCreate.jsp" />
        </div>
        <div>
            <jsp:include page="TeamAssign.jsp" />
        </div>
        <div>
            <jsp:include page="TeamListDeveloper.jsp" />
        </div>
        <div>
            <jsp:include page="TeamListTeam.jsp" />
        </div>
    </div>
</div>
