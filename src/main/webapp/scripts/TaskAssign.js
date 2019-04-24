$(document).ready(function(){

    console.log("page loaded");


    //$("#jsgrid").jsGrid("option", "data", []);


    $("#jsgrid").jsGrid({

        height: "80%",
        width: "100%",
        inserting: true,
        editing: true,
        sorting: true,
        paging: true,
        autoload: true,
        pageSize: 10,
        controller: {
            loadData: function(filter){
                var data = $.Deferred();
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/pm-task-assign",
                    datatype: "json"
                }).done(function(response){
                    data.resolve(response);
                    console.log("Task Ready Data " + response);
                });
                return data.promise();
            },
            insertItem: function (item) {
                var data = $.Deferred();
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/pm-task-assign",
                    data: item,
                    datatype: "json"
                }).done(function(response){
                    //data.resolve(response);
                    setTimeout(function(){$("#jsgrid").jsGrid("loadData")}, 500);
                });
                // return data.promise();
            },
            updateItem: function(item){
                var data = $.Deferred();
                $.ajax({
                    type: "PUT",
                    url: "http://localhost:8080/pm-task-assign",
                    data: item,
                    datatype: "json"
                }).done(function(response){
                    setTimeout(function(){$("#jsgrid").jsGrid("loadData")}, 500);
                });
            },
            deleteItem: function(item){
                var data = $.Deferred();
                $.ajax({
                    type: "DELETE",
                    url: "http://localhost:8080/pm-task-assign",
                    data: item,
                    datatype: "json"
                }).done(function(response){
                    //data.resolve(response);
                    setTimeout(function(){$("#jsgrid").jsGrid("loadData")}, 500);
                });
            }
        },
        fields: [
            {name: "taskId", title: "Task  Id", type: "number", validate: "required",width: "60px", editing: false},
            {name: "taskName", title: "Task  Name", type: "text",  width: "100px"},
            {name: "teamId", title: "Team  Id", type: "text", width: "60px"},
            {name: "teamName", title: "Team  Name", type: "text", validate: "required", width: "60px"},
            {name: "developerId", title: "Developer Id", type: "date", validate: "required", width: "100px"},
            {type: "control"}
        ]

    });



});

