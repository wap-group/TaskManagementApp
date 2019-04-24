$(document).ready(function(){

    console.log("page loaded");


    $("jsGrid").jsGrid("option", "data", []);


    $("#jsgridDeveloperList").jsGrid({

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
                    url: "http://localhost:8080/pm-developer-list",
                    datatype: "json"
                }).done(function(response){
                    data.resolve(response);
                });
                return data.promise();
            },
            insertItem: function (item) {
                var data = $.Deferred();
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/pm-developer-list",
                    data: item,
                    datatype: "json"
                }).done(function(response){
                    //data.resolve(response);
                    setTimeout(function(){$("#jsgridDeveloperList").jsGrid("loadData")}, 500);
                });
                // return data.promise();
            },
            updateItem: function(item){
                var data = $.Deferred();
                $.ajax({
                    type: "PUT",
                    url: "http://localhost:8080/pm-developer-list",
                    data: item,
                    datatype: "json"
                }).done(function(response){
                    setTimeout(function(){$("#jsgridDeveloperList").jsGrid("loadData")}, 500);
                });
            },
            deleteItem: function(item){
                var data = $.Deferred();
                $.ajax({
                    type: "DELETE",
                    url: "http://localhost:8080/pm-developer-list",
                    data: item,
                    datatype: "json"
                }).done(function(response){
                    //data.resolve(response);
                    setTimeout(function(){$("#jsgridDeveloperList").jsGrid("loadData")}, 500);
                });
            }
        },
        fields: [
            {name: "empId", title: "EmpId", type: "number", width: "60px", editing: false},
            {name: "fName", title: "FName", type: "text", validate: "required", width: "60px"},
            {name: "lName", title: "LName", type: "text", validate: "required", width: "60px"},
            {name: "pass_word", title: "Pw", type: "text", validate: "required", width: "50px"},
            {name: "email", title: "Email", type: "text", validate: "required", width: "100px"},
            {name: "phone", title: "Phone", type: "text", validate: "required", width: "80px"},
            {name: "roles", title: "Role", type: "select", validate: "required", valueField: "roles",  width: "80px", items:["admin","project manager", "developer"], autosearch: true, selectedIndex: 0},
            {name: "zipcode", title: "Zipcode", type: "text", validate: "required", width: "80px"},
            {name: "street", title: "Street", type: "text", validate: "required", width: "90px"},
            {name: "city", title: "City", type: "text", validate: "required", width: "80px"},
            {name: "state", title: "State", type: "text", validate: "required", width: "40px"},
            {type: "control"}
        ]

    });



});

