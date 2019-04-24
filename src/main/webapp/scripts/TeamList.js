$(document).ready(function(){

    console.log("page loaded");


    $("jsGrid").jsGrid("option", "data", []);


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
                    url: "http://localhost:8080/pm-team-list",
                    datatype: "json"
                }).done(function(response){
                    data.resolve(response);
                    console.log("Team Ready Data " + response);
                });
                return data.promise();
            },
            insertItem: function (item) {
                var data = $.Deferred();
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/pm-team-list",
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
                    url: "http://localhost:8080/pm-team-list",
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
                    url: "http://localhost:8080/pm-team-list",
                    data: item,
                    datatype: "json"
                }).done(function(response){
                    //data.resolve(response);
                    setTimeout(function(){$("#jsgrid").jsGrid("loadData")}, 500);
                });
            }
        },
        fields: [
            {name: "teamId", title: "Team Id", type: "text", width: "60px",validate: "required", editing: false},
            {name: "teamName", title: "Team Name", type: "text", validate: "required", width: "60px"},
            {type: "control"}
        ]

    });



});

