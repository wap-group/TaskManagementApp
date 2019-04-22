<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/20/2019
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>

<div class="hide" id="teamCreateDiv">
    <form action="/pm-team-create" method="post">
        <div class="container">
            <div class="row">
                <div class="col-lg-6" id="firstColTeam">
                    <div class="row top2">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Team ID: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <input type="text" name="teamId" id="teamIDId"/>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6" id="secondColTeam">
                    <div class="row top2">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Team Name: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <input type="text" name="teamName" id="teamNameId"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row top5">
                <div class="col-lg-4 col-md-2 col-sm-1">
                    <button id="createTeamSubmitId">Create Team</button>
                </div>
                <div class="col-lg-4 col-md-2 col-sm-1">
                    <button id="updateTeamSubmitId">Update Team</button>
                </div>
            </div>
        </div>
    </form>
</div>
