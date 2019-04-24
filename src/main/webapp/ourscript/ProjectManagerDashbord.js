
$(function() {
    assignLookUp("Assign Task");
    assignLookUp("Assign Team");
    //assignLookUp("Assign Developer");
//Task
    $("#createTask").click(function () {
        $("#taskCreateDiv").show();
        $("#taskAssignDiv").hide();
        $("#taskListDiv").hide();
    });

    $("#assignTask").on('click', function () {
        $("#taskCreateDiv").hide();
        $("#taskAssignDiv").show();
        $("#taskListDiv").hide();
    });

    $("#listTask").click(function () {
        $("#taskCreateDiv").hide();
        $("#taskAssignDiv").hide();
        $("#taskListDiv").show();
        /*$.get("http://localhost:8080/pm-task-list").done(function (data) {

            console.log(data);
            let divObject = $("#taskListDiv");
            let tableHeader = ["Task ID","Task Name", "Description","Status","Priority"];
            displayList(data, divObject, tableHeader, "Task List");

        }).fail(function (err) {
            console.log("ERR: "+err);
        });*/
    });

    $("#manageTeam").on('click', function () {
        $("#task").hide();
        $("#teamCreateDiv").hide();
        $("#teamAssignDiv").hide();
        $("#teamListDeveloperDiv").hide();
        $("#teamListTeamDiv").show();
        $("#team").show();
    });

//Team
    $("#createTeam").on('click', function () {
        $("#teamCreateDiv").show();
        $("#teamAssignDiv").hide();
        $("#teamListDeveloperDiv").hide();
        $("#teamListTeamDiv").hide();
    });

    $("#assignDeveloper").on('click', function () {
        $("#teamAssignDiv").show();
        $("#teamCreateDiv").hide();
        $("#teamListDeveloperDiv").hide();
        $("#teamListTeamDiv").hide();
    });

    $("#listTeam").on('click', function () {
        $("#teamListTeamDiv").show();
        $("#teamCreateDiv").hide();
        $("#teamAssignDiv").hide();
        $("#teamListDeveloperDiv").hide();

       /* $.get("http://localhost:8080/pm-team-list").done(function (data) {

            console.log(data);
            let divObject = $("#teamListTeamDiv");
            let tableHeader = ["Team ID","Team Name"];
            displayList(data, divObject, tableHeader, "Team List");

        }).fail(function (err) {
            console.log("ERR: "+err);
        });*/
    });

    $("#listDeveloper").on('click', function () {
        $("#teamListDeveloperDiv").show();
        $("#teamCreateDiv").hide();
        $("#teamAssignDiv").hide();
        $("#teamListTeamDiv").hide();

        /*$.get("http://localhost:8080/pm-developer-list").done(function (data) {

            console.log(data);
            let divObject = $("#teamListDeveloperDiv");
            let tableHeader = ["Developer ID" ,"Developer First Name","Developer Last Name","Task Name", "Team Name"];
            displayList(data, divObject, tableHeader, "Developer List");

        }).fail(function (err) {
            console.log("ERR: "+err);
        });*/
    });

    $("#manageTask").on('click', function () {
        $("#team").hide();
        $("#taskCreateDiv").hide();
        $("#taskAssignDiv").hide();
        $("#taskListDiv").show();
        $("#task").show();

    });
  //create
    $("#createTaskSubmitId").on("click",function () {
        taskCreateSubmit();
    });

    $("#updateTaskSubmitId").on("click",function () {
        taskCreateSubmit();
    });

    $("#createTeamSubmitId").on("click",function () {
        teamCreateSubmit();
    });

    $("#updateTeamSubmitId").on("click",function () {
        teamCreateSubmit();
    });

    //assign
    $("#createTaskAssignSubmitId").on("click",function () {
        taskAssignSubmit();
    });

    $("#updateTaskAssignSubmitId").on("click",function () {
        taskAssignSubmit();
    });

    $("#createTeamAssignSubmitId").on("click",function () {
        teamAssignSubmit();
    });

    $("#updateTeamAssignSubmitId").on("click",function () {
        teamAssignSubmit();
    });
});


function taskAssignSubmit(){
    $.ajax({
        url:"http://localhost:8080/pm-task-assign",
        data:{
            taskAssignTask: $("#taskAssignTeamId").val(),
            developerAssignedTask: $("#developerAssignTaskId").val(),
            teamAssignedTask: $("#teamAssignTaskId").val(),
        },
        type:'get',
        cache:false,
        success:function(data){
            console.log(data);
        },
        error:function(){
            console.log('error');
        }
    });

    $("#taskCreateDiv").hide();
    $("#taskAssignDiv").show();
    $("#taskListDiv").hide();

    $("#taskAssignId").val("");
    $("#developerAssignId").val("");
    $("#teamAssignId").val("");
}

function teamAssignSubmit() {
    $.ajax({
        url:"http://localhost:8080/pm-team-assign",
        data:{
            taskAssignedTeam: $("#taskAssignTeamId").val(),
            developerAssignedTeam: $("#developerAssignTeamId").val(),
            teamAssignTeam: $("#teamAssignTeamId").val(),
        },
        type:'get',
        cache:false,
        success:function(data){
            console.log(data);
        },
        error:function(){
            console.log('error');
        }
    });

    $("#teamAssignDiv").show();
    $("#teamCreateDiv").hide();
    $("#teamListDeveloperDiv").hide();
    $("#teamListTeamDiv").hide();

    $("#taskAssignId").val("");
    $("#developerAssignId").val("");
    $("#teamAssignId").val("");
}


