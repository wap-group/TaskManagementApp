
$(function() {

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

    $("#listTask").on('click', function () {
        $("#taskCreateDiv").hide();
        $("#taskAssignDiv").hide();
        $("#taskListDiv").show();
    });

    $("#manageTeam").on('click', function () {
        $("#task").hide();
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
    });

    $("#listDeveloper").on('click', function () {
        $("#teamListDeveloperDiv").show();
        $("#teamCreateDiv").hide();
        $("#teamAssignDiv").hide();
        $("#teamListTeamDiv").hide();
    });

    $("#manageTask").on('click', function () {
        $("#task").show();
        $("#team").hide();
    });
});

/*window.onload = startPage;

function startPage() {
    document.getElementById("createTask").onclick = createTask;
}

function createTask () {
    document.getElementById("taskCreateDiv").classList.remove("hide");
    document.getElementById("taskCreateDiv").classList.add("show");
}*/