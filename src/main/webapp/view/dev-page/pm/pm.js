$(document).ready(function(){

    console.log("page loaded");


    $("jsGrid").jsGrid("option", "data", []);


    $("#task-grid").jsGrid({

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
                    url: "../../ManageTaskServlet",
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
                    url: "../../ManageUsersServlet",
                    data: item,
                    datatype: "json"
                }).done(function(response){
                    //data.resolve(response);
                    setTimeout(function(){$("#task-grid").jsGrid("loadData")}, 500);
                });
                // return data.promise();
            }
        },
        fields: [
            {name: "taskId", title: "TaskId", type: "number", width: "60px"},
            {name: "taskName", title: "TaskName", type: "text", validate: "required", width: "60px"},
            {name: "dueDate", title: "DueDate", type: "Date", validate: "required", width: "60px"},

            /*{name: "pass_word", title: "Pw", type: "text", validate: "required", width: "50px"},
            {name: "email", title: "Email", type: "text", validate: "required", width: "100px"},
            */
            {name: "priority", title: "Priority", type: "number", validate: "required", width: "50px"},
            {name: "category", title: "Category", type: "select", validate: "required", valueField: "categories",  width: "80px", items:["Work","Personal"], autosearch: true, selectedIndex: 0},
            {name: "taskDescription", title: "TaskDescription", type: "text", validate: "required", width: "80px"},
            {name: "taskStatus", title: "Status", type: "select", validate: "required", valueField: "status",  width: "80px", items:["Not started","On Progress", "Completed"], autosearch: true, selectedIndex: 0},

            {name: "devEmail", title: "DevEmail", type: "text", validate: "required", width: "80px"},
            {name: "taskAssigned", title: "DateAssigned", type: "Date", validate: "required", width: "40px"},
            {type: "control"}
        ]

    });

});