function assignLookUp(type) {
    $.ajax({
        url:"http://localhost:8080/PM-assign-lookup",
        data:{type: type},
        type:'get',

        success:function(data){
            let parase = JSON.parse(data);
            if(type == "Assign Task") {
                populateAssignLookup(parase, "Assign Task");
            }
            else if(type == "Assign Team") {
                populateAssignLookup(parase, "Assign Team");
            }

            else if(type == "Assign Developer") {
                populateAssignLookup(parase, "Assign Developer");
            }
            console.log(parase);
        },
        error:function(){
            console.log('error');
        }
    });
}

function taskCreateSubmit() {
    $.ajax({
        url:"http://localhost:8080/pm-task-create",
        data:{
            taskId: $("#taskIDId").val(),
            taskName: $("#taskNameId").val(),
            dueDate: $("#dueDateId").val(),
            priority: $("#priorityId").val(),
            category: $("#categoryId").val(),
            description: $("#descriptionId").val(),
            status: $("#statusId").val(),
            taskAssigned: $("#taskAssignedId").val()
        },
        type:'get',
        cache:false,
        success:function(data){
            console.log(data);
        },
        error:function(){
            console.log('error');
        }
    });

    $("#taskCreateDiv").show();
    $("#taskAssignDiv").hide();
    $("#taskListDiv").hide();

    console.log("update Task sucessfully");
    $("#taskIDId").val("");
    $("#taskAssignedId").val("");
    $("#priorityId").val("");
    $("#statusId").val("");
    $("#taskNameId").val("");
    $("#dueDateId").val("");
    $("#categoryId").val("");
    $("#descriptionId").val("");

}

function teamCreateSubmit(){
    $.ajax({
        url:"http://localhost:8080/pm-team-create",
        data:{teamId: $("#teamIDId").val(), teamName: $("#teamNameId").val()},
        type:'get',
        cache:false,
        success:function(data){
            console.log(data);
        },
        error:function(){
            console.log('error');
        }

    });

    $("#teamListDeveloperDiv").hide();
    $("#teamCreateDiv").show();
    $("#teamAssignDiv").hide();
    $("#teamListTeamDiv").hide();
    $("#teamIDId").val("");
    $("#teamNameId").val("");
}
/*function displayList(listData, divObject, tableHeader, listType) {
    let listTable = "";
    listTable += "<table>\n" +
        "    <thead>\n" +
        "    <tr>\n";

    for(let i=0; i<tableHeader.length; i++) {
        listTable += "<th>" + tableHeader[i] + "</th>";
    }

    listTable +=  "</tr>\n" +
        "    </thead>\n" +
        "    <tbody>" +
        "     <tr>";


    for(let i=0; i<listData.length; i++) {
        if((i % tableHeader.length) == 0) {
            listTable += "</tr>" + "<tr>";
        }
        else {
            if(listType == "Task List"){
                listTable += "<td>" + listData[i].taskId + "</td>";
                listTable += "<td>" + listData[i].taskName + "</td>";
                listTable += "<td>" + listData[i].description + "</td>";
                listTable += "<td>" + listData[i].priority + "</td>";
                listTable += "<td>" + listData[i].status + "</td>";
            }
            else if(listType == "Team List"){
                listTable += "<td>" + listData[i].teamId + "</td>";
                listTable += "<td>" + listData[i].teamName + "</td>";
            }
            else if(listType == "Developer List"){
                listTable += "<td>" + listData[i].empId + "</td>";
                listTable += "<td>" + listData[i].fname + "</td>";
                listTable += "<td>" + listData[i].lname + "</td>";
                listTable += "<td>" + listData[i].team + "</td>";
                listTable += "<td>" + listData[i].team + "</td>";
            }

        }
    }

    listTable += " </tr>\n" +
                     "</tbody>\n" +
                     "</table>";
    divObject.append(listTable);

}*/

function populateAssignLookup(data, type) {
    let selectOption = "";

    for(let i=0; i<data.length; i++){
        if(type == "Assign Team") {
            selectOption += "<option value=" + data[i].taskId +">" + data[i].taskName + "</option>";
            console.log("taskId "+data[i].taskId);
            console.log("taskId "+data[i].taskName);
        }

        else if(type == "Assign Developer"){
            selectOption += "<option value=" + data[i].empId +">" + data[i].fName + "</option>";
            console.log("taskId "+data[i].empId);
            console.log("taskId "+data[i].fName);
        }

        else if(type == "Assign Task"){
            selectOption += "<option value=" + data[i].teamId +">" + data[i].taskName + "</option>";
        }
    }

    if(type == "Assign Team") {
        let task = $("#taskAssignTeamId");
        let team = $("#taskAssignTaskId");
        task.append(selectOption);
        team.append(selectOption);
        console.log(selectOption);
    }
    else if(type == "Assign Developer"){
        let task = $("#developerAssignTeamId");
        let team = $("#developerAssignTaskId");
        task.append(selectOption);
        team.append(selectOption);
        console.log(selectOption);
    }
    else if(type == "Assign Task"){

        let task = $("#teamAssignTaskId");
        let team = $("#teamAssignTeamId");
        task.append(selectOption);
        team.append(selectOption);
        console.log(selectOption);
    }

}

