$(document).ready(function(){

    console.log("page loaded");


    $("jsGrid").jsGrid("option", "data", []);

    var MyDateField = function(config){
        jsGrid.Field.call(this, config);
    };

    MyDateField.prototype = new jsGrid.Field({

       css: "date-field",
       align: "center",

       myCustomProperty: "foo",

       itemTemplate: function(value){
           return new Date(value).toDateString();
       } ,

        insertTemplate: function(value){
           return this._insertPicker = $("<input>").datepicker({default: new Date()});
        },

        editTemplate: function(value){
           return this._editPicker = $("<input>").datepicker().datepicker("setDate", new Date(value));
        },

        insertValue: function(){
           return this._insertPicker.datepicker("getDate").toISOString();
        },

        editValue: function(){
           return this._editPicker.datepicker("getDate").toISOString();
        }

    });

    jsGrid.fields.date = MyDateField;


    $("#task-grid").jsGrid({

        height: "80%",
        width: "100%",
        editing: true,
        sorting: true,
        paging: true,
        //filtering: true,
        autoload: true,
        inserting: true,
        pageSize: 10,
        controller: {
            loadData: function(filter){
                let data = $.Deferred();
                $.ajax({
                    type: "GET",
                    url: "../../../ManageTaskServlet",
                    datatype: "json"
                }).done(function(response){
                    data.resolve(response);
                });
                return data.promise();
            },
            insertItem: function (item) {
                let data = $.Deferred();
                $.ajax({
                    type: "POST",
                    url: "../../ManageTaskServlet",
                    data: item,
                    datatype: "json"
                }).done(function(response){
                    //data.resolve(response);
                    setTimeout(function(){$("#task-grid").jsGrid("loadData")}, 500);
                });
                // return data.promise();
            },
        },
        fields: [
            {name: "taskId", title: "TaskId", type: "number", width: "60px"},
            {name: "taskName", title: "TaskName", type: "text", validate: "required", width: "60px"},
            {name: "dueDate", title: "DueDate", type: "date", validate: "required", width: "60px"},

            /*{name: "pass_word", title: "Pw", type: "text", validate: "required", width: "50px"},
            {name: "email", title: "Email", type: "text", validate: "required", width: "100px"},
            */
            {name: "priority", title: "Priority", type: "number", validate: "required", width: "50px"},
            {name: "category", title: "Category", type: "select", validate: "required", valueField: "categories",  width: "80px", items:["Work","Personal"], autosearch: true, selectedIndex: 0},
            {name: "taskDescription", title: "TaskDescription", type: "text", validate: "required", width: "80px"},
            {name: "taskStatus", title: "Status", type: "select", validate: "required", valueField: "taskStatus", width: "80px", items:["Not started","In Progress", "Completed"], autosearch: true, selectedIndex: 0},

            {name: "devEmail", title: "DevEmail", type: "text", validate: "required", width: "80px"},
            {name: "taskAssigned", title: "DateAssigned", type: "date", validate: "required", width: "40px"},
            {type: "control"}
        ]

    });

});
