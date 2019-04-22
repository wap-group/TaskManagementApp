<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/20/2019
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>

<div class="hide container" id="taskCreateDiv">
    <form action="/pm-task-create" method="post">
        <div class="container">
            <div class="row">
                <div class="col-lg-6" id="firstColTask">
                    <div class="row top2">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Task ID: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <input type="text" name="taskId" id="taskIDId" required/>
                        </div>
                    </div>
                    <div class="row top10">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Task Assigned: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <input type="date" name="taskAssigned" id="taskAssignedId"/>
                        </div>
                    </div>
                    <div class="row top10">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Priority: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <input type="number" name="priority" id="priorityId"/>
                        </div>
                    </div>
                    <div class="row top10">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Status: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <select name="status" id="statusId">
                                <option value=""> </option>
                                <option value="NOT-STARTED">NOT-STARTED</option>
                                <option value="ON-PROGRESS">ON-PROGRESS</option>
                                <option value="COMPLETED">COMPLETED</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6" id="secondColTask">
                    <div class="row top2">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Task Name: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <input type="text" name="taskName" id="taskNameId"/>
                        </div>
                    </div>
                    <div class="row top10">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Due Date: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <input type="date" name="dueDate" id="dueDateId"/>
                        </div>
                    </div>
                    <div class="row top10">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Category: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <select name="category" id="categoryId">
                                <option value=""> </option>
                                <option value="personal">Personal</option>
                                <option value="work">Work</option>
                            </select>
                        </div>
                    </div>
                    <div class="row top10">
                        <div class="col-lg-5 col-md-4 col-sm-2">
                            <label>Description: </label>
                        </div>
                        <div class="col-lg-7 col-md-6 col-sm-4">
                            <textarea type="text" name="description" id="descriptionId"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row top5">
                <div class="col-md-2 col-sm-1">
                    <button id="createTaskSubmitId">Create Task</button>
                </div>
                <div class="col-md-2 col-sm-1">
                    <button id="updateTaskSubmitId">Update Task</button>
                </div>
            </div>
        </div>
    </form>
</div>

<!--<div class="row top5" id="firstRow">
<div class="col-lg-6 col-sm-3">
<div class="row">
<div class="col-lg-5 col-md-4 col-sm-2">
<label>Task ID: </label>
</div>
<div class="col-lg-7 col-md-6 col-sm-4">
<input type="text" name="taskId" id="taskIDId"/>
</div>
</div>
</div>
<div class="col-lg-6 col-sm-3">
<div class="row">
<div class="col-lg-5 col-md-4 col-sm-2">
<label>Task Name: </label>
</div>
<div class="col-lg-7 col-md-6 col-sm-4">
<input type="text" name="taskName" id="taskNameId"/>
</div>
</div>
</div>
</div>
<div class="row top5 right5" id="secondRow">
<div class="col-lg-6 col-sm-3">
<div class="row">
<div class="col-lg-5 col-md-4 col-sm-2">
<label>Task Assigned: </label>
</div>
<div class="col-lg-7 col-md-6 col-sm-4">
<input type="date" name="taskAssigned" id="taskAssignedId"/>
</div>
</div>
</div>
<div class="col-lg-6 col-sm-3">
<div class="row">
<div class="col-lg-5 col-md-4 col-sm-2">
<label>Due Date: </label>
</div>
<div class="col-lg-7 col-md-6 col-sm-4">
<input type="date" name="dueDate" id="dueDateId"/>
</div>
</div>
</div>
</div>
<div class="row top5 right5" id="thirdRow">
<div class="col-lg-6 col-sm-3">
<div class="row">
<div class="col-lg-5 col-md-4 col-sm-2">
<label>Priority: </label>
</div>
<div class="col-lg-7 col-md-6 col-sm-4">
<input type="number" name="priority" id="priorityId"/>
</div>
</div>
</div>
<div class="col-lg-6 col-sm-3">
<div class="row">
<div class="col-lg-5 col-md-4 col-sm-2">
<label>Category: </label>
</div>
<div class="col-lg-7 col-md-6 col-sm-4">
<select name="category" id="categoryId">
<option value=""> </option>
<option value="personal">Personal</option>
<option value="work">Work</option>
</select>
</div>
</div>
</div>
</div>
<div class="row top5 right2" id="fourthRow">
<div class="col-lg-6 col-sm-3">
<div class="row">
<div class="col-lg-5 col-md-4 col-sm-2">
<label>Status: </label>
</div>
<div class="col-lg-7 col-md-6 col-sm-4">
<select name="status" id="statusId">
<option value=""> </option>
<option value="NOT-STARTED">NOT-STARTED</option>
<option value="ON-PROGRESS">ON-PROGRESS</option>
<option value="COMPLETED">COMPLETED</option>
</select>
</div>
</div>
</div>
<div class="col-lg-6 col-sm-3">
<div class="row">
<div class="col-lg-5 col-md-4 col-sm-2">
<label>Description: </label>
</div>
<div class="col-lg-7 col-md-6 col-sm-4">
<textarea type="text" name="description" id="descriptionId"></textarea>
</div>
</div>
</div>
</div>-->