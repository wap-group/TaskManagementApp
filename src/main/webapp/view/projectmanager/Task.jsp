<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/20/2019
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>

<div id="task" class="top15">
    <div id="taskButtons" class="container">
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>Manage Task</h3>
            </div>

            <ul class="list-unstyled components">
                <li class="top5" id="createTask">
                    Create Task
                </li>
                <li class="top5" id="assignTask">
                    Assign Task
                </li>
                <li class="top5" id="listTask">
                    List Task
                </li>
                <li class="top5" id="manageTeam">
                    Manage Team
                </li>
            </ul>
        </nav>
    </div>
    <!--<div id="taskButtons" class="container">
        <div class="row">
            <div class="col-lg-2 col-sm-2 col-md-2">
                <button id="createTask">Create Task</button>
            </div>
            <div class="col-lg-2 col-sm-2 col-md-2">
                <button id="assignTask">Assign Task</button>
            </div>
            <div class="col-lg-2 col-sm-2 col-md-2">
                <button id="listTask">List Task</button>
            </div>
            <div class="col-lg-2 col-sm-2 col-md-2">
                <button id="manageTeam">Manage Team</button>
            </div>
        </div>-->
    <div class="wrapper top5" id="contentTask">
        <div>
            <jsp:include page="TaskCreate.jsp" />
        </div>
        <div>
            <jsp:include page="TaskAssign.jsp" />
        </div>
        <div>
            <jsp:include page="TaskList.jsp" />
        </div>
    </div>
</div>

