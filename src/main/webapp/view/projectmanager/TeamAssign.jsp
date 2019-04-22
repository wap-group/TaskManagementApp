<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/20/2019
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="hide" id="teamAssignDiv">
    <form action="/pm-team-assign" method="post">
        <div class="container">
            <div class="row">
                <div class="col-lg-6" id="firstColTaskAssign">
                    <div class="row top2">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Task: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <select name="category" id="taskAssignId" required>
                                <option value="">Data From DB</option>
                            </select>
                        </div>
                    </div>
                    <div class="row top10">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Developer: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <select name="category" id="developerAssignId" required>
                                <option value="">Data From DB</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6" id="secondColTaskAssign">
                    <div class="row top2">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Team: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <select name="category" id="teamAssignId" required>
                                <option value="">Data From DB</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row top5">
                <div class="col-lg-6 col-md-2 col-sm-1">
                    <button id="createTeamAssignSubmitId">Assign Team</button>
                </div>
                <div class="col-lg-6 col-md-2 col-sm-1">
                    <button id="updateTeamAssignSubmitId">Update Assign Team</button>
                </div>
            </div>
        </div>
    </form>
</div>
